package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunAuton extends CommandGroup {
	public RunAuton(Robot.startPosition pos){
		switch (pos){
		case LEFT:
			addSequential(new driveAuto(0.75), 1.3); //Drive forward
	    	addSequential(new turnAuto(-1, 0.55), 0.4); //Turn right
	    	addSequential(new driveAuto(0), 0.1);
	    	addSequential(new driveAuto(0.75), 0.7);
	    	addSequential(new driveAuto(0), 1.75);
	    	addSequential(new autoAim(0.4), 2); //Turn using VA
	    	addSequential(new ultraDrive(-0.45), 2); //Go forward until you hit
			addSequential(new ExtendSolenoid(), 1); //Open solenoid	
			addParallel(new MoveFeeder(-0.75), 1); //Run the feeder
			addSequential(new driveAuto(-0.5), 1.5); //Drive backwards
			addSequential(new driveAuto(0),0.1); //Stop driving backwards
			addParallel(new MoveFeeder(0), 0.1); //Stop running the feeder
			addParallel(new RetractSolenoid(), 1); //Close the solenoid 
			addSequential(new turnAuto(1, 0.75), 0.65); //Turn left
			addSequential(new driveAuto(0.75), 1.5);
			addSequential(new driveAuto(0), 2);
			break;
		case MIDDLE:
			addSequential(new driveAuto(0.75), 0.8); //Drive forward
	    	addSequential(new turnAuto(1, 0.55), 0.1); //Turn left
	    	addSequential(new driveAuto(0), 1.5);		//Stop until we settle down for VA
	    	addSequential(new autoAim(0.4), 2); //Turn using VA
	    	addSequential(new ultraDrive(-0.45), 2); //Go forward until you hit
			addSequential(new ExtendSolenoid(), 1); //Open solenoid		
			addParallel(new MoveFeeder(-0.75), 1); //Run the feeder
			addSequential(new driveAuto(-0.6), 1); //Drive backwards
			addSequential (new driveAuto(0), 0.1); //Stop driving backwards
			addParallel(new MoveFeeder(0), 0.1); //Stop running the feeder
			addParallel(new RetractSolenoid(), 1); //Close the solenoid 
			break;
		case RIGHT:
			addSequential(new driveAuto(0.6),0.75); //First step: drive forward at 60% for 0.75 seconds
	    	addSequential(new turnAuto(-1, 0.55), 0.45); //Second step: turn left at 55% for 0.45 seconds 
	    	addSequential(new driveAuto(0.5), 0.3); //Third step: drive forward at 50% for 0.3 seconds
	    	addSequential (new driveAuto(0),0.1); //Fourth step: stop for 0.1 second
	    	addSequential(new autoAim(0.4), 2); 
	    	addSequential(new driveAuto(0), 0.1);
	    	addSequential(new driveAuto(0.75), 0.7);
	    	addSequential(new driveAuto(0), 1.75);
	    	addSequential(new autoAim(0.4), 2); //Turn using VA
	    	addSequential(new ultraDrive(-0.45), 2); //Go forward until you hit
			addSequential(new ExtendSolenoid(), 1); //Open solenoid
			addParallel(new MoveFeeder(-0.75), 1); //Run the feeder
			addSequential(new driveAuto(-0.5), 1.5); //Drive backwards
			addSequential (new driveAuto(0),0.1); //Stop driving backwards
			addParallel(new MoveFeeder(0), 0.1); //Stop running the feeder
			addParallel(new RetractSolenoid(), 1); //Close the solenoid 
			addSequential(new turnAuto(-1, 0.75), 0.65); //Turn right
			addSequential(new driveAuto(0.75), 1.5);
			addSequential(new driveAuto(0), 2);
			break;
		case DEFAULT:
			addSequential(new driveAuto(-0.6), 0.75);
			break;
		}
	}

}
