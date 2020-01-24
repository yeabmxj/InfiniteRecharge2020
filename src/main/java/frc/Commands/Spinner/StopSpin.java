package frc.Commands.Spinner;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Spinner;

public class StopSpin extends CommandBase {
    Spinner spinner;

    public StopSpin(Spinner spinner) {
        this.spinner = spinner;
        addRequirements(spinner);
    }

    @Override
    public void initialize() {
        spinner.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
