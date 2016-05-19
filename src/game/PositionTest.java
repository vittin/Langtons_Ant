package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-18.
 * TODO: comments.
 */
public class PositionTest {
    Position position;
    Board board;
    @Before
    public void setUp() throws Exception {
        position = new Position(1,1);
        board = new Board(100,100);
        Position.setBoard(board);
    }

    @Test
    public void getX() throws Exception {
        assertEquals(1,position.getX());
    }

    @Test
    public void getY() throws Exception {
        assertEquals(1,position.getY());

    }

    @Test
    public void move() throws Exception {
        position.move(Direction.RIGHT);
        assertEquals(2,position.getX());

        position.move(Direction.DOWN);
        assertEquals(2,position.getY());

        position.move(Direction.LEFT);
        assertEquals(1,position.getX());

        position.move(Direction.UP);
        assertEquals(1,position.getY());
    }

    @Test
    public void invalidMoveLeft() throws Exception {
        position.move(Direction.LEFT);
        position.move(Direction.LEFT);
        position.move(Direction.LEFT);
        position.move(Direction.LEFT);
        assertEquals(0, position.getX());
    }

    @Test
    public void invalidMoveUp() throws Exception {
        position.move(Direction.UP);
        position.move(Direction.UP);
        position.move(Direction.UP);
        position.move(Direction.UP);
        assertEquals(0, position.getY());
    }

    @Test
    public void invalidMoveRight() throws Exception {

        position = new Position(board.getWidth() -1, 5);
        position.move(Direction.RIGHT);
        position.move(Direction.RIGHT);
        position.move(Direction.RIGHT);
        position.move(Direction.RIGHT);
        assertEquals(100, position.getX());
    }

    @Test
    public void invalidMoveDown() throws Exception {
        position = new Position(5, board.getHeight() -1);
        position.move(Direction.DOWN);
        position.move(Direction.DOWN);
        position.move(Direction.DOWN);
        position.move(Direction.DOWN);
        assertEquals(100, position.getY());
    }

}