package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.path.heading.ConstantInterpolator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drive.localizer.StandardTrackingWheelLocalizer;
import org.firstinspires.ftc.teamcode.drive.mecanum.SigmaDrive;
import org.firstinspires.ftc.teamcode.elements.Alliance;
import org.firstinspires.ftc.teamcode.elements.SkystoneState;
import org.firstinspires.ftc.teamcode.util.Detector;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import kotlin.Unit;

@Autonomous(group="auto")
public class BlueFront extends LinearOpMode {
    private Robot robot;
    SigmaDrive drive;
    private Detector detector;
    private OpenCvCamera camera;
    SkystoneState state = SkystoneState.UPPER;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap);
        drive = new SigmaDrive(hardwareMap);
        startCameraDetection(Alliance.BLUE);

        telemetry.addData("Initialized","");
        telemetry.update();

        /* while(!opModeIsActive() && !isStopRequested())
        {
            state = detector.getSkystoneState();
            telemetry.addData("SkyStone position: ", state);
            telemetry.update();

            sleep(50);
        } */
        waitForStart();

        state = detector.getSkystoneState();

        robot.intake.floatIntake();

        stopCameraDetection();

        telemetry.addData("following path",SkystoneState.UPPER);
        telemetry.update();
        drive.setLocalizer(new StandardTrackingWheelLocalizer(hardwareMap));
        drive.setPoseEstimate(new Pose2d(-36.0,62.75, Math.toRadians(180.0)));

        drive.followTrajectorySync(
            drive.trajectoryBuilder()
                    .lineTo(new Vector2d(-20.0, 37.0), new ConstantInterpolator(Math.toRadians(180.0))) //start strafe
                    .splineTo(new Pose2d(-24.0,26.0,Math.toRadians(225.0))).reverse() //first stone
                    .splineTo(new Pose2d(-5.0,34.0,Math.toRadians(90.0))).reverse()
                    .lineTo(new Vector2d(50.0,32.5), new ConstantInterpolator(Math.toRadians(90.0))) //marker for foundation
                    .splineTo(new Pose2d(50.0,37.0,Math.toRadians(90.0))) //release hooks //deploy stone 1
                    .splineTo(new Pose2d(30.0,48.0,Math.toRadians(180.0)))
                    .lineTo(new Vector2d(20.0,34.0),new ConstantInterpolator(Math.toRadians(180.0)))
                    .splineTo(new Pose2d(-47.0,27.0,Math.toRadians(225.0))).reverse()
                    .splineTo(new Pose2d(24.0,36.0,Math.toRadians(180.0))).reverse()
                    .lineTo(new Vector2d(38.0,50.5),new ConstantInterpolator(Math.toRadians(180.0))) //deploy stone 2
                    .lineTo(new Vector2d(20.0,34.0),new ConstantInterpolator(Math.toRadians(180.0)))
                    .splineTo(new Pose2d(-32.0,24.0,Math.toRadians(225.0))).reverse()
                    .splineTo(new Pose2d(20.0,36.0,Math.toRadians(180.0)))
                    .lineTo(new Vector2d(38.0,50.5),new ConstantInterpolator(Math.toRadians(180.0))) //deploy stone 3
                    .lineTo(new Vector2d(0.0,34.0),new ConstantInterpolator(Math.toRadians(180.0)))
                    .build()
        );
                /* robot.drive.trajectoryBuilder()
                        .addMarker(() -> {
                            robot.intake.intakeOn();
                            return Unit.INSTANCE;
                        })
                        .lineTo(new Vector2d(-20.0, 37.0), new ConstantInterpolator(Math.toRadians(180.0))) //start strafe
                        .addMarker(() -> {
                            //robot.drive.setSlow(true);
                            return Unit.INSTANCE;
                        })
                        .splineTo(new Pose2d(-24.0,26.0,Math.toRadians(225.0))).reverse() //first stone
                        .addMarker(() -> {
                            //robot.drive.setSlow(false);
                            return Unit.INSTANCE;
                        })
                        .splineTo(new Pose2d(-5.0,34.0,Math.toRadians(90.0))).reverse()
                        .lineTo(new Vector2d(50.0,32.5), new ConstantInterpolator(Math.toRadians(90.0))) //marker for foundation
                        .addMarker(() -> {
                            robot.foundation.deployForks();
                            //deploy hooks
                            return Unit.INSTANCE;
                        })
                        .splineTo(new Pose2d(50.0,37.0,Math.toRadians(90.0))) //release hooks //deploy stone 1
                        .addMarker(() -> {
                            robot.foundation.retractForks();
                            //release hooks and deploy stone 1
                            return Unit.INSTANCE;
                        })
                        .splineTo(new Pose2d(30.0,48.0,Math.toRadians(180.0)))
                        .lineTo(new Vector2d(20.0,34.0),new ConstantInterpolator(Math.toRadians(180.0)))
                        .splineTo(new Pose2d(-47.0,27.0,Math.toRadians(225.0))).reverse()
                        .splineTo(new Pose2d(24.0,36.0,Math.toRadians(180.0))).reverse()
                        .lineTo(new Vector2d(38.0,50.5),new ConstantInterpolator(Math.toRadians(180.0))) //deploy stone 2
                        .addMarker(() -> {
                            //deploy v4b
                            return Unit.INSTANCE;
                        })
                        .lineTo(new Vector2d(20.0,34.0),new ConstantInterpolator(Math.toRadians(180.0)))
                        .splineTo(new Pose2d(-32.0,24.0,Math.toRadians(225.0))).reverse()
                        .splineTo(new Pose2d(20.0,36.0,Math.toRadians(180.0)))
                        .lineTo(new Vector2d(38.0,50.5),new ConstantInterpolator(Math.toRadians(180.0))) //deploy stone 3
                        .addMarker(() -> {
                            //deploy stone 3
                            return Unit.INSTANCE;
                        })
                        .lineTo(new Vector2d(0.0,34.0),new ConstantInterpolator(Math.toRadians(180.0)))
                        .build()
        ); */
    }

    public void startCameraDetection(Alliance alliance)
    {
        int cameraMonitorViewId = hardwareMap.appContext.getResources()
                .getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        this.camera = new OpenCvInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
        camera.openCameraDevice();
        this.detector = new Detector(alliance);
        this.detector.useDefaults();
        camera.setPipeline(detector);
        camera.startStreaming(320, 240, OpenCvCameraRotation.SIDEWAYS_LEFT);
    }

    public void stopCameraDetection()
    {
        camera.stopStreaming();
    }
}
