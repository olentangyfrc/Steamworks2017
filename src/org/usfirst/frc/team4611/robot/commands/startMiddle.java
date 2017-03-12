package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startMiddle extends CommandGroup {
	public startMiddle() {
		addSequential(new driveAuto(-.6), .5);//drive forward
		addSequential(new driveAuto(0), .1);//stop
		addSequential(new driveAuto(-.6), .5);//drive forward
		addSequential(new driveAuto(0), .1);//stop
		addSequential(new driveAuto(.6), .5);//backup
	}
}
