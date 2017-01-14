package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.rightTank;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class rightSide extends Subsystem {
    private Victor frontR;
    private Victor backR;

    public rightSide() {
        this.frontR = new Victor(RobotMap.frontRightWheel);
        this.backR = new Victor(RobotMap.backRightWheel);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void move(double speed) {
        this.frontR.set(-speed);
        this.backR.set(-speed);
    }

    public void moveSingle(double speed) {
        this.frontR.set(-speed);
        this.backR.set(speed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new rightTank());

    }
}
