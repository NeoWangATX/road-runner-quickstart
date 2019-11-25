package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

public class BlueFront extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap);

        robot.drive.setPoseEstimate(new Pose2d(61.75,-36, 270));

        waitForStart();

        robot.drive.followTrajectorySync(
                robot.drive.trajectoryBuilder()
                .splineTo(new Pose2d(26,-20,210))
                .splineTo(new Pose2d(26,-20,180))
                .splineTo(new Pose2d(36, 50, 180))
                .build()
        );

        //robot.foundation.deployForks();

        robot.drive.followTrajectorySync(
                robot.drive.trajectoryBuilder()
                .splineTo(new Pose2d(36,50,270))
                .splineTo(new Pose2d(55,48,0))
                .build()
        );

        //robot.foundation.retractForks();

        robot.drive.followTrajectorySync(
                robot.drive.trajectoryBuilder()
                .splineTo(new Pose2d(59,0, 0))
                .build()
        );
    }
}
