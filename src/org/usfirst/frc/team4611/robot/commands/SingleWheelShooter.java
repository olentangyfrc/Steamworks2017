package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SingleWheelShooter extends Command{

	public SingleWheelShooter(){
		this.requires(Robot.sw);
	}
	 protected void initialize() {
	    }
	 protected void execute() {
	     double joyVal = (Robot.oi.rightJoy.getZ()*0.4); //port one //no filter on this (run 100%)
	     //Use the 'filter' function on the raw joystick input
	     Robot.sw.move(joyVal);									//Actually pass that value to the motors
	    }
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
