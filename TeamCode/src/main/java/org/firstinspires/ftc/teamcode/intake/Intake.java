package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.opmodes.OpMode;
import org.openftc.revextensions2.ExpansionHubMotor;

public class Intake {
    private Gamepad gamepad;
    private ExpansionHubMotor leftMotor;
    private ExpansionHubMotor rightMotor;
    private LinearOpMode opMode;

    public Intake(HardwareMap hwMap)
    {
        leftMotor = hwMap.get(ExpansionHubMotor.class, "intake_left");
        rightMotor = hwMap.get(ExpansionHubMotor.class, "intake_right");

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public Intake(HardwareMap hwMap, LinearOpMode opMode)
    {
        this(hwMap);
        this.opMode = opMode;
    }

    public void setGamepad(Gamepad gamepad)
    {
        this.gamepad = gamepad;
    }

    public void driveTeleOp()
    {
        if(gamepad.right_bumper)
        {
            this.intakeOn();
        }
        else if(gamepad.left_bumper)
        {
            this.reverseIntake();
        }
        else
        {
            this.intakeOff();
        }
    }

    public void floatIntake()
    {
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
        leftMotor.setPower(1);
        rightMotor.setPower(1);
    }

    public void intakeOff()
    {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public void reverseIntake()
    {
        leftMotor.setPower(-1);
        rightMotor.setPower(-1);
    }

    public boolean isOn()
    {
        return leftMotor.getPower() <= 0.05;
    }
}
