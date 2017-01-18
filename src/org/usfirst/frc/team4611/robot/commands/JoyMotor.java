package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class JoyMotor extends Command{

	/* public JoyMotor(){
	    	this.requires(Robot.m);
	    }
	  
	    @Override
	    protected void initialize() {
	    }

	    // Called once after isFinished returns true
	    @Override
	    protected void end() {
	        Robot.n.move(0);
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    @Override
	    protected void interrupted() {
	        this.end();
	    }
	    */
	
	protected void execute(){
		double joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY());
		Robot.m.move(joyVal);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}