package global;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TerraBot {
    public DcMotor arm;
    public CRServo lift;

    // Initialization method, defines motors
    public void init(HardwareMap hwMap) {
        // Get all 4 motors in mechanum drivetrain
        arm = getMotor(hwMap, "arm", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift = getCRServo(hwMap, "lift", CRServo.Direction.REVERSE);

    }
    public DcMotor getMotor(HardwareMap hwMap, String name, DcMotor.Direction dir, DcMotor.ZeroPowerBehavior zpb, DcMotor.RunMode mode){
        DcMotor motor = hwMap.get(DcMotor.class, name); // Get the motor from the hardware map
        motor.setPower(0); // Set the power to 0 initially
        motor.setDirection(dir); // Set to the desired direction
        motor.setZeroPowerBehavior(zpb); // Set the zero power behavior
        motor.setMode(mode); // Set the mode (use encoder or not)
        return motor;
    }

    public CRServo getCRServo(HardwareMap hwMap, String name, CRServo.Direction dir){
        CRServo crServo = hwMap.get(CRServo.class, name);
        crServo.setPower(0);
        crServo.setDirection(dir);
        return crServo;
    }
    public void moveArm(double p){
        arm.setPower(p);
    }
    public void lift(double p){
        lift.setPower(p);
    }
}