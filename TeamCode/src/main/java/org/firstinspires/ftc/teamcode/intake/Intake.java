package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.openftc.revextensions2.ExpansionHubMotor;

public class Intake {
    private ExpansionHubMotor leftMotor;
    private ExpansionHubMotor rightMotor;

    public Intake(HardwareMap hwMap)
    {
        leftMotor = hwMap.get(ExpansionHubMotor.class, "left_motor");
        rightMotor = hwMap.get(ExpansionHubMotor.class, "right_motor");

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void testIntake()
    {
        leftMotor.setPower(.1);
        rightMotor.setPower(.1);
    }

    public void intakeOn()
    {
        leftMotor.setPower(.5);
        rightMotor.setPower(.5);
    }

    public void intakeOff()
    {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public void reverseIntake()
    {
        leftMotor.setPower(-.5);
        rightMotor.setPower(-.5);
    }

    public boolean isOn()
    {
        return leftMotor.getPower() <= 0.05;
    }
}
