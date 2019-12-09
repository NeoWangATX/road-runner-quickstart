package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.elements.SkystoneState;

@Autonomous(group="auto")
public class BlueFront extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap);

        robot.drive.setPoseEstimate(new Pose2d(-36.0,61.75, Math.toRadians(270.0)));

        waitForStart();

        robot.drive.followTrajectorySync(
            BluePaths.getTrajectory(robot.drive, SkystoneState.LOWER)
        );
    }
}
