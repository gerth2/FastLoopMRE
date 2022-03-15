// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  double loopStartTime;
  double prevLoopStartTime;

  int loopCounter = 0;


  @Override
  public void robotInit() {

    System.out.println("Robot Init Starting");


    // 5 second robot init startup
    try {
      Thread.sleep(5000); 
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Robot Init Finished");


  }


  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
    loopStartTime = Timer.getFPGATimestamp();

    // 5ms of processing
    try {
      Thread.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //Calculate call rate and print out if it's 10ms above or below the 20ms expected
    var loopPeriod = loopStartTime - prevLoopStartTime;
    if(loopPeriod < 0.010){
      System.out.println("Loop " + Integer.toString(loopCounter) + " was fast!");
    } else if(loopPeriod > 0.030){
      System.out.println("Loop " + Integer.toString(loopCounter) + " was slow!");
    }


    prevLoopStartTime = loopStartTime;
    loopCounter++;
  }

}
