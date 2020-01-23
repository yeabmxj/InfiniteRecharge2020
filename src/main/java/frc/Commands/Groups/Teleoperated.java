package frc.Commands.Groups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;

public class Teleoperated extends ParallelCommandGroup {

    public Teleoperated() {
        addCommands(
            new ParallelDeadlineGroup()
        );
    }
}
