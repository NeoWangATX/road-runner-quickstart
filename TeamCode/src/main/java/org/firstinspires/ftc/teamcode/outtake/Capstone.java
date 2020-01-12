package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.openftc.revextensions2.ExpansionHubServo;

public class Capstone {
    private ExpansionHubServo capstone;

    public Capstone(HardwareMap hwMap)
    {
        capstone = hwMap.get(ExpansionHubServo.class, "capstone");
    }
}
