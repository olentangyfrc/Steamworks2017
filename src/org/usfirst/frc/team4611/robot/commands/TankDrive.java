package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {
	
	public TankDrive(){
		this.requires(Robot.driveT);
	}
	
	public void start() {
		//start by changing control modes into Percent Vbus
		//most basic control mode is Percent Vbus, 
		//where 1 stands for full forward, 0 for stop and -1 for reverse.
		Robot.driveT.masterLeft.changeControlMode(TalonControlMode.PercentVbus);
		Robot.driveT.masterRight.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	public void execute() { 
		//Here we just have to pass the tankDrive method the joysticks hopefully
	     Robot.driveT.setOutput(-Robot.oi.oldFilter(Robot.oi.leftJoy.getY()),Robot.oi.oldFilter( Robot.oi.rightJoy.getY()));
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		
        	return false;
	}
}
