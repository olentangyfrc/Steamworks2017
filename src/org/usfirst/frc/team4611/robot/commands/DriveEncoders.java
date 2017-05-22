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
	public double leftVelocity = 400;
	public double leftAcceleration = 100;
	public double rightAcceleration = 100;
	public double rightVelocity = 400;
	
	public DriveEncoders(double inches){
		this.requires(Robot.driveT);
		this.requires(Robot.gy);
		this.circumference = Math.PI * 6;
		this.rotations = inches / this.circumference;
	}
	
	public void initialize(){
		this.pValueGyro = 3.5;
		
		Robot.driveT.masterLeft.setF(RobotMap.fValue);
		Robot.driveT.masterLeft.setP(RobotMap.motionMagicP);
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
		Robot.driveT.setDistance(leftStart + rotations, rightStart + rotations);
		angleError = this.startAngle - Robot.gy.gyro.getAngle();

		double flipAcceleration = 1;
		if(Math.abs(leftStart + rotations - Robot.driveT.masterLeft.getPosition())<rotations/2)
		{
			flipAcceleration = -0.4;
		}
			
		if (angleError > 0) { //Left	
			if (leftStart + rotations - Robot.driveT.masterLeft.getPosition() < 0) {
				Robot.driveT.masterLeft.setMotionMagicAcceleration(leftAcceleration-((this.pValueGyro/2) * flipAcceleration * this.angleError));
				Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(leftVelocity-(this.pValueGyro*this.angleError));
			}
			else {
				Robot.driveT.masterRight.setMotionMagicAcceleration(rightAcceleration-((this.pValueGyro/2) * flipAcceleration *  this.angleError));
				Robot.driveT.masterRight.setMotionMagicCruiseVelocity(rightVelocity-(this.pValueGyro*this.angleError)); //Decrease right side
			}
		} 
		
		if (angleError < 0) { //Right
			if (leftStart + rotations - Robot.driveT.masterLeft.getPosition() < 0) {
				Robot.driveT.masterRight.setMotionMagicAcceleration(rightAcceleration+((this.pValueGyro/2) * flipAcceleration *  this.angleError));
				Robot.driveT.masterRight.setMotionMagicCruiseVelocity(rightVelocity+(this.pValueGyro*this.angleError));
			}
			else {
				Robot.driveT.masterLeft.setMotionMagicAcceleration(leftAcceleration+((this.pValueGyro/2)*  flipAcceleration * this.angleError));
				Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(leftVelocity+(this.pValueGyro*this.angleError)); //Decrease right side
			}
		}
	}

	@Override
	protected boolean isFinished() {
		if (Math.abs(leftStart + rotations - Robot.driveT.masterLeft.getPosition()) > .1||Math.abs(rightStart + rotations - Robot.driveT.masterRight.getPosition()) > .1) {
			return false;
		}
		else { 
			return true;
		}
	}
}
