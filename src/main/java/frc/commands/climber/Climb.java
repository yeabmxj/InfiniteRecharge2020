package frc.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Climber;

public class Climb extends CommandBase {
    private Climber climber;

    public Climb(Climber cl) {
        climber = cl;
        addRequirements(climber);
    }

    public void initialize() {

    }

    public void execute() {

    }
}
