package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class IntakeSubsystem extends SubsystemBase {
    public enum IntakeStates {
        STOW,
        MID_STOW,
        INTAKE,
        START
    }

    private IntakeIO intakeIO = new IntakeIO(){};

    public IntakeSubsystem(IntakeIO io) {
        this.intakeIO = io;
    }

    private IntakeStates currentIntakeState = IntakeStates.STOW;

    private void applyState() {
        switch (currentIntakeState){
            case STOW:
                intakeIO.setControl();
                break;
            case MID_STOW:
                break;
            case INTAKE:
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
