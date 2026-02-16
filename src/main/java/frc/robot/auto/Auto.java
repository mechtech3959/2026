package frc.robot.auto;

import choreo.Choreo;
import choreo.auto.AutoChooser;
import choreo.auto.AutoFactory;
import choreo.auto.AutoRoutine;
import choreo.auto.AutoTrajectory;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.RobotModeTriggers;
import static frc.robot.generated.ChoreoTraj.Test;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;

public class Auto {
    private DrivetrainSubsystem drivetrain;
    private AutoFactory autoFactory;
    private final AutoChooser autoChooser;

    private final Choreo.TrajectoryCache cache;

    public Auto(DrivetrainSubsystem drivetrain) {
        this.autoChooser = new AutoChooser();

        this.drivetrain = drivetrain;

        // Initialize trajectory cache - preloads trajectories at robot startup
        // This prevents delays when loading trajectories during auto
        cache = new Choreo.TrajectoryCache();

        // Preload all trajectories you'll use in autonomous
        cache.loadTrajectory("Test");
        // Add more as needed:
        // cache.loadTrajectory("Path2");
        // cache.loadTrajectory("Path3");

        this.autoFactory = drivetrain.makeAutoFactory(); /*
                                                          * new AutoFactory(
                                                          * drivetrain::getPose,
                                                          * drivetrain::resetPose,
                                                          * drivetrain::stageTrajectory,
                                                          * true, // Trajectories are relative to starting pose
                                                          * drivetrain);
                                                          */

    }

    public void configure() {
        autoChooser.addRoutine("Test", this::testRoutine);
        SmartDashboard.putData("Auto Chooser", autoChooser);
        RobotModeTriggers.autonomous().whileTrue(autoChooser.selectedCommandScheduler());
    }

    public AutoRoutine testRoutine() {
        final AutoRoutine routine = autoFactory.newRoutine("test");
        final AutoTrajectory test = Test.asAutoTraj(routine);

        // When the routine becomes active, reset odometry then follow the trajectory
        routine.active().onTrue(
                Commands.sequence(
                        Commands.print("Started the routine!"),
                        test.resetOdometry(), // Reset pose to trajectory start
                        test.cmd() // Follow the trajectory
                ));

        return routine;
    }

}
