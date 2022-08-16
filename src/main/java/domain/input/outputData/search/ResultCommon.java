package domain.input.outputData.search;

import dbcommon.entities.Buyer;
import responses.interfaces.Response;

import java.util.ArrayList;

public class ResultCommon implements Response {

    private String criteria;
    private ArrayList<Response> results;

    public ResultCommon(String criteria) {
        this.criteria = criteria;
        this.results = new ArrayList<>();
    }

    @Override
    public String getType() {
        return null;
    }

    public ArrayList<Response> getResults() {
        return results;
    }

    public String getCriteria() {
        return criteria;
    }
}
