package domain.input.inputData.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.input.inputData.InputData;

import java.time.LocalDate;
import java.util.Date;

public class Statistic extends InputData {
    private Date startDate;
    private Date endDate;

    public Statistic(@JsonProperty("startDate") Date startDate,
                     @JsonProperty("endDate") Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
