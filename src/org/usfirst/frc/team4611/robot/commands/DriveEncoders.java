package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class DriveEncoders extends Command {
	
	public double rotations;
	public double circumference;
	public double leftStart;
	public double rightStart;
	public double startAngle;
	public double angleError;
	public double pValueGyro;
	public double inches;
	public double leftVelocity = 400; //Left Side Max Velocity (RPM)
	public double leftAcceleration = 100; //Right Side Acceleration RPM/s
	public double rightAcceleration = 100; //Right Side Acceleration RPM/s
	public double rightVelocity = 400; //Right Side Max Velocity (RPM)
	
	public DriveEncoders(double inches){
		this.requires(Robot.driveT); //Requires Drive Train
		this.requires(Robot.gy); //And the gyro
		this.circumference = Math.PI * 6; //Get the Circumference of the wheel
		this.rotations = inches / this.circumference; //Divide input of inches by circuference to get rotations needed
	}
	
	public void initialize(){
		this.pValueGyro = 3.5; //RPM adjustment proportional to drift. If off by one degree adjust proportinally to this value
		
		Robot.driveT.masterLeft.setF(RobotMap.fValue); //Sorta predicts what the PID loop will output
		Robot.driveT.masterLeft.setP(RobotMap.motionMagicP); //The proportional adjustment for inconsistencies in motion majic curve
		Robot.driveT.masterLeft.setI(0);
		Robot.driveT.masterLeft.setD(0);
		Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(leftVelocity);
		Robot.driveT.masterLeft.setMotionMagicAcceleration(leftAcceleration);
		
		Robot.driveT.masterRight.setF(RobotMap.fValue);
		Robot.driveT.masterRight.setP(RobotMap.motionMagicP);
		Robot.driveT.masterRight.setI(0);
		Robot.driveT.masterRight.setD(0);
		Robot.driveT.masterRight.setMotionMagicCruiseVelocity(rightVelocity);
		Robot.driveT.masterRight.setMotionMagicAcceleration(rightAcceleration);
		
		leftStart = Robot.driveT.masterLeft.getPosition();
		rightStart = Robot.driveT.masterRight.getPosition();
		startAngle = Robot.gy.gyro.getAngle();
	}
	
	protected void execute(){
		Robot.driveT.setPosition(leftStart + rotations, rightStart + rotations); //Set the encoders to the positon it needs to travel plus the position its at
		angleError = this.startAngle - Robot.gy.gyro.getAngle(); //How far we are drifting. What angle we start with minus where we're at

		double flipAcceleration = 1; 
		if(Math.abs(leftStart + rotations - Robot.driveT.masterLeft.getPosition())<rotations/2)
		{
			flipAcceleration = -0.4; //If we are in the second half of auton we flip our acceleration correction because we are now decelerating. Decrease adjustment a little bit too cause it works better.
		}
			
		if (angleError > 0) { //If we are drifting left	
			if (leftStart + rotations - Robot.driveT.masterLeft.getPosition() < 0) { 
				Robot.driveT.masterLeft.setMotionMagicAcceleration(leftAcceleration-((this.pValueGyro/2) * flipAcceleration * this.angleError));
				Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(leftVelocity-(this.pValueGyro*this.angleError));//Decrease left side if above goal
			}
			else {
				Robot.driveT.masterRight.setMotionMagicAcceleration(rightAcceleration-((this.pValueGyro/2) * flipAcceleration *  this.angleError));
				Robot.driveT.masterRight.setMotionMagicCruiseVelocity(rightVelocity-(this.pValueGyro*this.angleError)); //Decrease right side if below goal
			}
		} 
		
		if (angleError < 0) { //If we are drifting right
			if (leftStart + rotations - Robot.driveT.masterLeft.getPosition() < 0) {
				Robot.driveT.masterRight.setMotionMagicAcceleration(rightAcceleration+((this.pValueGyro/2) * flipAcceleration *  this.angleError));
				Robot.driveT.masterRight.setMotionMagicCruiseVelocity(rightVelocity+(this.pValueGyro*this.angleError)); //Decrease right side if above goal
			}
			else {
				Robot.driveT.masterLeft.setMotionMagicAcceleration(leftAcceleration+((this.pValueGyro/2)*  flipAcceleration * this.angleError));
				Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(leftVelocity+(this.pValueGyro*this.angleError)); //Decrease left side if below goal
			}
		}
	}

	@Override
	protected boolean isFinished() {
		if (Math.abs(leftStart + rotations - Robot.driveT.masterLeft.getPosition()) > .1||Math.abs(rightStart + rotations - Robot.driveT.masterRight.getPosition()) > .1) { //If we are within .1 of a rotaiton. Stop the command.
			return false;
		}
		else { 
			return true;
		}
	}
}
