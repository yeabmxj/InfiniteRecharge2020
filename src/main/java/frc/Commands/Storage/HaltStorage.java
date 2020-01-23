package frc.Commands.Storage;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Storage;

public class HaltStorage extends CommandBase {
    Storage storage;

    public HaltStorage(Storage storage) {
        this.storage = storage;
        addRequirements(storage);
    }

    @Override
    public void execute() {
        storage.halt();
    }

    //todo add actual isFinished with storage capacity taken into account
    @Override
    public boolean isFinished() {
        return true;
    }
}
