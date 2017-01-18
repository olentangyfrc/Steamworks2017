//Ultrasonic rangefinder V2

package org.usfirst.frc.team4611.robot.commands;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.smartdashboard.*; 





public class UltrasonicRange  {
	

	//public double raw_range;
	public static AnalogInput ultrasonicAnalog = new AnalogInput(3); //port number
	
	public int raw_range;
	public double raw_rangeVoltage;
	public double suppliedVolt = 5;
	public double voltsPerInch = suppliedVolt / 512;
	public double rangeInches;
	
    /*public void Init() 
    {
    	ultra.setAutomaticMode(true); // turns on automatic mode
    	ultra.startLiveWindowMode();
    	   	
    }*/
	public UltrasonicRange()
	{
		ultrasonicAnalog.setOversampleBits(8);
		ultrasonicAnalog.setAverageBits(5);
	}
    public void ultrasonicMeasurement() 
    {
    	 // reads the range on the ultrasonic sensor
 
    	double raw_rangeVoltage = ultrasonicAnalog.getVoltage();
    	int raw_rangeValue = ultrasonicAnalog.getValue();
    	double averageVoltage = ultrasonicAnalog.getAverageVoltage();
    	double averageValue = ultrasonicAnalog.getAverageValue();
    	
    	double rangeInInchesA = averageVoltage / voltsPerInch;
    	double rangeInInchesB = averageVoltage * voltsPerInch;
    	double rangeInInchesC = 39.587242 * (averageVoltage) + 1.049719;
    	
    	//SmartDashboard.putNumber("Ultrasonic", rangeInInches);
    	
    	SmartDashboard.putNumber("UltraSonicVoltage", raw_rangeVoltage);
    	SmartDashboard.putNumber("UltrasonicValue", raw_rangeValue);
    	SmartDashboard.putNumber("UltraSonicVoltageAverage", averageVoltage);
    	SmartDashboard.putNumber("UltrasonicValueAverage", averageValue);
    	SmartDashboard.putNumber("Max botix", rangeInInchesA);
    	SmartDashboard.putNumber("Max botix, but with mult", rangeInInchesB);
    	SmartDashboard.putNumber("With our data", rangeInInchesC);
    	
    	//System.out.println(raw_);
    	/*ultrasonicAnalog.setOversampleBits(4);
    	ultrasonicAnalog.setAverageBits(2);
    	
    	raw_rangeVoltage = ultrasonicAnalog.getAverageVoltage();
    	raw_range = ultrasonicAnalog.getAverageValue();
    	
    	rangeInches = raw_rangeVoltage / voltsPerInch;
    	
    	
    	//double rangeInInches = raw_range / voltsPerInch;
    	SmartDashboard.putNumber("Raw value", raw_range);
    	SmartDashboard.putNumber("Voltage", raw_rangeVoltage);
    	SmartDashboard.putNumber("Inches", rangeInches);
    	System.out.println(raw_range);
    	*/
    }
    

}
