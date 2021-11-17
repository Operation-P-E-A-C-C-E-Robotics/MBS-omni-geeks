// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;

public class shooter extends SubsystemBase {
  public static WPI_TalonFX shoot_motor = new WPI_TalonFX(Constants.shooter);
  
  /** Creates a new shooter. */
  public shooter() {

    /*
    //set pidf constants
    shoot_motor.config_kP(0, Constants.shooter_kP);
    shoot_motor.config_kI(0, Constants.shooter_kI);
    shoot_motor.config_kD(0, Constants.
    shooter_kD);
    shoot_motor.config_kF(0, Constants.shooter_kF);
    // m_encoder.setDistancePerPulse(12);
    */
    
  }


  /**
   * set the speed of the flywheel using falcon pidf velocity control
   * @param speed velocity in (position change(of encoders))/100ms
   */

  

  
    /**
     * simple, set power output as percent of total
     * DONT GO NEGATIVE if I did 'setInverted' correctly
     * @param speed power as (-1 to 1)
     */
    public void flywheelSpeedPercent(double speed){
      shoot_motor.set(ControlMode.PercentOutput,speed);
    }
    
    /**
     * dont know if this is ever used, reset pidf gains to the values in Constants
     */
   
     /*

     public void setTalonGains(double p, double i, double d, double f){
      shoot_motor.config_kP(0, p);
      shoot_motor.config_kI(0, i);
      shoot_motor.config_kD(0, d);
      shoot_motor.config_kF(0, f);
    }
    */

    public void overidePIDControl(double speed) {
      shoot_motor.set(speed);
    }
    
   /*
    //self explanatory
    public double getFlywheelVelocity(){
      return shoot_motor.getSelectedSensorVelocity();
    }
    */
    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    
    }
    
  }