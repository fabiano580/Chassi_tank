package frc.robot.commands;

import frc.robot.subsystems.chassi;
import edu.wpi.first.wpilibj2.command.Command;

public class timedrive extends Command {

    private final chassi drive;

    public timedrive(chassi drive){
        this.drive = drive;
        addRequirements(drive);
    }
    

    @Override
    public void initialize(){}

    @Override
    public void execute() {
        drive.arcadedrive(0.2, 0);
    }
}
