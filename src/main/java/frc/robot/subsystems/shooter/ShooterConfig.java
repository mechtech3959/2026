package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class ShooterConfig {
    public TalonFXConfiguration leftShooterConfiguration() {
        return new TalonFXConfiguration().withCurrentLimits(currentLimits).withSlot0(slot0Configs)
                .withMotionMagic(motionMagic)
                .withMotorOutput(new MotorOutputConfigs().withInverted(InvertedValue.Clockwise_Positive)
                        .withNeutralMode(NeutralModeValue.Coast));
    }

    public TalonFXConfiguration rightShooterConfiguration() {
        return new TalonFXConfiguration().withCurrentLimits(currentLimits).withSlot0(slot0Configs)
                .withMotionMagic(motionMagic)
                .withMotorOutput(new MotorOutputConfigs().withInverted(InvertedValue.CounterClockwise_Positive)
                        .withNeutralMode(NeutralModeValue.Coast));
    }

    CurrentLimitsConfigs currentLimits = new CurrentLimitsConfigs().withStatorCurrentLimit(60)
            .withStatorCurrentLimitEnable(true).withSupplyCurrentLimit(40).withSupplyCurrentLimitEnable(true);

    Slot0Configs slot0Configs = new Slot0Configs().withKP(2).withKI(0).withKD(0.1).withKS(0).withKV(0).withKA(0);
    MotionMagicConfigs motionMagic = new MotionMagicConfigs().withMotionMagicAcceleration(2000)
            .withMotionMagicCruiseVelocity(50000).withMotionMagicJerk(4000);

}
