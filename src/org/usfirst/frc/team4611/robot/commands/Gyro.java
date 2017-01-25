package org.usfirst.frc.team4611.robot.commands;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Gyro {
	
    private ADXRS450Gyro gyro = new ADXRS450Gyro();
    double Kp = 0.03; // how fast the turns are, Too fast = oscillation, too slow = may not reach destination
    double angle;
    double correctionAngle;
    
    
    
    public Gyro() {
    	gyro.startThread();
    	gyro.reset();//angle set to 0 when restarted
    }
    
    public void gyroMeasure()
    {
    	gyro.update();
    	angle = gyro.getAngle();
    	correctionAngle = -angle * Kp;
    	
    	SmartDashboard.putNumber("Current Heading", angle);
    	SmartDashboard.putNumber("Correction Angle?", correctionAngle);
    	
    }

   
   }

