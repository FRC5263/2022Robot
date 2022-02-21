// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ballCollectorSubsystem extends SubsystemBase {

  //declare variables
  private MotorController ballRollerMotor;

  /** Creates a new ballCollectorSubsystem. */
  public ballCollectorSubsystem(MotorController ballRollerMotor) {
    System.out.print("Creating Ball Collector Subsystem\n");
    this.ballRollerMotor = ballRollerMotor;
    System.out.print("Created new Ball Collector Subsystem\n");
  }

  public void rollRoller(boolean doRollRoller) {
    if(doRollRoller == true) {
      ballRollerMotor.set(1);
    } else {
      ballRollerMotor.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
