package org.firstinspires.ftc.teamcode.foundation;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class FoundationTest extends LinearOpMode {
    private Foundation foundation;
    @Override
    public void runOpMode() throws InterruptedException {
        foundation = new Foundation(hardwareMap);

        waitForStart();

        while(opModeIsActive())
        {
            if(gamepad1.a)
            {
                foundation.deployForks();
            }
            else if(gamepad1.b)
            {
                foundation.retractForks();
            }

            telemetry.addData("Left position: ", foundation.getLeftServoPosition());
            telemetry.addData("Right position: ", foundation.getRightServoPosition());
            telemetry.update();
        }
    }
}
