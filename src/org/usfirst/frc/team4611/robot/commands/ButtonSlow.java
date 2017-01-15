package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ButtonSlow extends Command{
	
	    // Called just before this Command runs the first time
	  public ButtonSlow(){
	    	this.requires(Robot.m);
	    }
	  
	    @Override
	    protected void initialize() {
	    }

	    // Called repeatedly when this Command is scheduled to run
	    @Override
	    protected void execute() {
	    	Robot.n.move(1);//change speed if you can't tell difference between button speeds
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    @Override
	    protected boolean isFinished() {
	        return false;
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
	}