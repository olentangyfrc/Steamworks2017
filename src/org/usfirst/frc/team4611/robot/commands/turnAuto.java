package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class turnAuto extends Command{
	public int turning;
	public double speed;
	
	public turnAuto(int turn, double s){
		this.requires(Robot.leftS);
	    this.requires(Robot.rightS);
		this.turning = turn; //must be 1 or -1
		this.speed = s;
	}
	 protected void execute() {
	    Robot.leftS.move(this.turning * this.speed);
	    Robot.rightS.move(-this.turning * this.speed);
	 }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
