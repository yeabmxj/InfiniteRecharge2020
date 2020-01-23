package frc.Subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class PDP implements Subsystem {
    PowerDistributionPanel powerDistributionPanel;

    public PDP() {
        powerDistributionPanel = new PowerDistributionPanel();
    }

    public double getCurrentDraw(int channel) {
        return powerDistributionPanel.getCurrent(channel);
    }
}
