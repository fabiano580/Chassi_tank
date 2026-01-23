package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.robot.subsystems.chassi;
import frc.robot.commands.arcadedrive;
import frc.robot.commands.timedrive;

import static frc.robot.Constants.*;

public class RobotContainer {

  // Controle do driver (teleop)
  private final XboxController controller = new XboxController(CONTROLLER1_PORT);

  // Subsystem do chassi (drivetrain)
  private final chassi m_Chassi = new chassi();

  // Comando padrão de teleop (roda sempre que nenhum outro comando usa o chassi)
  private final arcadedrive arcadedriveCommand =
      new arcadedrive(m_Chassi, controller);

  public RobotContainer() {

    // Define o comando de teleop como padrão do chassi
    m_Chassi.setDefaultCommand(arcadedriveCommand);

    // Configuração de botões (se houver)
    configureBindings();
  }

  private void configureBindings() {
    // Por enquanto vazio
  }

  /**
   * ESTE MÉTODO DEFINE O AUTÔNOMO
   * O Robot.java chama este método quando o modo Auto começa
   */
  public Command getAutonomousCommand() {

    // Cria o comando de autônomo:
    // timedrive faz o robô andar para frente
    // withTimeout(2) faz ele rodar por 2 segundos e parar automaticamente
    return new timedrive(m_Chassi).withTimeout(2);
  }
}
