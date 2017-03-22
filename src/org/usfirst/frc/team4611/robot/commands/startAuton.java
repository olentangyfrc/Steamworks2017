package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startAuton extends CommandGroup{
	
	public startAuton(){
		addSequential (new driveAuto(0.5),0.85); //change speeds to positive for comp bot
		addSequential(new driveAuto(0));

		/*addSequential(new driveAuto(-0.6),0.75);
    	addSequential(new turnAuto(-1, 0.55), 0.45);
    	addSequential(new driveAuto(-0.5), 0.3);
    	addSequential (new driveAuto(0),0.1);
    	addSequential(new autoAim(0.4), 2);
    	addSequential(new driveAuto(0), 0.1);
    	addSequential(new ultraDrive(.4), 1.33);
		addSequential(new driveAuto(0),0.1);*/
    
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
