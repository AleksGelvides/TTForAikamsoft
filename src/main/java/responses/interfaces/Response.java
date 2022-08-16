package responses.interfaces;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Response {

    String getType();

    Object getResults();

}
