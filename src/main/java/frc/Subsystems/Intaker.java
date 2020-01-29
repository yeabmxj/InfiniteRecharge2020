package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.Commands.Intaker.Intake;
import frc.robot.RobotContainer;

import static frc.Configuration.Constants.*;

public class Intaker implements Subsystem {
    private TalonSRX groundIntake;

    private RobotContainer robotContainer;

    public Intaker() {
        groundIntake = new TalonSRX(INTAKE_MOTOR_ID);

        robotContainer = new RobotContainer();

        setDefaultCommand(robotContainer.stopIntake);
    }

    public void intake() { groundIntake.set(ControlMode.PercentOutput, INTAKE_SPEED);}

    public void stopIntake() { groundIntake.set(ControlMode.PercentOutput, 0); }
}
