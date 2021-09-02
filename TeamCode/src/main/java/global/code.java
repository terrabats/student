package global;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class code {

    public DcMotor lf; // Left Front
    public Servo s;

    // Initialization method, defines motors
    public void init(HardwareMap hwMap) {
        // Get all 4 motors in mechanum drivetrain
        lf = getMotor(hwMap, "lf", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        s = getServo(hwMap, "lb", Servo.Direction.REVERSE, 0.5);


    }
    public DcMotor getMotor(HardwareMap hwMap, String name, DcMotor.Direction dir, DcMotor.ZeroPowerBehavior zpb, DcMotor.RunMode mode){
        DcMotor motor = hwMap.get(DcMotor.class, name); // Get the motor from the hardware map
        motor.setPower(0); // Set the power to 0 initially
        motor.setDirection(dir); // Set to the desired direction
        motor.setZeroPowerBehavior(zpb); // Set the zero power behavior
        motor.setMode(mode); // Set the mode (use encoder or not)
        return motor;
    }

    public Servo getServo(HardwareMap hwMap, String name, Servo.Direction dir, double spos){
        Servo servo = hwMap.get(Servo.class, name);
        servo.setDirection(dir);
        servo.setPosition(spos);
        return servo;
    }
    public void movearm()
    {

    }
}