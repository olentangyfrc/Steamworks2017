package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	
	public startRight(){
		addSequential(new driveAuto(-0.5), 2);
    	addSequential(new turnAuto(1, 0.5), .5);
    	addSequential(new driveAuto(-0.5), 1);
    	//addSequential(new autoAim());
    	addSequential(new driveAuto(0), 1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
