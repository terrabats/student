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

        // This method has to connect the controllers to the movement of the robot
        // A gamepad is a controller
        // The left stick of gamepad 1 should turn the robot
        // The right stick of gamepad 1 should translate the robot
        // HINT
        // use gamepad1.right_stick_y to get the y value of the right stick

        // TODO
        // Make a boolean called fastmode and set it to false
        // Then add code that toggles fastmode based on gamepad.y
        // Finally if the robot is in fastmode move normally
        // Otherwise make the robot move at half speed

        //Dont put this hear otherwise it will always set fastmode to false put it outside of the loop method like at the top or something
        boolean fastmode = false;
        if(gamepad1.y) {
            //Add semicolon
            //and you also have to figure out how to toggle it
            fastmode = !fastmode;
        }
        //Dont need == true
        if(fastmode == true)
        {
            bot.move(-gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
        }
        else
        {
            bot.move(-gamepad1.right_stick_y/2, gamepad1.right_stick_x/2, gamepad1.left_stick_x/2);
        }
    }
}
