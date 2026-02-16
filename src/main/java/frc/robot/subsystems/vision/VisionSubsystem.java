package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
    private VisionIO io;
    public VisionSubsystem(VisionIO io) {
        this.io = io;
    }
}
