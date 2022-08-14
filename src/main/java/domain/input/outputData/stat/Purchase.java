package domain.input.outputData.stat;

public class Purchase {
    private String name;
    private double expenses;

    public Purchase(String name, double expenses) {
        this.name = name;
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public double getExpenses() {
        return expenses;
    }
}
