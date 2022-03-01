// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.wpilibj.drive.*;

public class DriveTrainSubsystem extends SubsystemBase {
  
  //variables for the drivetrain objects
  MotorController leftMotor;
  MotorController rightMotor;
  MotorController frontRightMotor;
  MotorController frontLeftMotor;
  MotorController rearRightMotor;
  MotorController rearLeftMotor;
  DifferentialDrive differentialDrivetrain;


  public DriveTrainSubsystem(MotorController frontRightMotor, MotorController frontLeftMotor, MotorController rearRightMotor, MotorController rearLeftMotor) {
    //makes variables for speedcontollers
    System.out.print("creating new drivetrain subsystem\n");
    this.frontLeftMotor = frontLeftMotor;
    this.frontRightMotor = frontRightMotor;
    this.rearRightMotor = rearRightMotor;
    this.rearLeftMotor = rearLeftMotor;
    this.leftMotor = new MotorControllerGroup(rearLeftMotor, frontLeftMotor);
    this.rightMotor = new MotorControllerGroup(rearRightMotor, frontRightMotor);

    this.differentialDrivetrain = new DifferentialDrive(leftMotor, rightMotor);
    System.out.print("new drivetrain subsystem created\n");
  }

  public DriveTrainSubsystem(MotorController rightMotor, MotorController leftMotor) {
    //makes variables for speedcontollers
    System.out.print("creating new drivetrain subsystem\n");
    this.leftMotor = leftMotor;
    this.rightMotor = rightMotor;

    this.differentialDrivetrain = new DifferentialDrive(leftMotor, rightMotor);
    System.out.print("new drivetrain subsystem created\n");
  }

  /**use this function to make a Differential Drive Train move with a tank drive control scheme. Left and Right will move independantly of each other */
  public void DriveDifferentialTank(double leftSpeed, double rightSpeed) {
    differentialDrivetrain.tankDrive(leftSpeed, rightSpeed);
  }

  /**use this funtion to make Differntail Drive Train move with a curverture drive control scheme. Left and Right work together*/
  public void DriveDifferentialCurvature(double xSpeed, double zRotation) {
    differentialDrivetrain.curvatureDrive(xSpeed, zRotation, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
