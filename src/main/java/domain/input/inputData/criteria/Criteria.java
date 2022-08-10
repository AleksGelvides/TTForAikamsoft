package domain.input.inputData.criteria;

import domain.input.inputData.InputData;

import java.util.HashMap;
import java.util.Map;

public abstract class Criteria extends InputData {
    private static final Map<String, Class> classMap = new HashMap<>();

    static{
        classMap.put("{lastName}", LastNameCriteria.class);
        classMap.put("{productName}{minTimes}", NameProductCountBuy.class);
        classMap.put("{minExpenses}{maxExpenses}", MinMaxExpences.class);
        classMap.put("{badCustomers}", BadCustomer.class);
    }
    public static Class getClassType(String jsonKey){
        String[] keyArray;
        if(jsonKey.indexOf("\",\"") != 0){
            keyArray = jsonKey.split(",");
        } else {
            keyArray = new String[]{jsonKey};
        }
        StringBuilder keys = new StringBuilder();
        for (int x = 0; x <= keyArray.length - 1; x++ ){
            keys.append("{" + keyArray[x]
                    .replaceAll("\\{", "").
                    replaceAll("\\}", "")
                    .replaceAll("\"","")
                    .replaceAll(":.*", "") + "}");
        }
        return classMap.get(keys.toString());
    }
}
