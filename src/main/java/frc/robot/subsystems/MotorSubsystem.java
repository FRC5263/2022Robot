/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class MotorSubsystem extends SubsystemBase {
  
  private MotorController motor;
  private double scalarPower = 1.0;
  private MotorController rearMotorRight;
  private MotorController rearMotorLeft;
  private MotorController frontMotorRight;
  private MotorController frontMotorLeft;
  private MotorController dualMotor;

  /**creates single motor MotorSubsytem */
  public MotorSubsystem(MotorController rearLeftMotor, MotorController rearRightMotor, MotorController frontLeftMotor, MotorController FrontRightMotor) {
    this.rearMotorLeft = rearLeftMotor;
    this.rearMotorRight = rearRightMotor;
    this.frontMotorLeft = frontLeftMotor;
    this.frontMotorRight = FrontRightMotor;
  }

  public MotorSubsystem(MotorController motor) {
    this.motor = motor;
  }

  public static void powerMotor(MotorController motor, double speed) {
    motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
