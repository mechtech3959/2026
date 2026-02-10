package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.intake.IntakeSubsystem;

public class SuperStructureSubsystem extends SubsystemBase {
    private final IntakeSubsystem intake;

    public SuperStructureSubsystem(IntakeSubsystem intake) {
        this.intake = intake;
    }

    public void setIntakeToStow() {
        intake.setPosition(IntakeSubsystem.IntakeStates.STOW);
    }

    public void setIntakeToMidStow() {
        intake.setPosition(IntakeSubsystem.IntakeStates.MID_STOW);
    }

    public void setIntakeToIntake() {
        intake.setPosition(IntakeSubsystem.IntakeStates.INTAKE);
    }
}
