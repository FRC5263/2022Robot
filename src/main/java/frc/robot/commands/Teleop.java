// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Teleop extends CommandBase {
  DriveTrainSubsystem differentialDriveTrain;
  ShooterSubsystem shooter;
  XboxController controller0;

  /** Creates a new DifferentialControl. */
  public Teleop(DriveTrainSubsystem drivetrain, ShooterSubsystem shooter, XboxController controller0) {
    System.out.print("creating new drivetrain control\n");
    this.differentialDriveTrain = drivetrain;
    this.shooter = shooter;
    this.controller0 = controller0;
    System.out.print("drivetrain control created\n");
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.print("DifferentialDriveTrainControl initialized\n");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    differentialDriveTrain.DriveDifferentialCurvature(controller0.getRawAxis(1), controller0.getRawAxis(0));
    controller0.setRumble(RumbleType.kRightRumble, 1);

    shooter.setIntake(controller0.getAButton());
    shooter.setShooter(controller0.getRawAxis(2));
    shooter.setVelcro(controller0.getXButton());
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