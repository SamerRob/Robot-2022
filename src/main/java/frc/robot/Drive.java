package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
//mport java.security.acl.Group;
import edu.wpi.first.wpilibj.XboxController;
import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Drive 
{
    private WPI_VictorSPX frontL;
    private WPI_VictorSPX frontR;
    private XboxController control;


    public Drive(WPI_VictorSPX FL, WPI_VictorSPX FR, XboxController uCon)
    {
        frontL = FL;
        frontR = FR;
        control = uCon;
    }

    public void setLeftSide(double speed)
    {
        SmartDashboard.putNumber("Controler left output", speed);
        //System.out.println("HERE");
        frontL.set(ControlMode.PercentOutput, speed);
    }
    public void setRightSide(double speed)
    {
        SmartDashboard.putNumber("Controler right output", speed);
        frontR.set(ControlMode.PercentOutput, speed);
    }
    public void setMotors()
    {
        setLeftSide(control.getLeftY() * Math.abs(control.getLeftY()));
        setRightSide(control.getRightY() * Math.abs(control.getRightY()));
    }


}
