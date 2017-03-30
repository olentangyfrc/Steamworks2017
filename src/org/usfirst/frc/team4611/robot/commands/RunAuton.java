package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunAuton extends CommandGroup {
	public RunAuton(Robot.startPosition pos){
		switch (pos){
		case LEFT:
			addSequential(new driveAuto(0.6),0.75); //First step: drive forward at 60% for 0.75 seconds
	    	addSequential(new turnAuto(1, 0.55), 0.45); //Second step: turn right at 55% for 0.45 seconds 
	    	addSequential(new driveAuto(0.5), 0.3); //Third step: drive forward at 50% for 0.3 seconds
	    	addSequential (new driveAuto(0),0.1); //Fourth step: stop for 0.1 second
	    	addSequential(new autoAim(0.4), 2); 
	    	addSequential(new driveAuto(0), 0.1);
	    	addSequential(new ultraDrive(.4), 1.33);
			addSequential(new driveAuto(0),0.1);
			break;
		case MIDDLE:
			addSequential (new driveAuto(0.5),0.5); //Drive forward at 50% for 0.5 seconds
			break;
		case RIGHT:
			addSequential(new driveAuto(0.6),0.75); //First step: drive forward at 60% for 0.75 seconds
	    	addSequential(new turnAuto(-1, 0.55), 0.45); //Second step: turn left at 55% for 0.45 seconds 
	    	addSequential(new driveAuto(0.5), 0.3); //Third step: drive forward at 50% for 0.3 seconds
	    	addSequential (new driveAuto(0),0.1); //Fourth step: stop for 0.1 second
	    	addSequential(new autoAim(0.4), 2); 
	    	addSequential(new driveAuto(0), 0.1);
	    	addSequential(new ultraDrive(.4), 1.33);
			addSequential(new driveAuto(0),0.1);
			break;
		}
	}

}
