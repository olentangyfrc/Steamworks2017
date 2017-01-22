package org.usfirst.frc.team4611.robot.commands;


import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyro extends SampleRobot {

	private RobotDrive myRobot; // robot drive system
    private AnalogGyro gyro = new AnalogGyro(1);// Gyro on Analog Channel 1

    double Kp = 0.03; // how fast the turns are, Too fast = oscillation, too slow = may not reach destination

    public Gyro() {
                 
        myRobot = new RobotDrive(0,1); // Drive train roborio on PWM 0 and 1
        myRobot.setExpiration(0.1); //0.1 expiration timeout
        }

    public void autonomous() {
        gyro.reset();
        while (isAutonomous()) {
            double angle = gyro.getAngle(); // get current heading
            myRobot.drive(-1.0, -angle*Kp); // drive towards heading 0
            Timer.delay(0.004); 
            SmartDashboard.putNumber("Angle", angle);
        }
        myRobot.drive(0.0, 0.0); //Stops Robot
    }
}
