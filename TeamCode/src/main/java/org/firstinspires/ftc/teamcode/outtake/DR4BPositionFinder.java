package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class DR4BPositionFinder extends LinearOpMode {
    private DoubleReverseFourbar outtake;

    @Override
    public void runOpMode() throws InterruptedException {
        outtake = new DoubleReverseFourbar(hardwareMap);
        outtake.motorFloat();

        waitForStart();

        while(opModeIsActive())
        {
            telemetry.addData("Position", outtake.getMotorPosition());
            telemetry.update();
        }
    }
}
