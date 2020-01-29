package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import static frc.Configuration.Constants.*;

public class Shooter extends SubsystemBase {
    private TalonSRX flyWheel;

    private RobotContainer robotContainer;

    public Shooter() {
        flyWheel = new TalonSRX(FLYWHEEL_MOTOR_ID);

        robotContainer = new RobotContainer();

        //setDefaultCommand(robotContainer.stopShooting);
    }

    public void shoot() {
        flyWheel.set(ControlMode.Velocity, SHOOT_SPEED);
    }
}
