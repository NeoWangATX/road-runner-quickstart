package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.elements.Alliance;
import org.firstinspires.ftc.teamcode.elements.SkystoneState;
import org.firstinspires.ftc.teamcode.util.Detector;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(group="auto")
public class RedFront extends LinearOpMode {
    private Robot robot;
    private Detector detector;
    private OpenCvCamera camera;
    SkystoneState state = SkystoneState.UPPER;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap);
        //robot.drive

        robot.drive.setPoseEstimate(new Pose2d(-36.0,-62.75, Math.toRadians(0)));
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

        telemetry.addData("following path",state);
        telemetry.update();

        robot.drive.followTrajectorySync(
            RedPaths.getTrajectory(robot, SkystoneState.UPPER)
        );
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
