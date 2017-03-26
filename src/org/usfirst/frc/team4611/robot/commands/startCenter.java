package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startCenter extends CommandGroup{

	public startCenter(){
		addSequential(new driveAuto(0.75), 0.8); //Drive forward
    	addSequential(new turnAuto(1, 0.55), 0.1); //Turn left
    	addSequential(new driveAuto(0), 1.5);		//Stop until we settle down for VA
    	addSequential(new autoAim(0.4), 2); //Turn using VA
    	//addSequential(new driveAuto(0.55), 0.1);
    	addSequential(new ultraDrive(-0.45), 2); //Go forward until you hit
		//addSequential(new driveAuto(0),0.1); //Stop driving
		addSequential(new MoveTestSolenoid(), 1); //Open solenoid		//FOR THE LOVE OF GOD REFACTOR ME TO BE toggleTestSolenoid
		addParallel(new MoveFeeder(-0.75), 1); //Run the feeder
		addSequential(new driveAuto(-0.6), 1); //Drive backwards
		addSequential (new driveAuto(0), 0.1); //Stop driving backwards
		addParallel(new MoveFeeder(0), 0.1); //Stop running the feeder
		addParallel(new CloseTestSolenoid(), 1); //Close the solenoid 

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
