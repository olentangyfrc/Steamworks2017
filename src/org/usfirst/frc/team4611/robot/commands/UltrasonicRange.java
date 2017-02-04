//Ultrasonic rangefinder V3 it works

package org.usfirst.frc.team4611.robot.commands;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.smartdashboard.*; 





public class UltrasonicRange  {
	
	public int raw_range;
	public double raw_rangeVoltage;
	public double suppliedVolt = 5;
	public double voltsPerInch = suppliedVolt / 512;
	public double rangeInches;
	public boolean inRange;
	public AnalogInput ultrasonicAnalog;
	public String smartLabel;
	public boolean showInRange;
	
	public UltrasonicRange(int port, String label, boolean show){
		//port should be from robot map to declare the port the instance of the sensor's analog port on the roborio
		//label is what old smartdashboard uses as the number's label, and what new smartdashboard uses in path
		//show determines which sensor is used for changing the box's colors
		ultrasonicAnalog = new AnalogInput(port); //sensor declared
		if(show){
			showInRange = true;
		}
		else{
			showInRange = false;
		}
		ultrasonicAnalog.setOversampleBits(8);
		ultrasonicAnalog.setAverageBits(5);
		inRange= false;
		smartLabel = label;
	}
    public void ultrasonicMeasurement() {
    	double averageVoltage = this.ultrasonicAnalog.getAverageVoltage();	
    	double rangeInInches = 39.587242 * (averageVoltage) + 1.049719;
    	double roundedInches = rangeInInches + .5;
    	
    	//receives range for shooting from the dashboard, then changes color box (red = not in range, green = in range)
    	if(showInRange){
    		double x = SmartDashboard.getNumber("low end", 40);
    		double y = SmartDashboard.getNumber("high end", 50);
    		//x & y for testing purposes, they are the range in which the robot should shoot as distance from the wall
    		//replace x & y with values once known
    		if(roundedInches > x && roundedInches < y){
    			inRange = true;
    		}
    		else{
    			inRange = false;
    		}
    	}
    		
    	
    	SmartDashboard.putNumber(smartLabel, (int)roundedInches);
    	if(showInRange)
    		SmartDashboard.putBoolean("in range", inRange);
    	
    }
    

}
