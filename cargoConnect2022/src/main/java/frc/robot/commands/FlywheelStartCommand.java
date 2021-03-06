/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;

public class FlywheelStartCommand extends CommandBase {
  private double m_speed;
  private BallSubsystem m_ballSubsystem;

  public FlywheelStartCommand(BallSubsystem ballSubsystem, double speed) {
    m_ballSubsystem = ballSubsystem;
    m_speed = speed;
  }

  @Override
  public void initialize() {
    m_ballSubsystem.setFlywheelSpeed(m_speed);
  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) {
    m_ballSubsystem.setFlywheelSpeed(0.0);
  }

  @Override
  public boolean isFinished() {

    return false;
  }
}
