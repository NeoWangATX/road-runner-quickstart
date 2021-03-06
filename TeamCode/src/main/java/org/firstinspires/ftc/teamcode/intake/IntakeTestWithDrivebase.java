package org.firstinspires.ftc.teamcode.intake;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.mecanum.SigmaDrive;

@Config
@TeleOp(group="test")
public class IntakeTestWithDrivebase extends LinearOpMode {
    private SigmaDrive drive;
    private Intake intake;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new SigmaDrive(hardwareMap);
        intake = new Intake(hardwareMap);

        waitForStart();

        intake.floatIntake();
        drive.setGamepad(gamepad1);

        while(opModeIsActive())
        {
            drive.driveTeleOp();

            if(gamepad1.right_bumper)
            {
                intake.intakeOn();
            }
            else if(gamepad1.left_bumper)
            {
                intake.reverseIntake();
            }
            else
            {
                intake.intakeOn();
            }
        }
    }
}
