package game;

/**
 * Created by mati on 2016-05-18.
 *
 */
class OutOfBoundsException extends Exception {

    OutOfBoundsException(String string){
        super(string);
        //Something went wrong, so game was finished;
        Engine.stop();
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
