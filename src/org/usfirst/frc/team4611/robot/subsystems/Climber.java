package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap; //Thanks Hannah

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	private Victor Climber;
	
	public Climber(){
		this.Climber= new Victor (RobotMap.Climber);
	}
 
	public void climb(double feed){
		this.Climber.set(feed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//this.setDefaultCommand(new SingleWheelShoot())
	}
		

}
