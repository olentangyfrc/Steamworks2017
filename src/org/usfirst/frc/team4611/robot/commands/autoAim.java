package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class autoAim extends Command {
	public static double visionSpeed = .5;
	public static boolean visionDone = false;
	
	public void moveContours(double x1, double x2){
		
		double targetNum = 0;
		targetNum = Math.abs(x1 - x2) + Math.max(x1, x2);
		System.out.println("Vision Speed:" + visionSpeed);
		System.out.println("THIS IS target number:" + targetNum);
		if (targetNum > 160 + 20){
			Robot.leftS.move(visionSpeed);
			Robot.rightS.move(-visionSpeed);//theoretically move right
			System.out.println("MOVED Right");
		}
		else if (targetNum < 160 - 20){
			Robot.leftS.move(-visionSpeed);
			Robot.rightS.move(visionSpeed);
			System.out.println("MOVED LEFT");
		}
		else{
			Robot.leftS.move(0);	
			Robot.rightS.move(0);
		}
	}
	
	
	protected void execute() { 
		double [] value = Robot.table.getNumberArray("centerX",new double [1]);
		if(visionDone == false) {
		if(value.length == 2) {
			moveContours(value[0], value[1]);
		}
		else if(value.length == 1 && value[0] < 100) {
			System.out.println(value[0]);
			Robot.leftS.move(-visionSpeed);
			Robot.rightS.move(visionSpeed);
		}
		else {
			Robot.leftS.move(0);
			Robot.rightS.move(0);
			visionDone = true;
			System.out.println("VISION DONE");
		}
	}
}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
