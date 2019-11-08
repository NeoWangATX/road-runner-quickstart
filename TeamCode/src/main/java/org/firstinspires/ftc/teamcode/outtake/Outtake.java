package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.util.MathUtil;
import org.openftc.revextensions2.ExpansionHubMotor;

public class Outtake {
    private ExpansionHubMotor liftOne;
    private ExpansionHubMotor liftTwo;
    private CRServo liftHorizontalOne;
    private CRServo liftHorizontalTwo;
    private TouchSensor inwardLimit;
    private TouchSensor outwardLimit;

    private final int[] LIFT_POSITIONS = {0,0,0,0,0,0,0,0,0,0,0};
    private int outtakeCount = 0;
    private int EXTENSION_MAX = 5000;
    private double SPOOL_SIZE_IN = 3.3;

    public Outtake(HardwareMap hwMap)
    {
        liftOne = hwMap.get(ExpansionHubMotor.class, "lift_one");
        liftTwo = hwMap.get(ExpansionHubMotor.class, "lift_two");
        liftHorizontalOne = hwMap.get(CRServo.class, "horizontal_one");
        liftHorizontalTwo = hwMap.get(CRServo.class, "horizontal_two");

        liftOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftTwo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public boolean outtake(double speed)
    {
        liftOne.setTargetPosition(LIFT_POSITIONS[outtakeCount]);
        liftTwo.setTargetPosition(LIFT_POSITIONS[outtakeCount]);

        liftOne.setPower(speed);
        liftTwo.setPower(speed);

        while(liftOne.isBusy() && !MathUtil.approxEqual(5, liftOne.getCurrentPosition(), LIFT_POSITIONS[outtakeCount]));
        {

        }

        horizontalExtension(true);

        liftOne.setTargetPosition(LIFT_POSITIONS[outtakeCount] + 100);
        liftTwo.setTargetPosition(LIFT_POSITIONS[outtakeCount] + 100);

        while(liftOne.isBusy() && !MathUtil.approxEqual(5, liftOne.getCurrentPosition(), LIFT_POSITIONS[outtakeCount]));
        {

        }

        horizontalExtension(false);

        outtakeCount++;

        return true;
    }

    public boolean horizontalExtension(boolean outwards)
    {
        if(outwards) {
            liftHorizontalOne.setPower(1);
            liftHorizontalTwo.setPower(1);

            while(!outwardLimit.isPressed())
            {

            }

            return true;
        }
        else {
            liftHorizontalOne.setPower(-1);
            liftHorizontalTwo.setPower(-1);

            while(!inwardLimit.isPressed())
            {

            }

            return true;
        }
    }

}
