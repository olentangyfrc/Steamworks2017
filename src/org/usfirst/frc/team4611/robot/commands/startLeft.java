package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startLeft extends CommandGroup{
	
	public startLeft(){
		//Hannah pneumatics close (extend) code goes here
		addSequential(new driveAuto(-0.6),0.75);
    	addSequential(new turnAuto(-1, 0.55), 0.45);
    	addSequential(new driveAuto(-0.5), 0.3);
    	addSequential (new driveAuto(0),0.1);
    	addSequential(new autoAim(0.4), 2);
    	addSequential(new driveAuto(0), 0.1);
    	addSequential(new ultraDrive(.45), 2);
		addSequential(new driveAuto(0),0.1);
		//Hannah pneumatics open (retract) code goes here
		//Hannah feeder also goes here
		addSequential(new driveAuto(0.5), 1.5);
		addSequential (new driveAuto(0),0.1);
		addSequential(new turnAuto(1, 0.55), 0.6);
		addSequential (new driveAuto(0),0.1);	
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
