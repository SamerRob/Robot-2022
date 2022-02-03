package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
public class Intake {
    private WPI_TalonSRX intakeOne;
    public Intake(WPI_TalonSRX intakeOne){
        this.intakeOne = intakeOne;
    }

    public void spin(double intakeSpeed){
        intakeOne.set(intakeSpeed);
    }
}