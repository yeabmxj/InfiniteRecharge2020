package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.Configuration.Constants.*;

public class Shooter extends SubsystemBase {
    private TalonSRX flyWheel;

    public Shooter() {
        flyWheel = new TalonSRX(FLYWHEEL_MOTOR_ID);
    }

    public void shoot() {
        flyWheel.set(ControlMode.Velocity, SHOOT_SPEED);
    }
}
