package auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import global.TerraBot;

@Autonomous(name = "TerraAuton")
public class TerraAuton extends LinearOpMode {

    // Create a TerraBot object
    TerraBot bot = new TerraBot();
    // Create a Timer object
    ElapsedTime timer = new ElapsedTime();

    @Override
    public void runOpMode(){
        telemetry.addData("Ready?", "No."); // Is the robot ready?
        telemetry.update(); // Update the telemetry
        bot.init(hardwareMap); // Init the robot
        telemetry.addData("Ready?", "Yes!"); // Now the robot is ready
        telemetry.update(); // Update the telemetry
        waitForStart();

        // TODO
        // Move the robot forward for 1 second at 0.5 power
        // HINT
        // timer.reset() resets the timer
        // timer.seconds() gives you the current time in seconds
    }

}
