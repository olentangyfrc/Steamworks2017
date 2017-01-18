package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ButtonOLS extends Subsystem{
	private Victor buttonMove;
	
	public ButtonOLS(){
		this.buttonMove = new Victor(RobotMap.shooter);
		
	}
	public void move(double speed){
		this.buttonMove.set(speed);
	}


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
