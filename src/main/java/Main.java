import services.DataService;

public class Main {
    private static DataService service = new DataService();

    public static void main(String[] args) {
        service.createSearch(args[0], args[1]);
    }
}
