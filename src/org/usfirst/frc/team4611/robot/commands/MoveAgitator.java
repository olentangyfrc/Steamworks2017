   package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveAgitator extends Command {
	
	private double speed;
		
	public MoveAgitator(double inputspeed){
		this.speed = inputspeed;
		this.requires(Robot.ag);
	}
	public MoveAgitator(){
		this.requires(Robot.ag);
	}
	protected void initialize(){
		//Runs once, on initialization.
	}
	
	protected void execute(){
		RobotMap.agitateSpeed = (SmartDashboard.getNumber("agitate speed", 0)) / 100;
		Robot.ag.agitate(RobotMap.agitateSpeed);
		SmartDashboard.putBoolean("agitate is on", true);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.ag.agitate(0); //ALEX CAN'T COPY AND PASTE 2/12/2017
		SmartDashboard.putBoolean("agitate is on", false);
	}

	protected void interupted(){
		this.end();
	}

}