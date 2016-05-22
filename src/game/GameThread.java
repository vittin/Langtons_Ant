package game;

/**
 * Created by mati on 2016-05-19.
 *
 */
class GameThread implements Runnable {
    //by default, the Thread is ready to run;
    private static boolean active = true;

    private Engine engine;

    //each engine create own thread;
    GameThread(Engine engine) {
        this.engine = engine;
    }


    @Override
    public void run() {
        while (active){
            engine.moveAll();
            engine.showResults();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void stop() {
        active = false;
    }
}
