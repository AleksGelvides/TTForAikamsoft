import domain.input.inputData.InputData;
import domain.input.inputData.criteria.Criteria;
import file_manager.IOManager;
import jsonMapper.JsonHandler;

public class Main {
    public static void main(String[] args) {
        try {
            switch (args[0]){
                case "stat":
                    stat(args[1]);
                    break;
                case "search":
                    search(args[2]);
                    break;
                default:
                    System.out.println("Неверная команда: \n" +
                            "\"search\" для поиска. Пример: \"search path.json\"\n" +
                            "\"stat\" для запроса статистики. Пример: \"stat path.json\"");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void search(String pathJsonFile) throws Exception{
        System.out.println("Path to json: " + pathJsonFile);
    }

    static void stat(String pathJsonFile) throws Exception{
        System.out.println("Path to json: " + pathJsonFile);
        String json = IOManager.readJson(pathJsonFile);
        InputData data = JsonHandler.readJsonFile(json);
    }
}
