package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.Robot;
import org.usfirst.frc.team4320.robot.subsystems.GearJaws.GrabberState;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleJaws extends Command {
	public ToggleJaws(){
		requires(Robot.gearJaws);
	}
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.gearJaws.setJaws(true);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.gearJaws.setJaws(false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

}
