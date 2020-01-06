package frc.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.config.Controls;
import frc.subsystems.Drivetrain;

public class Drive extends CommandBase {
    private Drivetrain drivetrain;

    public Drive(Drivetrain dt) {
        drivetrain = dt;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void executive() {
        drivetrain.drive(Controls.getX(), Controls.getY());
    }
}
