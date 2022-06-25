package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.components.CursorImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.components.PlaygroundImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InstructionConverterImplTest {

    static InstructionConverterImpl converter;

    @BeforeClass
    public static void prepareConverter(){
        converter = InstructionConverterImpl.getInstance();
    }

    @Test
    public void convertTest(){
        String commands = """
                RIGHT 90
                SETPENCOLOR 80 30 45
                REPEAT 3 [LEFT 50 FORWARD 90]""";
        ArrayList<LogoInstruction> in = new ArrayList<>();
        in.add(new MoveInstruction(InstructionType.RIGHT, 90));
        in.add(new CursorColorInstruction(InstructionType.SETPENCOLOR, new Color (89, 30, 45)));
        ArrayList<LogoInstruction> converted = converter.convert(new ArrayList<>(Arrays.asList(commands.split("\n"))));
        CursorImpl c = new CursorImpl();
        PlaygroundImpl play = new PlaygroundImpl(500, 500);
        converted.get(1).performInstruction(c, play);
        assertEquals(c.getLineColor(), new Color(80, 30, 45));
    }

    @Test
    public void testConvertInstructionType(){
        InstructionType type = converter.convertInstructionType("PENUP");
        InstructionType type2 = converter.convertInstructionType("WRONG INSTRUCTION");
        assertEquals(InstructionType.PENUP, type);
        assertNull(type2);
    }

}
