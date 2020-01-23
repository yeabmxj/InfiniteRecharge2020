package frc.Commands.Groups;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.Commands.Intaker.Intake;
import frc.Commands.Storage.FullCapacity;

public class CapacityBasedIntake extends ParallelDeadlineGroup {
    /**
     * Creates a new ParallelDeadlineGroup.  The given commands (including the deadline) will be
     * executed simultaneously.  The CommandGroup will finish when the deadline finishes,
     * interrupting all other still-running commands.  If the CommandGroup is interrupted, only
     * the commands still running will be interrupted.
     *
     * @param deadline the command that determines when the group ends
     * @param intake the commands to be executed
     */
    public CapacityBasedIntake(FullCapacity deadline, Intake intake) {
        super(deadline, intake);
    }
}
