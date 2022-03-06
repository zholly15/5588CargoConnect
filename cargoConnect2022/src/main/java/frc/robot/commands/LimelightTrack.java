package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class LimelightTrack extends CommandBase{
    private final LimelightSubsystem m_LimelightSubsystem;
    private final DriveSubsystem m_DriveSubsystem;

    public LimelightTrack(LimelightSubsystem l, DriveSubsystem d) {
        m_LimelightSubsystem = l;
        m_DriveSubsystem = d;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(l, d);
      }

      @Override
      public void initialize() {}
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
          if(!RobotContainer.m_LimelightSubsystem.hasTarget()){
            m_DriveSubsystem.tankDrive(0,0);//uhhhhh ask zach
          }
          else{
            System.out.print(RobotContainer.m_LimelightSubsystem.getX());
            double speed = RobotContainer.m_LimelightSubsystem.getX()*Constants.K_TURN;
            speed = MathUtil.clamp(speed, -1 * Constants.MAX_SPEED, Constants.MAX_SPEED);//speed, low, high
            m_DriveSubsystem.tankDrive(speed, -speed);//UHHHHHH ASK ZACH

          }
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {}
      
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return (RobotContainer.m_LimelightSubsystem.getX() <= 1.5 && RobotContainer.m_LimelightSubsystem.getX() >=-1.5);
      }//between -1.5->1.5


}
