package domain.input.inputData.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MinMaxExpences extends Criteria {
    private int minExpenses;
    private int maxExpenses;

    public MinMaxExpences(@JsonProperty("minExpenses") int minExpenses,
                          @JsonProperty("maxExpenses") int maxExpenses) {
        this.minExpenses = minExpenses;
        this.maxExpenses = maxExpenses;
    }

    public int getMinExpenses() {
        return minExpenses;
    }

    public void setMinExpenses(int minExpenses) {
        this.minExpenses = minExpenses;
    }

    public int getMaxExpenses() {
        return maxExpenses;
    }

    public void setMaxExpenses(int maxExpenses) {
        this.maxExpenses = maxExpenses;
    }
}
