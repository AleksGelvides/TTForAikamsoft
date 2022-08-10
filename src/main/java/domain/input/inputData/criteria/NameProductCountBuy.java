package domain.input.inputData.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NameProductCountBuy extends Criteria {

    private String productName;
    private int minTimes;

    public NameProductCountBuy(@JsonProperty("productName") String productName,
                               @JsonProperty("minTimes") int minTimes) {
        this.productName = productName;
        this.minTimes = minTimes;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getMinTimes() {
        return minTimes;
    }

    public void setMinTimes(int minTimes) {
        this.minTimes = minTimes;
    }
}
