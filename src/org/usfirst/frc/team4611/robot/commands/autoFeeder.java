package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class autoFeeder extends Command {
	
	public double speed;
	
	public autoFeeder (double s){
		this.requires(Robot.fe);
		this.speed = s;
	}
	protected void execute() {
		Robot.fe.feed(-this.speed);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
