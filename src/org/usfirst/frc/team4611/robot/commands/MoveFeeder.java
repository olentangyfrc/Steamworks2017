   package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveFeeder extends Command {
	
	private double speed;
		
	public MoveFeeder(double inputspeed){
		this.speed = inputspeed;
		this.requires(Robot.fe);
	}
	public MoveFeeder(){
		this.requires(Robot.fe);
	}
	protected void initialize(){
		//Runs once, on initialization.
	}
	
	protected void execute(){
		//RobotMap.Feederspeed = (SmartDashboard.getNumber("feed speed", 0)) / 100;
		Robot.fe.feed(RobotMap.feederSpeed); //speed: 100
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