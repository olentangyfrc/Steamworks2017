package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class driveAuto extends Command {
	
	public double speed;
	
	public driveAuto(double s){
		this.requires(Robot.leftS);
        this.requires(Robot.rightS);
		this.speed = s;
	}
	protected void execute() {
        Robot.leftS.move(-this.speed);
        Robot.rightS.move(-this.speed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
