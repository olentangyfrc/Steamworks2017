package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.turretMove;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class talonTurret extends Subsystem {
	private CANTalon turretMotor; //Create CANTalon "turretMotor"
	private FeedbackDevice turretEncoder; //Create a CTRE FeedbackDevice and name it "turretEncoder"
	
	public talonTurret(){
		this.turretMotor = new CANTalon(RobotMap.turretcim); //attach "turretMotor" to the port on RobotMap
		turretMotor.enableLimitSwitch(true, true); //Enable the limit switches on CANTalon "fwd , rev"
		turretMotor.setFeedbackDevice(turretEncoder); //Set the "FeedbackDevice" turretEncoder to the CANTalon
		turretEncoder = (FeedbackDevice.QuadEncoder); //Declare the "FeedbackDevice" as a QuadEncoder
		turretMotor.setPosition(0); //set "encoder's" starting position to 0
		turretMotor.reverseSensor(true); //Reverses the sensor. Duh.
	}
	
	public boolean isFwdLimitSwitchClosed() {
    	return turretMotor.isFwdLimitSwitchClosed();
	}
    public boolean isRevLimitSwitchClosed() {
    	return turretMotor.isRevLimitSwitchClosed();
	}

    public void move(double speed) {
    	boolean fwdLimitClosed = isFwdLimitSwitchClosed();
    	boolean revLimitClosed = isRevLimitSwitchClosed();
    	
    	if(fwdLimitClosed == true){ //Is fwdLimit closed?
    		if(speed <= 0){
    			this.turretMotor.set(speed); //If fwdLimit is closed and speed is negative, drive
    		}
    		else{
    			this.turretMotor.set(0); //If fwdLimit is closed and speed is positive, stop
    		}
    	}
    	else{
    		this.turretMotor.set(speed); //If fwdLimit is just not closed, drive
    	}
    	
    	
    	if(revLimitClosed == true){ //Is revLimit closed?
    		if(speed >= 0){
    			this.turretMotor.set(speed); //If revLimit is closed and speed is positive, drive
    		}
    		else{
    			this.turretMotor.set(0); //If revLimit is just closed and speed negative, stop
    		}    		
    	}
    	else{
    		this.turretMotor.set(speed); //If revLimit is not closed, drive
    	}
    	
    	SmartDashboard.putBoolean("FwdLimitClose", fwdLimitClosed);
    	SmartDashboard.putBoolean("RevLimitClose", revLimitClosed);   	
    }
    
    public void getEncoderMeasure(){
    	  double eSpeed = turretMotor.getSpeed();
    	   double ePosition = turretMotor.getEncPosition();
    	   double eVelocity = turretMotor.getEncVelocity();
    	   double eCurrent = turretMotor.getOutputCurrent();
    	   double eVoltage = turretMotor.getOutputVoltage();
    	   double eRawDegrees = ePosition/8192;  
    	   double eDegrees = eRawDegrees*360; 
    	   double eRotations = 0;
    	   
    	   if (Math.abs(ePosition) >= (8192)){
    		  turretMotor.setPosition(0);
    		  eRotations ++;
    	   }
    	   
    	   SmartDashboard.putNumber("Ecoder Speed", eSpeed);
    	   SmartDashboard.putNumber("Encoder Position", ePosition);
    	   SmartDashboard.putNumber("Ecoder Velocity", eVelocity);
    	   SmartDashboard.putNumber("Ecoder Current", eCurrent);
    	   SmartDashboard.putNumber("Ecoder Voltage", eVoltage);
    	   SmartDashboard.putNumber("Encoder Degrees", eDegrees);
    	   SmartDashboard.putNumber("Motor Roations", eRotations);
    }

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new turretMove());
		
	}
	
}
