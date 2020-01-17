package frc.Commands.Intaker;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Intaker;

public class StopIntake extends CommandBase {
    Intaker intake;
    public StopIntake(Intaker intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.intake();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
