package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class turnEncoder extends Command{
	
	public turnEncoder(){
		this.requires(Robot.me);
	}
	
	protected void execute(double deg){
		Robot.me.adjust(deg);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
