package game;

/**
 * Created by mati on 2016-05-18.
 * TODO: comments.
 */
public class OutOfBoundsException extends Exception {

    OutOfBoundsException(String string){
        super(string);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }


}
