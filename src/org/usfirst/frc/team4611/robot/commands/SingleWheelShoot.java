package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;

public class SingleWheelShoot extends Command{
	
	public SingleWheelShoot(){
		//this.speed = inputSpeed;
		this.requires(Robot.sw);
	}
	 protected void initialize() {
	    }
	 protected void execute() {
	     //double joyVal = (Robot.oi.rightJoy.getZ()*0.4); //port one //no filter on this (run 40%) //Use the 'filter' function on the raw joystick input
	     //Robot.sw.shoot(Robot.oi.leftJoy.getZ()); //Actually pass that value to the motors
	     //Robot.sw.shoot(RobotMap.singleShooterSpeed); //button only
		 //double joyVal = (Robot.oi.leftJoy.getZ());
		// double targetSpeed = -1500;
		 double targetSpeed= -2000;
		 Robot.sw.shoot(targetSpeed);
	    }
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void end() {
        Robot.sw.shoot(0);
    }
	protected void interrupted(){
		this.end();
	}


}
