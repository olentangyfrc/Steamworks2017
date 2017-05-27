package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartDefaultAuton extends CommandGroup{
	
	public StartDefaultAuton() {
		addSequential(new DriveEncoders(110));
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is right finished?");
		return false;
	}
}
