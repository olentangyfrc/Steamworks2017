package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestEncoderDriveBlock extends CommandGroup{
	
	public TestEncoderDriveBlock() {
		addSequential(new RetractSolenoid(),.5);
		addSequential(new DriveEncoders(74));
		addSequential(new Wait(),1);
		addSequential(new AutoTurn(-60));
		addSequential(new Wait(),1);
		addSequential(new DriveEncoders(65));
		addSequential(new Wait(),1);
		addSequential(new ExtendSolenoid(),1);
		addParallel(new MoveFeeder(-0.5));
		addSequential(new DriveEncoders(-50));
		addSequential(new Wait(),1);
		addSequential(new AutoTurn(60));
		addParallel(new MoveFeeder(0));
		addParallel(new RetractSolenoid());
		addSequential(new Wait(),1);
	}
}
