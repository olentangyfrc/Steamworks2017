package org.usfirst.frc.team4611.robot.commands;
import edu.wpi.first.wpilibj.ADXRS450_Gyro; //uses acceleration to measure the horizontal position of the gyro relative to angle measure 0
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Gyro {
	
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    double raw;//raw heading, no math
    int angleRound;//nearest whole nusmber of the heading
    int heading;//the angle the robot is facing, between -360 & 360
    int rotations;//# of times the robot has rotated
    
    
    public Gyro() {
        
        try{
               gyro = new ADXRS450_Gyro();
               gyro.reset();//angle set to 0 when restarted
           }
        catch(NullPointerException ex){
               System.out.println("No gyro found");
           }
   }
    
    
    public void gyroMeasure(){
    	raw = gyro.getAngle();//gets the angle of the gyro relative to the set angle 0
    	//negative values counter clockwise, positive values clockwise
    	
    	angleRound = (int)Math.round(raw);
    	
    	heading = angleRound;
    	//the remainder of angle/360 is an equivalent angle, just a simpler number to think with
    	if(heading <= -360 || heading >= 360)
    	{
    		heading %= 360;
    	}
    	
    	rotations = angleRound / 360;
    	
    	SmartDashboard.putNumber("Heading [-360,360]", heading);//Shows accurate angle
    	
    }

   
   }

