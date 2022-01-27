package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//mport java.security.acl.Group;
import edu.wpi.first.wpilibj.XboxController;
import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive 
{
    
    private WPI_TalonSRX backL;
    private WPI_TalonSRX backR;
    private WPI_TalonSRX frontL;
    private WPI_TalonSRX frontR;
    private XboxController control;


    public Drive(WPI_TalonSRX BL, WPI_TalonSRX FL, WPI_TalonSRX FR, WPI_TalonSRX BR, XboxController uCon)
    {
        backL = BL;
        backR = BR;
        frontL = FL;
        frontR = FR;
        control = uCon;
    }

    public void setLeftSide(double speed)
    {
        SmartDashboard.putNumber("Controler left output", speed);
        //System.out.println("HERE");
        backL.set(ControlMode.PercentOutput, speed);
        frontL.set(ControlMode.PercentOutput, speed);
    }
    public void setRightSide(double speed)
    {
        SmartDashboard.putNumber("Controler right output", speed);
        backR.set(ControlMode.PercentOutput, speed);
        frontR.set(ControlMode.PercentOutput, speed);
    }
    public void setMotors()
    {
        setLeftSide(control.getLeftY() * Math.abs(control.getLeftY()));
        setRightSide(control.getRightY() * Math.abs(control.getRightY()));
    }


}