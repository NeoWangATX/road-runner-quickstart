package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.mecanum.SigmaDrive;

public class IntakeTestWithDrivebase extends LinearOpMode {
    private SigmaDrive drive;
    private Intake intake;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new SigmaDrive(hardwareMap);
        intake = new Intake(hardwareMap);

        waitForStart();

        while(opModeIsActive())
        {
            drive.driveTeleOp(gamepad1.left_stick_x,gamepad1.left_stick_y,gamepad1.right_stick_x);

            if(gamepad1.left_bumper)
            {
                intake.intakeOn();
            }
            else if(gamepad1.right_bumper)
            {
                intake.reverseIntake();
            }
            else
            {
                intake.intakeOff();
            }
        }
    }
}
