// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Teleop extends CommandBase {
  DriveTrainSubsystem differentialDriveTrain;
  DriveTrainSubsystem driveTrainEncoders;
  ShooterSubsystem shooter;
  XboxController controller0;
  XboxController controller1;

  /** Creates a new DifferentialControl without drivetrain encoders. */
  public Teleop(DriveTrainSubsystem drivetrain, ShooterSubsystem shooter, XboxController controller0, XboxController controller1) {
    System.out.print("Creating new Teleop\n");
    this.differentialDriveTrain = drivetrain;
    this.shooter = shooter;
    this.controller0 = controller0;
    this.controller1 = controller1;
    System.out.print("Teleop created\n");
  }

  /** Creates a new DifferentialControl with Drive train encoders. */
  public Teleop(DriveTrainSubsystem drivetrain, DriveTrainSubsystem driveTrainEncoders, ShooterSubsystem shooter, XboxController controller0, XboxController controller1) {
    System.out.print("Creating new Teleop\n");
    this.driveTrainEncoders = driveTrainEncoders;
    this.differentialDriveTrain = drivetrain;
    this.shooter = shooter;
    this.controller0 = controller0;
    this.controller1 = controller1;
    System.out.print("Teleop created\n");
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.print("Teleop initialized\n");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    differentialDriveTrain.DriveDifferentialCurvature(-controller0.getRawAxis(1), -controller0.getRawAxis(0));
    controller0.setRumble(RumbleType.kRightRumble, 1);

    shooter.setIntake(controller1.getAButton(), .9);
    shooter.setShooter(controller1.getRawAxis(2)*.65);
    controller1.setRumble(RumbleType.kLeftRumble, controller1.getRawAxis(2));
    controller1.setRumble(RumbleType.kRightRumble, controller1.getRawAxis(2));
    controller0.setRumble(RumbleType.kLeftRumble, controller1.getRawAxis(2));
    shooter.setVelcro(controller1.getXButton());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    controller0.setRumble(RumbleType.kRightRumble, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
