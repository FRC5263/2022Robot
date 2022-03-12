// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Auton;
import frc.robot.commands.Teleop;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.climberSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //encoders
  private Encoder frontRightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
  private Encoder frontLeftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k2X);
  private Encoder rearRightEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k2X);
  private Encoder rearLeftEncoder = new Encoder(6, 7, false, Encoder.EncodingType.k2X);

  // CAN device ID assignments
  private final int CAN_RR_DRIVE_MOTOR = 6;
  private final int CAN_FR_DRIVE_MOTOR = 8;
  private final int CAN_RL_DRIVE_MOTOR = 9;
  private final int CAN_FL_DRIVE_MOTOR = 10;

  // PWM channel assignments
  private final int PWM_SHOOTER_LEFT = 0;
  private final int PWM_SHOOTER_RIGHT = 1;
  private final int PWM_VELCRO = 3;
  private final int PWM_INTAKE = 2;
  private final int PWM_CLIMBER = 4;

  //drivetrain motors
  private MotorController frontRightMotor = new WPI_VictorSPX(CAN_FR_DRIVE_MOTOR);
  private MotorController frontLeftMotor = new WPI_VictorSPX(CAN_FL_DRIVE_MOTOR);
  private MotorController rearRightMotor = new WPI_VictorSPX(CAN_RR_DRIVE_MOTOR);
  private MotorController rearLeftMotor = new WPI_VictorSPX(CAN_RL_DRIVE_MOTOR);

  //other motors
  private MotorController shooterLeft = new Spark(PWM_SHOOTER_LEFT);
  private MotorController shooterRight = new Spark(PWM_SHOOTER_RIGHT);
  private MotorController shooter = new MotorControllerGroup(shooterLeft, shooterRight);
  private MotorController velcro = new Spark(PWM_VELCRO);
  private MotorController intake = new Spark(PWM_INTAKE);
  private MotorController climber = new Spark(PWM_CLIMBER);

  public final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem(frontRightMotor, frontLeftMotor, rearRightMotor, rearLeftMotor);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem(shooter, velcro, intake);
  private final climberSubsystem climberSubsystem = new climberSubsystem(climber);

  final XboxController controller0 = new XboxController(0);
  final XboxController controller1 = new XboxController(1);
  private final Command m_teleOp = new Teleop(driveTrainSubsystem, shooterSubsystem, climberSubsystem, controller0, controller1);
  private final Command m_auton = new Auton(driveTrainSubsystem, shooterSubsystem);

  public Command getTeleOpCommad() {
    return m_teleOp;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_auton;
  }

}
