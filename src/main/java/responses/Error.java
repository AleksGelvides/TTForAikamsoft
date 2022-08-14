package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import responses.interfaces.Response;

@JsonIgnoreProperties({"results"})
public class Error implements Response {
    @JsonProperty("type")
    public String type;

    @JsonProperty("message")
    public String result;

    public Error(String result){
        this.type = "error";
        this.result = result;
    }
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getResults() {
        return result;
    }
}
