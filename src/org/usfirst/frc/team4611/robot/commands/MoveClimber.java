   package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class MoveClimber extends Command { //Thanks again hannah
	
	private double speed;
		
	public MoveClimber(double inputspeed){
		this.speed = inputspeed;
		this.requires(Robot.cl);
	}

	protected void initialize(){
		//Runs once, on initialization.
	}
	
	protected void execute(){
		Robot.cl.climb(RobotMap.Feederspeed);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.cl.climb(0);
	}

	protected void interupted(){
		this.end();
	}

}