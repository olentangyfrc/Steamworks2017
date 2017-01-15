//Ultrasonic rangefinder V2

package org.usfirst.frc.team4611.robot.commands;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.*;





public class UltrasonicRange  {
	

	public int raw_range;
	public double raw_rangeVoltage;
	public static AnalogInput ultrasonicAnalog = new AnalogInput(0);
	public double suppliedVolt = 5;
	public double voltsPerInch = suppliedVolt / 512;
	public double rangeInches;
	
    /*public void Init() 
    {
    	ultra.setAutomaticMode(true); // turns on automatic mode
    	ultra.startLiveWindowMode();
    	   	
    }*/

    public void ultrasonicMeasurement() 
    {
    	 // reads the range on the ultrasonic sensor
    	ultrasonicAnalog.setOversampleBits(4);
    	ultrasonicAnalog.setAverageBits(2);
    	
    	raw_rangeVoltage = ultrasonicAnalog.getAverageVoltage();
    	raw_range = ultrasonicAnalog.getAverageValue();
    	
    	rangeInches = raw_rangeVoltage / voltsPerInch;
    	
    	
    	//double rangeInInches = raw_range / voltsPerInch;
    	SmartDashboard.putNumber("Raw value", raw_range);
    	SmartDashboard.putNumber("Voltage", raw_rangeVoltage);
    	SmartDashboard.putNumber("Inches", rangeInches);
    	System.out.println(raw_range);
    	
    }
    

}
