package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.DualWheelShooter;
import org.usfirst.frc.team4611.robot.commands.SingleWheelShooter;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SingleWheel extends Subsystem{
	
	private Victor singleWheelShooter;
	
	public SingleWheel(){
		this.singleWheelShooter = new Victor (RobotMap.singleShooter);
	}
	public void move (double speed){
		this.singleWheelShooter.set(speed);	//-speed?
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	this.setDefaultCommand(new SingleWheelShooter());

    }
	}

