//Ultrasonic rangefinder V3 it works

package org.usfirst.frc.team4611.robot.commands;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.smartdashboard.*; 





public class UltrasonicRange  {
	

	//public double raw_range;
	
	public int raw_range;
	public double raw_rangeVoltage;
	public double suppliedVolt = 5;
	public double voltsPerInch = suppliedVolt / 512;
	public double rangeInches;
	public boolean inRange;
	public AnalogInput ultrasonicAnalog;
	public String smartLabel;
	
	public UltrasonicRange(int port, String label)
	{
		ultrasonicAnalog = new AnalogInput(port); //port number
		ultrasonicAnalog.setOversampleBits(8);
		ultrasonicAnalog.setAverageBits(5);
		inRange= false;
		smartLabel = label;
	}
    public void ultrasonicMeasurement() 
    {
    	double averageVoltage = this.ultrasonicAnalog.getAverageVoltage();	
    	double rangeInInches = 39.587242 * (averageVoltage) + 1.049719;
    	double roundedInches = rangeInInches + .5;
    	
    	if(roundedInches > 4 && roundedInches < 5)
    		inRange = true;
    	else
    		inRange = false;
    		
    	
    	SmartDashboard.putNumber(smartLabel, (int)roundedInches);
    	SmartDashboard.putBoolean("in range", inRange);
    	
    }
    

}
