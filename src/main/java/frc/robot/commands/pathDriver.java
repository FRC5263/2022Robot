// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class pathDriver extends SequentialCommandGroup {
  /**
   * creates a command to run over a pathweaver path
   * @param drivetrain insert your drivetrain here
   * @param filePathtoTrajectory put any pathweaver paths in here. all paths have to be put into the deploy folder, ie: src/main/deploy
   */
  public pathDriver(DriveTrainSubsystem drivetrain, String filePathtoTrajectory) {
    //inits the trajectory variable
    Trajectory driveTrainjectory;
    
    //checks to see if the file exist/ is a valid file path
    try {
      Path filepath = Filesystem.getDeployDirectory().toPath().resolve(filePathtoTrajectory);
      driveTrainjectory = TrajectoryUtil.fromPathweaverJson(filepath);
    } catch (IOException ex) {
      //reports to the driverstation that the path is unreachable
      DriverStation.reportError("Unable to open trajectory" + filePathtoTrajectory + "\neither the file does not exist or there is a typo in the path\n", ex.getStackTrace());
      return;
    }

    /*RamseteCommand ramseteCommand = 
      new RamseteCommand(
        driveTrainjectory, 
        drivetrain.odometry::getPosMeters, 
        controller, 
        feedforward, 
        kinematics, 
        wheelSpeeds, 
        leftController, 
        rightController, 
        outputVolts, 
        requirements
        )*/

    addCommands();
  }
}
