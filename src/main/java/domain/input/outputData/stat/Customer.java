package domain.input.outputData.stat;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Purchase> purchases;

    public Customer(String name) {
        this.name = name;
        this.purchases = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }
}
