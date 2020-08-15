package Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import Util.CodeSeg;

@Autonomous (name = "Autonomous Demo")
public class DemoAuton extends LinearOpMode {

    DemoBot2 bot = new DemoBot2();

    ElapsedTime timer = new ElapsedTime();

    @Override
    public void runOpMode() {

        bot.init(hardwareMap);

        telemetry.addData("Status", "Ready");
        telemetry.update();


        waitForStart();

//        bot.moveDis(10, 10, 0.8);
//        bot.moveDis(-10, 10, 0.8);
//        bot.moveDis(-10, -10, 0.8);
//        bot.moveDis(10, -10, 0.8);

    }

}
