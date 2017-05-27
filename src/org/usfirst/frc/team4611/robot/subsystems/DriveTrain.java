package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.TankDrive;
import org.usfirst.frc.team4611.robot.commands.driveVelocityByJoysticks;

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
		
		//There are slave talons too for the back of the drive train
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
		
		masterLeft.EnableCurrentLimit(true);
		masterRight.EnableCurrentLimit(true);
		slaveLeft.EnableCurrentLimit(true);
		slaveRight.EnableCurrentLimit(true);
		
		masterLeft.setCurrentLimit(30);
		masterRight.setCurrentLimit(30);
		slaveLeft.setCurrentLimit(30);
		slaveRight .setCurrentLimit(30);
	}
	
	@Override
	protected void initDefaultCommand() {
		// When no other commands are using the drivetrain we run this command
		this.setDefaultCommand(new driveVelocityByJoysticks());
	}

	// Tells the talon to run the motor at the given percent
	public void setOutput(double leftPercent, double rightPercent) {
		//most basic control mode is Percent Vbus, 
		//where 1 stands for full forward, 0 for stop and -1 for reverse.
		masterLeft.changeControlMode(TalonControlMode.PercentVbus);
		masterRight.changeControlMode(TalonControlMode.PercentVbus);
		
		masterLeft.set(leftPercent);
		masterRight.set(rightPercent);
	}

	// Tells the Talon to go to and hold the given position
	// This is motion magic so it uses a special way of reaching the target.
	// The "graph" below shows how the speed changes over time to reach the position.
	/*        ________________
	 *       /                \
	 *      /                  \
	 *     /                    \
	 *    /                      \
	 */
	public void setPosition(double leftRotations, double rightRotations) {
		// First we set the talons to run on the MotionMagic position mode 
		// Slaves don't convert from slave mode to position mode they just run the same amount as the master
		masterLeft.changeControlMode(TalonControlMode.MotionMagic);
		masterRight.changeControlMode(TalonControlMode.MotionMagic);
		
		masterLeft.set(leftRotations);
		masterRight.set(rightRotations);
	}
	
	// Tells the talon to go to and hold the given velocities.
	public void setVelocity(double leftRPM, double rightRPM) {
		// First we set the talons to run on speed mode 
		// Slaves don't convert from slave mode to position mode they just run the same amount as the master
		masterLeft.changeControlMode(TalonControlMode.Speed);
		masterRight.changeControlMode(TalonControlMode.Speed);
		
		masterLeft.set(leftRPM);
		masterRight.set(rightRPM);
	}
	
	// Used to set the right PID values
	public void setRightFPID(double F, double P, double I, double D) {
		masterRight.setF(F);
		masterRight.setP(P);
		masterRight.setI(I);
		masterRight.setD(D);
	}
	
	// Used to set the right PID values
	public void setLeftFPID(double F, double P, double I, double D) {
		masterLeft.setF(F);
		masterLeft.setP(P);
		masterLeft.setI(I);
		masterLeft.setD(D);
	}
	
	// Sets the right cruise velocity and acceleration for use of the Motion magic position mode
	public void setRightMotionMagic(double cruiseVelocity, double acceleraton) {
		masterRight.setMotionMagicCruiseVelocity(cruiseVelocity);
		masterRight.setMotionMagicAcceleration(acceleraton);
	}
	
	// Sets the left cruise velocity and acceleration for use of the Motion magic position mode
	public void setLeftMotionMagic(double cruiseVelocity, double acceleraton) {
		masterLeft.setMotionMagicCruiseVelocity(cruiseVelocity);
		masterLeft.setMotionMagicAcceleration(acceleraton);
	}
	
	// Returns the current RPM of the left side of drive train
	public double getLeftRPM() {
		return masterLeft.getSpeed();
	}
	
	// Returns the current RPM of the right side of drive train
	public double getRightRPM() {
		return masterRight.getSpeed();
	}

	// Returns the position in rotations of the left side of drive train
	public double getLeftPosition() {
		return masterLeft.getPosition();
	}
	
	// Returns the position in rotations of the right side of drive train
	public double getRightPosition() {
		return masterRight.getPosition();
	}
	
	// Sets output to neutral
	public void idle() {
		//most basic control mode is Percent Vbus, 
		//where 1 stands for full forward, 0 for stop and -1 for reverse.
		masterLeft.changeControlMode(TalonControlMode.PercentVbus); 
		masterRight.changeControlMode(TalonControlMode.PercentVbus);
		masterLeft.set(0); //stops motors
		masterRight.set(0);
	}

}
