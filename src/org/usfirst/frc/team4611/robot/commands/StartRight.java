package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRight extends CommandGroup{
	
	public StartRight() {
		addSequential(new RetractSolenoid(),.5);
		addSequential(new DriveEncoders(71));
		addSequential(new Wait(),1);
		addSequential(new AutoTurn(-59));
		addSequential(new Wait(),1);
		addSequential(new DriveEncoders(67));
		addSequential(new Wait(),1);
		addSequential(new ExtendSolenoid(),1);
		addParallel(new MoveFeeder(-0.5));
		addSequential(new DriveEncoders(-63));
		addSequential(new Wait(),1);
		addSequential(new AutoTurn(60));
		addParallel(new MoveFeeder(0));
		addParallel(new RetractSolenoid());
		addSequential(new Wait(),1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is right finished?");
		return false;
	}

}
