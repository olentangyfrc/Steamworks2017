package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class turretMove extends Command{
	
	public turretMove(){
		this.requires(Robot.turretMotor);
	}
	
	public void execute(){
		//double turretMove = Robot.oi.filter(Robot.oi.turretJoy.getY());
		//Robot.turretMotor.move(turretMove);
		Robot.turretMotor.auto();
	}
	
	/*protected void end(){
		Robot.turretMotor.move(0);
	}*/
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false ;
		}
}
