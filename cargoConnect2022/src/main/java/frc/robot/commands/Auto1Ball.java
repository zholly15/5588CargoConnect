package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.LimelightTrack;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;


public class Auto1Ball extends SequentialCommandGroup{
    private static final double FOWARD_DISTANCE = 60;
    private static final double FOWARD_SPEED = 0.7;
    public Auto1Ball(DriveSubsystem drive, LimelightSubsystem limelight, BallSubsystem ballSubsystem) {
        addCommands(
            new DriveDistance(drive, 70, 0.7),
            new LimelightTrack(limelight, drive),
            new AutoBallShoot(ballSubsystem)
            );
    }


}
