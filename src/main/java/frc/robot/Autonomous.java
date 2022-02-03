import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrollerGroup;



public class Autonomous 
{
    // The wheelz
    private WPI_TalonFX backL;
    private WPI_TalonFX backR;
    private WPI_TalonFX frontL;
    private WPI_TalonFX frontR;
    //grouping the motors for later 
    private SpeedControllerGroup leftMotorGroup;
    private SpeedControllerGroup rightMotorGroup;

    private WPI_TalonFX[] allMotorGroup;

    // The amount of ticks for the motor to turn 360 degrees
    private int ticks = 2048;
    // The size of the wheel to get accurate distance
    private double wheelSize = -1;

    public Autonomous(int p_backLeftMotorPort, int p_backRightMotorPort, int p_frontLeftMotorPort, int p_frontRightMotorPort)
    {
        this.backL = new WPI_TalonFX(p_backLeftMotorPort);
        this.backR = new WPI_TalonFX(p_backRightMotorPort);
        this.frontL = new WPI_TalonFX(p_frontLeftMotorPort);
        this.frontR = new WPI_TalonFX(p_frontRightMotorPort);

        SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(backL, frontL);
        this.rightMotorGroup = {backR, frontR};
        this.allMotorGroup = {backL, frontL, backR, frontR};
    }

    // getters
    public int getTicks() { return ticks;}
    public double getWheelSize() { return wheelSize;}
    
    // setters
    public void setTicks(int p_Ticks) { this.ticks = p_Ticks;}
    public void setWheelSize(double p_wheelSize) { this.wheelSize = p_wheelSize;}
   
    // moves forward like your scratch programs 
    public void move(int p_distance)
    {
        
        allMotorGroup.set(ControlMode.Position, (2048 * p_distance) / getWheelSize();
        
    }
    // turn the robot in degrees not rad, clockwise is positive 
    public void turn(int angle)
    {
        WPI_TalonFX[] forward;
        WPI_TalonFX[] backward;
        if (angle > 0)
        {
            forward = leftMotorGroup;
            backward = rightMotorGroup;
        }
        else
        {
            forward = rightMotorGroup;
            backward = leftMotorGroup;
        }

        forward.set(ControlMode.Position, angle * 2048 / 360);
        backward.set(ControlMode.Position, -angle * 2048 / 360);
    }

}