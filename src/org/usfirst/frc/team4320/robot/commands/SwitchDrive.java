package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.Robot;
import org.usfirst.frc.team4320.robot.subsystems.DriveSubsystem.DriveState;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SwitchDrive extends CommandGroup{
	public SwitchDrive(){
		if(Robot.driveSubsystem.getDriveState()==DriveState.arcade){
			addParallel(new ToggleDriveState(DriveState.mecanum));
			addParallel(new TogglePistons(true));
		}
		else if(Robot.driveSubsystem.getDriveState()==DriveState.mecanum){
			addParallel(new ToggleDriveState(DriveState.arcade));
			addParallel(new TogglePistons(false));
		}
	}

}
