package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	
	public startRight(){
		/*addSequential(new driveAuto(-0.5), 2);
    	addSequential(new turnAuto(1, 0.5), .5);
    	
    	addSequential(new driveAuto(0), 1);
		addSequential(new driveAuto(-0.5),0.75);
    	addSequential(new turnAuto(-1, 0.45), 0.6);
    	addSequential(new driveAuto(-0.5), 0.5);
    	addSequential (new driveAuto(0),0.1);
    	
    	addSequential(new driveAuto(-0.5), 0.75);
    	addSequential (new driveAuto(0),0.1);*/
		
		addSequential(new driveAuto(-0.5), 2);
    	addSequential(new turnAuto(1, 0.5), .5);
    	addSequential(new driveAuto(-0.5), 1);
    	addSequential(new autoAim(0.4),0.75);
    	addSequential(new driveAuto(-0.5), 0.75);
    	addSequential (new driveAuto(0),0.1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
