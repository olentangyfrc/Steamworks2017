package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class turretAuto extends Command{
	
	public turretAuto(){
		this.requires(Robot.turretMotor);
	}
	
	public void execute(){
		//Robot.turretMotor.auto();
	}
	
	protected void end(){
		Robot.turretMotor.move(0);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false ;
		}
}
