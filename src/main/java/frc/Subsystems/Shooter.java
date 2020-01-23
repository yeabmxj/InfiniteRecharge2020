package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Subsystem;

import static frc.Configuration.Constants.*;

public class Shooter implements Subsystem {
    private TalonSRX flyWheel;

    public Shooter() {
        flyWheel = new TalonSRX(FLYWHEEL_MOTOR_ID);
    }

    public void shoot(int velocity) {
        flyWheel.set(ControlMode.Velocity, velocity);
    }
}
