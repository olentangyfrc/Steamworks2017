package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command {
	
	public double inputAngle;
	public double angleError;
	public double pValue;
	
	public AutoTurn(double angle){
		this.requires(Robot.driveT);
		this.requires(Robot.gy);
		this.inputAngle = angle;
	}
	
	public void initialize(){
		pValue = 0.015;
		
		this.inputAngle += Robot.gy.gyro.getAngle();
		Robot.driveT.masterLeft.setPosition(0);
		Robot.driveT.masterRight.setPosition(0);
		
		Robot.driveT.masterLeft.changeControlMode(TalonControlMode.MotionMagic);
		Robot.driveT.masterRight.changeControlMode(TalonControlMode.MotionMagic);
		
		Robot.driveT.masterLeft.setF(1.74);
		Robot.driveT.masterLeft.setP(25);
		Robot.driveT.masterLeft.setI(0);
		Robot.driveT.masterLeft.setD(0);
		Robot.driveT.masterLeft.setMotionMagicCruiseVelocity(50);
		Robot.driveT.masterLeft.setMotionMagicAcceleration(100);
		
		Robot.driveT.masterRight.setF(1.74);
		Robot.driveT.masterRight.setP(25);
		Robot.driveT.masterRight.setI(0);
		Robot.driveT.masterRight.setD(0);
		Robot.driveT.masterRight.setMotionMagicCruiseVelocity(50);
		Robot.driveT.masterRight.setMotionMagicAcceleration(100);
	}
	
	public void execute() {
		angleError = inputAngle - Robot.gy.gyro.getAngle();
		Robot.driveT.masterLeft.set(Robot.driveT.masterLeft.getPosition() + (pValue * angleError));
		Robot.driveT.masterRight.set(Robot.driveT.masterRight.getPosition() - (pValue * angleError));
				
		System.out.println("Turning" + "\tAngle: " + Robot.gy.gyro.getAngle() + "\t Angle Error: " + angleError);
	}
	@Override
	protected boolean isFinished() {
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
