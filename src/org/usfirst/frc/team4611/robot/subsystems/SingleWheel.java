package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SingleWheel extends Subsystem{
	
	private Victor singleWheelShooter;
	
	public SingleWheel(){
		this.singleWheelShooter = new Victor (RobotMap.singleShooter);
	}
	public void move (double speed){
		this.singleWheelShooter.set(speed);	
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
