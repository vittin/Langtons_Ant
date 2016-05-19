package game;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * Created by mati on 2016-05-18.
 */
public class Engine {
    Board board;
    ArrayList<Ant> ants;
    GameThread gameThread;
    Engine(Board board, Ant ant){
        this.board = board;
        ants = new ArrayList<>();
        ants.add(ant);
    }

    Engine(Board board, ArrayList<Ant> ants){
        this.board = board;
        this.ants = ants;
    }

    void start() {
        gameThread = new GameThread(this);
        gameThread.run();
    }

    void stop() {
        gameThread.stop();
    }

    @NotNull
    private Direction findNextDirection(Direction direction, boolean status){
        Direction dir = null; //NEVER HAPPENS;
        switch (direction){
            case UP: dir = (status) ? Direction.RIGHT : Direction.LEFT; break;
            case LEFT: dir = (status) ? Direction.UP : Direction.DOWN; break;
            case DOWN: dir = (status) ? Direction.LEFT : Direction.RIGHT; break;
            case RIGHT: dir = (status) ? Direction.DOWN : Direction.UP; break;
        }
        return dir;
    }

    void moveAll() {
        ants.forEach(ant -> {
            Position position = ant.getPosition();
            try {
                Field field = board.getField(position);
                boolean fieldStatus = field.getStatus();
                field.trigger();
                Direction nextMove = findNextDirection(ant.getCurrentDirection(), fieldStatus);
                ant.move(nextMove);
            } catch(OutOfBoundsException e) {
                e.printStackTrace();
            }
        });
    }

    void showResults() {
        //todo: display;
    }
}
