import domain.input.inputData.InputData;
import file_manager.IOManager;
import jsonMapper.JsonHandler;
import responses.Error;
import responses.interfaces.Responce;

public class Main {
    public static void main(String[] args) {

        try {
            switch (args[0]){
                case "stat":
                    stat(args[0], args[1]);
                    break;
                case "search":
                    search(args[0], args[1]);
                    break;
                default:
                    System.out.println("Неверная команда: \n" +
                            "\"search\" для поиска. Пример: \"search path.json\"\n" +
                            "\"stat\" для запроса статистики. Пример: \"stat path.json\"");
            }
        }catch (Exception e){
            Responce response = new Error(e.getMessage());
            IOManager.createJson(args[1], JsonHandler.createResponseJson(response));
        }
    }

    static void search(String param, String pathJsonFile) throws Exception{
        System.out.println("Path to json: " + pathJsonFile);
        String json = IOManager.readJson(pathJsonFile);
        InputData data = JsonHandler.readJsonFile(param, json);
    }

    static void stat(String param, String pathJsonFile) throws Exception{
        System.out.println("Path to json: " + pathJsonFile);
        String json = IOManager.readJson(pathJsonFile);
        InputData data = JsonHandler.readJsonFile(param, json);
    }
}
