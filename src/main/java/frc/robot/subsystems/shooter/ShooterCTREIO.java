package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;

public class ShooterCTREIO implements ShooterIO {
    private final TalonFX leftShooter;
    private final TalonFX rightShooter;
    public ShooterCTREIO(TalonFX leftShooter, TalonFX rightShooter) {
        this.leftShooter = leftShooter;
        this.rightShooter = rightShooter;
    }  
}
