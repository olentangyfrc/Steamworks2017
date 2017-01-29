package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;

public class SingleWheelShoot extends Command{
	
	private double speed;

	public SingleWheelShoot(double inputSpeed){
		this.speed = inputSpeed;
		this.requires(Robot.sw);
	}
	 protected void initialize() {
	    }
	 protected void execute() {
	    // double joyVal = (Robot.oi.rightJoy.getZ()*0.4); //port one //no filter on this (run 100%)
	     //Use the 'filter' function on the raw joystick input
	     //Robot.sw.shoot(Robot.oi.leftJoy.getZ());
	     Robot.sw.shoot(RobotMap.singleShooterSpeed); //button only
	     //Actually pass that value to the motors
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
