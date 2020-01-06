package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.path.heading.ConstantInterpolator;
import com.acmerobotics.roadrunner.path.heading.SplineInterpolator;
import com.acmerobotics.roadrunner.path.heading.TangentInterpolator;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;

public class PathsBlue {
    private static void firstSkystone4(TrajectoryBuilder builder1, ParkSide side){
        builder1
                .lineTo(new Vector2d(-36.0, 60.0), new ConstantInterpolator(Math.toRadians(180.0)))
                .splineTo(new Pose2d(-49.0, 30.0, Math.toRadians(300.0)), new TangentInterpolator())
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(-38.0, 42.0, Math.toRadians(180.0)), new TangentInterpolator());
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(-38.0, 60.0, Math.toRadians(180.0)), new TangentInterpolator());
    }
    private static void firstSkystone5(TrajectoryBuilder builder1, ParkSide side){
        builder1
                .lineTo(new Vector2d(-36.0, 60.0), new ConstantInterpolator(Math.toRadians(180.0)))
                .splineTo(new Pose2d(-42.0, 29.0, Math.toRadians(300.0)), new TangentInterpolator())
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(-30.0, 42.0, Math.toRadians(180.0)), new TangentInterpolator());
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(-30.0, 60.0, Math.toRadians(180.0)), new TangentInterpolator());
    }
    private static void firstSkystone6(TrajectoryBuilder builder1, ParkSide side){
        builder1
                .lineTo(new Vector2d(-36.0, 60.0), new ConstantInterpolator(Math.toRadians(180.0)))
                .splineTo(new Pose2d(-34.0, 29.0, Math.toRadians(300.0)), new TangentInterpolator())
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(-30.0, 42.0, Math.toRadians(180.0)), new TangentInterpolator());
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(-30.0, 60.0, Math.toRadians(180.0)), new TangentInterpolator());
    }
    private static void pullFoundation(TrajectoryBuilder builder1, ParkSide side){
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(0.0, 60.0, Math.toRadians(180.0)), new TangentInterpolator());
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180.0)), new TangentInterpolator());
        builder1
                .splineTo(new Pose2d(45.0, 34.0, Math.toRadians(90.0)), new TangentInterpolator())
                .reverse()
                .splineTo(new Pose2d(38.0, 45.0, Math.toRadians(180.0)), new TangentInterpolator());
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
    }
    private static void stoneAt6(TrajectoryBuilder builder1, ParkSide side){
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(-23.0, 50.0, 180.0));
        builder1
                .splineTo(new Pose2d(-20.0, 30.0, Math.toRadians(240.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL)
            builder1
                    .splineTo(new Pose2d(-23.0, 50.0, 180.0))
                    .splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
        builder1
                .splineTo(new Pose2d(38.0, 45.0, Math.toRadians(180.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
    }
    private static void stoneAt5(TrajectoryBuilder builder1, ParkSide side){
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(-26.0, 50.0, 180.0));
        builder1
                .splineTo(new Pose2d(-30.0, 28.0, Math.toRadians(230.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL)
            builder1
                    .splineTo(new Pose2d(-26.0, 50.0, 180.0))
                    .splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
        builder1
                .splineTo(new Pose2d(38.0, 45.0, Math.toRadians(180.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
    }
    private static void stoneAt3(TrajectoryBuilder builder1, ParkSide side){
        builder1
                .splineTo(new Pose2d(-43.0, 28.0, Math.toRadians(230.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
        builder1
                .splineTo(new Pose2d(38.0, 45.0, Math.toRadians(180.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
    }
    private static void stoneAt2(TrajectoryBuilder builder1, ParkSide side){
        builder1
                .splineTo(new Pose2d(-52.0, 28.0, Math.toRadians(220.0)), new SplineInterpolator(Math.toRadians(180.0), Math.toRadians(220.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
        builder1
                .splineTo(new Pose2d(38.0, 45.0, Math.toRadians(180.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
    }
    private  static void stoneAt1(TrajectoryBuilder builder1, ParkSide side){
        builder1
                .splineTo(new Pose2d(-59.0, 28.0, Math.toRadians(220.0)), new SplineInterpolator(Math.toRadians(180.0), Math.toRadians(220.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
        builder1
                .splineTo(new Pose2d(38.0, 45.0, Math.toRadians(180.0)))
                .reverse();
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(20.0, 60.0, Math.toRadians(180.0)));
    }
    static void blueFoundation(TrajectoryBuilder builder1, ParkSide side){
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(0.0, 36.0, Math.toRadians(0.0)), new TangentInterpolator());
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(0.0, 60.0, Math.toRadians(0.0)), new TangentInterpolator());
        builder1
                .splineTo(new Pose2d(55.0, 45.0, Math.toRadians(0.0)), new TangentInterpolator())
                .reverse()
                .splineTo(new Pose2d(45.0, 34.0, Math.toRadians(90.0)), new TangentInterpolator())
                .reverse()
                .splineTo(new Pose2d(38.0, 45.0, Math.toRadians(180.0)), new TangentInterpolator());
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(0.0, 36.0, Math.toRadians(180.0)), new TangentInterpolator());
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(0.0, 60.0, Math.toRadians(180.0)), new TangentInterpolator());
    }
    private static void autoPark(TrajectoryBuilder builder1, ParkSide side){
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(0.0, 35.0, Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(0.0, 60.0, Math.toRadians(180.0)));
    }
    static void parkOnWall(TrajectoryBuilder builder){
        builder
                .splineTo(new Pose2d(0.0, 59.0, Math.toRadians(0.0)));
    }
    static void parkFromWall(TrajectoryBuilder builder){
        builder
                .splineTo(new Pose2d(0.0, 35.0, Math.toRadians(0.0)));
    }
    //Blue skystone 1 and 4 completed
    static Trajectory blueSkystoneAt4(TrajectoryBuilder builder1, ParkSide side){
        firstSkystone4(builder1, side);
        pullFoundation(builder1, side);
        stoneAt1(builder1, side);
        stoneAt6(builder1, side);
        stoneAt5(builder1, side);
        autoPark(builder1, side);
        return builder1.build();
    }
    //Blue skystone 2 and 5 completed
    static Trajectory blueSkystoneAt5(TrajectoryBuilder builder1, ParkSide side){
        firstSkystone5(builder1, side);
        pullFoundation(builder1, side);
        stoneAt2(builder1, side);
        stoneAt1(builder1, side);
        stoneAt6(builder1, side);
        autoPark(builder1, side);
        return builder1.build();
    }
    //Blue skystone 3 and 6 completed
    static Trajectory blueSkystoneAt6(TrajectoryBuilder builder1, ParkSide side){
        firstSkystone6(builder1, side);
        pullFoundation(builder1, side);
        stoneAt3(builder1, side);
        stoneAt2(builder1, side);
        stoneAt1(builder1, side);
        autoPark(builder1, side);
        return builder1.build();
    }
}
