package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.opmodes.OpMode;
import org.openftc.revextensions2.ExpansionHubServo;

public class Virtual4Bar {
    OpMode opmode;
    Gamepad gamepad;
    ExpansionHubServo armServo;
    ExpansionHubServo gripperServo;

    public Virtual4Bar(HardwareMap hwMap)
    {
        armServo = hwMap.get(ExpansionHubServo.class, "arm_servo");
        gripperServo = hwMap.get(ExpansionHubServo.class, "gripper_servo");
    }

    public void setGamepad(Gamepad gamepad)
    {
        this.gamepad = gamepad;
    }

    public Virtual4Bar(HardwareMap hwMap, OpMode opmode)
    {
        this(hwMap);
        this.opmode = opmode;
    }

    public Virtual4Bar(HardwareMap hwMap, Gamepad gamepad)
    {
        this(hwMap);
        this.gamepad = gamepad;
    }

    public void driveTeleOp()
    {
        if(gamepad.dpad_up)
        {
            armServo.setPosition(1);
        }
        else if(gamepad.dpad_down)
        {
            armServo.setPosition(0);
        }
        else if(gamepad.x)
        {
            armServo.setPosition(.2);
        }
        else if(gamepad.y)
        {
            armServo.setPosition(.8);
        }
        else if(gamepad.dpad_left)
        {
            gripperServo.setPosition(1);
        }
        else if(gamepad.dpad_right)
        {
            gripperServo.setPosition(0);
        }

        /* if(Math.abs(gamepad.left_stick_y) > 0.05)
        {
            armServo.setPosition(armServo.getPosition() + gamepad.left_stick_y / 2);
        } */
    }

    public void outtake()
    {
        armServo.setPosition(1);

        while(opmode.opModeIsActive() && armServo.getPosition() <= .9)
        {
            ;
        }

        gripperServo.setPosition(0);
    }

    public void intake()
    {
        armServo.setPosition(0);

        while(opmode.opModeIsActive() && armServo.getPosition() >= .1)
        {
            ;
        }

        gripperServo.setPosition(1);
    }
}
