// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {}
  public static WPI_VictorSPX m_leftMotor = new WPI_VictorSPX(0);
  public static WPI_VictorSPX m_rightMotor = new WPI_VictorSPX(1);
  public static DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Motor Speed:", m_leftMotor.get());
    SmartDashboard.putNumber("Right Motor Speed:", m_rightMotor.get());

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  
    
  }

  public static void teledrive(double x, double y) {
    m_robotDrive.arcadeDrive(x, y);
  }
  
  public static void autodrive(double x, double y) {
    m_robotDrive.tankDrive(y, x);
  }

}
