package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SingleWheelShoot extends Command{
	
	private double speed;

	public SingleWheelShoot(double inputSpeed){
		this.speed = inputSpeed;
		this.requires(Robot.sw);
	}
	public SingleWheelShoot(){
		this.requires(Robot.sw);
	}
	 protected void initialize() {
	    }
	 protected void execute() {

	     RobotMap.singleShooterSpeed = (SmartDashboard.getNumber("shoot speed", 0)) / 100;
	     Robot.sw.shoot(RobotMap.singleShooterSpeed); //button only
	    }
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void end() {
        Robot.sw.shoot(0);
    }
	protected void interrupted(){
		this.end();
	}


}
