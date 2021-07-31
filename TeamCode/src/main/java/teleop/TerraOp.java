package teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import global.TerraBot;

@TeleOp(name = "TerraOp")
public class TerraOp extends OpMode {
    // Create a TerraBot object
    TerraBot bot = new TerraBot();

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
        // TODO
        // This method has to connect the controllers to the movement of the robot
        // A gamepad is a controller
        // The left stick of gamepad 1 should turn the robot
        // The right stick of gamepad 1 should translate the robot
        // HINT
        // use gamepad1.right_stick_y to get the y value of the right stick

    }
}
