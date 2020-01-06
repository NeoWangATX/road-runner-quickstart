package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.path.heading.ConstantInterpolator;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import org.firstinspires.ftc.teamcode.PathGenerator;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.elements.SkystoneState;

import kotlin.Unit;

public class BluePaths {
    public static Trajectory getTrajectory(Robot robot, SkystoneState state) {
        /* switch(state)
        {
            case UPPER:
                return PathGenerator.blueSkystoneAt4(robot.drive.trajectoryBuilder()).build();
            case MIDDLE:
                return PathGenerator.blueSkystoneAt5(robot.drive.trajectoryBuilder()).build();
            case LOWER:
                return PathGenerator.blueSkystoneAt6(robot.drive.trajectoryBuilder()).build();
            default:
                return PathGenerator.blueSkystoneAt4(robot.drive.trajectoryBuilder()).build();
        } */
        // }
        switch (state) {
            case UPPER:
                return robot.drive.trajectoryBuilder()
                        .addMarker(() -> {
                            robot.intake.intakeOn();
                            return Unit.INSTANCE;
                        })
                        .splineTo(new Pose2d(-22.0, 30.0, Math.toRadians(225))).reverse()
                        .splineTo(new Pose2d(50.0, 32.0, Math.toRadians(180))).reverse()//deploy foundation here
                        .splineTo(new Pose2d(50.0, 37.0, Math.toRadians(90)))
                        .splineTo(new Pose2d(30.0, 48.0, Math.toRadians(180)))
                        //.addMarker(() -> {robot.intake.intakeOff(); return Unit.INSTANCE; })
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180)))
                        .addMarker(() -> {
                            robot.intake.intakeOn();
                            return Unit.INSTANCE;
                        })
                        .splineTo(new Pose2d(-45.0, 33.0, Math.toRadians(225))).reverse()
                        //.addMarker(() -> {robot.intake.intakeOff(); return Unit.INSTANCE; })
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180))).reverse()
                        .build();
            case MIDDLE:
                return robot.drive.trajectoryBuilder()
                        .addMarker(() -> {
                            robot.intake.intakeOn();
                            return Unit.INSTANCE;
                        })
                        .lineTo(new Vector2d(-20, 37), new ConstantInterpolator(180))
                        .splineTo(new Pose2d(-35.0, 21.0, Math.toRadians(200.0))).reverse()
                        .lineTo(new Vector2d(-20, 37), new ConstantInterpolator(180))
                        .splineTo(new Pose2d(50.0, 33.0, Math.toRadians(180))).reverse()
                        //.addMarker(() -> {robot.intake.intakeOff(); return Unit.INSTANCE; })
                        .splineTo(new Pose2d(50.0, 37.0, Math.toRadians(90)))
                        .splineTo(new Pose2d(30.0, 48.0, Math.toRadians(180)))
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180)))
                        .addMarker(() -> {
                            robot.intake.intakeOn();
                            return Unit.INSTANCE;
                        })
                        .splineTo(new Pose2d(-55.0, 27.0, Math.toRadians(225))).reverse()
                        //.addMarker(() -> {robot.intake.intakeOff(); return Unit.INSTANCE; })
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180.0))).reverse()
                        .build();
                //return PathsBlue.blueSkystoneAt5(robot.drive.trajectoryBuilder(),ParkSide.FROMWALL);
            case LOWER:
                return robot.drive.trajectoryBuilder()
                        .addMarker(() -> {
                            robot.intake.intakeOn();
                            return Unit.INSTANCE;
                        })
                        .lineTo(new Vector2d(-20, 37), new ConstantInterpolator(180))
                        .splineTo(new Pose2d(-38.0, 22.0, Math.toRadians(245.0))).reverse()
                        .splineTo(new Pose2d(50.0, 33.0, Math.toRadians(180))).reverse()
                        //.addMarker(() -> {robot.intake.intakeOff(); return Unit.INSTANCE; })
                        .splineTo(new Pose2d(50.0, 37.0, Math.toRadians(90)))
                        .splineTo(new Pose2d(30.0, 48.0, Math.toRadians(180)))
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180)))
                        .addMarker(() -> {
                            robot.intake.intakeOn();
                            return Unit.INSTANCE;
                        })
                        .splineTo(new Pose2d(-56.0, 26.0, Math.toRadians(225))).reverse()
                        //.addMarker(() -> {robot.intake.intakeOff(); return Unit.INSTANCE; })
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180.0))).reverse()
                        .build();
            default:
                return robot.drive.trajectoryBuilder()
                        .splineTo(new Pose2d(-22.0, 30.0, Math.toRadians(225))).reverse()
                        .splineTo(new Pose2d(50.0, 32.0, Math.toRadians(180))).reverse()//deploy foundation here
                        .splineTo(new Pose2d(50.0, 37.0, Math.toRadians(90)))
                        .splineTo(new Pose2d(30.0, 48.0, Math.toRadians(180)))
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180)))
                        .splineTo(new Pose2d(-45.0, 33.0, Math.toRadians(225))).reverse()
                        .splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180))).reverse()
                        .build();
        }
        /* switch (state) {
            case LOWER:
                return PathsBlue.blueSkystoneAt4(robot.drive.trajectoryBuilder(), ParkSide.WALL);
            case MIDDLE:
                return PathsBlue.blueSkystoneAt5(robot.drive.trajectoryBuilder(), ParkSide.WALL);
            case UPPER:
            default:
                return PathsBlue.blueSkystoneAt6(robot.drive.trajectoryBuilder(), ParkSide.WALL);
        } */
    }
}
