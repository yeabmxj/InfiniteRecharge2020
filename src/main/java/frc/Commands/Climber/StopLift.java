package frc.Commands.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Climber;

public class StopLift extends CommandBase {
    Climber climber;

    public StopLift(Climber climber) {
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        climber.stopScissorLift();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
