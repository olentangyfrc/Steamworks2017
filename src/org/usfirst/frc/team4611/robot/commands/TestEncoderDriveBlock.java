package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestEncoderDriveBlock extends CommandGroup{
	
	public TestEncoderDriveBlock() {
		//addSequential(new driveAuto(0.6 , 0), 2); Straight for 2 seconds at 60% power 
		//addSequential(new driveAuto(0.6 , 1), 2); Right for 2 seconds at 60% power
		addSequential(new DriveEncoders(60));
		addSequential(new Wait(), 0.5);
		addSequential(new AutoTurn(-60));
		addSequential(new Wait(), 0.5);
		addSequential(new DriveEncoders(10));
		addSequential(new Wait(), 0.5);
		addSequential(new DriveEncoders(-10));
		addSequential(new Wait(), 0.5);
		addSequential(new AutoTurn(60));
		addSequential(new Wait(), 0.5);
		addSequential(new DriveEncoders(-60));
	}
}
