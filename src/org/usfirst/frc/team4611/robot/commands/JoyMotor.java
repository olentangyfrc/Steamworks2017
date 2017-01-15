package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class JoyMotor extends Command{
	
	protected void execute(){
		double joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY());
		Robot.m.move(joyVal);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}