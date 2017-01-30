package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Feeder extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
		private double speed;
		
		public Feeder(double inputspeed){
			this.speed = inputspeed;
			this.requires(Robot.fe);
		}

		public Feeder() {
			// TODO Auto-generated constructor stub
		}

		private void requires(Feeder fe) {
			// TODO Auto-generated method stub
			
		}
		protected void initialize(){
		}
		protected void execute(){
			  Robot.fe.Feed(RobotMap.Feederspeed);
		}
		   protected void end(){
			   Robot.fe.Feed(0);
		   }
			private void Feed(double feederspeed) {
			// TODO Auto-generated method stub
			
		}

		protected void interupted(){
			this.end();
		}














}
