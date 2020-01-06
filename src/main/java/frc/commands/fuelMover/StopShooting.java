package frc.commands.fuelMover;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.FuelMover;

public class StopShooting extends CommandBase {
    private FuelMover fuelMover;

    public StopShooting(FuelMover fm) {
        fuelMover = fm;
        addRequirements(fuelMover);
    }

    public void initialize() {

    }

    public void execute() {

    }
}
