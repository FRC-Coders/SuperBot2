package org.usfirst.frc.team4320.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4320.robot.commands.Drive;
import org.usfirst.frc.team4320.robot.commands.EjectGear;
import org.usfirst.frc.team4320.robot.commands.GrabGear;
import org.usfirst.frc.team4320.robot.commands.LiftJaws;
import org.usfirst.frc.team4320.robot.commands.SwitchDrive;
import org.usfirst.frc.team4320.robot.commands.ToggleCompressor;
import org.usfirst.frc.team4320.robot.commands.ToggleJaws;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joystick;
	private XboxController xboxController;
	private JoystickButton compressorButton;
	private JoystickButton trigger;
	private JoystickButton jawsButton;
	private JoystickButton grabButton;
	private JoystickButton ejectButton;
	private JoystickButton liftJawsButton;
	
	public OI(){
		joystick = new Joystick(RobotMap.JOYSTICK);
		xboxController = new XboxController(RobotMap.XBOXCONTROLLER);
		compressorButton = new JoystickButton(xboxController,4);//Y Button
		trigger = new JoystickButton(joystick,1);//Front Trigger
		jawsButton = new JoystickButton(xboxController,6);
		grabButton = new JoystickButton(xboxController,3);
		ejectButton = new JoystickButton(xboxController,2); 
		liftJawsButton = new JoystickButton(xboxController,5);
		
		trigger.whenPressed(new SwitchDrive());
		compressorButton.toggleWhenPressed(new ToggleCompressor());
		jawsButton.toggleWhenPressed(new ToggleJaws());
		grabButton.toggleWhenPressed(new GrabGear());
		ejectButton.toggleWhenPressed(new EjectGear());
		liftJawsButton.toggleWhenPressed(new LiftJaws());
	}
	public Joystick getJoystick(){
		return joystick;
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

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
