package frc.Commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.Subsystems.Drivetrain;

import java.util.Set;

public class Drive extends CommandBase {
    Drivetrain drivetrain;
    double x, y, t = 0;

    public Drive(Drivetrain drivetrain, double x, double y, double t) {
        this.drivetrain = drivetrain;
        this.x = x;
        this.y = y;
        this.t = t;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.drive(x,y,t);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
