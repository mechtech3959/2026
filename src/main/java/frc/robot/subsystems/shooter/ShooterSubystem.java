package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubystem extends SubsystemBase {
    // TODO time longest possible time shoot all balls/ averge time to shoot all
    // balls, use this to determine auto shooting times
    public enum ShooterState {
        STOPPED, IDLE, SPINNING_UP, AT_SPEED, SHOOTING
    }

    public enum ShooterMode {
        KNOWN_CLOSE, KNOWN_FAR, UNKNOWN
    }

    private double targetRPM;
    private double targetAngle;

    private final ShooterIO io;
    private ShooterState shooterState = ShooterState.IDLE;
    private ShooterMode shooterMode = ShooterMode.UNKNOWN;

    public ShooterSubystem(ShooterIO io) {
        this.io = io;

    }

    private void handleShooterState() {
        switch (shooterState) {
            case STOPPED:
                break;
            case IDLE:
                break;
            case SPINNING_UP:
                break;
            case AT_SPEED:
                break;
            case SHOOTING:
                break;
        }
    }

    @Override
    public void periodic() {
        io.periodic();
        handleShooterState();
    }

}
