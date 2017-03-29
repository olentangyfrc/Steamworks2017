package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.RetractSolenoid;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Solenoid extends Subsystem {
	public DoubleSolenoid Sole1;
	public DoubleSolenoid Sole2;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Solenoid() {
		this.Sole1 = new DoubleSolenoid(RobotMap.sole1Open, RobotMap.sole1Close);
		this.Sole2 = new DoubleSolenoid(RobotMap.sole2Open, RobotMap.sole2Close); 
    }
	
	public void move(Value v) {
        this.Sole1.set(v);
        this.Sole2.set(v);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	this.setDefaultCommand(new RetractSolenoid());
    }
}

