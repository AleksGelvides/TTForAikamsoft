package dbcommon.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import responses.interfaces.Response;

public class Buyer implements Response {
    private String lastName;
    private String firstName;

    public Buyer(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonIgnoreProperties
    @Override
    public String getType() {
        return null;
    }

    @JsonIgnoreProperties
    @Override
    public Object getResults() {
        return null;
    }
}
