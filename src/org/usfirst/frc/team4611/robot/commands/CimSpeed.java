package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class CimSpeed extends Command{

	public CimSpeed(){
		this.requires(Robot.s);
	}
	
	
	
	protected void execute() {
        //double joyVal = Robot.oi.filter(Robot.oi.cimStick.getY());	
        //Robot.s.move(joyVal);
		Robot.s.move(0.5);
		double joyVal = Robot.oi.filter(Robot.oi.cimStick.getY());
		Robot.s.move(joyVal);
    }
	



	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
