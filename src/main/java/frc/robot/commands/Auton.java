// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auton extends CommandBase {
  DriveTrainSubsystem driveTrain;
  ShooterSubsystem shooter;
  Timer timer = new Timer();
  /** Creates a new Auton. */
  public Auton(DriveTrainSubsystem driveTrain, ShooterSubsystem shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.shooter = shooter;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    System.out.print("auton lmao\n");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get() >= 0.0 && timer.get() <= .45) {
      driveTrain.DriveDifferentialTank(-1.0, -1.0);
    } else if (timer.get() >= .45 && timer.get() <= .8) {
      driveTrain.DriveDifferentialTank(1, 1);
      //shooter.setVelcro(1);
    } else if (timer.get() >= .8 && timer.get() < 2.0) {
      shooter.setVelcro(1);
    } else {
      driveTrain.DriveDifferentialTank(0, 0);
      shooter.setVelcro(0);
    }
    shooter.setShooter(1);
    System.out.print("farret gilkins\n");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.print("bye bye auton\n");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
