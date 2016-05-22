package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-18.
 * TODO: comments.
 */
public class PositionTest {
    private Position position;
    private Board board;
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
        assertEquals(99, position.getX());
    }

    @Test
    public void invalidMoveUp() throws Exception {

        position.move(Direction.UP);
        assertEquals(99, position.getY());
    }

    @Test
    public void skipRightBorder() throws Exception {

        position = new Position(board.getWidth() -1, 5);
        position.move(Direction.RIGHT);
        assertEquals(1, position.getX());
    }

    @Test
    public void skipDownBorder() throws Exception {

        position = new Position(5, board.getHeight() -1);
        position.move(Direction.DOWN); //1
        assertEquals(1, position.getY());
    }

}