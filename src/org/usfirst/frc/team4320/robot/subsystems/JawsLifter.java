package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class JawsLifter extends Subsystem {
	private DoubleSolenoid jawsLift;
	private static JawsLifter instance;
	public static JawsLifter getInstance(){
		if(instance == null)
			instance = new JawsLifter();
		return instance;
	}
	private JawsLifter(){
		jawsLift = new DoubleSolenoid(RobotMap.JAWS_LIFT_ACTIVE,RobotMap.JAWS_LIFT_DRAIN);
	}
	public void setJawsPos(boolean state){
		if(state)
			jawsLift.set(Value.kForward);
		else
			jawsLift.set(Value.kReverse);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	

}
