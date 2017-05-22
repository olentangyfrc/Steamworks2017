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
		this.singleWheelShooter = new CANTalon (RobotMap.singleShooter); //Create a CANTalon attached to port 61		
		shooterEncoder = (FeedbackDevice.QuadEncoder); //The feedback device called shooterEncoder is a Quadrature Encoder
		singleWheelShooter.setFeedbackDevice(shooterEncoder); //The feedback device plugged into the Talon is shooterEncoder
		singleWheelShooter.setPosition(0); //Start the encoder at 0
		singleWheelShooter.reverseSensor(false); //Reverse the sensor if needed
		singleWheelShooter.configEncoderCodesPerRev(20); //There are 20 position units in a revolution for the am-3314a encoder
		
		//PID loops account for drops in speed by pushing more voltage toward the motor
        singleWheelShooter.setProfile(0); //There can be two PID loops just in case we were shooting at multiple speeds
        singleWheelShooter.setF(-1.942405063); //Calculated using the equation found in the Talon SRX software manual. Sets target value for speed
        singleWheelShooter.setP(-4); //This determines how much extra the talon pumps in the account for speed change
        singleWheelShooter.setI(0.0); //If the mechanism doesn't quite reach the speed add an I value
        singleWheelShooter.setD(0.0); //Your D value smoothes the motion of the motor
        
        singleWheelShooter.configNominalOutputVoltage(+0f, -0f); //Sets the lowest amount of voltage that can go to the motor
        singleWheelShooter.configPeakOutputVoltage(+12f, -12f); //Sets the highest amount of voltage that can go to the motor
	}
	public void shoot(double targetSpeed){   
		singleWheelShooter.changeControlMode(TalonControlMode.Speed); //Now what we "set" the motor to isn't percentage but speed
		singleWheelShooter.set(targetSpeed);
		System.out.println("Shooter speed:" + singleWheelShooter.getSpeed());
	}
	
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}