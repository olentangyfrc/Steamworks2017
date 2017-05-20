package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command {
	
	public double inputAngle;
	public double angleError;
	public double pAngleValue;
	
	public AutoTurn(double angle){
		this.requires(Robot.driveT);
		this.requires(Robot.gy);
		this.inputAngle = angle;
	}
	
	public void initialize(){
		 pAngleValue = 0.005; 
		//pValue = 0.03;
		//pAngleValue = 0.035;
		
		Robot.driveT.masterLeft.setPosition(0);
		Robot.driveT.masterRight.setPosition(0);
		
		Robot.driveT.masterLeft.changeControlMode(TalonControlMode.MotionMagic);
		Robot.driveT.masterRight.changeControlMode(TalonControlMode.MotionMagic);
		
		Robot.driveT.masterLeft.setF(0.3581);
		Robot.driveT.masterLeft.setP(RobotMap.pValueForMotionMagic);
		Robot.driveT.masterLeft.setI(0);
		Robot.driveT.masterLeft.setD(0);
		Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(30);
		Robot.driveT.masterLeft.setMotionMagicAcceleration(60);
		
		Robot.driveT.masterRight.setF(0.3581);
		Robot.driveT.masterRight.setP(RobotMap.pValueForMotionMagic);
		Robot.driveT.masterRight.setI(0);
		Robot.driveT.masterRight.setD(0);
		Robot.driveT.masterRight.setMotionMagicCruiseVelocity(30);
		Robot.driveT.masterRight.setMotionMagicAcceleration(60);
	}
	
	public void execute() {
		double currentAngle = Robot.gy.gyro.getAngle();
		angleError = inputAngle - currentAngle;
		Robot.driveT.masterLeft.set(Robot.driveT.masterLeft.getPosition() + (pAngleValue * angleError));
		Robot.driveT.masterRight.set(Robot.driveT.masterRight.getPosition() - (pAngleValue * angleError));
				
		System.out.println("Turning" + "\tAngle: " + currentAngle + "\t Angle Error: " + angleError);
		
	}
	
	@Override
	protected boolean isFinished() {
		if (Math.abs(angleError) < 2) {
			Robot.fl.makeGreen();
		}
		else {
			Robot.fl.makeRed();
		}
		if (Math.abs(angleError) < 2 && Math.round(Math.abs(Robot.driveT.masterLeft.getEncVelocity())) == 0) {
			System.out.println("TURNING ENDED");
			return true;
		}
		else
			return false;
	}
	protected void end() {
		//Robot.driveT.masterLeft.set(Robot.driveT.masterLeft.getPosition());
		//Robot.driveT.masterRight.set(Robot.driveT.masterRight.getPosition());
	}

}
