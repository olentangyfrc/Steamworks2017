package org.usfirst.frc.team4611.robot.commands;
import edu.wpi.first.wpilibj.ADXRS450_Gyro; //uses acceleration to measure the horizontal position of the gyro relative to angle measure 0
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Gyro {
	
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    double raw;
    int angleRound;
    int heading;
    int rotations;
    boolean direction;//true is clockwise
    
    
    public Gyro() {
    	gyro.reset();//angle set to 0 when restarted
    }
    
    public void gyroMeasure()
    {
    	raw = gyro.getAngle();//get's the angle of the gyro relative to the set angle 0
    	//negative values counter clockwise, positive values clockwise
    	angleRound = (int)Math.round(raw);
    	heading = angleRound;
    	if(heading <= -360)
    	{
    		direction = false;
    		heading %= 360;
    	}
    	if(heading >= 360)
    	{
    		direction = true;
    		heading %= 360;
    	}
    	rotations = angleRound / 360;
    	
    	//SmartDashboard.putNumber("Raw Heading", raw);
    	//SmartDashboard.putNumber("Rounded Heading", angleRound);
    	SmartDashboard.putNumber("Heading [-360,360]", heading);
    	SmartDashboard.putNumber("# of roations", rotations);
    	SmartDashboard.putBoolean("Clockwise?", direction);
    	
    }

   
   }

