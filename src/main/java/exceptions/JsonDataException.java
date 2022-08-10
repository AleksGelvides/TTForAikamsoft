package exceptions;

public class JsonDataException extends Exception{
    private String type;
    private String message;

    public JsonDataException(String type, String message){
        super(message);
    }
}
