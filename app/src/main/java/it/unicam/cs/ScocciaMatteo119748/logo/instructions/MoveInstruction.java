package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.components.Playground;

import java.awt.*;

/**
 * This implements a move instruction that moves the cursor by the specified parameter
 */
public class MoveInstruction implements LogoInstruction{

    private final InstructionType type;
    private final int parameter;

    public MoveInstruction(InstructionType type, int parameter) {
        this.type = type;
        this.parameter = parameter;
    }

    /**
     * Performs the movement instruction on the given cursor
     * @param start starting cursor state
     * @return ending cursor state
     */
    @Override
    public Cursor performInstruction(Cursor start, Playground field) {
        switch(this.type){
            case FORWARD -> start.setPosition(move(start.getPosition(), start.getDirection(), parameter));
            case BACKWARD -> start.setPosition(move(start.getPosition(), start.getDirection(), -parameter));
            case LEFT -> start.setDirection((start.getDirection() + parameter)%360);
            case RIGHT -> start.setDirection((start.getDirection() - parameter)%360);
            case HOME -> start.setPosition(field.getHome());
        }
        return start;
    }

    /**
     * Moves the point by parameter distance on the given angle direction
     * @param point startingo coordinates
     * @param angle direction of movement
     * @param parameter distance
     * @return new point's position
     */
    private Point move(Point point, int angle, int parameter) {
        var x = point.getX();
        var y = point.getY();
        var rad = radians(angle % 360);

        x += parameter*Math.cos(rad);
        y += parameter*Math.sin(rad);

        return new Point((int)Math.round(x), (int)Math.round(y));
    }

    double radians (int degrees) {
        return degrees * Math.PI / 180;
    }
}


