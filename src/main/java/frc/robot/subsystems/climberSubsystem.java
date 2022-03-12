// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class climberSubsystem extends SubsystemBase {
private MotorController motor;

  /** Creates a new climberSubsystem. */
  public climberSubsystem(MotorController motor) {
    this.motor = motor;
  }

  public void moveMotor(double power) {
    motor.set(power*.3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
