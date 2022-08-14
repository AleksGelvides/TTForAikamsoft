package domain.input.outputData.stat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import responses.interfaces.Response;
import java.util.ArrayList;

@JsonIgnoreProperties({"results"})
public class OutputStat implements Response {
    private String type;
    private long totalDays;
    private ArrayList<Customer> customers;

    public OutputStat(String type, long totalDays) {
        this.type = type;
        this.totalDays = totalDays;
        this.customers = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    @Override
    public Object getResults() {
        return null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
