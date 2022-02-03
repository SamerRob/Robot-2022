package frc.robot;
import com.revrobotics.CANSparkMax;
public class Uppy {
    private CANSparkMax upperOne;
    public Uppy(CANSparkMax upperOne){
        this.upperOne = upperOne;
    }

    public void goUp(double motorSpeed){
        upperOne.set(motorSpeed);
    }
}