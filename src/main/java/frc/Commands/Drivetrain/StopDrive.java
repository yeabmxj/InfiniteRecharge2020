package frc.Commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Drivetrain;

public class StopDrive extends CommandBase {
    Drivetrain drivetrain;

    public StopDrive(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
