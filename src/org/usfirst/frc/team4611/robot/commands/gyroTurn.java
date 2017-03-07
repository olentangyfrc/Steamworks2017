package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.subsystems.Gyro;

import edu.wpi.first.wpilibj.command.Command;

public class gyroTurn extends Command {
	public int turning;
	public double speed;
	int angle;
	int initAngle;
	
	public gyroTurn(int a){
		Robot.gy.gyroMeasure();
		initAngle = Robot.gy.getAngle(); 
		angle = initAngle + a;
		this.requires(Robot.leftS);
	    this.requires(Robot.rightS);
	}
	 protected void execute() {
		 
	Robot.gy.gyroMeasure();
	
	if(Robot.gy.getAngle() < angle){
		 Robot.leftS.move(1);
		 Robot.rightS.move(-1);
	 }
	
	else if(Robot.gy.getAngle() > angle){
		 Robot.leftS.move(-1);
		 Robot.rightS.move(1);
	 }
	 
	else{
		 Robot.leftS.move(0);
		 Robot.rightS.move(0);
	}
	 
	 
	 }  
	    @Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
