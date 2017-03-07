package org.usfirst.frc.team4611.robot.subsystems;
import edu.wpi.first.wpilibj.ADXRS450_Gyro; //uses acceleration to measure the horizontal position of the gyro relative to angle measure 0
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Gyro extends Subsystem{
	
    private static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    static double raw;//raw heading, no math
    static int angleRound;//nearest whole number of the heading
    static int heading;//the angle the robot is facing, between -360 & 360
    static int rotations;//# of times the robot has rotated
    
    
    public Gyro() {
    	gyro.reset();//angle set to 0 when restarted
    }
    
    public static void gyroMeasure(){//this method causes the gyro to measure the current heading but IT IS VOID
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
    
    public static int getAngle()//the method that actually returns the current angle
    {
    	
    	return angleRound;
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

   
   }

