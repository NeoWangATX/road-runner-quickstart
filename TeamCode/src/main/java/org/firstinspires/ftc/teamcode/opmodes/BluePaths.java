package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.mecanum.SigmaDrive;
import org.firstinspires.ftc.teamcode.elements.SkystoneState;

public class BluePaths {
    public static Trajectory getTrajectory(SigmaDrive drive, SkystoneState state)
    {
        switch(state)
        {
            case UPPER:
                return drive.trajectoryBuilder()
                        .splineTo(new Pose2d(-22.0, 30.0, Math.toRadians(225))).reverse()
                        .splineTo(new Pose2d(50.0,32.0, Math.toRadians(180))).reverse()//deploy foundation here
                        .splineTo(new Pose2d(50.0, 37.0, Math.toRadians(90)))
                        .splineTo(new Pose2d(30.0, 48.0, Math.toRadians(180)))
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180)))
                        .splineTo(new Pose2d(-45.0,33.0,Math.toRadians(225))).reverse()
                        .splineTo(new Pose2d(0.0,36.0, Math.toRadians(180))).reverse()
                        .build();
            case MIDDLE:
                break;
            case LOWER:
                break;
        }

        return drive.trajectoryBuilder()
                .splineTo(new Pose2d(-22.0, 30.0, Math.toRadians(225))).reverse()
                .splineTo(new Pose2d(50.0,32.0, Math.toRadians(180))).reverse()//deploy foundation here
                .splineTo(new Pose2d(50.0, 37.0, Math.toRadians(90)))
                .splineTo(new Pose2d(30.0, 48.0, Math.toRadians(180)))
                .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180)))
                .splineTo(new Pose2d(-45.0,33.0,Math.toRadians(225))).reverse()
                .splineTo(new Pose2d(0.0,36.0, Math.toRadians(180))).reverse()
                .build();
    }
}
