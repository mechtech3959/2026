package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class ShooterConfig {
    TalonFXConfiguration leftShooterConfiguration(){
        return new TalonFXConfiguration();
    } 
    TalonFXConfiguration rightShooterConfiguration() {
        return new TalonFXConfiguration();
    }
}
