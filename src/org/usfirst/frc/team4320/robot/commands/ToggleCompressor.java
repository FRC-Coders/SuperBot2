package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleCompressor extends InstantCommand {
	public ToggleCompressor(){
		requires(Robot.pneumaticsControl);
	}
	// Called just before this Command runs the first time
	//set the compressor state to its opposite state;
	@Override
	protected void initialize() {
		Robot.pneumaticsControl.setComressorState(!Robot.pneumaticsControl.getCompressorState());
	}

}
