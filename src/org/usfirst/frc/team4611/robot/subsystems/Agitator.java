package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Agitator extends Subsystem {

	private Victor Agitator;
	
	public Agitator(){
		this.Agitator= new Victor (RobotMap.Agitator);
	}
 
	public void agitate(double speed){
		this.Agitator.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//this.setDefaultCommand(new SingleWheelShoot())
	}
		

}
