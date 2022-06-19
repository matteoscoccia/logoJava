package it.unicam.cs.ScocciaMatteo119748.logo.components;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class PlaygroundImplTest {

    @Test
    public void testPlaygroundDefaultColor(){
        Playground field = new PlaygroundImpl(300,200);
        assertEquals(200, field.getHeight());
        assertEquals(300, field.getWidth());
        assertEquals(Color.WHITE, field.getBackground());
    }

    @Test
    public void testPlaygroundWithBackgroundColor(){
        Playground field = new PlaygroundImpl(300,200, Color.BLACK);
        assertEquals(200, field.getHeight());
        assertEquals(300, field.getWidth());
        assertEquals(Color.BLACK, field.getBackground());
    }
}
