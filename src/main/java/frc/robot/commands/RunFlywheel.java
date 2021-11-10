/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.shooter;

/**
 * An example command that uses an example subsystem.
 */
public class RunFlywheel extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private ShuffleboardTab tab = Shuffleboard.getTab("SmartDashboard");
  //private NetworkTableEntry p = tab.add("p",Constants.shooter_kP).getEntry();
  //private NetworkTableEntry i = tab.add("i",Constants.shooter_kI).getEntry();
  //private NetworkTableEntry d = tab.add("d",Constants.shooter_kD).getEntry();
  //rivate NetworkTableEntry f = tab.add("f",Constants.shooter_kF).getEntry();
  private NetworkTableEntry dashspeed = tab.add("target velocity",0).getEntry();
  //private NetworkTableEntry vel = tab.add("flywheel velocity",0.1).getEntry();
  

  

    private shooter shooter;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunFlywheel(shooter subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    shooter = subsystem;
  }


  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   /*
    shooter.setTalonGains(p.getDouble(0), i.getDouble(0), d.getDouble(0), f.getDouble(0));
    shooter.setFlywheelSpeed(speed.getDouble(0));
  */
   shooter.flywheelSpeedPercent(-dashspeed.getDouble(1));
  }


  public void execute() {
   // vel.setDouble(shooter.getFlywheelVelocity());
  }

  // Called every time the scheduler runs while the command is scheduled

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      shooter.flywheelSpeedPercent(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}