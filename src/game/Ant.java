package game;

import com.sun.istack.internal.NotNull;

/**
 * Created by mati on 2016-05-18.
 * TODO: comments.
 */
public class Ant {
    private Position position;
    private Direction lookingDirection = Direction.RIGHT;

    Ant(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @NotNull
    public void move(Direction direction) {
        this.position.move(direction);
        lookingDirection = direction;
    }

    public Direction getCurrentDirection() {

        return lookingDirection;
    }


}
