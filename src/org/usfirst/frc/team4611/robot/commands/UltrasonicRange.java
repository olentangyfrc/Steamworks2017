//Ultrasonic rangefinder V1

package org.usfirst.frc.team4611.robot.commands;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.*;
import org.usfirst.frc.team4611.robot.OI;
import edu.wpi.first.wpilibj.Ultrasonic;




public class UltrasonicRange extends SampleRobot {
	

	public double volts;
	public double averageVolts;
	public Timer time;
	public static AnalogInput ultrasonicAnalog = new AnalogInput(0);
	public double suppliedVolt = 5;
	public double voltsPerInch;
	
	Ultrasonic ultra = new Ultrasonic(2,1); // creates the ultra object and assigns ultra to be an ultrasonic sensor which uses DigitalOutput 1 for 
        // the echo pulse and DigitalInput 1 for the trigger pulse
    public void robotInit() 
    {
    	ultra.setAutomaticMode(true); // turns on automatic mode
    	ultra.startLiveWindowMode();
    	voltsPerInch = suppliedVolt / 512;    	
    }

    public void ultrasonicSample() 
    {
    	 // reads the range on the ultrasonic sensor
    	time.start();
    	
    	double stopper = 120;
    	while(time.get() % 5 == 0 && time.get()<= stopper)
    	{
    	volts = ultrasonicAnalog.getVoltage();
    	averageVolts = ultrasonicAnalog.getAverageVoltage();
    	
    	double rangeInInches = volts / voltsPerInch;
    	SmartDashboard.putNumber("Ultrasonic", rangeInInches);
    	
    	}
    	
    }
    

}
