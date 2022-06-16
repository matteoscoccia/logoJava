package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class InstructionConverterImplTest {

    static InstructionConverterImpl converter;

    @BeforeClass
    public static void prepareConverter(){
        converter = InstructionConverterImpl.getInstance();
    }

    @Test
    //TODO FINIRE QUESTO METODO
    public void convertTest(){
        /*String commands = """
                RIGHT 90
                SETPENCOLOR 80 30 45
                REPEAT 3 [LEFT 50 FORWARD 90]""";
        ArrayList<BasicInstruction> in = new ArrayList<>();
        in.add(new SingleParameterInstruction(new Command("RIGHT", CommandType.SINGLEPARAMETERINSTRUCTION), 90));
        in.add(new ColorInstruction(new Command("SETPENCOLOR", CommandType.COLORINSTRUCTION), new Color(80, 30, 45)));
        ArrayList<BasicInstruction> nested = new ArrayList<>();
        nested.add(new BasicInstruction(new Command("LEFT 50", CommandType.BASICINSTRUCTION)));
        nested.add(new BasicInstruction(new Command("FORWARD 90", CommandType.BASICINSTRUCTION)));
        in.add(new RepeatInstruction<BasicInstruction>(3, nested));
        ArrayList<BasicInstruction> converted = converter.convert(new ArrayList<String>(Arrays.asList(commands.split(" "))));
        assertEquals(in.get(0), converted.get(0));
        assertEquals(in.get(1), converted.get(1));*/
    }


}
