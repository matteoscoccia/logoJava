package it.unicam.cs.ScocciaMatteo119748.logo.instruction;

import it.unicam.cs.ScocciaMatteo119748.logo.components.CursorImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.components.PlaygroundImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;
import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InstructionTest {

    private CursorImpl c;
    private PlaygroundImpl play;

    @Before
    public void init(){
        c = new CursorImpl();
        play = new PlaygroundImpl(800, 800);
    }


    @Test
    public void testMoveInstruction(){
        MoveInstruction i = new MoveInstruction(InstructionType.FORWARD, 50);
        assertEquals(i.getType(), InstructionType.FORWARD);
        assertEquals(i.getParameter(), 50);
    }

    @Test
    public void testPerformMovementInstruction(){
        MoveInstruction i = new MoveInstruction(InstructionType.FORWARD, 50);
        i.performInstruction(c, play);
        assertEquals(c.getPosition().getX(), 50, 0);
        assertEquals(c.getPosition().getY(), 0, 0);
    }

    @Test
    public void testPenInstruction(){
        PenInstruction i = new PenInstruction(InstructionType.SETPENSIZE, 15);
        i.performInstruction(c, play);
        assertEquals(c.getPenSize(), 15);
        assertEquals(i.getType(), InstructionType.SETPENSIZE);
        assertEquals(i.getParameter(), 15);
    }

    @Test
    public void testCursorColorInstruction(){
        Color color = new Color(30, 120, 200);
        CursorColorInstruction i = new CursorColorInstruction(InstructionType.SETPENCOLOR, color);
        i.performInstruction(c, play);
        assertEquals(i.getType(), InstructionType.SETPENCOLOR);
        assertEquals(i.getColor(), new Color(30, 120, 200));
        assertEquals(c.getLineColor(), color);
    }

    @Test
    public void testPlaygroundInstruction(){
        Color color = new Color(100, 30, 20);
        PlaygroundInstruction i = new PlaygroundInstruction(InstructionType.SETSCREENCOLOR, color);
        i.performInstruction(c, play);
        assertEquals(i.getType(), InstructionType.SETSCREENCOLOR);
        assertEquals(i.getColor(), color);
    }

    @Test
    public void testRepeatInstruction(){
        ArrayList<LogoInstruction> list = new ArrayList<>();
        list.add(new MoveInstruction(InstructionType.FORWARD, 50));
        list.add(new MoveInstruction(InstructionType.LEFT, 90));
        RepeatInstruction<LogoInstruction> rep = new RepeatInstruction(3, list);
        ArrayList<Cursor> cursorList = rep.performNestedInstruction(c, play);
        Cursor finalCursor = cursorList.get(cursorList.size() -1);
        assertEquals(0, finalCursor.getPosition().getX(), 0);
        assertEquals(50, finalCursor.getPosition().getY(), 0);
        assertEquals(270, finalCursor.getDirection());
    }
}
