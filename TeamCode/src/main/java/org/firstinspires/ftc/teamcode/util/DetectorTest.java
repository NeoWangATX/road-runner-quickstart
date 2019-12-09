package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.elements.Alliance;
import org.firstinspires.ftc.teamcode.opmodes.OpMode;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@TeleOp(group="vision")
public class DetectorTest extends LinearOpMode {

    Detector detector;
    OpenCvCamera camera;

    @Override
    public void runOpMode() throws InterruptedException {
        startCameraDetection(Alliance.BLUE);

        waitForStart();

        while(opModeIsActive())
        {
            telemetry.addData("Position:", detector.getSkystoneState());
            telemetry.update();
        }
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
