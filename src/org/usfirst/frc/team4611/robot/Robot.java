
package org.usfirst.frc.team4611.robot;

import org.usfirst.frc.team4611.robot.subsystems.*;
//import org.usfirst.frc.team4611.robot.subsystems.Motor;
//import org.usfirst.frc.team4611.robot.subsystems.VisionTank;
import org.usfirst.frc.team4611.robot.subsystems.leftSide;
import org.usfirst.frc.team4611.robot.subsystems.rightSide;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4611.robot.commands.UltrasonicRange;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// public static final ExampleSubsystem exampleSubsystem = new
	// ExampleSubsystem();
	public static OI oi;
	public static leftSide leftS; 
	public static rightSide rightS;
	public static talonTurret turretMotor;
	public static SingleWheelShooter sw;
	public static Timer time;
	public UltrasonicRange ultra;
	public static double visionSpeed = .5;
	public static boolean visionDone = false;
	
	public static boolean dir = false;

	public static Preferences prefs ;
	Command autonomousCommand;
	SendableChooser chooser;

	public static NetworkTable table;
	public static NetworkTable table2;

	CameraServer server;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	@Override
	public void robotInit() {
		// Initializes camera feed on driver station
		// server = CameraServer.getInstance();
		// server.setQuality(50);
		// server.startAutomaticCapture("cam1");
		leftS = new leftSide();
		rightS = new rightSide();
		turretMotor = new talonTurret();
		sw = new SingleWheelShooter();
		oi = new OI();

		prefs = Preferences.getInstance();
		 
		this.chooser = new SendableChooser(); //SmartDashboard

		// this.autonomousCommand = new autonomousCommandGroup();
		 table = NetworkTable.getTable("GRIP/data"); //Network tables to pull
		 table2 = NetworkTable.getTable("GRIP");
		// VA data to roborio. Not currently in use
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)

		this.autonomousCommand = (Command) this.chooser.getSelected();
		if (this.autonomousCommand != null) {
			this.autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (this.autonomousCommand != null) {
			this.autonomousCommand.cancel();
		}
		time = new Timer();
		ultra = new UltrasonicRange();
		//time.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public static int tracker = 0;
	
	double lastFrame = 0;
	public static double lastTime = 0;
	@Override
	public void teleopPeriodic() {
		
			
		double [] value = table.getNumberArray("centerX",new double [1]);
		//printArray("centerX",value);
		double [] value2 = table.getNumberArray("centerY",new double [1]);
		//printArray("centerY",value2);
		double [] value3 = table.getNumberArray("width",new double [1]);
		//printArray("width",value3);
		double [] value4 = table.getNumberArray("height",new double [1]);
		//printArray("height",value4);
		double [] value5 = table.getNumberArray("area",new double [1]);
		//printArray("area",value5);
		double currentFrame = table2.getNumber("FrameRate", 0.0);
		
		if(lastFrame != currentFrame) {
			lastFrame = currentFrame;
			lastTime = time.get(); 
		}
		else {
			double differentTime = time.get() - lastTime;
			if(differentTime > 5)
				SmartDashboard.putString("Kangaroo", "Dead");
		}
		
		
		
		System.out.println("Number of contours" + value.length);
		//System.out.println("Boolean" + OI.leftJoy.getRawButton(7));
		if(visionDone == false) {
			if (oi.leftJoy.getRawButton(7)) {
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
			
			else {
				Robot.leftS.move(0);
				Robot.rightS.move(0);
			}
		}
			//moveContours(value[0]);
		Scheduler.getInstance().run();	
		// LiveWindow.run();
		ultra.ultrasonicMeasurement();
		turretMotor.getEncoderMeasure();
		}
	
	
	public void moveContours(double x1, double x2){
	
		//double ave = (x1+x2)/2;
		double targetNum = 0;
		targetNum = Math.abs(x1 - x2) + Math.max(x1, x2);
		 //oi.leftJoy.getAxis(AxisType.kZ);
		//double visionSpeedPercent = 1.3;
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
	
	public void printArray (String name, double[] ar){
		System.out.print(name + ",");
		for (int s = 0; s< ar.length; s++){
			System.out.print(ar[s]);
			if (s!= ar.length-1){
				System.out.print(",");
			}
		}
		System.out.println();		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
