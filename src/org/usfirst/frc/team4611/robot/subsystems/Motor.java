package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.JoyMotor;


import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Motor extends Subsystem{
	private Victor joyMove;
	public Motor(){
		this.joyMove = new Victor(RobotMap.shooter);
		
		
	}
	public void move(double speed){
		this.joyMove.set(speed);
	}
	public void singleMove(boolean dir){
		if(dir==true){
			this.joyMove.set(30);
		}
		else{
			this.joyMove.set(-30);
		}
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		this.setDefaultCommand(new JoyMotor());
	}
	
}
