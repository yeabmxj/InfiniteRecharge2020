package frc.Subsystems;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class Storage implements Subsystem {
    ColorSensorV3 lineBreak;

    public Storage() {
        lineBreak = new ColorSensorV3(I2C.Port.kMXP);
    }
}
