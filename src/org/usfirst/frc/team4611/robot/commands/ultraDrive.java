package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ultraDrive extends Command{
	
	public double ultraSpeed = 0;
	
	public ultraDrive(double s) {
		this.ultraSpeed = s;
	}
	
	protected void execute() {
		System.out.println("moving");
		Robot.rightS.move(this.ultraSpeed);
		Robot.leftS.move(this.ultraSpeed);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		double inches = Robot.ultra.getRoundedInches();
		System.out.println("Range: " + inches);
		if(inches < 15)
			return true;
		return false;
	}

}
