package game;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-19.
 * TODO: comments.
 */
public class FieldTest {

    @Test
    public void triggerTest() {
        Field field = new Field();
        assertEquals(false, field.getStatus());
        field.trigger();
        assertEquals(true, field.getStatus());
        field.trigger();
        assertEquals(false, field.getStatus());
    }

}