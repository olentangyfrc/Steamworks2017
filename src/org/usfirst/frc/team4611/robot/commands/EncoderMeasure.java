package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4611.robot.Robot;

public class EncoderMeasure {
	
	
	public EncoderMeasure()
	{
		Encoder enc;
		enc = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
		encoder.setSamplesToAverage(7);
	}
	public static Encoder encoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
	
	public void getEncoderMeasure() {
		
		//encoder.setMaxPeriod(.1);
		//encoder.setMinRate(10);
		//encoder.setDistancePerPulse(5);
		//encoder.setReverseDirection(true);
		double eRate = encoder.getRate();
		int eRaw = encoder.getRaw();
		
		SmartDashboard.putNumber("Enconder rate", eRate);
		SmartDashboard.putNumber("Enconder raw", eRaw);
		
	}
	
	public void resetEncoderMeasure() {
		
	}
}
