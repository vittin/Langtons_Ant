package game;

/**
 * Created by mati on 2016-05-18.
 * TODO: comments.
 */


class Position {
    private int x;
    private int y;
    private static Board board;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //position is always on the board;
    static void setBoard(Board board) {
        Position.board = board;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    private void changeX(int difference) throws OutOfBoundsException {
        if ((this.x <= 1 && difference < 0)) {
            this.x = board.getWidth() - 1;
        } else if((this.x + 1 >= board.getWidth() && difference > 0)){
            this.x = 1;
        } else {
            this.x += difference;
        }

    }

    private void changeY(int difference) throws OutOfBoundsException {
        if ((this.y <= 1 && difference < 0)) {
            this.y = board.getHeight() - 1;
        } else if((this.y + 1 >= board.getHeight() && difference > 0)) {
            this.y = 1;
        }else {
            this.y += difference;
        }
    }

    void move(Direction direction) {
        try {
            switch (direction) {
                case LEFT:
                    changeX(-1);
                    break;
                case RIGHT:
                    changeX(1);
                    break;
                case UP:
                    changeY(-1);
                    break;
                case DOWN:
                    changeY(1);
                    break;
            }
        }
        catch(OutOfBoundsException ignored){}
    }

    int hashCode(int multiplier) {
        return y * multiplier + x;
    }

}
