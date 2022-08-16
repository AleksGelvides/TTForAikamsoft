package domain.input.outputData.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import responses.interfaces.Response;

import java.util.ArrayList;

public class OutputSearch implements Response {
    String type;
    ArrayList<ResultCommon> results;

    public OutputSearch(String type) {
        this.type = type;
        this.results = new ArrayList<>();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Object getResults() {
        return results;
    }

    public void addResults(ResultCommon result){
        this.results.add(result);
    }

}
