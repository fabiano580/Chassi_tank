package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import static frc.robot.Constants.*;

public class intake {

    private final SparkMax INTAKE_MOTOR;

    public intake() {
        INTAKE_MOTOR = new SparkMax(INTAKE_ID, MotorType.kBrushed);
    }

    public void take(double take){
        INTAKE_MOTOR.set(take);
    } 
}