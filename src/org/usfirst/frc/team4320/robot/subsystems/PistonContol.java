package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PistonContol extends Subsystem{
	
	public enum Piston {
		frontLeft,
		rearLeft,
		frontRight,
		rearRight
	}
	private DoubleSolenoid frontLeft;
	private DoubleSolenoid rearLeft;
	private DoubleSolenoid frontRight;
	private DoubleSolenoid rearRight;
	private boolean state;
	
	public PistonContol() {
		frontLeft=new DoubleSolenoid(RobotMap.FRONT_LEFT_ACTIVE, RobotMap.FRONT_LEFT_DRAIN);
		rearLeft=new DoubleSolenoid(RobotMap.REAR_LEFT_ACTIVE ,RobotMap.REAR_LEFT_DRAIN);
		frontRight=new DoubleSolenoid(RobotMap.FRONT_RIGHT_ACTIVE, RobotMap.FRONT_RIGHT_DRAIN);
		rearRight=new DoubleSolenoid(RobotMap.REAR_RIGHT_ACTIVE, RobotMap.REAR_LEFT_DRAIN);
		
	}
	
	public void setPistonState(boolean state,Piston piston){
		if(state) {
			switch(piston) {
			case frontLeft : frontLeft.set(DoubleSolenoid.Value.kForward) ;
			break;
			case rearLeft : rearLeft.set(DoubleSolenoid.Value.kForward);
			break;
			case frontRight : frontRight.set(DoubleSolenoid.Value.kForward);
			break;
			case rearRight : rearRight.set(DoubleSolenoid.Value.kForward);
			break;
			}
		}
		else {
			switch(piston) {
			case frontLeft : frontLeft.set(DoubleSolenoid.Value.kReverse) ;
			break;
			case rearLeft : rearLeft.set(DoubleSolenoid.Value.kReverse);
			break;
			case frontRight : frontRight.set(DoubleSolenoid.Value.kReverse);
			break;
			case rearRight : rearRight.set(DoubleSolenoid.Value.kReverse);
			break;
			}
		}
		this.state=state;
	}
	public boolean getState() {
		return state;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
