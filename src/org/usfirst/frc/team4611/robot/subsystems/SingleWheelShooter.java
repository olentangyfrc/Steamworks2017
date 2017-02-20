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
	
	public SingleWheelShooter(){
		this.singleWheelShooter = new CANTalon (RobotMap.singleShooter);		
		shooterEncoder = (FeedbackDevice.QuadEncoder);
		singleWheelShooter.setFeedbackDevice(shooterEncoder);
		singleWheelShooter.setPosition(0);
		singleWheelShooter.reverseSensor(false);
		singleWheelShooter.configEncoderCodesPerRev(20);
		
        singleWheelShooter.setProfile(0);
        singleWheelShooter.setF(1.942405063);
        singleWheelShooter.setP(4);
        singleWheelShooter.setI(0.0); 
        singleWheelShooter.setD(0.0);
        
        singleWheelShooter.configNominalOutputVoltage(+0f, -0f);
        singleWheelShooter.configPeakOutputVoltage(+12f, -12f);
	}
	public void shoot(double targetSpeed){   
		singleWheelShooter.changeControlMode(TalonControlMode.Speed);
		singleWheelShooter.set(targetSpeed);
	}
	
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}