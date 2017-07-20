package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;



public class DriveSubsystem extends Subsystem{
	public enum DriveState{
		arcade,
		mecanum
	}
	private CANTalon leftRearTalonM;
	private CANTalon leftFrontTalonS;
	private CANTalon rightRearTalonM;
	private CANTalon rightFrontTalonS;
	private RobotDrive arcadeDrive;
	private RobotDrive mecanumDrive;
	private DriveState state;//will be used to determine the cylinders state

	
	private DriveSubsystem(){
		 //Define CAN Talons
		 leftRearTalonM = new CANTalon(RobotMap.LEFT_REAR_MOTOR);
		 leftFrontTalonS = new CANTalon(RobotMap.LEFT_FRONT_MOTOR);
		 rightRearTalonM = new CANTalon(RobotMap.RIGHT_REAR_MOTOR);
		 rightFrontTalonS = new CANTalon(RobotMap.RIGHT_FRONT_MOTOR);
		 arcadeDrive = new RobotDrive(leftRearTalonM, rightRearTalonM);
		 mecanumDrive  =new RobotDrive(leftFrontTalonS, leftRearTalonM, rightFrontTalonS, rightRearTalonM);       
	}
	public void initArcade(){
		 //Define slave and master with follower
		 leftFrontTalonS.changeControlMode(TalonControlMode.Follower);
		 leftFrontTalonS.set(RobotMap.LEFT_REAR_MOTOR);
		 rightFrontTalonS.changeControlMode(TalonControlMode.Follower);
		 rightFrontTalonS.set(RobotMap.RIGHT_REAR_MOTOR);
		 
		 state = DriveState.arcade;
	}
	public void initMecanum(){
		 //Define slave and master with follower
		 leftFrontTalonS.changeControlMode(TalonControlMode.PercentVbus);
		 rightFrontTalonS.changeControlMode(TalonControlMode.PercentVbus);
		 state = DriveState.arcade;
	}
	
	public void Drive(double y, double z){
		arcadeDrive.arcadeDrive(y,z);
	}
	public void Drive(double x, double y, double z){
		arcadeDrive.mecanumDrive_Cartesian(x, y, z, 0);
	}
	public DriveState getDriveState(){
		return state;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
