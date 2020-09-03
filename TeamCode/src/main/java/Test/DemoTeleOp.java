package Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import Util.CodeSeg;

@TeleOp(name = "Demo TeleOp")
public class DemoTeleOp extends OpMode {

    DemoBot bot = new DemoBot();
    ElapsedTime timer = new ElapsedTime();

    @Override
    public void init() {

        telemetry.addData("Status: ","Not Ready");
        telemetry.update();

        bot.init(hardwareMap);

        telemetry.addData("Status: ","Ready");
        telemetry.update();
//
//        bot.l1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        bot.l2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        bot.r1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        bot.r2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    @Override
    public void start(){
        timer.reset();
    }

    @Override
    public void loop() {

        telemetry.addData("time:", timer.seconds());
        telemetry.update();

        double forward = -gamepad1.right_stick_y;
        double strafe = gamepad1.right_stick_x;
        double turn = -gamepad1.left_stick_x;



        bot.move(forward, strafe, turn);

        bot.move(forward*0.5,strafe*0.5,turn*0.5);




    }



}
