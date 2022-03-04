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
}

@Override
public void execute() {
    m_ballSubsystem.setFlywheelSpeed(Constants.sixHIGH_FLYWHEEL_SPEED);
    
}