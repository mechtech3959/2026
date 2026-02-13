package frc.robot.subsystems.shooter;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubystem extends SubsystemBase {
    // TODO time longest possible time shoot all balls/ averge time to shoot all
    // balls, use this to determine auto shooting times
    public enum ShooterState {
        STOPPED,
        IDLE,
        SPINNING_UP,
        AT_SPEED,
        SHOOTING
    }

    public enum ShooterMode {
        KNOWN_CLOSE,
        KNOWN_FAR,
        REST,
        UNKNOWN
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

        switch (shooterMode) {
            case KNOWN_CLOSE -> io.setShooterSpeed(targetRPM);
            case KNOWN_FAR -> {
                // no-op for known far mode (configure if needed)
            }
            case REST -> io.setShooterNeutral();
            case UNKNOWN -> io.setShooterSpeed(0);
        }
    }

    public void shooterStatus() {
        if (shooterMode == ShooterMode.REST)
            shooterState = ShooterState.IDLE;
        if (!io.isNearTargetSpeed())
            shooterState = ShooterState.SPINNING_UP;
        else if (io.isNearTargetSpeed())
            shooterState = ShooterState.AT_SPEED;
        else if (io.getShooterSpeed() == 0)
            shooterState = ShooterState.STOPPED;
    }

    public void ChangeShooterState(ShooterState newState) {
        shooterState = newState;
    }

    public void ChangeShooterState(ShooterMode newState, double targetRPM) {
        this.targetRPM = targetRPM;
        shooterMode = newState;
    }

    @Override
    public void periodic() {
        io.periodic();
        Logger.recordOutput("here", true);
        Logger.recordOutput("speed", io.getShooterSpeed());
        Logger.recordOutput("isAtSpeed", io.isNearTargetSpeed());
        handleShooterState();
    }

}
