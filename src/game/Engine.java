package game;

import com.sun.istack.internal.NotNull;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.Contract;


import java.util.ArrayList;

/**
 * Created by mati on 2016-05-18.
 *
 */

class Engine {
    private Board board;
    private ArrayList<Ant> ants;
    private GameThread gameThread;

    //constructor1, only one ant;
    Engine(Board board, Ant ant){
        this.board = board;
        ants = new ArrayList<>();
        ants.add(ant);
    }

    //constructor2, more ants = more fun;
    Engine(Board board, ArrayList<Ant> ants){
        this.board = board;
        this.ants = ants;
    }

    //create new Game;
    void start() {
        gameThread = new GameThread(this);
        new Thread(gameThread).start();
    }

    //end Game;
    static void stop() {
        GameThread.stop();
    }

    //app logic - where ant should go;
    @Contract(pure = true)
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

    //means "next tour" also.
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

    //draw results, the game is too simply to implement MVC;
    void showResults() {

        ants.forEach(ant -> {

            int x = ant.getPosition().getX();
            int y = ant.getPosition().getY();
            Color color = Color.WHITE;

            try {
                //check field under the ant;
                boolean status = board.getField(ant.getPosition()).getStatus();
                color = (status) ? Color.WHITE : Color.BLACK;
            } catch (OutOfBoundsException ignored){}

            //draw only new points, old points won't be removed;
            View.draw(x,y, color);

        });

    }
}
