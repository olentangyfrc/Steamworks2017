package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.leftTank;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class leftSide extends Subsystem {
    private Victor frontL;
    private Victor backL;
    
    public leftSide() {
        this.frontL = new Victor(RobotMap.frontLeftWheel);		//Tell the robot that there's a motor there, and name it
        this.backL = new Victor(RobotMap.backLeftWheel);    //Tell the robot that there's a motor there, and name it
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void move(double speed) {
        this.frontL.set(-speed);		//Each side has 2 motors, so we've gotta set them individually
        this.backL.set(-speed);		//The geartrain requires this side to run backwards, hence the negative
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new leftTank());

    }
}