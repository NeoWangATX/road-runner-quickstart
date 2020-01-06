package org.firstinspires.ftc.teamcode.drive.localizer;

import android.support.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.localization.ThreeTrackingWheelLocalizer;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.openftc.revextensions2.ExpansionHubEx;
import org.openftc.revextensions2.ExpansionHubMotor;
import org.openftc.revextensions2.RevBulkData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Sample tracking wheel localizer implementation assuming the standard configuration:
 *
 *    /--------------\
 *    |     ____     |
 *    |     ----     |
 *    | ||        || |
 *    | ||        || |
 *    |              |
 *    |              |
 *    \--------------/
 *
 * Note: this could be optimized significantly with REV bulk reads
 */
@Config
public class StandardTrackingWheelLocalizer extends ThreeTrackingWheelLocalizer {
    public static double TICKS_PER_REV = 8192;
    public static double WHEEL_RADIUS = 1; // in
    public static double GEAR_RATIO = 1; // output (wheel) speed / input (encoder) speed

    public static double LATERAL_DISTANCE = 14.74; // in; distance between the left and right wheels
    public static double LATERAL_OFFSET = 2.29; // in; left and right wheel distance from center
    public static double FORWARD_OFFSET = 6.13; // in; offset of the lateral wheel

    private ExpansionHubMotor leftEncoder, rightEncoder, frontEncoder;
    private ExpansionHubEx hub;
    private List<ExpansionHubMotor> encoders;

    public StandardTrackingWheelLocalizer(HardwareMap hardwareMap) {
        super(Arrays.asList(
                new Pose2d(LATERAL_OFFSET, LATERAL_DISTANCE / 2, 0), // left
                new Pose2d(LATERAL_OFFSET, -LATERAL_DISTANCE / 2, 0), // right
                new Pose2d(FORWARD_OFFSET, 2.96, Math.toRadians(90)) // front
        ));

        hub = hardwareMap.get(ExpansionHubEx.class,"hub2");

        leftEncoder = hardwareMap.get(ExpansionHubMotor.class,"intake_right");
        leftEncoder.setDirection(DcMotorSimple.Direction.REVERSE);
        rightEncoder = hardwareMap.get(ExpansionHubMotor.class,"middle");
        rightEncoder.setDirection(DcMotorSimple.Direction.FORWARD);
        frontEncoder = hardwareMap.get(ExpansionHubMotor.class,"intake_left");
        frontEncoder.setDirection(DcMotorSimple.Direction.FORWARD);
        encoders = Arrays.asList(leftEncoder,rightEncoder,frontEncoder);
    }

    public static double encoderTicksToInches(int ticks) {
        return WHEEL_RADIUS * 2 * Math.PI * GEAR_RATIO * ticks / TICKS_PER_REV;
    }

    @NonNull
    @Override
    public List<Double> getWheelPositions() {
        RevBulkData bulkData = hub.getBulkInputData();

        if(bulkData == null)
        {
            return Arrays.asList(0.0,0.0,0.0);
        }

        List<Double> wheelPositions = new ArrayList<>();
        for (ExpansionHubMotor encoder : encoders) {
            wheelPositions.add(encoderTicksToInches(bulkData.getMotorCurrentPosition(encoder)));
            //wheelPositions.add(bulkData.getMotorCurrentPosition(motor) + 0.0);
        }

        return wheelPositions;
    }
}
