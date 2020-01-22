package frc.Subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import static frc.Configuration.Constants.*;

public class Limelight {
    private NetworkTable table;

    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry tv;
    private NetworkTableEntry pipline;

    int currentPipline = 0;

    public Limelight() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        tv = table.getEntry("tv");
        pipline = table.getEntry("pipline");

        setPipeline(LIMELIGHT_PIPELINE);
    }

    public double getX() {
        return tx.getDouble(0);
    }

    public double getY() {
        return ty.getDouble(0);
    }

    public boolean hasTarget() {
        return tv.getDouble(0) != 0;
    }

    public void setPipeline(int p) {
        if (p != currentPipline) {
            pipline.setNumber(p);
            currentPipline = p;
        }
    }

    public double getDistance() {
        return (GOAL_HEIGHT - CAMERA_HEIGHT) / Math.tan(Math.toRadians(getY() + CAMERA_ANGLE));
    }
}
