package global;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TerraBot {

    public DcMotor lf; // Left Front
    public DcMotor lb; // Left Back
    public DcMotor rf; // Right Front
    public DcMotor rb; // Right Back

    // Initialization method, defines motors
    public void init(HardwareMap hwMap) {
        // Get all 4 motors in mechanum drivetrain
        lf = getMotor(hwMap, "lf", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lb = getMotor(hwMap, "lb", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rf = getMotor(hwMap, "rf", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rb = getMotor(hwMap, "rb", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    // getMotor returns a DcMotor with the specified settings
    public DcMotor getMotor(HardwareMap hwMap, String name, DcMotor.Direction dir, DcMotor.ZeroPowerBehavior zpb, DcMotor.RunMode mode){
        DcMotor motor = hwMap.get(DcMotor.class, name); // Get the motor from the hardware map
        motor.setPower(0); // Set the power to 0 initially
        motor.setDirection(dir); // Set to the desired direction
        motor.setZeroPowerBehavior(zpb); // Set the zero power behavior
        motor.setMode(mode); // Set the mode (use encoder or not)
        return motor;
    }

    public void move(double forward, double strafe, double turn){
        // TODO
        // This method has to move the robot at a certain power in three different types of motion
        // forward is forward (+) and backward (-)
        // strafe is right (+) and left (-)
        // turn is turn clockwise (+) and turn anticlockwise (-)
        // HINT
        // use rf.setPower(0.5) to set the right front motor to 0.5 power
        lf.setPower(forward+strafe-turn);
        lb.setPower(forward-strafe+turn);
        rf.setPower(-forward+strafe+turn);
        rb.setPower(-forward-strafe-turn);
    }



}
