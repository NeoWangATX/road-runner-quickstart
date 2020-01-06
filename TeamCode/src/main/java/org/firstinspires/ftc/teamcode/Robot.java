package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.mecanum.SigmaDrive;
import org.firstinspires.ftc.teamcode.foundation.Foundation;
import org.firstinspires.ftc.teamcode.intake.Intake;
import org.firstinspires.ftc.teamcode.opmodes.OpMode;
import org.firstinspires.ftc.teamcode.outtake.DoubleReverseFourbar;

public class Robot {
    public SigmaDrive drive;
    public Intake intake;
    public DoubleReverseFourbar dr4b;

    public Robot(HardwareMap hardwareMap)
    {
        drive = new SigmaDrive(hardwareMap);
        intake = new Intake(hardwareMap);
        dr4b = new DoubleReverseFourbar(hardwareMap);
    }

    public Robot(HardwareMap hardwareMap, LinearOpMode opMode)
    {
        drive = new SigmaDrive(hardwareMap, opMode);
        intake = new Intake(hardwareMap, opMode);
        dr4b = new DoubleReverseFourbar(hardwareMap);
    }
}