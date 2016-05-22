package game;

import com.sun.istack.internal.NotNull;

/**
 * Created by mati on 2016-05-18.
 *
 */
class Ant {

    private Position position;
    //all ants look to the East when they born, don't ask why. They are weird.
    private Direction lookingDirection = Direction.RIGHT;

    Ant(Position position){
        this.position = position;
    }


    Position getPosition() {
        return position;
    }

    //say me where i should go and i will go there;
    @NotNull
    void move(Direction direction) {
        this.position.move(direction);
        lookingDirection = direction;
    }

    //last move direction;
    Direction getCurrentDirection() {

        return lookingDirection;
    }


}
