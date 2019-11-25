package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.mecanum.SigmaDrive;
import org.firstinspires.ftc.teamcode.foundation.Foundation;

public class Robot {
    public SigmaDrive drive;

    public Robot(HardwareMap hardwareMap)
    {
        drive = new SigmaDrive(hardwareMap);
    }
}