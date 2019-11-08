package org.firstinspires.ftc.teamcode.foundation;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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
        }
    }
}
