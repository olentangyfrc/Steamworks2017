package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenter extends CommandGroup{

	public StartCenter() {
		addSequential(new RetractSolenoid(),.5); 
		addSequential(new DriveEncoders(77));
		addSequential(new Wait(), .01);
		addSequential(new ExtendSolenoid(),1);
		addParallel(new MoveFeeder(-0.5));
		addSequential(new DriveEncoders(-50));
		addParallel(new MoveFeeder(0));
		addParallel(new RetractSolenoid());
		addSequential(new Wait(), .01);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is center finished?");
		return false;
	}

}
