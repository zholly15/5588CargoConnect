package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;

public class DriveDistance extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_subsystem;
  private final double m_distance;
  private final  double m_speed;
  private double origin;
  private double target;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveDistance(DriveSubsystem DriveSubsystem, double d, double s) {
    m_subsystem = DriveSubsystem;
    m_distance = d;
    m_speed = s;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DriveSubsystem);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    origin = m_subsystem.getLeftEncoderDistance();
    target = Math.signum(m_speed)*m_distance + origin;

    //m_subsystem.getRightEncoderDistance();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.tankDrive(m_speed, m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      double current = m_subsystem.getLeftEncoderDistance();
      if(m_speed > 0){
        return current >= target;
    }
      else
        return current <= target;
  }
}
