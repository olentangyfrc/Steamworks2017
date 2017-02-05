   package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Feeder extends Command {
	
	private double speed;
		
	public Feeder(double inputspeed){
		this.speed = inputspeed;
		this.requires(Robot.fe);
	}

	protected void initialize(){
		//Runs once, on initialization.
	}
	
	protected void execute(){
		Robot.fe.feed(RobotMap.Feederspeed);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.fe.feed(0);
	}

	protected void interupted(){
		this.end();
	}

}