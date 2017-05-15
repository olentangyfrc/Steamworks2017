package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.TankDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{
	
	public CANTalon masterLeft;
	private CANTalon slaveLeft;
	public CANTalon masterRight;
	private CANTalon slaveRight;
	private FeedbackDevice leftEncoder;
	private FeedbackDevice rightEncoder;
	
	public DriveTrain() {
		//Setting up front drive chain
		masterLeft = new CANTalon (RobotMap.frontLeftWheel);
		masterRight = new CANTalon (RobotMap.frontRightWheel);
		
		//Setting up rear drive
		slaveRight = new CANTalon (RobotMap.rearRightWheel);
		slaveLeft = new CANTalon (RobotMap.rearLeftWheel);
		
		//There are slave talons too for the back of the drive train (maybe this will work (probably wont)
		//The slaved talons just copy what their master talon does (established using slave.set(master.getDeviceID))
		slaveLeft.changeControlMode(TalonControlMode.Follower);
		slaveLeft.set(masterLeft.getDeviceID());
		slaveRight.changeControlMode(TalonControlMode.Follower);
		slaveRight.set(masterRight.getDeviceID());
		
		//"Hey this FeedbackDevice is a QuadratureEncoder
		leftEncoder = (FeedbackDevice.QuadEncoder);
		rightEncoder = (FeedbackDevice.QuadEncoder);
		
		//Because we set the rear talons to slaves we dont need to set them to encoders, only the front two
		masterLeft.setFeedbackDevice(leftEncoder);
		masterRight.setFeedbackDevice(rightEncoder);
		
		//Set the encoders to start at zero
		masterLeft.setEncPosition(0);
		masterRight.setEncPosition(0);
		
		//Might have to reverse the direction depending on if fab and electrical can set up a bot right this time
		masterLeft.reverseSensor(false);
		masterRight.reverseOutput(true);
		masterRight.reverseSensor(true);
		
		//How many ticks (position units) in one revolution, can get from dividing resolution by 4. Varies from encoder to encoder
		//Arbitrary for now
		masterLeft.configEncoderCodesPerRev(RobotMap.cpr/4);
		masterRight.configEncoderCodesPerRev(RobotMap.cpr/4);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		//When no other commands are running we run tankDrive
		this.setDefaultCommand(new TankDrive());
	}

	public void tankDrive(Joystick leftJoy, Joystick rightJoy) {
		masterLeft.changeControlMode(TalonControlMode.PercentVbus);
		masterRight.changeControlMode(TalonControlMode.PercentVbus);
		
		masterLeft.set(-leftJoy.getY());
		masterRight.set(rightJoy.getY());
		
		//System.out.println("RPM Left: " + masterLeft.getEncVelocity());
		//System.out.println("RPM Right: " + masterRight.getEncVelocity());
	}



	public void setDistance(double leftRotation, double rightRotation) {
		//First we set the talons to run on position mode 
		//Slaves dont convert from slave mode to position mode they just run the same amount as the master
		masterLeft.changeControlMode(TalonControlMode.MotionMagic);
		masterRight.changeControlMode(TalonControlMode.MotionMagic);
		
		masterLeft.set(leftRotation);
		masterRight.set(rightRotation);
	}

}
