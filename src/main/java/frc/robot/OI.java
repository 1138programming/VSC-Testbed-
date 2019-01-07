/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  public static final int KXboxArms = 0;
  public static final int KLogitechDrive = 1;

  public static final double KDeadZoneAxis = 0.2; 

  public Joystick xbox;
  public Joystick logitech;
  public OI(){
    logitech = new Joystick(KLogitechDrive);
    xbox = new Joystick(KXboxArms);
  }

  public double getRightAxis() {
    if(KDeadZoneAxis < logitech.getThrottle() || KDeadZoneAxis > -logitech.getThrottle()){
      return logitech.getThrottle(); 
    }
    else {
      return 0; 
    }
  }
  public double getLeftAxis() {
    if(KDeadZoneAxis < logitech.getY() || KDeadZoneAxis > -logitech.getY()){
      return logitech.getY(); 
    }
    else {
      return 0; 
    }
  }

  //Joystick stick = new Joystick(port);
  //Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}