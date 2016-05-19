package game;

import com.sun.istack.internal.NotNull;

/**
 * Created by mati on 2016-05-18.
 * TODO: comments.
 */
public class Board {
    private int width;
    private int height;
    private int size;
    private Field[] fields;

    Board(int width, int height){

        if (width < 1 || height < 1){
            throw new IllegalArgumentException("Width and height must be greater than 0");
        }
        this.size = width * height;
        this.width = width;
        this.height = height;
        this.fields = new Field[size];
        for (int i = 0; i < size; i++){
            fields[i] = new Field();
        }

    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    int getSize() {
        return size;
    }

    @NotNull
    Field getField(Position position) throws OutOfBoundsException {
        if (position.hashCode(width) < this.getSize()) {
            int x = position.getX();
            int y = position.getY();
            return fields[y * width + x];
        } else {
            throw new OutOfBoundsException("Illegal position");
        }
    }

}
