package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    public enum IntakeStates {
        STOW,
        MID_STOW,
        INTAKE,
        START
    }

    private final IntakeIO intakeIO;

    public IntakeSubsystem(IntakeIO io) {
        this.intakeIO = io;
    }

    private IntakeStates currentIntakeState = IntakeStates.STOW;

    private void applyState() {
        switch (currentIntakeState){
            case STOW:
                intakeIO.setControl(0);
                break;
            case MID_STOW:
                intakeIO.setControl(1);
                break;
            case INTAKE:
                intakeIO.setControl(2);
                break;
            default:
                System.out.println("Error in Intake Subsystem: State applied to non-existing option/undefined error.");
                break;
        }
    }

    @Override
    public void periodic() {
        applyState();
    }
}
