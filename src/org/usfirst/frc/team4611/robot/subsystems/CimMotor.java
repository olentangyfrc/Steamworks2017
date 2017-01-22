package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.CimSpeed;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CimMotor extends Subsystem{

	private Victor cim;
	private double setSpeedMultipliedBy = 0.5;
	
	public CimMotor(){
		this.cim = new Victor(RobotMap.cimMotor);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//cim = new Victor(RobotMap.cimMotor);
		this.setDefaultCommand(new CimSpeed());
		
	}
	public void move(double speed){
		cim.set(speed * setSpeedMultipliedBy);
	}

}
