package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveMecanumShooter extends Command{

	private double speed;
	
	public MoveMecanumShooter(double inputspeed){
		this.speed = inputspeed;
		this.requires(Robot.MS);
	}
	public MoveMecanumShooter(){
		this.requires(Robot.MS);
	}
	protected void initialize(){
		//Runs once, on initialization.
	}
	
	protected void execute(){
		RobotMap.MecanumShooterSpeed = (SmartDashboard.getNumber("Shoot Speed", 0)) / 100;
		Robot.MS.shoot(RobotMap.MecanumShooterSpeed);
		//Robot.MS.shoot(speed); (If smartdashboard bails on us)
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.MS.shoot(0);
	}

	protected void interupted(){
		this.end();
	}

}














