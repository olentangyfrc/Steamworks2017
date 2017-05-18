package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRight extends CommandGroup{
	
	public StartRight() {
		addSequential(new DriveEncoders(59.81));
		addSequential(new Wait(), 0.2);
		addSequential(new AutoTurn(-60));
		addSequential(new Wait(), 0.2);
		addSequential(new DriveEncoders(80.65));
		addSequential(new Wait(), 0.2);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is right finished?");
		return false;
	}

}
