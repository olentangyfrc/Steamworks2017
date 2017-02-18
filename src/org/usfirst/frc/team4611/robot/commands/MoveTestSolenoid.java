package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveTestSolenoid extends Command {
	/*The state of the valve can then be set to kOff (neither output activated), 
	 * kForward (forward channel enabled) or kReverse (reverse channel enabled).
	 */
    public MoveTestSolenoid() {
        // Use requires() here to declare subsystem dependencies
        this.requires(Robot.testSol);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.testSol.move(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putBoolean("is closed", false);
    	SmartDashboard.putString("gear state", "open");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.testSol.move(DoubleSolenoid.Value.kOff);
        SmartDashboard.putBoolean("is closed", true);
        SmartDashboard.putString("gear state", "closed");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
