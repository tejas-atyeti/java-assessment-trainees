package main.java.Exception;

public class ProcessingErrorException extends RuntimeException{
    public ProcessingErrorException(String message){
        super(message);
    }
}
