package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.util.MathUtil;
import org.openftc.revextensions2.ExpansionHubMotor;

public class Outtake {
    ExpansionHubMotor liftOne; //the motor on the left
    ExpansionHubMotor liftTwo; //the motor on the right
    private CRServo liftHorizontalOne; //vex motor controlling horizontal
    private CRServo liftHorizontalTwo; //other one

    private final int[] LIFT_POSITIONS = {0,0,0,0,0,0,0,0,0,0,0}; // TODO: fill these with the respective skystones positions
    private int outtakeCount = 0; //the amount of times the robot has outtake aka what level of skystones the robot is on
    private double SPOOL_SIZE_IN = 3.3; //spool size (in)
    private int TICKS_PER_REV = 7; //ticks per revolution (gobilda 5.2 motor)

    private double DISTANCE_ABOVE_GROUND_IN = 1; //distance the outtake is above the ground measuring from the bottom plate without moving
    private double VERTICAL_POSITION = DISTANCE_ABOVE_GROUND_IN; //distance the outtake is above the ground at any given moment.

    public Outtake()
    {

    }

    public Outtake(HardwareMap hwMap) //initializes the full outtake
    {
        liftOne = hwMap.get(ExpansionHubMotor.class, "lift_one");
        liftTwo = hwMap.get(ExpansionHubMotor.class, "lift_two");
        liftHorizontalOne = hwMap.get(CRServo.class, "horizontal_one");
        liftHorizontalTwo = hwMap.get(CRServo.class, "horizontal_two");
        /* inwardLimit = hwMap.get(TouchSensor.class, "inward_limit");
        outwardLimit = hwMap.get(TouchSensor.class, "outward_limit"); */

        liftOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftTwo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void initOnlyMotors(HardwareMap hwMap) //intializes only the motors for testing and with power control
    {
        liftOne = hwMap.get(ExpansionHubMotor.class, "lift_one");
        liftTwo = hwMap.get(ExpansionHubMotor.class, "lift_two");

        liftOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        liftOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void updateOuttake() //updates the vertical position and calculations are simple dimensional analysis
    {
        VERTICAL_POSITION = liftOne.getCurrentPosition() * TICKS_PER_REV * (Math.PI * SPOOL_SIZE_IN) + DISTANCE_ABOVE_GROUND_IN;
    }

    public double getVerticalPosition() //self explanatory
    {
        return VERTICAL_POSITION;
    }

    public boolean outtake(double speed) //performs an outtake cycle on the respective outtake count
    {
        liftOne.setTargetPosition(LIFT_POSITIONS[outtakeCount]); //sets it to the respective lift position
        liftTwo.setTargetPosition(LIFT_POSITIONS[outtakeCount]);

        liftOne.setPower(speed);
        liftTwo.setPower(speed);

        while(liftOne.isBusy() && !MathUtil.approxEqual(5, liftOne.getCurrentPosition(), LIFT_POSITIONS[outtakeCount]));
        {
            updateOuttake();
        }

        horizontalExtension(true); //extends the horizontal extension outwards

        liftOne.setTargetPosition(LIFT_POSITIONS[outtakeCount] + 100);
        liftTwo.setTargetPosition(LIFT_POSITIONS[outtakeCount] + 100);

        while(liftOne.isBusy() && !MathUtil.approxEqual(5, liftOne.getCurrentPosition(), LIFT_POSITIONS[outtakeCount]));
        {
            updateOuttake();
        }

        horizontalExtension(false); //retracts the horizontal extensions

        //TODO: make the lift go down and up like the motions the power stackers shown

        outtakeCount++; //raises the next deposit cycles level by 1

        return true;
    }

    public boolean horizontalExtension(boolean outwards) //depending on outwards or not the horizontal extension moves until it hits the respective limit switch
    {
        if(outwards) {
            liftHorizontalOne.setPower(1);
            liftHorizontalTwo.setPower(1);

            return true;
        }
        else {
            liftHorizontalOne.setPower(-1);
            liftHorizontalTwo.setPower(-1);

            return true;
        }
    }

}
