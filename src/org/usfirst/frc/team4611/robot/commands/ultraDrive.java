package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;

public class ultraDrive extends Command{
	
	public double ultraSpeed = 0;
	private PowerDistributionPanel pd;
	int timeCounter = 0; 
	double previousCurrent = 0;
	
	public ultraDrive(double s) {
		ultraSpeed = s;
		pd = new PowerDistributionPanel(RobotMap.powerdis);
	}
	
	public void initialize(){
		timeCounter = 0;
	}
	
	protected void execute() {
			Robot.rightS.move(ultraSpeed);
			Robot.leftS.move(ultraSpeed);
			timeCounter ++;
		}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		double current = pd.getCurrent(12) + pd.getCurrent(13) + pd.getCurrent(14) + pd.getCurrent(15);
		System.out.println("PD Board Current" + current + "\tCounter" + timeCounter);
		//System.out.println("Range: " + inches);
		if(current > previousCurrent + 2.5 && timeCounter > 30){
			System.out.println("Finished ultraDrive");
			return true;
		}
		previousCurrent = current;
		return false;
	}

}
