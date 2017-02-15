package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveLinearActuator extends Command {

	private int distance;
	private double speed;
	public double actuate;
	
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
		Robot.la.setActuate(RobotMap.actuateSpeed);
	}
	
	
	protected void end(){
		Robot.la.setActuate(0);
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











