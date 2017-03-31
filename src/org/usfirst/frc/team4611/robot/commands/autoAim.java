package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class autoAim extends Command {
	public static double visionSpeed;
	public static boolean visionDone = false;
	public static int bounceCounter = 0;
	public static final int BOUNCE_LIMIT = 3;
	public boolean lastDirection;
	
	public autoAim(double speed){
		visionSpeed = speed;
		System.out.println("Ran the constructor");
		//bounceCounter = 0;
		//System.out.println("bounce count set to 0");
		
	}
	
	public void initialize(){
		bounceCounter = 0;
		System.out.println("Set bounceCounter to 0 in initialize()");
	}
	
	public void moveContours(double x1, double x2){						//Receive the x values of our two target contours
		double targetNum = 0;
		targetNum = (Math.abs(x1 - x2)*0.625) + Math.max(x1, x2);		//Set target location to the right of the right side contour. This will be 0.625 of the distance between the contours. This lines us up just about right, by trial and error
		//System.out.println("Vision Speed:" + visionSpeed);
		//System.out.println("THIS IS target number:" + targetNum);
		//System.out.println("Average: " + (x1+x2)/2);//This says where the place between the contours is
		if (bounceCounter >= BOUNCE_LIMIT){
			System.out.print("WE ARE DONE- Bounce Counters");
			return;
		}
		System.out.println("bounceCounter "+ bounceCounter);
		if (targetNum > 160){							//If we're too right, then go more right to center the contours						
			Robot.leftS.move(-visionSpeed);
			Robot.rightS.move(visionSpeed);//theoretically move right
			System.out.println("MOVED Right");
			if (lastDirection){
				bounceCounter++;
			}
			lastDirection= false;
		}
		else if (targetNum < 160){						//If we're left, keep going more left to center the contours
			Robot.leftS.move(visionSpeed);
			Robot.rightS.move(-visionSpeed);
			System.out.println("MOVED LEFT");
			if (!lastDirection){
				bounceCounter++;
			}
			lastDirection = true;
		}
		else{											//If we're at exactly center by some miracle, don't move
			Robot.leftS.move(0);	
			Robot.rightS.move(0);
			System.out.println("We are pointed at the exact center");
		}
	}
	
	
	protected void execute() { 
		if (bounceCounter >= BOUNCE_LIMIT){
			System.out.print("WE ARE DONE- Bounce Counters");
			return;
		}
		//System.out.println("Vision Done: " + visionDone);
		double [] xValues = Robot.table.getNumberArray("centerX",new double [1]);
		double [] yValues = Robot.table.getNumberArray("centerY",new double [1]);
		if(visionDone == false) {
			//System.out.println("Number of Contours: "+xValues.length);
			if(xValues.length > 0 && yValues.length > 0) {
				//System.out.println("X value #1: " +xValues[0]+ " Y value #1: " + yValues[0]);
				if (xValues.length > 1 && yValues.length > 1){
					//System.out.println("X value #2: " +xValues[1]+ " Y value #2: " + yValues[1]);
					//System.out.println("Difference of y values: "+Math.abs(yValues[0]-yValues[1]));
				}
			}
			int targetContour1 = 0;
			int targetContour2 = 1;
			if(xValues.length > 2) {									//These loops go through and find the first 2 contours on a similar vertical location
				for(int c = 0; c < yValues.length; c++) {				//Please kill me. You can do this with one loop.
					for(int c2 = c + 1; c2 < yValues.length; c2++){
						if(Math.abs(yValues[c] - yValues[c2]) <= 8) {
							targetContour1 = c;		//Set of 2 contours that we want since they're close together vertically.
							targetContour2 = c2;	//Second of the two. These are the array locations of the elements that define the contours we want
						}
					}
				}
			}
		
			
			if(xValues.length >= 2) {		//If we have 2 or more contours, then just run the normal contours command
				//System.out.println("X Val first contour: "+ xValues[targetContour1]+" "+ "X Val second contour:"+ xValues[targetContour2]);
				moveContours(xValues[targetContour1], xValues[targetContour2]);
				Robot.fl.makeGreen();
				//Remember, these are the array locations
				//System.out.println("Have two contours, move according to moveContours method");
			}
			else if(xValues.length == 1 && xValues[0] < 100) {	//If there's only one contour, and it's to the left of 100, then turn a bit to the left
				Robot.leftS.move(visionSpeed);					//Maybe this is when we're only finding one contour because the other is offscreen?
				Robot.rightS.move(-visionSpeed);
				Robot.fl.makeBlue();
				System.out.println("1 contour, left of 100, move left.");
			}
			else if(xValues.length == 1 && xValues[0] > 200) {	//If there's only one contour, and it's to the right of 160, then turn a bit to the right
				Robot.leftS.move(-visionSpeed);					//Maybe this is when we're only finding one contour because the other is offscreen?
				Robot.rightS.move(visionSpeed);
				Robot.fl.makeBlue();
				System.out.println("1 contour, right of 200, move right.");
			}
			
			else {												//If we don't have any contours, then turn right (clockwise)
				Robot.leftS.move(-visionSpeed);
				Robot.rightS.move(visionSpeed);		
				Robot.fl.makeRed();
				System.out.print("\tNO CONTOURS FOUND\t");
			}
		}
	}


	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
