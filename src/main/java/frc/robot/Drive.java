package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//mport java.security.acl.Group;
import edu.wpi.first.wpilibj.XboxController;
import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive 
{
    
    private TalonSRX backL;
    private TalonSRX backR;
    private TalonSRX frontL;
    private TalonSRX frontR;
    private XboxController control;


    public Drive(TalonSRX BL, TalonSRX FL, TalonSRX FR, TalonSRX BR, XboxController uCon)
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
