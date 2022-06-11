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
        BasicInstruction i = new BasicInstruction(new Command("HOME", CommandType.BASICINSTRUCTION));
        assertEquals(i.getCommand().getName(), "HOME");
        assertEquals(i.getCommand().getType(), CommandType.BASICINSTRUCTION);
    }

    @Test
    public void testSingleParameterInstruction(){
        SingleParameterInstruction i = new SingleParameterInstruction(new Command("FORWARD", CommandType.SINGLEPARAMETERINSTRUCTION), 20);
        assertEquals(i.getCommand().getName(), "FORWARD");
        assertEquals(i.getCommand().getType(), CommandType.SINGLEPARAMETERINSTRUCTION);
        assertEquals(i.getParam(), 20);
    }

    @Test
    public void testColorInstruction(){
        ColorInstruction i = new ColorInstruction(new Command("SETPENCOLOR", CommandType.COLORINSTRUCTION), Color.BLACK);
        assertEquals(i.getCommand().getName(), "SETPENCOLOR");
        assertEquals(i.getCommand().getType(), CommandType.COLORINSTRUCTION);
        assertEquals(i.getColor(), Color.BLACK);
    }

    @Test
    public void testRepeatInstruction(){
        Color color = Color.WHITE;
        List<BasicInstruction> instructions = new ArrayList<>();
        BasicInstruction first = new BasicInstruction(new Command("HOME", CommandType.BASICINSTRUCTION));
        ColorInstruction second = new ColorInstruction(new Command("SETPENCOLOR", CommandType.COLORINSTRUCTION), Color.RED);
        instructions.add(first);
        instructions.add(second);

        RepeatInstruction i = new RepeatInstruction(3, instructions);
        assertEquals(i.getCommand().getName(), "REPEAT");
        assertEquals(i.getCommand().getType(), CommandType.REPEATINSTRUCTION);
        assertEquals(i.getTimes(), 3);
        assertEquals(first, i.getInstructionList().get(0));
        assertEquals(second, i.getInstructionList().get(1));
    }
}
