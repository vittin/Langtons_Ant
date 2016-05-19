package game;

/**
 * Created by mati on 2016-05-19.
 * TODO: comments.
 */
public class Field {
    private boolean status = false;
    void trigger(){
        this.status = !this.status;
    }
    boolean getStatus() {
        return this.status;
    }
}
