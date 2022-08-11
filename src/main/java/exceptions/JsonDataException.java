package exceptions;

public class JsonDataException extends Exception{
    private String message;
    public JsonDataException(String message){
        super(message);
    }
}
