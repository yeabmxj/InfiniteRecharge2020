package frc.Commands.Groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.Commands.Spinner.PositionControl;
import frc.Commands.Spinner.RotationControl;

public class SpinRoutine extends SequentialCommandGroup {

    public SpinRoutine(PositionControl positionControl, RotationControl rotationControl) {
        addCommands(rotationControl, positionControl);
    }
}
