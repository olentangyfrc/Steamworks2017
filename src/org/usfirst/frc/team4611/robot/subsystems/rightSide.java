package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.rightTank;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class rightSide extends Subsystem {
    private Victor frontR;
    private Victor backR;

    public rightSide() {
        this.frontR = new Victor(RobotMap.frontRightWheel);			//Tell the robot that there's a motor there, and name it
        this.backR = new Victor(RobotMap.backRightWheel);			//Tell the robot that there's a motor there, and name it
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void move(double speed) {
        this.frontR.set(-speed);			//Each side has 2 motors, so we've gotta set them individually
        this.backR.set(-speed);				//The geartrain requires this side to run backwards, hence the negative
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new rightTank());

    }
}
