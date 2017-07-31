package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearJaws extends Subsystem {
	private DoubleSolenoid jaws;
	private DigitalInput microSwitch;
	private Talon leftGrabTalon;
	private Talon rightGrabTalon;
	private static GearJaws instance;
	public static GearJaws getInstance(){
		if(instance == null)
			instance = new GearJaws();
		return instance;
	}
	private GearJaws(){
		jaws = new DoubleSolenoid(RobotMap.JAWS_ACTIVE,RobotMap.JAWS_DRAIN);
		microSwitch = new DigitalInput(RobotMap.MICRO_SWITCH_PORT);
		leftGrabTalon = new Talon(RobotMap.JAWS_LEFT_MOTOR);
		rightGrabTalon = new Talon(RobotMap.JAWS_RIGHT_MOTOR);
	}
	public void setJaws(boolean state){
		if(state){
			jaws.set(DoubleSolenoid.Value.kForward);
		}
		else{
			jaws.set(DoubleSolenoid.Value.kReverse);
		}
	}
	public boolean getJaws(){
		if(jaws.get() == DoubleSolenoid.Value.kForward)
			return true;
		else if(jaws.get() == DoubleSolenoid.Value.kReverse);
			return false;
	}
	public boolean getMicroSwitchState(){
		return microSwitch.get();
	}
	public void setGrabber(double speed){
		leftGrabTalon.set(-speed);
		rightGrabTalon.set(speed);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
