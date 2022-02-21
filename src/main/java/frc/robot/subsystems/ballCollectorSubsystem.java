// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ballCollectorSubsystem extends SubsystemBase {

  private MotorController ballRollerMotor;
  private MotorController armJointMotor;

  /** Creates a new ballCollectorSubsystem. */
  public ballCollectorSubsystem(MotorController ballRollerMotor, MotorController armJointMotor) {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
