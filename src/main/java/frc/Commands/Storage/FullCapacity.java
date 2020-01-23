package frc.Commands.Storage;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Storage;

public class FullCapacity extends CommandBase {
    Storage storage;

    public FullCapacity(Storage storage) {
        this.storage = storage;
        addRequirements(storage);
    }

    @Override
    public boolean isFinished() {
        return storage.isFullCapacity();
    }
}
