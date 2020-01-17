/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.Configuration;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int INTAKE_BUTTON = 0;
    public static final int SHOOT_BUTTON = 1;
    public static final int CLIMB_BUTTON = 2;
    public static final int SPINNER_BUTTON = 3;

    public static final int INTAKE_MOTOR_ID = 0;
    public static final int SHOOT_MOTOR_ID = 1;
    public static final int CLIMB_MOTOR_ID = 2;

    public static final int FRONT_LEFT_TALON_ID = 0;
    public static final int FRONT_RIGHT_TALON_ID = 1;
    public static final int BACK_LEFT_TALON_ID = 2;
    public static final int BACK_RIGHT_TALON_ID = 3;

    public static final int CLIMB_SPEED = 0;
    public static final int INTAKE_SPEED = 1;
    public static final int SHOOT_SPEED = 2;
}
