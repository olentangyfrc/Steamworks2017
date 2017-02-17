package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	
	public startRight(){
		addSequential(new driveAuto(-0.5),0.75);
    	addSequential(new turnAuto(-1, 0.5), 0.6);
    	addSequential(new driveAuto(-0.5), 0.8);
    	addSequential(new driveAuto(0));
    	addSequential(new autoAim());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
