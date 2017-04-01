package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startDefaultAuton extends CommandGroup{
	
	public startDefaultAuton(){
		addSequential(new driveAuto(0.6), 2.5);
		addSequential(new driveAuto(0), 0.1);
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is right finished?");
		return false;
	}
}
