// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.Controller;
//import edu.wpi.first.wpilibj.Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;	
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;



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
  private WPI_TalonSRX intakeMotor = new WPI_TalonSRX	(Constants.intakeId);
  private WPI_TalonSRX uppyMotor = new WPI_TalonSRX	(Constants.uppyId);
  Intake intake = new Intake(intakeMotor);
  Uppy uppy = new Uppy(uppyMotor);
  XboxController controller = new XboxController(0);
  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.frontLeft);
  public WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.backLeft);
  public WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.frontRight);
  public WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.backRight);
  Drive roboMove = new Drive(backLeft,frontLeft,frontRight,backRight, controller);

  Boolean running = false;

  // the new class we lookin at
  public WPI_TalonFX testMotor = new WPI_TalonFX(0);



  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic()
   {
    // if(controller.getBButton()){
    //   intake.spin(-0.5);
    // }else if(controller.getAButton()){
    //   intake.spin(0.5);
    // }else{
    //   intake.spin(0);
    // }
    // if(controller.getYButton()){
    //   uppy.goUp(0.7);
    // }else if(controller.getXButton()){
    //   uppy.goUp(-0.7);
    // }else{
    //   uppy.goUp(0);
    // }
    // roboMove.setMotors();

   
    
      testMotor.set(ControlMode.Position, 2048 *controller.getLeftY());
 SmartDashboard.putNumber("Input for controller", 2048 *controller.getLeftY());


    
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
