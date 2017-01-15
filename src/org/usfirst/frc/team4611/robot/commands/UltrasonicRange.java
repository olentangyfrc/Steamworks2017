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
	public static AnalogInput ultrasonicAnalog = new AnalogInput(0);
	public double suppliedVolt = 5;
	public double voltsPerInch;
	
    /*public void Init() 
    {
    	ultra.setAutomaticMode(true); // turns on automatic mode
    	ultra.startLiveWindowMode();
    	   	
    }*/

    public void ultrasonicMeasurement() 
    {
    	 // reads the range on the ultrasonic sensor
    	voltsPerInch = suppliedVolt / 512; 
    	raw_range = ultrasonicAnalog.getValue();
    	
    	//double rangeInInches = raw_range / voltsPerInch;
    	SmartDashboard.putNumber("Ultrasonic", raw_range);
    	System.out.println(raw_range);
    	
    }
    

}
