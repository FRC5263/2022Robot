// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DifferentialDriveTrainControl extends CommandBase {
  DriveTrainSubsystem differentialDriveTrain;
  XboxController controller0 = new XboxController(0);


  /** Creates a new DifferentialControl. */
  public DifferentialDriveTrainControl(DriveTrainSubsystem drivetrain) {
    System.out.print("creating new drivetrain control\n");
    this.differentialDriveTrain = drivetrain;
    System.out.print("drivetrain control created\n");
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double Speed = controller0.getRawAxis(1);
    double rotation = controller0.getRawAxis(0);
    differentialDriveTrain.DriveDifferentialCurvature(controller0.getRawAxis(1), controller0.getRawAxis(0));
    controller0.setRumble(RumbleType.kRightRumble, 1);
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
