/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.MoveArmWithJoysticks;
import frc.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import static org.junit.Assume.assumeNoException;
/*
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
*/
import com.ctre.phoenix.motorcontrol.StickyFaults; 
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ArmSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static final int KArmTalon = 10;

  //ArmSpeed
  public static final double KArmSpeed = 1.0; // 100%

  private TalonSRX armTalon;

  public ArmSubsystem()
  {
    armTalon = new TalonSRX(KArmTalon);
  }

  @Override
  public void initDefaultCommand() {
    //default command for a subsystem here.
   setDefaultCommand(new MoveArmWithJoysticks());
  }

  public void move(double speed) {
    armTalon.set(ControlMode.PercentOutput, speed);
  }
  public void moveWithJoysticks(double speed) {
    armTalon.set(ControlMode.PercentOutput, speed);
    SmartDashboard.putNumber("XBOX AXIS", Robot.oi.getXboxAxis());
  }
}
