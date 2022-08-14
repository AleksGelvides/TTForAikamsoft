package domain.input.inputData.criteria;

public class NotDetermined extends Criteria{

    private String fail = "Not found: ";

    public NotDetermined(String failJson) {
        this.fail = fail.concat(failJson);
    }

    public String getFail() {
        return fail;
    }

    public void setFail(String fail) {
        this.fail = fail;
    }
}
