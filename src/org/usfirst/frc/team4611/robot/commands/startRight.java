package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	//THIS SHOULD NOT BE USED USE THE START AUTO
	//ONLY USE THIS FOR TESTING
	public startRight(){
		/*addSequential(new driveAuto(0.75), 1); //Drive forward
    	addSequential(new turnAuto(1, 0.55), 0.45); //Turn left*/
    	addSequential(new autoAim(0.4)); //Turn using VA
    	/*addSequential(new ultraDrive(-0.45), 2); //Go forward until you hit
		addSequential(new driveAuto(0),0.1); //Stop driving
		addSequential(new MoveTestSolenoid(), 1); //Open solenoid
		addParallel(new MoveFeeder(-0.75), 1); //Run the feeder
		addSequential(new driveAuto(-0.5), 1.5); //Drive backwards
		addSequential (new driveAuto(0),0.1); //Stop driving backwards
		addParallel(new MoveFeeder(0), 0.1); //Stop running the feeder
		addParallel(new CloseTestSolenoid(), 1); //Close the solenoid 
		addSequential(new turnAuto(-1, 0.55), 0.6); //Turn right
		addSequential (new driveAuto(0),0.1); //Stop driving*/
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
