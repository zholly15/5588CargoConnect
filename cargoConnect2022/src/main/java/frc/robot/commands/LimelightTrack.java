package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;

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
          
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {}
      
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return false;
      }


}
