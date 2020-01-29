package frc.Subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavX extends SubsystemBase {
    AHRS navX;

    public NavX() {
        navX = new AHRS(I2C.Port.kMXP);
    }

    public void reset() {
        navX.reset();
    }
}
