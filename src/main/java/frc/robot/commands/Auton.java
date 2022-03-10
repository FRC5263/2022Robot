// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import com.kauailabs.navx.frc.*;

public class Auton extends CommandBase {
  private final AHRS gyro = new AHRS(SPI.Port.kMXP);
  private DriveTrainSubsystem drivetrain;
  private DriveTrainSubsystem drivetrainEncoders;

  /** Creates a new Auton command. */
  public Auton(DriveTrainSubsystem drivetrain, DriveTrainSubsystem drivetrainEncoders, ShooterSubsystem shooter) {
    System.out.print("Creating new auton command\n");
    this.drivetrain = drivetrain;
    this.drivetrainEncoders = drivetrainEncoders;
    System.out.print("new auton commad created\n");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.print("auton command initialized\n");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.print("auton command ended\n");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
