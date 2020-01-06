package frc.commands;

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
        drivetrain.drive(Controls.getX(), Controls.getY(), drivetrain.getT(Controls.getIncrease(), Controls.getDecrease()));
    }
}
