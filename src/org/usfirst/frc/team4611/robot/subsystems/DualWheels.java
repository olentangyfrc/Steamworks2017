package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.DualWheelShooter;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DualWheels extends Subsystem {
    private Victor leftShootWheel;
    private Victor rightShootWheel;

    public DualWheels() {
        this.leftShootWheel = new Victor(RobotMap.leftShooter); 		//Tell the robot that there's a motor there, and name it
        this.rightShootWheel = new Victor(RobotMap.rightShooter);		//Tell the robot that there's a motor there, and name it
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void move(double speed) {
        this.leftShootWheel.set(-speed);		//Each side has 2 motors, so we've gotta set them individually
        this.rightShootWheel.set(speed);
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	this.setDefaultCommand(new DualWheelShooter());

    }
}