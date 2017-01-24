package org.usfirst.frc.team4611.robot.commands;


import org.usfirst.frc.team4611.robot.RobotMap;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

public class moveTurret extends Command{
	public Victor turretMotor;
	
	public moveTurret(){
		this.requires(Robot.turret);
		
	}
	
	protected void execute(){
		double joyVal = Robot.oi.filter(Robot.oi.rightJoy.getX()); //Joysticks from x value (side to side)
		Robot.turret.specialMove(joyVal);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
