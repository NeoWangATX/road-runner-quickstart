package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.opmodes.OpMode;

public class Outtake {
    DoubleReverseFourbar lift;
    Virtual4Bar fourbar;
    OpMode opmode;

    public Outtake(HardwareMap hwMap)
    {
        lift = new DoubleReverseFourbar(hwMap);
        fourbar = new Virtual4Bar(hwMap);
    }

    public Outtake(HardwareMap hwMap, OpMode opmode)
    {
        lift = new DoubleReverseFourbar(hwMap);
        fourbar = new Virtual4Bar(hwMap);
        this.opmode = opmode;
    }


}
