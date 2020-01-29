package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;

import static frc.Configuration.Constants.*;

public class Storage implements Subsystem {
    private ColorSensorV3 lineBreak;

    private TalonSRX storageActuator;

    private RobotContainer robotContainer;

    private int ballCount = 0;

    public Storage() {
        lineBreak = new ColorSensorV3(I2C.Port.kMXP);

        storageActuator = new TalonSRX(STORAGE_MOTOR_ID);

        robotContainer = new RobotContainer();

        setDefaultCommand(robotContainer.haltStorage);
    }

    public void increment() {
        ballCount+= ballCount != MAX_STORAGE_CAPACITY ? 1 : 0;
    }

    public void decrement() {
        ballCount-= ballCount != 0 ? 1 : 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isFullCapacity() {
        return getBallCount() >= MAX_STORAGE_CAPACITY;
    }

    public void actuate() {
        storageActuator.set(ControlMode.PercentOutput, STORAGE_SPEED);
    }

    public void halt() {
        storageActuator.set(ControlMode.PercentOutput, 0);
    }
}
