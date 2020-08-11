package Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import Util.CodeSeg;

@TeleOp(name = "Demo TeleOp")
public class DemoTeleOp extends OpMode {

    DemoBot2 bot = new DemoBot2();

    ElapsedTime timer = new ElapsedTime();

    @Override
    public void init() {

        telemetry.addData("Status: ","Not Ready");
        telemetry.update();

        bot.init(hardwareMap);

        telemetry.addData("Status: ","Ready");
        telemetry.update();

        bot.l1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bot.l2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bot.r1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bot.r2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    @Override
    public void start(){
        timer.reset();
    }

    @Override
    public void loop() {




        double forward = -gamepad1.right_stick_y;
        double strafe = gamepad1.right_stick_x;
        double turn = -gamepad1.left_stick_x;


        telemetry.addData("r1", bot.r1.getCurrentPosition());
        telemetry.addData("r2", bot.r2.getCurrentPosition());
        telemetry.addData("l1", bot.l1.getCurrentPosition());
        telemetry.addData("l2", bot.l2.getCurrentPosition());
        telemetry.update();

        bot.move(forward, strafe, turn);


    }



}
