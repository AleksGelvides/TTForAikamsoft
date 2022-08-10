package jsonMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import domain.input.inputData.InputData;
import domain.input.inputData.criteria.Criteria;
import domain.input.inputData.stat.Statistic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

    public static InputData readJsonFile(String json){
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(json).get("criterias");
            if(isCriteria(node)) {
                return InputData.inputDataBuilder(findAllCriterias(node, mapper));
            } else {
                Statistic stat = mapper.readValue(json, Statistic.class);
                ArrayList<InputData> statList = new ArrayList<>();
                statList.add(stat);
                return InputData.inputDataBuilder(statList);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static List<Criteria> findAllCriterias(JsonNode node, ObjectMapper mapper) throws JsonProcessingException {
        ArrayList<Criteria> criteries = new ArrayList<>();
        for(int counter = 0; counter <= node.size() - 1; counter++){
            String nodeString = node.get(counter).toString();
            TypeFactory typeFactory = mapper.getTypeFactory();
            Criteria criteria = mapper.readValue(nodeString,
                    typeFactory.constructFromCanonical(Criteria.getClassType(nodeString).getCanonicalName()));
            criteries.add(criteria);
            System.out.println(criteria.toString());
        }
        return criteries;
    }

    private static boolean isCriteria(JsonNode node){
        return node != null;
    }
}
