package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
public class Intake {
    private WPI_TalonSRX intakeOne;
    public Intake(WPI_TalonSRX intakeOne){
        this.intakeOne = intakeOne;
    }

    public void spin(double intakeSpeed){
        intakeOne.set(intakeSpeed);
    }

    public void getIn(XboxController uController)
    {
        if(uController.getBButton())
        {
        spin(-0.5);
        }
        else if(uController.getAButton())
        {
        spin(0.5);
        }
        else
        {
        spin(0);
        }
    }
}