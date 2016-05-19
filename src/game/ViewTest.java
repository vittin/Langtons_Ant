package game;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-18.
 * TODO: comments.
 */

public class ViewTest {
    View view;
    @org.junit.Before
    public void setUp() throws Exception {
        view = new View();
    }

    @Test
    public void createCanvas(){
        view.createCanvas(800,600);
        assertEquals(800, view.canvas.getWidth());
        assertEquals(600, view.canvas.getHeight());
    }

    @Test
    public void getColor(){
        Color color = view.getColor(new Position(2,3));
        assertEquals(Color.WHITE, color);
    }

    @Test
    public void drawBlack(){
        Position position = new Position(2,3);
        view.draw(position, Color.BLACK);
        assertEquals(Color.BLACK, view.getColor(position));
    }

    @Test
    public void drawWhite(){
        Position position = new Position(2,3);
        view.draw(position, Color.WHITE);
        assertEquals(Color.WHITE, view.getColor(position));
    }

    @Test (expected = OutOfBoundsException.class)
    public void BadSize(){
        view.createCanvas(0,23);
    }

    @Test (expected = OutOfBoundsException.class)
    public void BadSize2(){
        view.createCanvas(23,0);
    }

    @Test (expected = OutOfBoundsException.class)
    public void BadSize3(){
        view.createCanvas(-65,23);
    }

}