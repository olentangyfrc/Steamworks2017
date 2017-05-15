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
	
	public DriveEncoders(double inches){
		this.requires(Robot.driveT);
		this.requires(Robot.gy);
		this.circumference = Math.PI * 6;
		this.rotations = inches / this.circumference;
	}
	
	public void initialize(){
		this.pValueGyro = 1;
		
		Robot.driveT.masterLeft.setF(1.74);
		Robot.driveT.masterLeft.setP(18);
		Robot.driveT.masterLeft.setI(0);
		Robot.driveT.masterLeft.setD(0);
		Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(150);
		Robot.driveT.masterLeft.setMotionMagicAcceleration(150);
		
		Robot.driveT.masterRight.setF(1.74);
		Robot.driveT.masterRight.setP(18);
		Robot.driveT.masterRight.setI(0);
		Robot.driveT.masterRight.setD(0);
		Robot.driveT.masterRight.setMotionMagicCruiseVelocity(150);
		Robot.driveT.masterRight.setMotionMagicAcceleration(150);
		
		leftStart = Robot.driveT.masterLeft.getPosition();
		rightStart = Robot.driveT.masterRight.getPosition();
		startAngle = Robot.gy.gyro.getAngle();
		//System.out.println("Left Start:  "+leftStart);
		//System.out.println("Left Goal:  "+(leftStart + rotations));
		//System.out.println("Right Start:  "+rightStart);
		//System.out.println("Right Goal:  "+(rightStart+ rotations));
	}
	
	protected void execute(){
		Robot.driveT.setDistance(leftStart + rotations, rightStart + rotations);
		angleError = this.startAngle - Robot.gy.gyro.getAngle();
		System.out.println("Driving Forward" + "\tAngle: " + Robot.gy.gyro.getAngle() + "\t Angle Error: " + angleError);
		
		int flipAcceleration = 1;
		if(Math.abs(leftStart + rotations - Robot.driveT.masterLeft.getPosition())>rotations/2)
		{
			System.out.println("Second Half");
			flipAcceleration = -1;
		}
		else
			System.out.println("First Half");
		if (angleError > 0) { //Left
					
			if (leftStart + rotations - Robot.driveT.masterLeft.getPosition() < 0) {
				Robot.driveT.masterLeft.setMotionMagicAcceleration(150-(this.pValueGyro * flipAcceleration * this.angleError));
				Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(150-(this.pValueGyro*this.angleError));
			}
			else {
				Robot.driveT.masterRight.setMotionMagicAcceleration(150-(this.pValueGyro * flipAcceleration *  this.angleError));
				Robot.driveT.masterRight.setMotionMagicCruiseVelocity(150-(this.pValueGyro*this.angleError)); //Decrease right side
			}
		} 
		
		if (angleError < 0) { //Right
			if (leftStart + rotations - Robot.driveT.masterLeft.getPosition() < 0) {
				Robot.driveT.masterRight.setMotionMagicAcceleration(150-(this.pValueGyro * flipAcceleration *  this.angleError));
				Robot.driveT.masterRight.setMotionMagicCruiseVelocity(150-(this.pValueGyro*this.angleError));
			}
			else {
				Robot.driveT.masterLeft.setMotionMagicAcceleration(150-(this.pValueGyro *  flipAcceleration * this.angleError));
				Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(150-(this.pValueGyro*this.angleError)); //Decrease right side
			}
		}
	}

	@Override
	protected boolean isFinished() {
		if (Math.abs(leftStart + rotations - Robot.driveT.masterLeft.getPosition()) > .1||Math.abs(rightStart + rotations - Robot.driveT.masterRight.getPosition()) > .1){
			return false;
		}
		return true;
	}
}
