package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
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
*/ 

public class ClimberSubsystem extends SubsystemBase{
    public VictorSPX climber = new VictorSPX(9);
    public VictorSPX climber1 = new VictorSPX(10);
    
    public ClimberSubsystem() {
        climber.setNeutralMode(NeutralMode.Brake);//keeps climber in break mode from the code itself :)
        climber1.setNeutralMode(NeutralMode.Brake);
    }

 @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double s){
    climber.set(ControlMode.PercentOutput, s);//climber functionsaadffa are parallel :)
    climber1.set(ControlMode.PercentOutput, s);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
