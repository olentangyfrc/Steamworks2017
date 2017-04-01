package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class startRight extends CommandGroup{
	
	public startRight(){
		addSequential(new driveAuto(0.6), 1); //Drive forward //was 1.3 seconds for first match
		addSequential(new turnAuto(1, 0.45), 0.4); //Turn left
    	addSequential(new ultraDrive(-0.45), 1.3); //Go forward until you hit
    	addSequential(new driveAuto(0), 0.1); //stop driving
    	
    	//Nearly functional match 2 code
    	/*addSequential(new driveAuto(0.6), 1); //Drive forward //was 1.3 seconds for first match
		//was 1 second for third match
		addSequential(new turnAuto(1, 0.45), 0.4); //Turn left
    	addSequential(new driveAuto(0), 0.1);
    	addSequential(new driveAuto(0.6), 0.3); //was 0.6 power second match //was 0.5 seconds for first match//after turn, get closer to peg to initiate VA
    	//^was 0.3 seconds second match
    	addSequential(new driveAuto(0), 1.75);
    	addSequential(new autoAim(0.4), 2); //Turn using VA ////was 2 seconds third match
    	addSequential(new ultraDrive(-0.45), 1); //Go forward until you hit
    	addSequential(new driveAuto(0), 0.1); //stop driving*/
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//System.out.println("Is right finished?");
		return false;
	}

}
