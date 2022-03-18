/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public final class Constants {
    public static double k = 0.8;// in DriveSubsystem, changes speed for some reason
    public static final double K_TURN = 0.25;
    public static final double MAX_SPEED = 0.25;
    // public static final double tenHIGH_FLYWHEEL_SPEED = -1;
    public static final double sixHIGH_FLYWHEEL_SPEED = -1;// 2800-3000 RPM
    public static final double AUTO_FLYWHEEL_SPEED = -1;
    public static final double LOW_FLYWHEEL_SPEED = -0.45; // 1500-1800 RPM
    public static final double BALL_INDEX_SPEED = -0.75;
    public static final double GATHERER_SPEED = 1;
    public static final double TRANSPORT_SPEED = 0.5;
    public static final int SMART_LIMIT = 80;
    public static final double CLIMBER_SPEED = 0.5;//multiplier for the climber
    public static final double INTAKELIFT_SPEED_UP = 1.0;
    public static final double INTAKELIFT_SPEED_DOWN = 0.6;
}
