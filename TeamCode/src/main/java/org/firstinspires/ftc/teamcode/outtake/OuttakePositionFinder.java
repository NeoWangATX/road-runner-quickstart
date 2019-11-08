package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class OuttakePositionFinder extends LinearOpMode {
    private Outtake outtake;

    @Override
    public void runOpMode() throws InterruptedException {
        outtake = new Outtake();
        outtake.initOnlyMotors(hardwareMap);

        waitForStart();

        while(opModeIsActive())
        {
            outtake.liftOne.setPower(gamepad1.left_stick_y);
            outtake.liftTwo.setPower(-gamepad1.left_stick_y);

            telemetry.addData("Position", outtake.liftOne.getCurrentPosition());
            telemetry.addData("Distance off Ground", outtake);
            telemetry.update();
        }
    }
}
