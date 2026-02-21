package frc.robot.subsystems.conveyor;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class ConveyorREVIO implements ConveyorIO {
    private final SparkMax conveyorMotor = new SparkMax(30, MotorType.kBrushless);
    
    public ConveyorREVIO() {
        ConveyorConfiguration conveyorMotorConfig = new ConveyorConfiguration();
        conveyorMotor.configure(conveyorMotorConfig.getConfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
    }

    
    public void runConveyorMotor() { conveyorMotor.set(1);}
    public void stopCoveyorMotor() { conveyorMotor.set(0);}

    
}
