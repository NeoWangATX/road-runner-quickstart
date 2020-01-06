package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(group="outtake")
public class DR4BPositionFinder extends LinearOpMode {
    private DoubleReverseFourbar outtake;

    @Override
    public void runOpMode() throws InterruptedException {
        outtake = new DoubleReverseFourbar(hardwareMap);
        outtake.motorFloat();
        outtake.resetEncoders();

        waitForStart();

        while(opModeIsActive())
        {
            telemetry.addData("Position", outtake.getMotorPosition());
            telemetry.update();
        }
    }
}
