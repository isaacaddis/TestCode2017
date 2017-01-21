package org.usfirst.frc.team687.robot;

import org.usfirst.frc.team687.robot.commands.CloseGear;
import org.usfirst.frc.team687.robot.commands.Kick;
import org.usfirst.frc.team687.robot.commands.OpenGear;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joy = new Joystick(RobotMap.joystickPort);
	Button gearOpenButton = new JoystickButton(joy, 1);
	Button shootButton = new JoystickButton(joy, 3);
	Button hangButton = new JoystickButton(joy, 4);
	DoubleSolenoid doubly = new DoubleSolenoid(RobotMap.solenoidPort1,RobotMap.solenoidPort2);
	public OI(){
		gearOpenButton.whenPressed(new OpenGear());
		gearOpenButton.whenReleased(new CloseGear());
		shootButton.whenPressed(new Kick());				
	}	
}

