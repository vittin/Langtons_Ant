package game;

import com.sun.istack.internal.NotNull;

/**
 * Created by mati on 2016-05-18.
 *
 */
class Board {
    private final int width;
    private final int height;
    private final int size;
    //store all fields;
    private final Field[] fields;

    Board(int width, int height){
        //0 or minus signed numbers as map size? bad idea;
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

        //look strange, but position must be linked to a board; we want get f.ex. (2,2) point from board;
        Position.setBoard(this);
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    private int getSize() {
        return size;
    }
    
    @NotNull
    Field getField(Position position) throws OutOfBoundsException {
        //hashcode is ordinal number too;
        if (position.hashCode(width) < this.getSize()) {
            int x = position.getX();
            int y = position.getY();
            return fields[y * width + x];
        } else {
            throw new OutOfBoundsException("Illegal position");
        }
    }

}
