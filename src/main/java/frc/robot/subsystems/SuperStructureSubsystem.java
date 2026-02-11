package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.intake.feed.FeedSubsystem;

public class SuperStructureSubsystem extends SubsystemBase {
    private final IntakeSubsystem intake;
    private final FeedSubsystem feed;

    public SuperStructureSubsystem(IntakeSubsystem intake, FeedSubsystem feed) {
        this.intake = intake;
        this.feed = feed;
    }

    public void setIntakeToStow() {
        intake.setIntakeState(IntakeSubsystem.IntakeStates.STOW);
    }

    public void setIntakeToMidStow() {
        intake.setIntakeState(IntakeSubsystem.IntakeStates.MID_STOW);
    }

    public void setIntakeToIntake() {
        intake.setIntakeState(IntakeSubsystem.IntakeStates.INTAKE);
    }

    public void setFeedToRun() {
        feed.setFeedState(FeedSubsystem.FeedStates.RUN);
    }

    public void setFeedToStop() {
        feed.setFeedState(FeedSubsystem.FeedStates.STOP);
    }
}
