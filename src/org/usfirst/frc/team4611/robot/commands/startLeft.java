package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startLeft extends CommandGroup{
	
	public startLeft(){
		addSequential(new driveAuto(0.6), 1); //Drive forward //was 1.3 seconds for first match
    	addSequential(new turnAuto(-1, 0.45), 0.4); //Turn right
    	addSequential(new driveAuto(0), 0.1);
    	addSequential(new driveAuto(0.6), 0.3); //was 0.5 seconds for first match //after turn, get closer to peg to initiate VA
    	addSequential(new driveAuto(0), 1.75);
    	addSequential(new autoAim(0.4), 2); //Turn using VA
    	addSequential(new ultraDrive(-0.45), 1); //Go forward until you hit
    	addSequential(new driveAuto(0), 0.1); //stop driving
    	
    	//Schmidt didn't want us to continue past getting the gear on the peg
    	/*addSequential(new driveAuto(0), 0.1); //Stop driving
		addSequential(new ExtendSolenoid(), 1); //Open solenoid	
		addParallel(new MoveFeeder(-0.75), 1); //Run the feeder
		addSequential(new driveAuto(-0.5), 1.5); //Drive backwards
		addSequential (new driveAuto(0),0.1); //Stop driving backwards
		addParallel(new MoveFeeder(0), 0.1); //Stop running the feeder
		addParallel(new RetractSolenoid(), 1); //Close the solenoid 
		addSequential(new turnAuto(1, 0.55), 0.65); //Turn left
		addSequential(new driveAuto(0.55), 1.5);
		addSequential(new driveAuto(0), 2);*/
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is left finished?");
		return false;
	}

}
