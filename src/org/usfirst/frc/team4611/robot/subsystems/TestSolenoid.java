package org.usfirst.frc.team4611.robot.subsystems;


import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.MoveTestSolenoid;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestSolenoid extends Subsystem {
	DoubleSolenoid testDSole;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public TestSolenoid() {
		this.testDSole = new DoubleSolenoid(RobotMap.testSolenoidForward, RobotMap.testSolenoidReverse);
    }
	
	public void move(Value v) {
        this.testDSole.set(v);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	this.setDefaultCommand(new MoveTestSolenoid());
    }
}

