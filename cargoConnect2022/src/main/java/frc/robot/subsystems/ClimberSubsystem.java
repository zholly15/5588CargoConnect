package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

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
