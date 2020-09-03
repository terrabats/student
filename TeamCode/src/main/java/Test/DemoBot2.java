package Test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class DemoBot2 {

    public DcMotor l1;
    public DcMotor l2;
    public DcMotor r1;
    public DcMotor r2;

    public final double ROTATIONS_TO_TICKS = 537.6;
    public final double INCHES_TO_ROTATIONS = 0.079577;
    public final double STRAFE_CONSTANT = 1.3;


    public void init(HardwareMap hwMap) {

        l1 = hwMap.get(DcMotor.class, "l1");
        l2 = hwMap.get(DcMotor.class, "l2");
        r1 = hwMap.get(DcMotor.class, "r1");
        r2 = hwMap.get(DcMotor.class, "r2");

        l1.setPower(0);
        l2.setPower(0);
        r1.setPower(0);
        r2.setPower(0);


        l1.setDirection(DcMotorSimple.Direction.FORWARD);
        l2.setDirection(DcMotorSimple.Direction.REVERSE);
        r1.setDirection(DcMotorSimple.Direction.REVERSE);
        r2.setDirection(DcMotorSimple.Direction.FORWARD);

        l1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        l2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        r1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        r2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        l1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        l2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        r1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        r2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        resetEncoders();
    }

    public void move(double f, double s, double t) {
        l1.setPower(-f + s - t);
        l2.setPower(f + s + t);
        r1.setPower(-f - s + t);
        r2.setPower(f - s - t);
    }


    public void resetEncoders(){
        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


    public void moveForwardUsingEncoder(double dis, double p){

        int ticks = (int)(dis*INCHES_TO_ROTATIONS*ROTATIONS_TO_TICKS);

        resetEncoders();

        l1.setTargetPosition(ticks);
        l2.setTargetPosition(-ticks);
        r1.setTargetPosition(ticks);
        r2.setTargetPosition(-ticks);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        move(p,0,0);

        while (l1.isBusy() || l2.isBusy() || r1.isBusy() || r2.isBusy()){

        }

        move(0,0,0);

    }

    public void moveDis(double f,double s, double p){

        int fticks = (int)(f*INCHES_TO_ROTATIONS*ROTATIONS_TO_TICKS);
        int sticks = (int)(s*INCHES_TO_ROTATIONS*ROTATIONS_TO_TICKS * STRAFE_CONSTANT);

        //sticks lol
        double totalDis = Math.sqrt((fticks*fticks)+(sticks*sticks));

        l1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        l2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        r1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        r2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        resetEncoders();

        //switch positions of run to pos and target position

        l1.setTargetPosition(fticks-sticks);
        l2.setTargetPosition(-fticks-sticks);
        r1.setTargetPosition(fticks+sticks);
        r2.setTargetPosition(-fticks+sticks);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Just in case
        p = Math.abs(p);

        move(p*(fticks/totalDis),p*(sticks/totalDis),0);

        while (l1.isBusy() || l2.isBusy() || r1.isBusy() || r2.isBusy()){

        }

        move(0,0,0);

        l1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        l2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        r1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        r2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

}