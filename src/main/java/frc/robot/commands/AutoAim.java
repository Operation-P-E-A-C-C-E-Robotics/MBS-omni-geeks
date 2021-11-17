// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
  /** Creates a new autoaim. */
public class AutoAim extends CommandBase {
  private static DriveTrain driveTrain;
  private static Limelight camera = new Limelight(0, 0, 0);
  private static final double rotationP = 0.1;
  private static final double foc_len = 0.01;
  private static final double targ_dist = 10;
  /** Creates a new autoaim. */
  public AutoAim(DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dt);
    driveTrain = dt;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //double short_length = camera.getTargetShortSidelength();
    double offset = Limelight.getTargetOffsetX();

    double rot = offset * rotationP;
    //double drv = short_length / foc_len - targ_dist;

    SmartDashboard.putNumber("offset", offset);
    SmartDashboard.putNumber("rotation out", rot);

    DriveTrain.teledrive(0, rot);
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
}
