package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;

public class ultraDrive extends Command{
	
	public double ultraSpeed = 0;
	private PowerDistributionPanel pd;
	static int timeCounter = 0; 
	static double previousCurrent = 0;
	
	public ultraDrive(double s) {
		this.ultraSpeed = s;
		pd = new PowerDistributionPanel(RobotMap.powerdis);
	}
	
	protected void execute() {
			Robot.rightS.move(this.ultraSpeed);
			Robot.leftS.move(this.ultraSpeed);
			timeCounter ++;
		}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		double inches = Robot.ultra.getRoundedInches();
		double current = pd.getCurrent(12) + pd.getCurrent(13) + pd.getCurrent(14) + pd.getCurrent(15);
		System.out.println("PD Board Current" + current + "\tCounter" + timeCounter);
		//System.out.println("Range: " + inches);
		if(current > previousCurrent + 2 && timeCounter > 30){
			return true;
		}
		previousCurrent = current;
		return false;
		/*if(inches < 15)
			return true;
		return false;*/
	}

}
