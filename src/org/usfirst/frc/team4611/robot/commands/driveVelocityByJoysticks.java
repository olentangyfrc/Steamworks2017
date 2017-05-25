package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveVelocityByJoysticks extends Command {

	public double lStoppedPosition;	// The positions that should be held in lockdown mode 
	public double rStoppedPosition;
    public driveVelocityByJoysticks() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveT);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lockdown = true;
    	
    	Robot.driveT.setRightFPID(RobotMap.fGain, RobotMap.pForHoldingPosition, 0, 0); 
    	Robot.driveT.setLeftFPID(RobotMap.fGain, RobotMap.pForHoldingPosition, 0, 0);
    	lStoppedPosition = Robot.driveT.getLeftPosition();
    	rStoppedPosition = Robot.driveT.getRightPosition();
    	Robot.driveT.setLeftMotionMagic(RobotMap.maxRPM, RobotMap.maxRPM);
    	Robot.driveT.setRightMotionMagic(RobotMap.maxRPM, RobotMap.maxRPM);
    	Robot.driveT.setPosition(Robot.driveT.getLeftPosition(), Robot.driveT.getRightPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Calculate RPM from joystick input[]\
    	double leftTargetVelocity = RobotMap.maxRPM * Robot.oi.filter(Robot.oi.leftJoy.getY()); 
    	double rightTargetVelocity = RobotMap.maxRPM * Robot.oi.filter(Robot.oi.rightJoy.getY());
    	
    	// If the bot is not moving, isn't being told to move, and is not in lockdown mode...
    	if(((Robot.driveT.getLeftRPM() == 0 && Robot.driveT.getRightRPM() == 0 && leftTargetVelocity ==0 && rightTargetVelocity == 0)    ||    (Robot.oi.leftJoy.getRawButton(2) && Robot.oi.rightJoy.getRawButton(2)))    && !Robot.lockdown) {
    		// Put it into lockdown mode
    		Robot.lockdown = true; 
    		
    		// Change PID values to hold its position
    		Robot.driveT.setRightFPID(RobotMap.fGain, RobotMap.pForHoldingPosition, 0, 0); 
        	Robot.driveT.setLeftFPID(RobotMap.fGain, RobotMap.pForHoldingPosition, 0, 0);
        	
        	// Record what position to lock to
        	lStoppedPosition = Robot.driveT.getLeftPosition();
        	rStoppedPosition = Robot.driveT.getRightPosition();
    	}
    	else if((leftTargetVelocity !=0 || rightTargetVelocity!=0) && !(Robot.oi.leftJoy.getRawButton(2) && Robot.oi.rightJoy.getRawButton(2)) && Robot.lockdown) { //Otherwise, if the bot is in lockdown mode and is being told to move...
    		// Take it out of lockdown mode
    		Robot.lockdown = false;
    		
    		// Set PID values for moving
    		Robot.driveT.setRightFPID(RobotMap.fGain, RobotMap.pForVelocity, RobotMap.iForVelocity, 0);
        	Robot.driveT.setLeftFPID(RobotMap.fGain, RobotMap.pForVelocity, RobotMap.iForVelocity, 0);
    	}
    	
    	// If it is in lockdown
    	if(Robot.lockdown) {
    		Robot.driveT.setPosition(lStoppedPosition, rStoppedPosition);// Tell it to go to the position it is locked to.
    		Robot.fl.turnOff();
    	}
    	else {// Otherwise
    		Robot.driveT.setVelocity(leftTargetVelocity, rightTargetVelocity); // Go the speed given by the joysicks
    		Robot.fl.makeBlue();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// This command is the joystick command that always runs so it never "isFinished"
    	return false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run. Also runs on disable
    protected void interrupted() {
    	// Do nothing, just let the other command take control
    	Robot.driveT.idle();
    }
}
