package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.leftTank;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class leftSide extends Subsystem {
    private Victor frontL;
    private Victor backL;

    public leftSide() {
        this.frontL = new Victor(RobotMap.frontLeftWheel);
        this.backL = new Victor(RobotMap.backLeftWheel);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void move(double speed) {
        this.frontL.set(speed);
        this.backL.set(speed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new leftTank());
        
    }
}
