package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveLinearActuator extends Command {

	private double distance;
	private double speed;
	public MoveLinearActuator(double inputspeed){
		this.speed = inputspeed;
		this. requires(Robot.la);
	}
	public MoveLinearActuator(){
		this.requires(Robot.la);
	}
	public void initialize(){
	
	}
	protected void execute(){
		RobotMap.actuateSpeed =(SmartDashboard.getNumber("linear distance", distance));
		Robot.la.actuate(RobotMap.actuateSpeed);
	}
	
	protected void end(){
		Robot.la.actuate(0);
	}
	
	protected void interupted(){
		this.end();
	}
	
	
	


	
	

@Override
protected boolean isFinished() {
	// TODO Auto-generated method stub
	return false;

	}
}











