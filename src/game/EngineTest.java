package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-19.
 * TODO: comments.
 */
public class EngineTest {
    Engine engine;
    Board board;
    Ant ant;
    Position position;
    @Before
    public void setUp() throws Exception {
        board = new Board(200, 300);
        Position.setBoard(board);
        position = new Position(100, 100);
        ant = new Ant(position);
        engine = new Engine(board, ant);
    }

    @Test
    public void moveAll() throws Exception {
        engine.moveAll();
        assertEquals(99, ant.getPosition().getY());
        engine.moveAll();
        assertEquals(99, ant.getPosition().getX());
        engine.moveAll();
        assertEquals(100, ant.getPosition().getY());
        engine.moveAll();
        assertEquals(100, ant.getPosition().getX());
        engine.moveAll();
        assertEquals(101, position.getY());
    }


}