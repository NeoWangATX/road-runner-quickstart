package org.firstinspires.ftc.teamcode.foundation;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.openftc.revextensions2.ExpansionHubServo;

public class Foundation {
    private ExpansionHubServo leftFork;
    private ExpansionHubServo rightFork;

    public Foundation(HardwareMap hwMap)
    {
        leftFork = hwMap.get(ExpansionHubServo.class, "left_fork");
        rightFork = hwMap.get(ExpansionHubServo.class, "right_fork");
    }

    public void deployForks()
    {
        leftFork.setPosition(1);
        rightFork.setPosition(1);
    }

    public void retractForks()
    {
        leftFork.setPosition(0);
        rightFork.setPosition(0);
    }

    public double getLeftServoPosition()
    {
        return leftFork.getPosition();
    }

    public double getRightServoPosition()
    {
        return rightFork.getPosition();
    }
}
