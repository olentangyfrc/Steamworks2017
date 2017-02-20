package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.SingleWheelShoot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SingleWheelShooter extends Subsystem{
	
	private CANTalon singleWheelShooter;
	private FeedbackDevice shooterEncoder;
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;
	
	public SingleWheelShooter(){
		this.singleWheelShooter = new CANTalon (RobotMap.singleShooter);		
		shooterEncoder = (FeedbackDevice.QuadEncoder);
		singleWheelShooter.setFeedbackDevice(shooterEncoder);
		singleWheelShooter.setPosition(0);
		singleWheelShooter.reverseSensor(false);
		singleWheelShooter.configEncoderCodesPerRev(20);
		
        singleWheelShooter.setProfile(0);
        singleWheelShooter.setF(1.942405063);
        singleWheelShooter.setP(7);
        singleWheelShooter.setI(0.0); 
        singleWheelShooter.setD(0.0);
        
        singleWheelShooter.configNominalOutputVoltage(+0f, -0f);
        singleWheelShooter.configPeakOutputVoltage(+12f, -12f);
	}
	public void shoot(double targetSpeed){
		double motorOutput = singleWheelShooter.getOutputVoltage() / singleWheelShooter.getBusVoltage();
		
		_sb.append("\tout:");
		_sb.append(motorOutput);
        _sb.append("\tspd:");
        _sb.append(singleWheelShooter.getSpeed());
        
		singleWheelShooter.changeControlMode(TalonControlMode.Speed);
		singleWheelShooter.set(targetSpeed);
		
		_sb.append("\terr:");
    	_sb.append(singleWheelShooter.getClosedLoopError());
    	_sb.append("\ttrg:");
    	_sb.append(targetSpeed);
    	
    	  if(++_loops >= 10) {
	        	_loops = 0;
	        	System.out.println(_sb.toString());
	        }
	        _sb.setLength(0);
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
    	//this.setDefaultCommand(new SingleWheelShoot());

    }
	}

