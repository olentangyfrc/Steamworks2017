package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class TankDrive extends Command{
	
	public double rightJoyVal;
	public double leftJoyVal;
	
	public TankDrive(){
		this.requires(Robot.tankDrive); //This command uses this subsystem
	}
	
	protected void initialize() {}
	
	protected void execute() { //execute is called every 20 miliseconds
		rightJoyVal = Robot.oi.filter(Robot.oi.controller.getY(GenericHID.Hand.kLeft)); //Grab the Y value of the joystick and pass 
		leftJoyVal = Robot.oi.filter(Robot.oi.controller.getY(GenericHID.Hand.kRight)); //it through the filter 
	    Robot.tankDrive.move(leftJoyVal, rightJoyVal); //Then pass that double to the method "move" in tankDrive
	  }
	
	@Override
	protected boolean isFinished() {
		return false; //Don't stop running this command 
	}
	 @Override
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    @Override
	    protected void interrupted() {
	    }

}
