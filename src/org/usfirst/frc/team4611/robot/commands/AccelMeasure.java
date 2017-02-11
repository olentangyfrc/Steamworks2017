package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AccelMeasure {
	
	Accelerometer accel;
	double xVal;
	double yVal;
	double zVal;
	
	
	public AccelMeasure(){
	accel = new BuiltInAccelerometer(); 
	//accel = new BuiltInAccelerometer(Accelerometer.Range.k4G); 

	}
	
	public void accelMeasurement(){
		xVal = accel.getX();
		yVal = accel.getY();
		zVal = accel.getZ();
		
		xVal = (int)(Math.round(xVal));
		yVal = (int)(Math.round(yVal));
		zVal = (int)(Math.round(zVal));
		
		SmartDashboard.putNumber("x acceleration", xVal);
		SmartDashboard.putNumber("y acceleration", yVal);
		SmartDashboard.putNumber("z acceleration", zVal);
	}
}
