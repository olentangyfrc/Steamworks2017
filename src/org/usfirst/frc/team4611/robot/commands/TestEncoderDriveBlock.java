package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestEncoderDriveBlock extends CommandGroup{
	
	public TestEncoderDriveBlock() {
		addSequential(new AutoTurn(90));
		addSequential(new Wait(), .5);
		addSequential(new AutoTurn(-90));
		addSequential(new Wait(), .5);
		addSequential(new AutoTurn(90));
		addSequential(new Wait(), .5);
		addSequential(new AutoTurn(-90));
		addSequential(new Wait(), .5);
		
		
	}
}
