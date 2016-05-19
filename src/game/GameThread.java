package game;

/**
 * Created by mati on 2016-05-19.
 * TODO: comments.
 */
public class GameThread implements Runnable {
    private boolean active = true;
    private Engine engine;

    GameThread(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void run() {
        while (active){
            engine.moveAll();
            engine.showResults();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        active = false;
    }
}
