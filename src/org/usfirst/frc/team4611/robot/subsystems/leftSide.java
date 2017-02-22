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
    private PowerDistributionPanel pd;

    public leftSide() {
        this.frontL = new Victor(RobotMap.frontLeftWheel);		//Tell the robot that there's a motor there, and name it
        this.backL = new Victor(RobotMap.backLeftWheel);    //Tell the robot that there's a motor there, and name it
        pd = new PowerDistributionPanel(RobotMap.powerdis);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void move(double speed) {
    	double current = pd.getCurrent(12) + pd.getCurrent(13) + pd.getCurrent(14) + pd.getCurrent(15);
        this.frontL.set(speed);		//Each side has 2 motors, so we've gotta set them individually
        this.backL.set(speed);
        System.out.println("PD Board Current" + current);
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new leftTank());

    }
}