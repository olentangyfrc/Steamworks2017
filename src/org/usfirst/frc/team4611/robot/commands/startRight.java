package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	
	public startRight(){
		//Hannah pneumatics close (extend) code goes here
		addSequential(new driveAuto(-0.6),0.75);
    	addSequential(new turnAuto(1, 0.55), 0.45);
		addSequential (new driveAuto(0.5),0.5); //change speeds to positive for comp bot
		addSequential(new driveAuto(-0.6),0.75);
    	addSequential(new turnAuto(-1, 0.55), 0.45);
    	addSequential(new ultraDrive(.45), 2);
		addSequential(new driveAuto(0),0.1);
		
		addSequential(new MoveTestSolenoid(), 1);
		addSequential(new CloseTestSolenoid(), 1);
		//Connor pneumatics open (retract) code goes here
		//Connor feeder also goes here
		
		addSequential(new driveAuto(0.5), 1.5);
		addSequential (new driveAuto(0),0.1);
		addSequential(new turnAuto(-1, 0.55), 0.6);
		addSequential (new driveAuto(0),0.1);	 
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
