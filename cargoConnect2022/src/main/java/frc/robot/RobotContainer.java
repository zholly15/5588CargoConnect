// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;
import frc.robot.commands.FlywheelStartCommand;
import frc.robot.commands.OneIndexBallCommand;
import frc.robot.commands.Spit;
import frc.robot.commands.AutoBallShoot;
import frc.robot.commands.BallIntake;
import frc.robot.commands.BallOuttake;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.Transport;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.TurnInPlaceCommand;
import frc.robot.commands.Auto1Ball;
import frc.robot.commands.IntakeLiftIn;
import frc.robot.commands.IntakeLiftOut;
import frc.robot.commands.ClimberUp;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();// declaring new drivesystem object
  // private final TurnInPlaceCommand m_autoCommand = new
  // TurnInPlaceCommand(m_driveSubsystem, 90, 0.5);
  // private final DriveDistance m_autoCommand = new
  // DriveDistance(m_driveSubsystem, 60, 0.7);
  private final Auto1Ball m_autoCommand = new Auto1Ball(m_driveSubsystem, m_LimelightSubsystem, M_BALL_SUBSYSTEM);
  public static BallSubsystem M_BALL_SUBSYSTEM = new BallSubsystem();
  public static LimelightSubsystem m_LimelightSubsystem = new LimelightSubsystem();
  public static ClimberSubsystem m_ClimberSubsystem = new ClimberSubsystem();

  public static XboxController driverXBox = new XboxController(1);
  public static XboxController operatorController = new XboxController(2);

  private static final int A_BUTTON_XBOX = 1;
  private static final int B_BUTTON_XBOX = 2;
  private static final int X_BUTTON_XBOX = 3;
  private static final int Y_BUTTON_XBOX = 4;
  private static final int LEFT_BUMPER_XBOX = 5;
  private static final int RIGHT_BUMPER_XBOX = 6;
  private static final int BACK_ARROW = 7;
  private static final int START_ARROW = 8;
  private static final int JOYSTICK_RIGHT_CLICK = 10;
  private static final int JOYSTICK_LEFT_CLICK = 9;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_driveSubsystem.setDefaultCommand(
        new RunCommand(() -> m_driveSubsystem.tankDrive(driverXBox.getRawAxis(1), driverXBox.getRawAxis(5)),
            m_driveSubsystem));
    // ^ Setting the Default Command to m_robotDrive, meaning it will drive as long
    // as nothing else is scheduled

    /*
     * Climber climber_command = new Climber(m_ClimberSubsystem,
     * operatorController.getRawAxis(1) * Constants.CLIMBER_SPEED_MULTIPLIER);
     * m_ClimberSubsystem.setDefaultCommand(climber_command);
     */
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton flywheelStarButton = new JoystickButton(operatorController, B_BUTTON_XBOX);
    flywheelStarButton.toggleWhenPressed(new FlywheelStartCommand(M_BALL_SUBSYSTEM, Constants.sixHIGH_FLYWHEEL_SPEED));

    JoystickButton oneIndexBallCommandButton = new JoystickButton(operatorController, A_BUTTON_XBOX);
    oneIndexBallCommandButton.whileHeld(new OneIndexBallCommand(M_BALL_SUBSYSTEM));

    JoystickButton bounceFlywheel = new JoystickButton(operatorController, X_BUTTON_XBOX);
    bounceFlywheel.toggleWhenPressed(new FlywheelStartCommand(M_BALL_SUBSYSTEM, Constants.LOW_FLYWHEEL_SPEED));

    JoystickButton transportButton = new JoystickButton(operatorController, LEFT_BUMPER_XBOX);
    transportButton.whileHeld(new Transport(M_BALL_SUBSYSTEM));

    JoystickButton SpitButton = new JoystickButton(operatorController, RIGHT_BUMPER_XBOX);
    SpitButton.whileHeld(new Spit(M_BALL_SUBSYSTEM));

    JoystickButton intakeButton = new JoystickButton(driverXBox, LEFT_BUMPER_XBOX);
    intakeButton.toggleWhenPressed(new BallIntake(M_BALL_SUBSYSTEM));

    JoystickButton outtakeButton = new JoystickButton(driverXBox, RIGHT_BUMPER_XBOX);
    outtakeButton.toggleWhenPressed(new BallOuttake(M_BALL_SUBSYSTEM));

    JoystickButton intakeLiftInButton = new JoystickButton(operatorController, START_ARROW);
    intakeLiftInButton.toggleWhenPressed(new IntakeLiftIn(M_BALL_SUBSYSTEM));

    JoystickButton intakeLiftOutButton = new JoystickButton(operatorController, BACK_ARROW);
    intakeLiftOutButton.toggleWhenPressed(new IntakeLiftOut(M_BALL_SUBSYSTEM));

    JoystickButton enableClimber = new JoystickButton(driverXBox, X_BUTTON_XBOX);
    enableClimber.toggleWhenPressed(new ClimberUp(m_ClimberSubsystem, Constants.CLIMBER_SPEED));

    JoystickButton disableClimber = new JoystickButton(driverXBox, Y_BUTTON_XBOX);
    disableClimber.toggleWhenPressed(new ClimberDown(m_ClimberSubsystem, Constants.CLIMBER_SPEED));
    // TODO: limelight and check flywhel rpm

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    m_driveSubsystem.resetEncoders();
    return m_autoCommand;
  }
}
