package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class ExtendOneSolenoid extends Command{
	public DoubleSolenoid sole;
	
	public ExtendOneSolenoid(DoubleSolenoid soul){
		this.requires(Robot.testSol);
		sole = soul;
	}
	/*public ExtendOneSolenoid(){
		this.requires(Robot.testSol);
		sole = 
	}*/
	
	@Override
    protected void initialize() {
    }
	
	@Override
    protected void execute() {
		sole.set(DoubleSolenoid.Value.kForward);
	}
	
	@Override
    protected boolean isFinished() {
        return false;
    }
	
	@Override
	protected void end() {
		sole.set(DoubleSolenoid.Value.kReverse);
	}
	 
	@Override
	protected void interrupted() {
	}

}
