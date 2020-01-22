package frc.Commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Drivetrain;

import static frc.Configuration.Constants.*;

public class CappedDrive extends CommandBase {
    Drivetrain drivetrain;
    double x, y, t = 0;

    public CappedDrive(Drivetrain drivetrain, double x, double y, double t) {
        this.drivetrain = drivetrain;
        this.x = x;
        this.y = y;
        this.t = t;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.cappedDrive(x, y, t, ROBOT_SPEED_CAP);
    }

    @Override
    public boolean isFinished() {
        return drivetrain.getDistance() < SAFE_DISTANCE_THRESHOLD;
    }
}
