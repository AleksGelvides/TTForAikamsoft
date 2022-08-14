package domain.input.inputData;

import domain.input.inputData.criteria.Criteria;

import java.util.List;

public class InputData {
    private List<Criteria> criteriaList;

    public static InputData inputDataBuilder(List<Criteria> criteriaList){
        InputData inputData = new InputData();
        inputData.setCriteriaList(criteriaList);
        return inputData;
    }
    private void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }
}
