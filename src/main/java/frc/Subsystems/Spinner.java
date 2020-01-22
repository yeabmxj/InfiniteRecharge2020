package frc.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableType;
import edu.wpi.first.wpilibj2.command.Subsystem;

import java.awt.*;

import static frc.Configuration.Constants.*;

public class Spinner implements Subsystem {
    private TalonSRX spinnerMotor;

    private ColorSensorV3 colorSensor;

    private NetworkTable fms;
    private NetworkTableEntry gameSpecificMessage;

    private boolean colorReached = false;

    public Spinner() {
        spinnerMotor = new TalonSRX(SPINNER_MOTOR_ID);
        spinnerMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

        fms = NetworkTableInstance.getDefault().getTable("FMSInfo");
        gameSpecificMessage = fms.getEntry("GameSpecificMessage");
    }

    public void spin() {
        spinnerMotor.set(ControlMode.PercentOutput, SPINNER_SPEED);
    }

    public void stop() {
        spinnerMotor.set(ControlMode.PercentOutput, 0);
    }

    public boolean getColorReached() {
        return colorReached;
    }

    //todo look up actual messages and color options
    public int getColor() {
        switch(gameSpecificMessage.getValue().getString()) {
            case "RED":
                return colorSensor.getRed();
            case "BLUE":
                return colorSensor.getBlue();
            case "GREEN":
                return colorSensor.getGreen();
        }
        return 0;
    }

    public boolean messageReceived() {
        return gameSpecificMessage.getValue().getType() != NetworkTableType.kUnassigned;
    }

    public double getSpinDistance() {
        return (spinnerMotor.getSelectedSensorPosition() * SPINNER_MOTOR_REVOLUTIONS_PER_TICK * WHEEL_CIRCUMFERENCE) / SPINNER_WHEEL_CIRCUMFERENCE;
    }

    public void rotationControl() {
        if (getSpinDistance() < SPINNER_REQUIRED_SPINS) {
            spin();
        }
        else {
            stop();
        }
    }

    public void positionControl() {
        if (getColor() >= COLOR_THRESHOLD) {
            stop();
            colorReached = true;
        }
        else {
            spin();
        }
    }
}
