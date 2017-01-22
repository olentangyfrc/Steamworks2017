package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4611.robot.commands.LimitSwitch;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

public class EncoderMeasure {
	Encoder encoder;
	
	public EncoderMeasure()
	{
		encoder = new Encoder(RobotMap.channelA, RobotMap.channelB, false, Encoder.EncodingType.k2X);
		encoder.setSamplesToAverage(7);
	}
	
	
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
			if(turret.isClosed() = true)
				encoder.reset();
	}
}
