package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

public class chassi extends SubsystemBase{

    private final SparkMax LEFT_FOLLOWER;
    private final SparkMax LEFT_LEADER;
    private final SparkMax RIGTH_FOLLOWER;
    private final SparkMax RIGHT_LEADER;

    private final DifferentialDrive drive;

    public chassi() {
        LEFT_FOLLOWER = new SparkMax(LF, MotorType.kBrushed);
        LEFT_LEADER = new SparkMax(LL, MotorType.kBrushed);
        RIGTH_FOLLOWER = new SparkMax (RF, MotorType.kBrushed);
        RIGHT_LEADER = new SparkMax (RL, MotorType.kBrushed);

        drive = new DifferentialDrive(LEFT_LEADER, RIGHT_LEADER);

    SparkMaxConfig config = new SparkMaxConfig();
    config.voltageCompensation(12);
    config.smartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);
    config.follow(LEFT_LEADER);
    LEFT_FOLLOWER.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    config.follow(RIGHT_LEADER);
    RIGTH_FOLLOWER.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    config.disableFollowerMode();
    RIGHT_LEADER.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    config.inverted(true);
    LEFT_LEADER.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void arcadedrive (double FORWARD, double ROTATION){;
        drive.arcadeDrive(FORWARD, ROTATION);
    }
}
