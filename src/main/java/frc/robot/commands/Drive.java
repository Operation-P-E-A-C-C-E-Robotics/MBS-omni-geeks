// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrain;



/** An example command that uses an example subsystem. */
public class Drive extends CommandBase {
  private final Joystick m_stick = new Joystick(0);

  public static double x;
  public static double y;

  /**
   * Creates a new ExampleCommand.
   *
   * @param m_DriveTrain The subsystem used by this command.
   */
  DriveTrain dt;
  public Drive(DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    dt = driveTrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
    x = -m_stick.getX();
    y = -m_stick.getY();
   dt.teledrive(y, x);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
