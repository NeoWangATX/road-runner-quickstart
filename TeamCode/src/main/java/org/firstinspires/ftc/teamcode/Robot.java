package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.mecanum.SigmaDrive;
import org.firstinspires.ftc.teamcode.foundation.Foundation;
import org.firstinspires.ftc.teamcode.intake.Intake;
import org.firstinspires.ftc.teamcode.opmodes.OpMode;

public class Robot {
    public SigmaDrive drive;
    public Intake intake;

    public Robot(HardwareMap hardwareMap)
    {
        drive = new SigmaDrive(hardwareMap);
        intake = new Intake(hardwareMap);
    }

    public Robot(HardwareMap hardwareMap, LinearOpMode opMode)
    {
        drive = new SigmaDrive(hardwareMap, opMode);
        intake = new Intake(hardwareMap, opMode);
    }
}