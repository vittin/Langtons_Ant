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

    public static void setBoard(Board board) {
        Position.board = board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void changeX(int difference) throws OutOfBoundsException {
        if ((this.x < 1 && difference < 0) ||
                (this.x + 1 > board.getWidth() && difference > 0)) {

            throw new OutOfBoundsException("Out of map");
        } else {
            this.x += difference;
        }

    }

    private void changeY(int difference) throws OutOfBoundsException {
        if ((this.y < 1 && difference < 0) ||
                (this.y + 1 > board.getHeight() && difference > 0)) {

            throw new OutOfBoundsException("Out of map");
        } else {
            this.y += difference;
        }
    }

    public void move(Direction direction) {
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
