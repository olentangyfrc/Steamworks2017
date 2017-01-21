package org.usfirst.frc.team4611.robot.commands;


import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

public class Gyro extends SampleRobot {

	private RobotDrive myRobot; // robot drive system
    private AnalogGyro gyro;

     double Kp = 0.03;

    public Gyro() {
        gyro = new AnalogGyro(1);          // Gyro on Analog Channel 1
        myRobot = new RobotDrive(1,2); // Drive train jaguars on PWM 1 and 2
        myRobot.setExpiration(0.1);
        }

    public void autonomous() {
        gyro.reset();
        while (isAutonomous()) {
            double angle = gyro.getAngle(); // get current heading
            myRobot.drive(-1.0, -angle*Kp); // drive towards heading 0
            Timer.delay(0.004);
        }
        myRobot.drive(0.0, 0.0);
    }
}
