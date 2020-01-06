package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.config.Constants.*;

public class Drivetrain extends SubsystemBase {
    private TalonSRX frontLeft;
    private TalonSRX frontRight;
    private TalonSRX backLeft;
    private TalonSRX backRight;

    private double throttle = .5;

    public Drivetrain() {
        frontLeft = new TalonSRX(FRONT_LEFT_DRIVE_TALON_ID);
        frontRight = new TalonSRX(FRONT_RIGHT_DRIVE_TALON_ID);
        backLeft = new TalonSRX(BACK_LEFT_DRIVE_TALON_ID);
        backRight = new TalonSRX(BACK_RIGHT_DRIVE_TALON_ID);

        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    }

    public void drive(double x, double y, double t) {
        double leftSpeed = (y + x) * t;
        double rightSpeed = (y - x) * t;

        frontLeft.set(ControlMode.PercentOutput, leftSpeed);
        frontRight.set(ControlMode.PercentOutput, rightSpeed);
        backLeft.set(ControlMode.PercentOutput, leftSpeed);
        backRight.set(ControlMode.PercentOutput, rightSpeed);
    }

    public double getT(double increase, double decrease) {
        throttle += 0.03 *(increase - decrease);

        if (throttle > 1){
            throttle = 1;
        } else if(throttle < 0){
            throttle = 0;
        }
        return throttle;
    }
}
