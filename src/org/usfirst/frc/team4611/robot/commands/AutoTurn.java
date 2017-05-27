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
		 pAngleValue = 0.01; //How many degrees we correct for proportionally to how far off we are
		
		this.inputAngle = Robot.gy.gyro.getAngle()+this.targetAngle; //Current angle plus how much we want to turn = where we should be
		Robot.driveT.masterLeft.setPosition(0); //Start at 0 position units
		Robot.driveT.masterRight.setPosition(0);
		
		Robot.driveT.masterLeft.changeControlMode(TalonControlMode.MotionMagic); //Make sure we're in motion magic mode
		Robot.driveT.masterRight.changeControlMode(TalonControlMode.MotionMagic); //Motion magic is a position closed loop with added speed controls
		
		Robot.driveT.masterLeft.setF(RobotMap.fValue); //Sorta predicts what the PID loop will output
		Robot.driveT.masterLeft.setP(RobotMap.motionMagicP); //The proportional adjustment for inconsistencies in motion majic curve
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
		double currentAngle = Robot.gy.gyro.getAngle(); //Where we are
		angleError = inputAngle - currentAngle; //How far off we are = Where we should be - where we are
		Robot.driveT.masterLeft.set(Robot.driveT.masterLeft.getPosition() + (pAngleValue * angleError)); //Set the position to 
		Robot.driveT.masterRight.set(Robot.driveT.masterRight.getPosition() - (pAngleValue * angleError)); // Current position multiplied by our proportinal adjustment
	}
	
	@Override
	protected boolean isFinished() {
		if (Math.abs(angleError) < 1) { 
			Robot.fl.makeGreen(); //Green lights if we are within goal
		}
		else {
			Robot.fl.makeRed(); //Red if outside goal
		}
		if (Math.abs(angleError) < 1 && Robot.driveT.masterLeft.getEncVelocity() == 0) //Finish command if within a degree and velocity is 0
			return true;	
		else
			return false;
	}
	protected void end() {
		//Robot.driveT.masterLeft.set(Robot.driveT.masterLeft.getPosition());
		//Robot.driveT.masterRight.set(Robot.driveT.masterRight.getPosition());
	}

}
