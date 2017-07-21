package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.Robot;
import org.usfirst.frc.team4320.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	
	public Drive(){
		requires(Robot.driveSubsystem);
	}
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(Robot.driveSubsystem.getDriveState() == DriveSubsystem.DriveState.arcade){
			Robot.driveSubsystem.initArcade();
			Robot.driveSubsystem.drive(Robot.oi.getJoystick().getY(),Robot.oi.getJoystick().getZ());
		}
		else if (Robot.driveSubsystem.getDriveState() == DriveSubsystem.DriveState.mecanum){
			Robot.driveSubsystem.initMecanum();
			Robot.driveSubsystem.drive(Robot.oi.getJoystick().getX(),Robot.oi.getJoystick().getY(),Robot.oi.getJoystick().getZ());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveSubsystem.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
