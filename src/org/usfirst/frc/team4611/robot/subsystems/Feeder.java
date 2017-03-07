package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem {

	private Victor Feeder;
	
	public Feeder(){
		this.Feeder= new Victor (RobotMap.Feeder );
	}
 
	public void feed (double feed){
		this.Feeder.set(feed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//this.setDefaultCommand(new SingleWheelShoot())
	}
		

}
