package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
    private final ClimberIO climberIO;

    public ClimberSubsystem(ClimberIO climberIO) {
        this.climberIO = climberIO;
    }

    private ClimberStates currentClimberState = ClimberStates.RETRACT;

    public void setClimberState(ClimberStates state){
        this.currentClimberState = state;
    }

    private void applyState(){
        switch (currentClimberState){
            case RETRACT:
                climberIO.setPosition(0);
                break;
            case CLEAR_INTAKE:
                climberIO.setPosition(0.2);
                break;
            case CLIMB:
                climberIO.setPosition(1);
                break;
            default:
                System.out.println("Error in Climber Subsystem: State applied to "
                        + "non-existing option/undefined error.");
                break;
        }
    }

    public enum ClimberStates {
        RETRACT,
        CLEAR_INTAKE,
        CLIMB
    }
}
