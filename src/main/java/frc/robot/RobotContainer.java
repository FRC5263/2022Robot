// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Teleop;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private MotorController frontRightMotor = new WPI_VictorSPX(8);
  private MotorController frontLeftMotor = new WPI_VictorSPX(10);
  private MotorController rearRightMotor = new WPI_VictorSPX(6);
  private MotorController rearLeftMotor = new WPI_VictorSPX(9);
  private MotorController shooterLeft = new Spark(7);
  private MotorController shooterRight = new Spark(5);
  private MotorController shooter = new MotorControllerGroup(shooterLeft, shooterRight);
  private MotorController velcro = new Spark(6);
  private MotorController intake = new Spark(8);

  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem(frontRightMotor, frontLeftMotor, rearRightMotor, rearLeftMotor);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem(shooter, velcro, intake);

  final XboxController controller0 = new XboxController(0);
  final XboxController controller1 = new XboxController(1);
  private final Command m_teleOp = new Teleop(driveTrainSubsystem, shooterSubsystem, controller0, controller1);

  //private final Command m_teleOp = new DifferentialDriveTrainControl(new DriveTrainSubsystem(frontRightMotor, frontLeftMotor));

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    
  }

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
    return m_teleOp;
  }
}
