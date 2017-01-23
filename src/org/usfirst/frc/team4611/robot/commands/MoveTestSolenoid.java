package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveTestSolenoid extends Command {

    public MoveTestSolenoid() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.testDSole);
    }
    
    
    /* Tutorial from the FRC website
      	exampleDouble.set(DoubleSolenoid.Value.kOff);
		exampleDouble.set(DoubleSolenoid.Value.kForward);
		exampleDouble.set(DoubleSolenoid.Value.kReverse);
     */

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean shouldExtend = false;
    	if(shouldExtend){
    		Robot.testDSole.set(DoubleSolenoid.Value.kForward);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
