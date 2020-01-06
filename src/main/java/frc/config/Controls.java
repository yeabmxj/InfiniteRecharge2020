package frc.config;

import edu.wpi.first.wpilibj.Joystick;

import static frc.config.Constants.*;

public class Controls {
    public static Joystick joy = new Joystick(0);

    public static double getX() { return joy.getRawAxis(JOYSTICK_X_AXIS); }
    public static double getY() { return joy.getRawAxis(JOYSTICK_Y_AXIS); }

    public static boolean getIncrease() { return joy.getRawAxis()}
}
