package it.unicam.cs.ScocciaMatteo119748.logo.instruction;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InstructionTest {

    @Test
    public void testBasicInstruction(){
        BasicInstruction i = new BasicInstruction(Command.HOME);
        assertEquals(i.getCommand(), Command.HOME);
    }

    @Test
    public void testSingleParameterInstruction(){
        SingleParameterInstruction i = new SingleParameterInstruction(Command.FORWARD, 20);
        assertEquals(i.getCommand(), Command.FORWARD);
        assertEquals(i.getParam(), 20);
    }

    @Test
    public void testColorInstruction(){
        ColorInstruction i = new ColorInstruction(Command.SETPENCOLOR, Color.BLACK);
        assertEquals(i.getCommand(), Command.SETPENCOLOR);
        assertEquals(i.getColor(), Color.BLACK);
    }

    @Test
    public void testRepeatInstruction(){
        Color color = Color.WHITE;
        List<BasicInstruction> instructions = new ArrayList<>();
        BasicInstruction first = new BasicInstruction(Command.HOME);
        ColorInstruction second = new ColorInstruction(Command.SETPENCOLOR, Color.RED);
        instructions.add(first);
        instructions.add(second);

        RepeatInstruction i = new RepeatInstruction(3, instructions);
        assertEquals(i.getCommand(), Command.REPEAT);
        assertEquals(i.getTimes(), 3);
        assertEquals(first, i.getInstructionList().get(0));
        assertEquals(second, i.getInstructionList().get(1));
    }
}
