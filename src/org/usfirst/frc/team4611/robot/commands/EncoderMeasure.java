package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

public class EncoderMeasure {
	Encoder encoder;
	
	public EncoderMeasure()
	{
		encoder = new Encoder(RobotMap.channelA, RobotMap.channelB, false, Encoder.EncodingType.k2X);
		encoder.setSamplesToAverage(7);
	}
	
	/*public void getEncoderMeasure()  {
		/*double eRate = encoder.getRate();
		int eRaw = encoder.getRaw();
		
		SmartDashboard.putNumber("Encoder Rate", eRate);
		SmartDashboard.putNumber("Encoder Raw", eRaw);
	}*/
	
	
	public void resetEncoderMeasure() {
		
	}
}
