package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenter extends CommandGroup{

	public StartCenter() {
		addSequential(new DriveEncoders(72.5));
		addSequential(new Wait(), 2);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is center finished?");
		return false;
	}

}
