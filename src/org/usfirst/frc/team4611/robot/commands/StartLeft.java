package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeft extends CommandGroup{
	
	public StartLeft() {
		addSequential(new RetractSolenoid(),.5);
		addSequential(new DriveEncoders(66));
		addSequential(new Wait(), .01);
		addSequential(new AutoTurn(59));
		addSequential(new Wait(), .01);
		addSequential(new DriveEncoders(67));
		addSequential(new Wait(), .01);		//Supah short
		addSequential(new ExtendSolenoid(),1);
		addParallel(new MoveFeeder(-0.5));
		addSequential(new DriveEncoders(-31.5));
		addSequential(new Wait(), .01);
		addSequential(new AutoTurn(60));
		addParallel(new MoveFeeder(0));
		addParallel(new RetractSolenoid());
		addSequential(new Wait(), .01);
		addSequential(new DriveEncoders(80));
		addSequential(new Wait(), .01);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is left finished?");
		return false;
	}

}
