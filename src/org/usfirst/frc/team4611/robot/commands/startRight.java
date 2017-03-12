package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	
	public startRight(){
		addSequential(new driveAuto(-0.6),0.75); //Drive forward
    	addSequential(new turnAuto(1, 0.55), 0.45); //Turn left
		addSequential(new driveAuto(-0.6),0.75); //Drive forward again
    	addSequential(new autoAim(0.55), 0.45); //Turn using VA
    	addSequential(new ultraDrive(.45), 2); //Go forward until you hit
		addSequential(new driveAuto(0),0.1); //Stop driving
		addSequential(new MoveTestSolenoid(), 1); //Open solenoid
		addParallel(new autoFeeder(0.75), 1); //Run the feeder
		addSequential(new driveAuto(0.5), 1.5); //Drive backwards
		addSequential (new driveAuto(0),0.1); //Stop driving backwards
		addParallel(new autoFeeder(0), 0.1); //Stop running the feeder
		addParallel(new CloseTestSolenoid(), 1); //Close the solenoid 
		addSequential(new turnAuto(-1, 0.55), 0.6); //Turn right
		addSequential (new driveAuto(0),0.1); //Stop driving
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
