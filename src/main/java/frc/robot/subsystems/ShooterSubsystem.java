// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  //variable deleration 
  MotorController shooter;
  MotorController velcro;
  MotorController intake;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem(MotorController shooter, MotorController velcro, MotorController intake) {
    //variable declerations and assignments
    System.out.print("Creating new shooter subsystem\n");
    this.velcro = velcro;
    this.shooter = shooter;
    this.intake = intake;
    
    System.out.print("new shooter subsystem created");
  }
  

  /**
   * Sets intake power.
   * @param power -1.0 = full power reverse-- i.e. the ball will be ejected out the front of the robot
   *              1.0 = full power forward-- i.e. ball will be taken into front of robot
   */
  public void setIntake(double power) {
    intake.set(power);
  }

  /**
   * Activates intake motor with boolean statments. use this function with a button
   * @param offoron the intake turns on or off depending on if this parameter is true
   */
  public void setIntake(boolean spinIntake) {
    if(spinIntake == true) {
      System.out.print("spining intake");
      intake.set(.8);
    } else {
      intake.set(0);
    }
  }

  /**
   * Sets shooter wheel power for both shooter wheels.
   * @param power 1.0 = full power shoot i.e. balls will be shot up and out of the robot
   *              -1.0 = full pwoer reverse i.e. balls will be drawn down toward the floor
   */
  public void setShooter(double power) {
    shooter.set(power);
  }

  /**
   * Sets velcro power.
   * @param power 1.0 = full power shoot, i.e. balls will be drawn towards shooter
   *              -1.0 = full power reverse, i.e. balls will be pushed towards intake
   */
  public void setVelcro(double power) {
    velcro.set(power);
  }

  /**
   * activates velcro motor with a boolean. use this with buttons
   * @param spinVelcro set to true to activate the motor
   */
  public void setVelcro(boolean spinVelcro) {
    if(spinVelcro == true) {
      System.out.print("spining velcro");
      velcro.set(.8);
    } else {
      velcro.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
