package jsonMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import domain.input.inputData.InputData;
import domain.input.inputData.criteria.Criteria;
import domain.input.inputData.criteria.NotDetermined;
import domain.input.inputData.stat.Statistic;
import exceptions.JsonDataException;
import exceptions.JsonParamException;
import responses.interfaces.Responce;

import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

    private static final ObjectMapper inputMapper;
    private static final ObjectMapper outputMapper;

    static {
        ObjectMapper mapper = new ObjectMapper();
        inputMapper = mapper;
        outputMapper = mapper;
    }

    public static InputData readJsonFile(String param, String json) throws Exception {
        switch (param) {
            case "search":
                try {
                    JsonNode node = inputMapper.readTree(json).get("criterias");
                    if (isCriteria(node)) {
                        return InputData.inputDataBuilder(findAllCriterias(node));
                    } else
                        throw new JsonDataException("Не удалось определить параметр json: criterias");
                } catch (JsonProcessingException e) {
                    throw new JsonParamException("Не корректный запрос поиска в json для search");
                }
            case "stat":
                try {
                    Statistic stat = inputMapper.readValue(json, Statistic.class);
                    if (stat.getStartDate().before(stat.getEndDate())) {
                        throw new JsonDataException("stat: endDate не может быть после startDate");
                    }
                    ArrayList<InputData> statList = new ArrayList<>();
                    statList.add(stat);
                    return InputData.inputDataBuilder(statList);
                } catch (JsonProcessingException e) {
                    throw new JsonDataException("Не корректный запрос поиска в json для stat");
                }
            default:
                throw new JsonParamException("Не удалось определить параметр поиска");
        }
    }

    public static String createResponseJson(Responce response) {
        try {
            return outputMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
        } catch (JsonProcessingException e) {
            System.err.println();
            return null;
        }
    }

    private static List<Criteria> findAllCriterias(JsonNode node) throws JsonProcessingException {
        ArrayList<Criteria> criteries = new ArrayList<>();
        for (int counter = 0; counter <= node.size() - 1; counter++) {
            String nodeString = node.get(counter).toString();
            TypeFactory typeFactory = inputMapper.getTypeFactory();
            Class clazz = Criteria.getClassType(nodeString);
            if(clazz == null){
                Criteria failCriteria = new NotDetermined(nodeString);
                criteries.add(failCriteria);
            } else {
                Criteria criteria = inputMapper.readValue(nodeString,
                        typeFactory.constructFromCanonical(clazz.getCanonicalName()));
                criteries.add(criteria);
            }
        }
        return criteries;
    }

    private static boolean isCriteria(JsonNode node) {
        return node != null;
    }
}
