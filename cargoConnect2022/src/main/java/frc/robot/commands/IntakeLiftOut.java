// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//something about motor control
//spin motor (VictorSPX)
//run at 10% power out
//run ta 20% power back in
package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.subsystems.BallSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class IntakeLiftOut extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final BallSubsystem ball_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeLiftOut(BallSubsystem subsystem) {
    ball_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() // only once,
  {
    ball_subsystem.setArmSpeed(Constants.INTAKELIFT_SPEED);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()// always going
  {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ball_subsystem.setArmSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {// when get ball?
    return false;
  }
}
