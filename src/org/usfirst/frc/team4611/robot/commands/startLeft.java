package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startLeft extends CommandGroup{
	
	public startLeft(){
		addSequential(new driveAuto(0.6), 0.85); //Drive forward //was 1.3 seconds for first match
		addSequential(new turnAuto(-1, 0.45), 0.4); //Turn right
    	addSequential(new ultraDrive(-0.45), 1.3); //Go forward until you hit
    	addSequential(new driveAuto(0), 0.1); //stop driving
		
		//Copy of startRight() with reversed turn direction
    	
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is left finished?");
		return false;
	}

}
