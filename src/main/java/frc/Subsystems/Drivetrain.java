package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
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

    public Drivetrain() {
        frontLeft = new TalonSRX(FRONT_LEFT_TALON_ID);
        frontRight = new TalonSRX(FRONT_RIGHT_TALON_ID);
    }
}
