package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
public class Uppy {
    private WPI_TalonSRX upperOne;
    public Uppy(WPI_TalonSRX upperOne){
        this.upperOne = upperOne;
    }

    public void goUp(double motorSpeed){
        upperOne.set(motorSpeed);
    }
}
