package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.LinearFilter;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Commands.Drivetrain.Drive;
import frc.robot.RobotContainer;

import static frc.Configuration.Constants.*;

public class Drivetrain implements Subsystem {
    private TalonSRX frontLeft;
    private TalonSRX frontRight;
    private TalonSRX backLeft;
    private TalonSRX backRight;

    private AnalogInput frontBumper;

    private LinearFilter linearFilter;

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

        frontBumper = new AnalogInput(PING);

        linearFilter = new LinearFilter(new double[]{0}, new double[]{0});
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
}
