package frc.Commands.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Climber;

public class RetractLift extends CommandBase {
    Climber climber;

    public RetractLift(Climber climber) {
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        climber.retractScissorLift();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
