package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.Robot;
import org.usfirst.frc.team4320.robot.subsystems.DriveSubsystem.DriveState;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleDriveState extends InstantCommand {
	private DriveState state;
	public ToggleDriveState(DriveState state){
		requires(Robot.driveSubsystem);
		this.state = state;
	}
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.driveSubsystem.setDriveState(state);
	}

}
