package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.SingleWheelShoot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SingleWheelShooter extends Subsystem{
	
	private CANTalon singleWheelShooter;
	private FeedbackDevice shooterEncoder;
	
	public SingleWheelShooter(){
		this.singleWheelShooter = new CANTalon (RobotMap.singleShooter);
		
		shooterEncoder = (FeedbackDevice.QuadEncoder);
		singleWheelShooter.setFeedbackDevice(shooterEncoder);
		singleWheelShooter.setPosition(0);
		singleWheelShooter.reverseSensor(true);
		
		singleWheelShooter.setF(0);
		singleWheelShooter.setP(0);
		singleWheelShooter.setI(0);
		singleWheelShooter.setD(0);
					
	}
	public void shoot (double speed){
		this.singleWheelShooter.set(speed);
	}
	
	public void getEncoderMeasure() {
		double ePosition = singleWheelShooter.getEncPosition();
		double eSpeed = singleWheelShooter.getSpeed();
		double eVelocity = singleWheelShooter.getEncVelocity();
		double eCurrent = singleWheelShooter.getOutputCurrent();
		double eVoltage = singleWheelShooter.getOutputVoltage();
		
		SmartDashboard.putNumber("Encoder Positon", ePosition);
		SmartDashboard.putNumber("Encoder Speed", eSpeed);
		SmartDashboard.putNumber("Encoder Velocity", eVelocity);
		SmartDashboard.putNumber("Encoder Current", eCurrent);
		SmartDashboard.putNumber("Encoder Voltage", eVoltage);
		
		
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	this.setDefaultCommand(new SingleWheelShoot());

    }
	}

