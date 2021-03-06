package frc.Commands.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Climber;

public class ExtendLift extends CommandBase {
    Climber climber;

    public ExtendLift(Climber climber) {
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        climber.extendScissorLift();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
