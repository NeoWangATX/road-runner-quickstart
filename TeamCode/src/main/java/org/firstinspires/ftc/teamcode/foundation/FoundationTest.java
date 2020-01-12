package org.firstinspires.ftc.teamcode.foundation;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.mecanum.SigmaDrive;

@TeleOp
public class FoundationTest extends LinearOpMode {
    private Foundation foundation;
    private SigmaDrive drive;
    @Override
    public void runOpMode() throws InterruptedException {
        foundation = new Foundation(hardwareMap);
        drive = new SigmaDrive(hardwareMap);
        drive.setGamepad(gamepad1);

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

            drive.driveTeleOp();

            telemetry.addData("Left position: ", foundation.getLeftServoPosition());
            telemetry.addData("Right position: ", foundation.getRightServoPosition());
            telemetry.update();
        }
    }
}
