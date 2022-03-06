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

public class Spit extends CommandBase {
  private double m_speed;
  private BallSubsystem m_ballSubsystem;

  public Spit(BallSubsystem ballSubsystem) {
    m_ballSubsystem = ballSubsystem;
    m_speed = 0.25;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_ballSubsystem.setFlywheelSpeed(m_speed);
    m_ballSubsystem.setIndexSpeed(m_speed);
  }

  @Override
  public void end(boolean interrupted) {
    m_ballSubsystem.setFlywheelSpeed(0);
    m_ballSubsystem.setIndexSpeed(0);
  }

  @Override
  public boolean isFinished() {

    return false;
  }
}
