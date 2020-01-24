package frc.Commands.Spinner;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Spinner;

public class Spin extends CommandBase {
    Spinner spinner;

    public Spin(Spinner spinner) {
        this.spinner = spinner;
        addRequirements(spinner);
    }

    @Override
    public void execute() {
        spinner.spin();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
