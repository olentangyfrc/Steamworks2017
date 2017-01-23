package org.usfirst.frc.team4611.robot.commands;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Gyro {
	
    private AnalogGyro gyro = new AnalogGyro(2);// This line MUST be changed
    //the type of gyro we have is not analog based, so the constructor to be used needs a model #
    double Kp = 0.03; // how fast the turns are, Too fast = oscillation, too slow = may not reach destination
    double angle;
    double correctionAngle;
    
    
    
    public Gyro() {
    	gyro.reset();//angle set to 0 when restarted
    }
    
    public void gyroMeasure()
    {
    	angle = gyro.getAngle();
    	correctionAngle = -angle * Kp;
    	
    	SmartDashboard.putNumber("Current Heading", angle);
    	SmartDashboard.putNumber("Calculation from wpilib", correctionAngle);
    	
    }

   
    }

