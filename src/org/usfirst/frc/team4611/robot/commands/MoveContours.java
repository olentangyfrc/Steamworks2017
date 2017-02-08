package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveContours extends Command{

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	public void moveContours(double x1, double x2){
	double ave = (x1+x2)/2;
	if (ave < 158)
		Robot.rightS.move(0.75); //theoretically move left
	else if (ave > 162)
		Robot.leftS.move(0.75);
	else{
		Robot.leftS.move(0);	
		Robot.rightS.move(0);
	}
}
}