package domain.input.inputData;

import domain.input.inputData.criteria.Criteria;

import java.util.List;

public class InputData {
    private List<? extends InputData> inputData;

    public static InputData inputDataBuilder(List<? extends InputData> inputDataList){
        InputData inputData = new InputData();
        inputData.setInputData(inputDataList);
        return inputData;
    }
    private void setInputData(List<? extends InputData> inputData) {
        this.inputData = inputData;
    }

    public List<? extends InputData> getInputData() {
        return inputData;
    }
}
