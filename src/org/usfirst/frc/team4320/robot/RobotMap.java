package org.usfirst.frc.team4320.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//CAN Ports
	public static final int LEFT_REAR_MOTOR = 0;
	public static final int LEFT_FRONT_MOTOR = 1;
	public static final int RIGHT_REAR_MOTOR = 2;
	public static final int RIGHT_FRONT_MOTOR = 3;
	
	//Joysticks port
	public static final int JOYSTICK = 0;
	
	//Controller port
	public static final int XBOXCONTROLLER = 1;
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
