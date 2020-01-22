package frc.Commands.Spinner;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Spinner;

public class PositionControl extends CommandBase {
    Spinner spinner;

    public PositionControl(Spinner spinner) {
        this.spinner = spinner;
        addRequirements(spinner);
    }

    @Override
    public void execute() {
        spinner.positionControl();
    }

    @Override
    public boolean isFinished() {
        return spinner.getColorReached();
    }
}