package services;

import dbcommon.Repository;
import domain.input.inputData.InputData;
import domain.input.inputData.criteria.*;
import domain.input.inputData.stat.Statistic;
import domain.input.outputData.search.OutputSearch;
import domain.input.outputData.search.ResultCommon;
import domain.input.outputData.stat.OutputStat;
import file_manager.IOManager;
import jsonMapper.JsonHandler;
import responses.Error;
import responses.interfaces.Response;

import java.io.IOException;

public class DataService {
    private final Repository repository;
    private final JsonHandler jsonHandler;

    public DataService() {
        this.repository = new Repository();
        this.jsonHandler = new JsonHandler();
    }

    public void createSearch(String type, String jsonFile) {
        try {
            String json = IOManager.readJson(jsonFile);
            InputData inputData = jsonHandler.readJsonFile(type, json);
            Response output = null;
            switch (type){
                case "search":
                    output = getBuyers(type, inputData);
                    break;
                case "stat":
                    output = getStat((Statistic) inputData);
                    break;
            }
            IOManager.createJson(jsonFile, jsonHandler.createResponseJson(output));
        } catch (Exception e) {
            Response responce = new Error(e.getMessage());
            IOManager.createJson(jsonFile, jsonHandler.createResponseJson(responce));
        }
    }

    private OutputStat getStat(Statistic statistic) throws IOException {
        OutputStat outputStat = new OutputStat("stat", statistic.getEndDate().toEpochDay() - statistic.getStartDate().toEpochDay());
        outputStat.getCustomers().addAll(repository.getStat(statistic.getStartDate(), statistic.getEndDate()));
        return outputStat;
    }

    private OutputSearch getBuyers(String type, InputData data) throws IOException {
        OutputSearch output = new OutputSearch(type);
        for (Criteria criteria : data.getCriteriaList()) {
            if (criteria.getClass() == NameProductCountBuy.class) {
                ResultCommon result = new ResultCommon(criteria.getCriteriaName());
                result.getResults().addAll(repository
                        .getBuyerByProductNameAndCountPurchase((NameProductCountBuy) criteria));
                output.addResults(result);
            } else if (criteria.getClass() == LastNameCriteria.class) {
                ResultCommon result = new ResultCommon(criteria.getCriteriaName());
                result.getResults().addAll(repository.getBuyerByLastName((LastNameCriteria) criteria));
                output.addResults(result);
            } else if (criteria.getClass() == BadCustomer.class) {
                ResultCommon result = new ResultCommon(criteria.getCriteriaName());
                result.getResults().addAll(repository.getBadBuyers((BadCustomer) criteria));
                output.addResults(result);
            } else if (criteria.getClass() == MinMaxExpences.class) {
                ResultCommon result = new ResultCommon(criteria.getCriteriaName());
                result.getResults().addAll(repository.getBuyersByMinPriceAndMaxPrice((MinMaxExpences) criteria));
                output.addResults(result);
            } else {
                ResultCommon result = new ResultCommon("Error! Неизвестный критерий: " + criteria.getCriteriaName());
                output.addResults(result);
            }
        }
        return output;
    }
}
