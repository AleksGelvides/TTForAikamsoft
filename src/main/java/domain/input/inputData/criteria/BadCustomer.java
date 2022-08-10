package domain.input.inputData.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BadCustomer extends Criteria {

    private int badCustomer;

    public BadCustomer(@JsonProperty("badCustomers") int badCustomer) {
        this.badCustomer = badCustomer;
    }

    public int getBadCustomer() {
        return badCustomer;
    }

    public void setBadCustomer(int badCustomer) {
        this.badCustomer = badCustomer;
    }
}
