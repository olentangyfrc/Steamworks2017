package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class autoAim extends Command {
	public static double visionSpeed;
	public static boolean visionDone = false;
	
	public autoAim(double speed){
		visionSpeed = speed;
		
	}
	
	public void moveContours(double x1, double x2){
		double targetNum = 0;
		targetNum = (Math.abs(x1 - x2)*0.625) + Math.max(x1, x2);
		//System.out.println("Vision Speed:" + visionSpeed);
		System.out.println("THIS IS target number:" + targetNum);
		System.out.println("Average: " + x1+x2/2);
		if (targetNum > 160){
			Robot.leftS.move(visionSpeed);
			Robot.rightS.move(-visionSpeed);//theoretically move right
			System.out.println("MOVED Right");
		}
		else if (targetNum < 160){
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
		double [] value2 = Robot.table.getNumberArray("centerY",new double [1]);
		if(visionDone == false) {
			System.out.println("Contours: "+value.length);
			if(value.length > 0 && value2.length > 0) {
				System.out.println("X value" +value[0]+ " Y value: " + value2[0]);
			}
			int y1 = 0;
			int y2 = 1;
			if(value.length > 2) {
				for(int c = 0; c < value2.length; c++) {
					for(int c2 = c + 1; c2 < value2.length; c2++)
					{
						if(Math.abs(value2[c] - value2[c2]) <= 8) {
							y1 = c;
							y2 = c2;
						}
						
					}
				}
			}
		
			
			if(value.length >= 2) {
				moveContours(value[y1], value[y2]);
			}
			else if(value.length == 1 && value[0] < 100) {
				Robot.leftS.move(-visionSpeed);
				Robot.rightS.move(visionSpeed);
			}
			else {
				Robot.leftS.move(0);
				Robot.rightS.move(0);
				//visionDone = true;
				System.out.println("VISION DONE");
			}
			}
		else{
			return;
		}
	}


	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
