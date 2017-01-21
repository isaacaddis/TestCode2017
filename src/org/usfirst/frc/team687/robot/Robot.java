
package org.usfirst.frc.team687.robot;

import org.usfirst.frc.team687.robot.commands.DriveForward;
import org.usfirst.frc.team687.robot.commands.Kick;
import org.usfirst.frc.team687.robot.subsystems.Drive;
import org.usfirst.frc.team687.robot.subsystems.Gears;
import org.usfirst.frc.team687.robot.subsystems.Hang;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Robot extends IterativeRobot {

	public static final Drive drive = new Drive();
	public static final Gears gears = new Gears();
	public static final Hang hang = new Hang();
	public static final Kick kick = new Kick();

	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;
    
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new DriveForward());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
    }
    public void disabledInit(){

    }	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    public void testPeriodic() {
        LiveWindow.run();
    }
}
