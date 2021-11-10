// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

 public static final int Ldrive = 0;
 public static final int Rdrive = 1;
 public static final int shooter = 2;
 public static final int intake = 7;
 public static final double shooter_kP = 0.5,
                            shooter_kI = 0,
                            shooter_kD = 0,
                            shooter_kF = 0.06;
}


