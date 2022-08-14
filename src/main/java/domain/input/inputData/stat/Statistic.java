package domain.input.inputData.stat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.input.inputData.InputData;
import domain.input.inputData.criteria.Criteria;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Statistic extends InputData {

    private LocalDate startDate;
    private LocalDate endDate;

    public Statistic(@JsonProperty("startDate") Date startDate,
                     @JsonProperty("endDate") Date endDate) {
        this.startDate = LocalDate.from(startDate.toInstant().atZone(ZoneId.systemDefault()));
        this.endDate = LocalDate.from(endDate.toInstant().atZone(ZoneId.systemDefault()));
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
