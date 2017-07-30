package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.PistonContol.Piston;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TogglePistons extends CommandGroup {
	public TogglePistons(boolean state){
		addParallel(new setPistons(Piston.frontLeft,state));
		addParallel(new setPistons(Piston.rearLeft,state));
		addParallel(new setPistons(Piston.frontRight,state));
		addParallel(new setPistons(Piston.rearRight,state));
	}

}
