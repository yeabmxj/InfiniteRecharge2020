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
    public static final byte INTAKE_BUTTON = 0;
    public static final byte SHOOT_BUTTON = 1;
    public static final byte CLIMB_BUTTON = 2;
    public static final byte SPINNER_BUTTON = 3;
    public static final byte INCREASE_THROTTLE_BUTTON = 4;
    public static final byte DECREASE_THROTTLE_BUTTON = 5;
    public static final byte EXTEND_CLIMBER_BUTTON = 6;
    public static final byte RETRACT_CLIMBER_BUTTON = 7;

    public static final int JOYSTICK_X_AXIS = 0;
    public static final int JOYSTICK_Y_AXIS = 0;

    public static final byte INTAKE_MOTOR_ID = 0;
    public static final byte FLYWHEEL_MOTOR_ID = 1;
    public static final byte SPINNER_MOTOR_ID = 2;
    public static final byte STORAGE_MOTOR_ID = 3;
    public static final byte SCISSOR_LIFT_MOTOR_ID = 4;
    public static final byte WINCH_MOTOR_ID = 5;

    public static final byte FRONT_LEFT_TALON_ID = 0;
    public static final byte FRONT_RIGHT_TALON_ID = 1;
    public static final byte BACK_LEFT_TALON_ID = 2;
    public static final byte BACK_RIGHT_TALON_ID = 3;

    public static final double INTAKE_SPEED = 1;
    public static final double SHOOT_SPEED = 1;
    public static final double SPINNER_SPEED = 1;
    public static final double STORAGE_SPEED = 1;
    public static final double SCISSOR_LIFT_FORWARD_SPEED = 1;
    public static final double SCISSOR_LIFT_BACKWARD_SPEED = 1;
    public static final double WINCH_FORWARD_SPEED = 1;
    public static final double WINCH_BACKWARD_SPEED = 1;

    public static final double SCISSOR_LIFT_ENCODER_CONVERSION = 1;

    public static final byte ULTRASONIC_ID = 1;

    public static final double SAFE_DISTANCE_THRESHOLD = 2;
    public static final double ROBOT_SPEED_CAP = .75;
    public static final double ULTRASONIC_UNIT_CONVERSION = (5.0/10240);
    public static final double SPINNER_MOTOR_REVOLUTIONS_PER_TICK = 1;
    public static final double SPINNER_REQUIRED_SPINS = 4;
    public static final double WHEEL_RADIUS = 6;
    public static final double WHEEL_CIRCUMFERENCE = WHEEL_RADIUS * Math.PI * 2;

    public static final double SPINNER_WHEEL_CIRCUMFERENCE = 1;

    public static final double COLOR_THRESHOLD = 8;

    public static final byte LIMELIGHT_PIPELINE = 2;
    public static final double GOAL_HEIGHT = 2;
    public static final double CAMERA_HEIGHT = 1;
    public static final double CAMERA_ANGLE = 0;

    public static final byte MAX_STORAGE_CAPACITY = 5;

    public static final double INITIAL_THROTTLE = .5;
    public static final double THROTTLE_GAIN = .003;
}
