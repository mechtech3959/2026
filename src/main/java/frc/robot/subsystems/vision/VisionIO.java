package frc.robot.subsystems.vision;

public interface VisionIO {

    default void setVisionNeutral() {
    }

    default void trackingStart() {
    }

    default double estimatedDistanceToTarget() {
        return -1;
    }

    default boolean hasTarget() {
        return false;
    }

    default boolean isEstimateValid() {
        return false;
    }

    default boolean isPoseEstimateValid() {
        return false;
    }

    default void periodic() {
    }

}
