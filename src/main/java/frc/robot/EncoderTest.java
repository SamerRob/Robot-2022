package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.XboxController;


public class EncoderTest 
{
    final double degEncode = 4096 / 360;
    XboxController cont;
    WPI_TalonSRX _tal = new WPI_TalonSRX(3);
    public EncoderTest(XboxController control){
        cont = control;
    }
    public void goUp(int deg)
    {
        _tal.set(ControlMode.Position, (degEncode * deg));
    }
    
    
}
