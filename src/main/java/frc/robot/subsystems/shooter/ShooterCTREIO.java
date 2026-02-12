package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.controls.StrictFollower;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.RobotMap;

public class ShooterCTREIO implements ShooterIO {
    private final TalonFX leftShooter;
    private final TalonFX rightShooter;
    private final VelocityVoltage velocityVoltage = new VelocityVoltage(0);
    CANBus tempBus = new CANBus("rio");

    private double target = 0;

    public ShooterCTREIO() {
        this.leftShooter = new TalonFX(RobotMap.SHOOTER.LEFT_SHOOTER, tempBus);
        this.rightShooter = new TalonFX(RobotMap.SHOOTER.RIGHT_SHOOTER, tempBus);
        leftShooter.getConfigurator().apply(ShooterConfig.leftShooterConfiguration());
        rightShooter.getConfigurator().apply(ShooterConfig.rightShooterConfiguration());
        leftShooter.setControl(new StrictFollower(rightShooter.getDeviceID()));
    }

    @Override
    public void setShooterSpeed(double speed) {
        if (target != speed) {
            rightShooter.setControl(velocityVoltage.withVelocity(speed));
            target = speed;
        }
    }

    @Override
    public double getShooterSpeed() {
        return rightShooter.getVelocity().getValueAsDouble();

    }

    @Override
    public boolean isNearTargetSpeed() {
        return rightShooter.getVelocity().isNear(target, 50); // Adjust the tolerance as needed

    }
}
