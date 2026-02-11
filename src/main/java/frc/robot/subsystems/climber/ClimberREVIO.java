package frc.robot.subsystems.climber;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;

public class ClimberREVIO implements ClimberIO {
    private final SparkMax climberMotor = new SparkMax(1, SparkLowLevel.MotorType.kBrushless);

    public ClimberREVIO() {
        ClimberConfiguration climberConfig = new ClimberConfiguration();
        climberMotor.configure(climberConfig.getClimberMotorConfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setPosition(double position) {
        climberMotor.getClosedLoopController().setSetpoint(position, SparkBase.ControlType.kMAXMotionPositionControl);
    }

    public void stop() {
        climberMotor.stopMotor();
    }

    public double getPosition() {
        return climberMotor.getEncoder().getPosition();
    }
}
