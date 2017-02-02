package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.turretMove;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * READ THIS FIRST  
 * Okay, hello non CANTalon people, you're gonna need to import a library if you wanna get rid of these 
 * errors. Find the library at http://www.ctr-electronics.com/control-system/hro.html#product_tabs_technical_resources
 * click on CTRE Toolsuite Installer and download the zip. Extract and install the libraries.
 * Now you'll have CTRELib.jar under "Referenced Libraries" in all your new projects. Notice "new"
 * Steamworks2017 was created before you installed this so Steamworks isn't gonna automatically import 
 * this library you gotta point to the .jar file yourself. Right click the project, go to properties, then 
 * Java Build Path, Libraries, add JAR. C:>Users>name>wpilib>user>java>lib
 */

public class talonTurret extends Subsystem {
	private CANTalon turretMotor; //Create CANTalon "turretMotor"
	private FeedbackDevice turretEncoder; //Create a CTRE FeedbackDevice and name it "turretEncoder"
	
	public talonTurret(){
		this.turretMotor = new CANTalon(RobotMap.turretcim); //attach "turretMotor" to the port on RobotMap
		turretMotor.enableLimitSwitch(true, true); //Enable the limit switches on CANTalon "fwd , rev"
		
		turretEncoder = (FeedbackDevice.QuadEncoder); //Declare the "FeedbackDevice" as a QuadEncoder
		turretMotor.setFeedbackDevice(turretEncoder); //Set the "FeedbackDevice" turretEncoder to the CANTalon
		turretMotor.setPosition(0); //set "encoder's" starting position to 0
		turretMotor.reverseSensor(true); //Reverses the sensor. Duh.
		
		turretMotor.setForwardSoftLimit(4096);
		turretMotor.enableForwardSoftLimit(true);
		turretMotor.setReverseSoftLimit(-4096);
		turretMotor.enableReverseSoftLimit(true);
	}
	
	double ePosition = turretMotor.getEncPosition();
	double eRawDegrees = ePosition/8192;  
	double eDegrees = eRawDegrees*360; 
	
	/*public void move(double speed){ //Normal movement of the turret
		this.turretMotor.set(speed); 
	}*/ 
	   
	public void auto(){ //Auto pilot (I hope)
		double inputDegrees = -15; //Connor's VA input
		final double moveDegrees = eDegrees + inputDegrees; //Current position plus his input
		
		if(inputDegrees >= 0){ //If input degrees are postive
			if (moveDegrees == eDegrees){ 
				turretMotor.set(0);
			}
			else{
				turretMotor.set(1); //Move until your input degrees + original degrees are equal
			}
		}
		else{
			if (moveDegrees == eDegrees){  //If input degrees are negative
				turretMotor.set(0);
			}
			else{
				turretMotor.set(-1); //Move until your input degrees + original degrees are equal
			}
		}
	}
    
    public void getEncoderMeasure(){
    	   double eSpeed = turretMotor.getSpeed();
    	   //double ePosition = turretMotor.getEncPosition();
    	   double eVelocity = turretMotor.getEncVelocity();
    	   double eCurrent = turretMotor.getOutputCurrent();
    	   double eVoltage = turretMotor.getOutputVoltage();
    	   
    	   //double eRawDegrees = ePosition/8192;  
    	   //double eDegrees = eRawDegrees*360; 
    	   
    	   if (Math.abs(ePosition) >= (8192)){
    		  turretMotor.setPosition(0);
    	   }
    	   
    	   SmartDashboard.putNumber("Encoder Speed", eSpeed);
    	   SmartDashboard.putNumber("Encoder Position", ePosition);
    	   SmartDashboard.putNumber("Encoder Velocity", eVelocity);
    	   SmartDashboard.putNumber("Encoder Current", eCurrent);
    	   SmartDashboard.putNumber("Enncoder Voltage", eVoltage);
    	   SmartDashboard.putNumber("Encoder Degrees", eDegrees);
    }

	@Override
	protected void initDefaultCommand() {
		//this.setDefaultCommand(new turretMove());		
	}
	
}
