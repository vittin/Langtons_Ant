package game;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-19.
 * TODO: comments.
 */
public class BoardTest {

    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(200, 300);
    }

    @Test (expected = IllegalArgumentException.class)
    public void badSize() throws Exception {
        board = new Board(0, 300);
    }

    @Test (expected = IllegalArgumentException.class)
    public void badSize2() throws Exception {
        board = new Board(200, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void badSize3() throws Exception {
        board = new Board(200, -300);
    }

    @Test
    public void arraySize() throws Exception {
        Position position = new Position(199, 299);
        board.getField(position);
    }

    @Test (expected = OutOfBoundsException.class)
    public void fieldNotExist() throws Exception {
        Position position = new Position(200, 301);
        board.getField(position);
    }

}