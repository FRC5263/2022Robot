// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  //variable deleration 
  MotorController rightShooterMotor;
  MotorController leftShooterMotor;
  MotorControllerGroup shooter;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem(MotorController rightShooterMotor, MotorController leftShooterMotor) {
    //variable declerations and assignments
    System.out.print("Creating new shooter subsystem\n");
    this.rightShooterMotor = rightShooterMotor;
    this.leftShooterMotor = leftShooterMotor;
    shooter = new MotorControllerGroup(rightShooterMotor, leftShooterMotor);
    this.shooter = shooter;
    System.out.print("new shooter subsystem created");
  }

  /**sets the power of the motors to power*/
  public void PowerShooter(float power) {
    shooter.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
