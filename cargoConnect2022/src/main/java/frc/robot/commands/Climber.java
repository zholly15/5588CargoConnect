package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;

public class Climber extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_ClimberSubsystem;
  private final double m_speed;

  public Climber(ClimberSubsystem climberSubsystem, double s) {
    m_ClimberSubsystem = climberSubsystem;
    m_speed = s;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climberSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ClimberSubsystem.setSpeed(m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(m_ClimberSubsystem.getEncoderDistance()) >= 5 || m_ClimberSubsystem.getSwitch())
      return true;
    return false;
    // return (m_ClimberSubsystem.getEncoderDistance() <= 0 &&
    // m_ClimberSubsystem.getSwitch() );
  }// 5 x 16, 6 x 16

}
