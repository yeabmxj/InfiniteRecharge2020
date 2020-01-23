package frc.Commands.Storage;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Storage;

public class IncrementBallCount extends CommandBase {
    Storage storage;

    public IncrementBallCount(Storage storage) {
        this.storage = storage;
        addRequirements(storage);
    }

    @Override
    public void initialize() {
        storage.increment();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}