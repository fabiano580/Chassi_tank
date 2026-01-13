package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.chassi;

public class arcadedrive extends Command {

    private final chassi m_chassi;
    private final XboxController controller;

    public arcadedrive(chassi subsystem, XboxController controller){
        this.m_chassi = subsystem;
        this.controller = controller;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
    double FORWARD = controller.getLeftY();
    double ROTATION = controller.getRightX();
    double LIMIT;

    if(controller.getLeftBumper()){
        LIMIT = 0.6;
    } else if (controller.getRightBumper()){
        LIMIT = 1;
    }else {
        LIMIT = 1;
    }

    m_chassi.arcadedrive(FORWARD*LIMIT, ROTATION*LIMIT);
    }

    @Override
    public void end(boolean interrupted) {
        m_chassi.arcadedrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

