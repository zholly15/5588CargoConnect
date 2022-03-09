package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.Constants;

public class AutoBallShoot extends CommandBase {
    BallSubsystem m_ballSubsystem;

    public AutoBallShoot(BallSubsystem b) {
        m_ballSubsystem = b;
        addRequirements(m_ballSubsystem);
    }

    @Override
  public void initialize() {}

    @Override
    public void execute() {
        m_ballSubsystem.setFlywheelSpeed(Constants.AUTO_FLYWHEEL_SPEED);
        if(m_ballSubsystem.checkFlywheelSpeed())//checks if flywheel is up to speed
            m_ballSubsystem.setIndexSpeed(Constants.BALL_INDEX_SPEED);//activates index wheel to transport ball :)
            //flywheel RPM hits negative, rework flywheel logic, change limelight pipeline,
    }

    @Override
    public void end(boolean interrupted) {
        m_ballSubsystem.setFlywheelSpeed(0);
        m_ballSubsystem.setIndexSpeed(0);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}