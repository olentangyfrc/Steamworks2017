package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command {
	
	public double inputAngle;
	public double targetAngle;
	public double angleError;
	public double pAngleValue;
	
	public AutoTurn(double angle){
		this.requires(Robot.driveT);
		this.requires(Robot.gy);
		this.targetAngle = angle;
	}
	
	public void initialize(){
		 pAngleValue = 0.01; 
		//pValue = 0.03;
		//pAngleValue = 0.035;
		
		this.inputAngle = Robot.gy.gyro.getAngle()+this.targetAngle;
		Robot.driveT.masterLeft.setPosition(0);
		Robot.driveT.masterRight.setPosition(0);
		
		Robot.driveT.masterLeft.changeControlMode(TalonControlMode.MotionMagic);
		Robot.driveT.masterRight.changeControlMode(TalonControlMode.MotionMagic);
		
		Robot.driveT.masterLeft.setF(RobotMap.fValue);
		Robot.driveT.masterLeft.setP(RobotMap.motionMagicP);
		Robot.driveT.masterLeft.setI(0);
		Robot.driveT.masterLeft.setD(0);
		Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(50);
		Robot.driveT.masterLeft.setMotionMagicAcceleration(100);
		
		Robot.driveT.masterRight.setF(RobotMap.fValue);
		Robot.driveT.masterRight.setP(RobotMap.motionMagicP);
		Robot.driveT.masterRight.setI(0);
		Robot.driveT.masterRight.setD(0);
		Robot.driveT.masterRight.setMotionMagicCruiseVelocity(50);
		Robot.driveT.masterRight.setMotionMagicAcceleration(100);
	}
	
	
	public void execute() {
		double currentAngle = Robot.gy.gyro.getAngle();
		angleError = inputAngle - currentAngle;
		Robot.driveT.masterLeft.set(Robot.driveT.masterLeft.getPosition() + (pAngleValue * angleError));
		Robot.driveT.masterRight.set(Robot.driveT.masterRight.getPosition() - (pAngleValue * angleError));
				
		//System.out.println((Robot.driveT.masterLeft.getPosition() + (pAngleValue * angleError))+" "+ (Robot.driveT.masterRight.getPosition() - (pAngleValue * angleError)));
		
	}
	
	@Override
	protected boolean isFinished() {
		if (Math.abs(angleError) < 1) {
			Robot.fl.makeGreen();
		}
		else {
			Robot.fl.makeRed();
		}
		if (Math.abs(angleError) < 1 && Robot.driveT.masterLeft.getEncVelocity() == 0)
			return true;	
		else
			return false;
	}
	protected void end() {
		//Robot.driveT.masterLeft.set(Robot.driveT.masterLeft.getPosition());
		//Robot.driveT.masterRight.set(Robot.driveT.masterRight.getPosition());
	}

}
