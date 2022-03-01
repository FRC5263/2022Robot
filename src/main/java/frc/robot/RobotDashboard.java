// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import pabeles.concurrency.ConcurrencyOps.NewInstance;

/** Add your docs here. */
public class RobotDashboard extends Robot{
    //varibable declerations

    //shuffleboard stuff
    ShuffleboardTab mainTab = Shuffleboard.getTab("Robot: Main");
    ShuffleboardTab diagnosticTab = Shuffleboard.getTab("Robot: Diagnostics");
    
    //wheel info
    public double backWheelDiameter;
    public double frontWheelDiameter;
    public double backWheelCircumfrence;
    public double frontWheelCircumfrence;

    //encoders for the wheels
    public Encoder frontRightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
    public Encoder frontLeftEncoder = new Encoder(2, 3, false, EncodingType.k2X);
    public Encoder rearRightEncoder = new Encoder(4, 5, false, EncodingType.k2X);
    public Encoder rearLeftEncoder = new Encoder(6, 7, false, EncodingType.k2X);

    //networkTables
    NetworkTableEntry robotVelocity;
    NetworkTableEntry redGamePiecesControled;
    NetworkTableEntry blueGamePiecesControled;
    NetworkTableEntry shooterPower;
    NetworkTableEntry shooterAim;
    NetworkTableEntry rollerPower;
    NetworkTableEntry velcroPower;

    public RobotDashboard() {}
}
