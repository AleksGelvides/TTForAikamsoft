package domain.input.inputData.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class LastNameCriteria extends Criteria {
    private String lastName;

    public LastNameCriteria(@JsonProperty("lastName") String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "lastName: " + this.lastName;
    }

}
