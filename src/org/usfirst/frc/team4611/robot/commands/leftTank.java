package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class leftTank extends Command {

    public leftTank() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.leftS);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY());	//Use the 'filter' function on the raw joystick input
        Robot.leftS.move(joyVal);									//Actually pass that value to the motors
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
