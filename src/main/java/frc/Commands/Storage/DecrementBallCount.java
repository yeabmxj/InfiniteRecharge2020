package frc.Commands.Storage;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Storage;

public class DecrementBallCount extends CommandBase {
    Storage storage;

    public DecrementBallCount(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void initialize() {
        storage.decrement();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
