package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumShooter extends Subsystem {


	private Talon MecanumShooter;
	
	public MecanumShooter(){
		this.MecanumShooter= new Talon (RobotMap.Feeder );
	}
 
	public void shoot (double shoot){
		this.MecanumShooter.set(shoot);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//this.setDefaultCommand(new SingleWheelShoot())
	}
		

}















