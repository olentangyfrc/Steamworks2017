package org.usfirst.frc.team4611.robot.commands;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Gyro {
	
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    double raw;
    
    
    
    public Gyro() {
    	gyro.reset();//angle set to 0 when restarted
    }
    
    public void gyroMeasure()
    {
    	raw = gyro.getAngle();    	
    	SmartDashboard.putNumber("Raw Heading", raw);
    	
    }

   
   }

