package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	
	public startRight(){
		addSequential(new driveAuto(0.6), 0.85); //Drive forward //was 1.3 seconds for first match
		//was 1 second for third match
		addSequential(new turnAuto(1, 0.45), 0.4); //Turn left
    	addSequential(new driveAuto(0), 0.1);
    	//addSequential(new driveAuto(0.4), 0.15); //was 0.6 power second match //was 0.5 seconds for first match//after turn, get closer to peg to initiate VA
    	//^was 0.3 seconds second match
    	//addSequential(new driveAuto(0), 1.75);
    	//addSequential(new autoAim(0.25), 4); //Turn using VA ////was 2 seconds third match
    	addSequential(new ultraDrive(-0.45), 3); //Go forward until you hit
    	addSequential(new driveAuto(0), 0.1); //stop driving
    	
    	//Schmidt didn't want us to continue past getting the gear on the pe g
    	/*addSequential(new ExtendSolenoid(), 1); //Open solenoid	
		addParallel(new MoveFeeder(-0.75), 1); //Run the feeder
		addSequential(new driveAuto(-0.5), 1.5); //Drive backwards
		addSequential (new driveAuto(0),0.1); //Stop driving backwards
		addParallel(new MoveFeeder(0), 0.1); //Stop running the feeder
		addParallel(new RetractSolenoid(), 1); //Close the solenoid 
		addSequential(new turnAuto(-1, 0.55), 0.65); //Turn right
		addSequential(new driveAuto(0.55), 1.5);
		addSequential(new driveAuto(0), 2);*/
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is right finished?");
		return false;
	}

}
