package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	
	public startRight(){
<<<<<<< HEAD
		addSequential(new driveAuto(-0.5), 2);
    	addSequential(new turnAuto(1, 0.5), .5);
    	addSequential(new driveAuto(-0.5), 1);
    	//addSequential(new autoAim());
    	addSequential(new driveAuto(0), 1);
=======
		addSequential(new driveAuto(-0.5),0.75);
    	addSequential(new turnAuto(-1, 0.45), 0.6);
    	//addSequential(new driveAuto(-0.5), 0.8);
    	//addSequential(new driveAuto(0), 0.1);
    	addSequential(new driveAuto(-0.5), 0.5);
    	addSequential (new driveAuto(0),0.1);
    	addSequential(new autoAim(0.4),0.75);
    	addSequential(new driveAuto(-0.5), 0.75);
    	addSequential (new driveAuto(0),0.1);
    
>>>>>>> f01f40f72fceef1b4b148a2b26ed9e4a93b8b643
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
