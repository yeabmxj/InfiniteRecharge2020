package frc.Subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class PDP {
    PowerDistributionPanel powerDistributionPanel;

    public PDP() {
        powerDistributionPanel = new PowerDistributionPanel();
    }

    public double getCurrentDraw(int channel) {
        return powerDistributionPanel.getCurrent(channel);
    }
}
