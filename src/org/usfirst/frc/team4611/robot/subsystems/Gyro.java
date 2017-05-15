package org.usfirst.frc.team4611.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyro extends Subsystem{

	public ADXRS450_Gyro gyro;
	
	public Gyro() {
		gyro = new ADXRS450_Gyro();
    }
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
