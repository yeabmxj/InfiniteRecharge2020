package frc.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Climber;
import frc.subsystems.FuelMover;

public class Release extends CommandBase {
    private Climber climber;

    public Release(Climber cl) {
        climber = cl;
        addRequirements(climber);
    }

    public void initialize() {

    }

    public void execute() {

    }
}
