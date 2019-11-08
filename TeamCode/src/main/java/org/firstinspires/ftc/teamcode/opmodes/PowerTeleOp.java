package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.Arrays;

@Config
@TeleOp(group="opmode")
public class PowerTeleOp extends OpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        /*
          _____   _____  _______ _____  _____  __   _ _______
         |     | |_____]    |      |   |     | | \  | |______
         |_____| |          |    __|__ |_____| |  \_| ______|

         */

        useAutoPos = false;

        /*
         _____ __   _ _____ _______
           |   | \  |   |      |
         __|__ |  \_| __|__    |

         */

        if(!useAutoPos) { robot = new Robot(hardwareMap); }

        logInit();

        waitForStart();

        if(isStopRequested()) return;

        while(!isStopRequested())
        {
            //START OF GAMEPAD1 CONTROL
            robot.drive.driveTeleOp(gamepad1.left_stick_x,gamepad1.left_stick_y,gamepad1.right_stick_x);
            //END OF GAMEPAD1 CONTROL
            telemetry.addData("Joysticks: ", Arrays.asList(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad2.right_stick_x));
            telemetry.addData("Motor powers: ", robot.drive.getWheelPositions());
            telemetry.update();
            //LOGGING
            //endLoop();
        }
    }
}
