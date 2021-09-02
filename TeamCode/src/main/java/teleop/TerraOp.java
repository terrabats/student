package teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import global.TerraBot;

@TeleOp(name = "TerraOp")
public class TerraOp extends OpMode {
    // Create a TerraBot object
    TerraBot bot = new TerraBot();

    boolean fastmode = false;

    @Override
    public void init() {
        telemetry.addData("Ready?", "No."); // Is the robot ready?
        telemetry.update(); // Update the telemetry
        bot.init(hardwareMap); // Init the robot
        telemetry.addData("Ready?", "Yes!"); // Now the robot is ready
        telemetry.update(); // Update the telemetry
    }

    @Override
    public void loop() {

        if(gamepad1.y) {
            fastmode = !fastmode;
        }
        if(fastmode)
        {
            //bot.move(-gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
        }
        else
        {
            //bot.move(-gamepad1.right_stick_y/2, gamepad1.right_stick_x/2, gamepad1.left_stick_x/2);
        }
        bot.moveArm(-gamepad1.right_stick_y);
        bot.lift(-gamepad1.left_stick_y);

    }
}
