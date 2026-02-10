package frc.robot.subsystems.intake;

public interface IntakeIO {
    default void setControl() {}

    default void stop() {}

    default void getPosition() {}
}
