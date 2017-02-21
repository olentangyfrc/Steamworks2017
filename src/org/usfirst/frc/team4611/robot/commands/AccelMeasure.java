package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class AccelMeasure {
	
	Accelerometer accel;
	double xVal;
	double yVal;
	double zVal;
	
	public AccelMeasure(){
		accel = new BuiltInAccelerometer();
	}
	
	public void accelMeasurement(){
		xVal = accel.getX();
		yVal = accel.getY();
		zVal = accel.getZ();
		
		xVal = (int)(Math.round(xVal));
		yVal = (int)(Math.round(yVal));
		zVal = (int)(Math.round(zVal));
		
		System.out.println("X value: " + xVal);
		System.out.println("Y value: " + yVal);
		System.out.println("Z value: " + zVal);
	}

}
