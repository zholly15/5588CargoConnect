package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

/*
* limit switch, to know when we reached a certain point
* mechanism pulls in and stops the winch
* get a true false reading, signal pin should always be 5 or 0 bolts
* idfk read limit switch documentation
* will forward be extending or pulling?????????????
* run motor in other direction, not same direction anymore
* SparkMax motors connecting directly to the motor controller?????????????
* NEO motors 
* DIO pins
* use NO and CLOSE
*10 and 11
*/ 

public class ClimberSubsystem extends SubsystemBase{
    public CANSparkMax climber = new CANSparkMax(10, MotorType.kBrushless);
    public DigitalInput Switch = new DigitalInput(1);
    public RelativeEncoder m_encoder = climber.getEncoder();

    public ClimberSubsystem() {
      climber.setIdleMode(null);
      //climber.setIdleMode(NeutralMode.Brake);keeps climber in break mode from the code itself :)
    }

 @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double s){
    climber.set(s);//climber functionsaadffa are parallel :)
  }

  public boolean getSwitch(){
    return Switch.get();
  }

  public double getEncoderDistance() {
    return (m_encoder.getPosition() / 42);//42 ticks in one rotation, counting how many full rotations there are :)
  }
  
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
//turn motor controllers into SPARK Maxes, DONE
//pull encoder from SPARK MAX
//check docs for limit switches 
//bottom limit is limit switch
//when climnber retracts itll stop by touching limit switch
//encoder distance is how far high 
//set encoder value to 0 when 
//2 conditions always going to be if limit switch is hit or maxencoder distance is hit 