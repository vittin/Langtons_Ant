package game;

/**
 * Created by mati on 2016-05-19.
 *
 */
 class Field {
    //all fields are white by default;
    private boolean status = false;

    void trigger(){
        this.status = !this.status;
    }

    boolean getStatus() {
        return this.status;
    }
}
