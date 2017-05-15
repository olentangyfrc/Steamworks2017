package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {
	
	public TankDrive(){
		this.requires(Robot.driveT);
	}
	
	public void start() {
		Robot.driveT.masterLeft.changeControlMode(TalonControlMode.PercentVbus);
		Robot.driveT.masterRight.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	public void execute() { 
		//Here we just have to pass the tankDrive method the joysticks hopefully
	     Robot.driveT.tankDrive(Robot.oi.leftJoy, Robot.oi.rightJoy);
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
