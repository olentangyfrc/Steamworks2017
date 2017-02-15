package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LinearActuator extends Subsystem {
	public double actuate;
	public double getActuate() {
		return actuate;
	}
	public void setActuate(double actuate) {
		this.actuate = actuate;
	}
	private double speed;
	private Victor LinearActuator;
	
	public LinearActuator(){
		this.LinearActuator= new Victor (RobotMap.LinearActuator);
	}
	public void Linear(double push){
		this.LinearActuator.set(push);
	}
	public void LinearActuator(double pull){
	    this.LinearActuator.set(pull);	
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
