// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class Autonomous extends CommandBase {
  /** Creates a new Autonomous. */

  
  private double x;
  private double y;

  private Subsystem dt;

  public Autonomous(Subsystem DriveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DriveTrain);
    
    DriveTrain = dt;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //moveOffLine();
  
    /*
    moveOffLine();
    System.out.println("Left Motor At" + DriveTrain.m_leftMotor.get());
    System.out.println("Right Motor At" + DriveTrain.m_rightMotor.get());
    System.out.println("Holding for 5 seconds");
    Timer.delay(5);
    DriveTrain.teledrive(0, 0);
    System.out.println("Left Motor At" + DriveTrain.m_leftMotor.get());
    System.out.println("Right Motor At" + DriveTrain.m_rightMotor.get());
    */
  }



  // Called every time the scheduler runs if the command is scheduled.
  @Override
  public void execute() {
   
    moveOffLine();
    /*
    DriveTrain.autodrive(x, y);
    System.out.println("Left Motor At" + DriveTrain.m_leftMotor.get());
    System.out.println("Right Motor At" + DriveTrain.m_rightMotor.get());
    
    if(Limelight.hasTarget() != 1 && this.robot.isAutonomous()){
      System.out.println("Searching For Target...");
      spinUntilTarget();
    } else {
      movetoTarget();
    }
    */
  } 


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveTrain.teledrive(0, 0);
  }
  



  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


 public void spinUntilTarget() {
  x = 0.5;
  y = -0.5;
}

 public void movetoTarget() {
  DriveTrain.autodrive(-Limelight.getTargetOffsetX(), -Limelight.getTargetOffsetY());

 }

public void moveOffLine() {
  if(Timer.getMatchTime() < 15) {
  DriveTrain.autodrive(0.5, 0.5);
  System.out.println("Move off line");
  Shooter.shoot_motor.set(0.5);

 }
  if(Timer.getMatchTime() < 10) {
  Intake.intake.set(-1);
 }
  if(Timer.getMatchTime() < 5) {
  DriveTrain.autodrive(-0.5, -0.5);
  Intake.intake.set(0);
  Shooter.shoot_motor.set(0);

  }
}


}
