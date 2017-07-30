package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.Robot;
import org.usfirst.frc.team4320.robot.subsystems.DriveSubsystem.DriveState;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleDriveState extends InstantCommand {
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		if(Robot.driveSubsystem.getDriveState()==DriveState.arcade){
			Robot.driveSubsystem.setDriveState(DriveState.mecanum);
		}
		else if(Robot.driveSubsystem.getDriveState()==DriveState.mecanum){
			Robot.driveSubsystem.setDriveState(DriveState.arcade);
		}
	}

}
