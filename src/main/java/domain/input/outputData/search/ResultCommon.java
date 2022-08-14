package domain.input.outputData.search;

import dbcommon.entities.Buyer;

import java.util.ArrayList;

public class ResultCommon {

    private String criteria;
    private ArrayList<Buyer> results;

    public ResultCommon(String criteria) {
        this.criteria = criteria;
        this.results = new ArrayList<>();
    }

    public ArrayList<Buyer> getResults() {
        return results;
    }

    public String getCriteria() {
        return criteria;
    }
}
