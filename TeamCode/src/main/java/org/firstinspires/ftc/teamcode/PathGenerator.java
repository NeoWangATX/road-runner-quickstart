package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.path.heading.ConstantInterpolator;
import com.acmerobotics.roadrunner.path.heading.LinearInterpolator;
import com.acmerobotics.roadrunner.path.heading.SplineInterpolator;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import org.firstinspires.ftc.teamcode.elements.ParkSide;

public class PathGenerator {
    
    public static void firstSkystone4(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(-49.0, 30.0, Math.toRadians(300)), new SplineInterpolator(Math.toRadians(270), Math.toRadians(300)))
                .reverse()
                .splineTo(new Pose2d(-38.0, 42.0, Math.toRadians(180)), new SplineInterpolator(Math.toRadians(360), Math.toRadians(300)));
    }

    public static void firstSkystone5(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(-42.0, 29.0, Math.toRadians(300)), new SplineInterpolator(Math.toRadians(270), Math.toRadians(300)))
                .reverse()
                .splineTo(new Pose2d(-38.0, 42.0, Math.toRadians(180)), new SplineInterpolator(Math.toRadians(360), Math.toRadians(300)));
    }
    public static void firstSkystone6(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(-34.0, 29.0, Math.toRadians(300.0)), new SplineInterpolator(Math.toRadians(270.0), Math.toRadians(300.0)))
                .reverse()
                .splineTo(new Pose2d(-38.0, 42.0, Math.toRadians(180.0)), new SplineInterpolator(Math.toRadians(360.0), Math.toRadians(300.0)));
    }

    public static void pullFoundation(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(43.0, 35.0, Math.toRadians(180.0)), new SplineInterpolator(Math.toRadians(90.0), Math.toRadians(0.0)))
                .reverse()
                .lineTo(new Vector2d(38.0, 42.0), new LinearInterpolator(Math.toRadians(90.0), Math.toRadians(90.0)))
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
    }

    public static void stoneAt6(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(-20.0, 28.0, Math.toRadians(230.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)))
                .splineTo(new Pose2d(38.0, 42.0, Math.toRadians(180.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
    }

    public static void stoneAt5(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(-30.0, 28.0, Math.toRadians(230.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)))
                .splineTo(new Pose2d(38.0, 42.0, Math.toRadians(180.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
    }

    public static void stoneAt3(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(-43.0, 28.0, Math.toRadians(230.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)))
                .splineTo(new Pose2d(38.0, 42.0, Math.toRadians(180.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
    }
    public static void stoneAt2(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(-52.0, 28.0, Math.toRadians(220.0)), new SplineInterpolator(Math.toRadians(180.0), Math.toRadians(220.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)))
                .splineTo(new Pose2d(38.0, 42.0, Math.toRadians(180.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
    }
    public static void stoneAt1(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(-59.0, 28.0, Math.toRadians(220.0)), new SplineInterpolator(Math.toRadians(180.0), Math.toRadians(220.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)))
                .splineTo(new Pose2d(38.0, 42.0, Math.toRadians(180.0)))
                .reverse()
                .splineTo(new Pose2d(20.0, 35.0, Math.toRadians(180.0)));
    }
    public static void blueFoundation(TrajectoryBuilder builder1, ParkSide side){
        builder1
                .splineTo(new Pose2d(43.0, 35.0, Math.toRadians(270.0)), new SplineInterpolator(Math.toRadians(270.0), Math.toRadians(90.0)))
                .reverse()
                .lineTo(new Vector2d(38.0, 42.0), new LinearInterpolator(Math.toRadians(180.0), -Math.toRadians(90.0)));
        if (side == ParkSide.WALL) builder1.splineTo(new Pose2d(0.0, 59.0, Math.toRadians(0.0)), new ConstantInterpolator(Math.toRadians(180.0)));
        if (side == ParkSide.FROMWALL) builder1.splineTo(new Pose2d(0.0, 35.0, Math.toRadians(0.0)), new ConstantInterpolator(Math.toRadians(180.0)));
    }
    public static void autoPark(TrajectoryBuilder builder1){
        builder1
                .splineTo(new Pose2d(0.0, 35.0, Math.toRadians(180.0)));
    }
    public static void parkOnWall(TrajectoryBuilder builder){
        builder
                .splineTo(new Pose2d(0.0, 59.0, Math.toRadians(0.0)));
    }
    public static void parkFromWall(TrajectoryBuilder builder){
        builder
                .splineTo(new Pose2d(0.0, 35.0, Math.toRadians(0.0)));
    }
    //Blue skystone 1 and 4 completed
    public static TrajectoryBuilder blueSkystoneAt4(TrajectoryBuilder builder1){
        firstSkystone4(builder1);
        pullFoundation(builder1);
        stoneAt1(builder1);
        stoneAt6(builder1);
        stoneAt5(builder1);
        autoPark(builder1);
        return builder1;
    }
    //Blue skystone 2 and 5 completed
    public static TrajectoryBuilder blueSkystoneAt5(TrajectoryBuilder builder1){
        firstSkystone5(builder1);
        pullFoundation(builder1);
        stoneAt2(builder1);
        stoneAt1(builder1);
        stoneAt6(builder1);
        autoPark(builder1);
        return builder1;
    }
    //Blue skystone 3 and 6 completed
    public static TrajectoryBuilder blueSkystoneAt6(TrajectoryBuilder builder1){
        firstSkystone6(builder1);
        pullFoundation(builder1);
        stoneAt3(builder1);
        stoneAt2(builder1);
        stoneAt1(builder1);
        autoPark(builder1);
        return builder1;
    }
}