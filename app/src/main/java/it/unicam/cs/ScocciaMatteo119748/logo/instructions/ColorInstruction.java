package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import java.awt.*;

/**
 * Represents an instruction that specifies a color, like pen color or fill color
 */
public class ColorInstruction extends BasicInstruction{

    private final Color color;

    /**
     * Builds an instruction that represents a color
     * @param command command to perform
     * @param color color needed by the command
     */
    public ColorInstruction(Command command, Color color) {
        super(command);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
