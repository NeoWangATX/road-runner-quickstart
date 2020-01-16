package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;
import org.openftc.revextensions2.ExpansionHubEx;
import org.openftc.revextensions2.ExpansionHubMotor;

import java.util.Arrays;
import java.util.List;

@Config
@TeleOp(group="opmode")
public class PowerTeleOp extends OpMode {
    private ExpansionHubMotor leftEncoder, rightEncoder, frontEncoder;

    @Override
    public void runOpMode() throws InterruptedException {
        leftEncoder = hardwareMap.get(ExpansionHubMotor.class,"intake_right");
        rightEncoder = hardwareMap.get(ExpansionHubMotor.class,"intake_left");
        frontEncoder = hardwareMap.get(ExpansionHubMotor.class,"middle");
        leftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        useAutoPos = false;

        if(!useAutoPos) { robot = new Robot(hardwareMap); }

        robot.intake.setGamepad(gamepad1);
        robot.drive.setGamepad(gamepad1);
        robot.foundation.setGamepad(gamepad1);
        robot.dr4b.setGamepad(gamepad2);
        robot.v4b.setGamepad(gamepad2);

        logInit();

        waitForStart();

        if(isStopRequested()) return;

        while(!isStopRequested())
        {

            if(gamepad1.x)
            {
                robot.dr4b.resetEncoders();
            }
            //START OF GAMEPAD1 CONTROL
            robot.drive.driveTeleOp();
            robot.foundation.driveTeleOp();
            robot.intake.driveTeleOp();
            robot.dr4b.powerDriveTeleOp(.7);
            robot.v4b.driveTeleOp();
            //END OF GAMEPAD1 CONTROL
            telemetry.addData("Joysticks: ", Arrays.asList(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad2.right_stick_x));
            telemetry.addData("Motor positions: ", robot.drive.getWheelPositions());
            telemetry.addData("leftEncoder:",leftEncoder.getCurrentPosition());
            telemetry.addData("rightEncoder",rightEncoder.getCurrentPosition());
            telemetry.addData("middle",frontEncoder.getCurrentPosition());
            telemetry.addData("Lift:", robot.dr4b.getMotorPosition());
            telemetry.addData("Pose2d: ", robot.drive.getPoseEstimate());
            telemetry.update();
            //LOGGING
            //endLoop();
        }
    }

    public void initialize()
    {
        robot.intake.setGamepad(gamepad1);
    }
}
