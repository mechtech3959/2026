package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.climber.ClimberSubsystem;

public class SuperStructureSubsystem extends SubsystemBase {
    private final ClimberSubsystem climber;

    public SuperStructureSubsystem(ClimberSubsystem climber) {
        this.climber = climber;
    }

    public void setClimberToRetract(){
        climber.setClimberState(ClimberSubsystem.ClimberStates.RETRACT);
    }

    public void setClimberToClearIntake() {
        climber.setClimberState(ClimberSubsystem.ClimberStates.CLEAR_INTAKE);
    }

    public void setClimberToClimb() {
        climber.setClimberState(ClimberSubsystem.ClimberStates.CLIMB);
    }
}
