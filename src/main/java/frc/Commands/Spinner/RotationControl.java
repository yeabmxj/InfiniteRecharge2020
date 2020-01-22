package frc.Commands.Spinner;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Spinner;

public class RotationControl extends CommandBase {
    Spinner spinner;

    public RotationControl(Spinner spinner) {
        this.spinner = spinner;
        addRequirements(spinner);
    }

    @Override
    public void execute() {
        spinner.rotationControl();
    }

    @Override
    public boolean isFinished() {
        return spinner.messageReceived();
    }
}