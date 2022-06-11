package it.unicam.cs.ScocciaMatteo119748.logo.instruction;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InstructionTest {
/*
    @Test
    public void testBasicInstruction(){
        BasicInstruction i = new BasicInstruction(CommandType.HOME);
        assertEquals(i.getCommand(), CommandType.HOME);
    }

    @Test
    public void testSingleParameterInstruction(){
        SingleParameterInstruction i = new SingleParameterInstruction(CommandType.FORWARD, 20);
        assertEquals(i.getCommand(), CommandType.FORWARD);
        assertEquals(i.getParam(), 20);
    }

    @Test
    public void testColorInstruction(){
        ColorInstruction i = new ColorInstruction(CommandType.SETPENCOLOR, Color.BLACK);
        assertEquals(i.getCommand(), CommandType.SETPENCOLOR);
        assertEquals(i.getColor(), Color.BLACK);
    }

    @Test
    public void testRepeatInstruction(){
        Color color = Color.WHITE;
        List<BasicInstruction> instructions = new ArrayList<>();
        BasicInstruction first = new BasicInstruction(CommandType.HOME);
        ColorInstruction second = new ColorInstruction(CommandType.SETPENCOLOR, Color.RED);
        instructions.add(first);
        instructions.add(second);

        RepeatInstruction i = new RepeatInstruction(3, instructions);
        assertEquals(i.getCommand(), CommandType.REPEAT);
        assertEquals(i.getTimes(), 3);
        assertEquals(first, i.getInstructionList().get(0));
        assertEquals(second, i.getInstructionList().get(1));
    }*/
}
