package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightSubsystem extends SubsystemBase {
private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");


public LimelightSubsystem(int a){
    table.getEntry("Pipeline").setNumber(a);//declares and sets up a limelight :)
}

public LimelightSubsystem(){
    this(0);//calls normal constructor cuz it needs a default for some reason
}

public boolean hasTarget(){
    return table.getEntry("tv").getDouble(0.0) > 0.0;//checks if taget value is greater than 0, 1 if has target 0 if no target :)
}

public double getX(){
    return table.getEntry("tx").getDouble(0.0);
}

public double getY(){
    return table.getEntry("ty").getDouble(0.0);
}

public double getArea(){
    return table.getEntry("ta").getDouble(0.0);
}

@Override
  public void periodic() {
    
  }

}