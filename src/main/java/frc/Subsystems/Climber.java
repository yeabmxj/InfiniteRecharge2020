package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import static frc.Configuration.Constants.*;

public class Climber extends SubsystemBase {
    private TalonSRX scissorLift;
    private TalonSRX winch;

    private RobotContainer robotContainer;

    public Climber() {
        scissorLift = new TalonSRX(SCISSOR_LIFT_MOTOR_ID);
        winch = new TalonSRX(WINCH_MOTOR_ID);

        scissorLift.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

        setDefaultCommand(robotContainer.stopLift);
    }

    public void stopScissorLift() {
        scissorLift.set(ControlMode.PercentOutput, 0);
        winch.set(ControlMode.PercentOutput, 0);
    }

    public void retractScissorLift() {
        scissorLift.set(ControlMode.PercentOutput, SCISSOR_LIFT_BACKWARD_SPEED);
        winch.set(ControlMode.PercentOutput, WINCH_BACKWARD_SPEED);
    }

    public void extendScissorLift() {
        scissorLift.set(ControlMode.PercentOutput, SCISSOR_LIFT_FORWARD_SPEED);
        winch.set(ControlMode.PercentOutput, WINCH_FORWARD_SPEED);
    }

    public double getHeight() {
        return scissorLift.getSelectedSensorPosition() * SCISSOR_LIFT_ENCODER_CONVERSION;
    }
}
