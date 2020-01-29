package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.LinearFilter;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;

import static frc.Configuration.Constants.*;

public class Drivetrain implements Subsystem {
    private TalonSRX frontLeft;
    private TalonSRX frontRight;
    private TalonSRX backLeft;
    private TalonSRX backRight;

    private AnalogInput frontBumper;

    private LinearFilter linearFilter;

    private RobotContainer robotContainer;

    private double throttle = INITIAL_THROTTLE;

    public Drivetrain() {
        frontLeft = new TalonSRX(FRONT_LEFT_TALON_ID);
        frontRight = new TalonSRX(FRONT_RIGHT_TALON_ID);
        backLeft = new TalonSRX(BACK_LEFT_TALON_ID);
        backRight = new TalonSRX(BACK_RIGHT_TALON_ID);

        frontLeft.set(ControlMode.Follower, backLeft.getDeviceID());
        frontRight.set(ControlMode.Follower, backRight.getDeviceID());

        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

        frontBumper = new AnalogInput(ULTRASONIC_ID);

        linearFilter = new LinearFilter(new double[]{0}, new double[]{0});

        robotContainer = new RobotContainer();

        setDefaultCommand(robotContainer.drive);
    }

    public void stop() {
        drive(0,0,0);
    }

    public void drive(double x, double y, double t) {
        backLeft.set(ControlMode.PercentOutput, (x+y) * t);
        backRight.set(ControlMode.PercentOutput, (x-y) * t);
    }

    public void cappedDrive(double x, double y, double t, double cap) {
        backLeft.set(ControlMode.PercentOutput, (x+y) * t * cap);
        backRight.set(ControlMode.PercentOutput, (x-y) * t * cap);
    }

    public double getDistance() {
        return linearFilter.calculate(frontBumper.getVoltage() * ULTRASONIC_UNIT_CONVERSION);
    }

    public void increaseThrottle() {
        throttle += throttle < 1 ? THROTTLE_GAIN : 0;
    }

    public void decreaseThrottle() {
        throttle -= throttle > 0 ? THROTTLE_GAIN : 0;
    }

    public double getThrottle() {
        return Math.pow(throttle, 1.0/4.0);
    }
}
