package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.openftc.revextensions2.ExpansionHubMotor;

public class DoubleReverseFourbar {
    private ExpansionHubMotor liftOne; //the motor
    private final int MOTOR_LOWERBOUND_TICKS = 0; //lower limit
    private final int MOTOR_UPPERBOUND_TICKS = 780; //upper limit
    private final int TOTAL_EXTENSION = Math.abs(MOTOR_UPPERBOUND_TICKS - MOTOR_LOWERBOUND_TICKS); //total extension in ticks

    private final double DANGER_CONSTANT = 0.2; //percent / 100 extension where the motors should start slowing down to avoid damaging the robot
    private final double DANGER_SPEED_CONSTANT = 0.6; //scaling done when the robot is in the "danger zone"
    private final double SPEED_CONSTANT = 0.4; //general speed constant to scale the motor power maybe for testing

    public DoubleReverseFourbar(HardwareMap hwMap) //initialization
    {
        liftOne = hwMap.get(ExpansionHubMotor.class, "lift_motor");
        liftOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftOne.setDirection(DcMotorSimple.Direction.REVERSE);
        //liftOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void motorFloat() //floats the motor so it doesn't break at zero power
    {
        liftOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void resetEncoders()
    {
        liftOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void powerDriveTeleOp(double power, double gamepad) //drive for teleop
    {
        if(gamepad > 0.05)
        {
            liftOne.setTargetPosition(MOTOR_UPPERBOUND_TICKS);
            liftOne.setPower(gamepad * .8);
        }
        else if(gamepad < -0.05)
        {
            liftOne.setTargetPosition(MOTOR_LOWERBOUND_TICKS);
            liftOne.setPower(gamepad * .8);
        }
        else
        {
            liftOne.setPower(0);
        }
        /*
        if(dangerZone()) //if motor is past the extension
        {
            if(liftOne.getCurrentPosition() < MOTOR_LOWERBOUND_TICKS) //lower than functional
            {
                liftOne.setPower(SPEED_CONSTANT * Range.clip(gamepad, 0, 1)); //only allows upwards motion
            }
            else if(liftOne.getCurrentPosition() > MOTOR_UPPERBOUND_TICKS) //higher than functional
            {
                liftOne.setPower(SPEED_CONSTANT * Range.clip(gamepad, -1, 0)); //only allows downwards motion
            }
            else //normal function
            {
                liftOne.setPower(SPEED_CONSTANT * Range.clip(gamepad,-1,1)); //regular motion
            }
        }
        else
        {
            if(liftOne.getCurrentPosition() < MOTOR_LOWERBOUND_TICKS) //lower than functional
            {
                liftOne.setPower(DANGER_SPEED_CONSTANT * SPEED_CONSTANT * Range.clip(gamepad, 0, 1));
            }
            else if(liftOne.getCurrentPosition() > MOTOR_UPPERBOUND_TICKS) //higher than functional
            {
                liftOne.setPower(DANGER_SPEED_CONSTANT * SPEED_CONSTANT * Range.clip(gamepad, -1, 0));
            }
            else //normal function
            {
                liftOne.setPower(DANGER_SPEED_CONSTANT * SPEED_CONSTANT * Range.clip(gamepad,-1,1));
            }
        } */
    }

    public boolean dangerZone() //if motor is near its limit
    {
        return true;
        //return getExtensionDecimal() > 1 - DANGER_CONSTANT || getExtensionDecimal() < DANGER_CONSTANT; //returns whether or not it is in the zone
    }

    public double getExtensionDecimal() //returns a decimal [0,1] of how far the motor is extended
    {
        return liftOne.getCurrentPosition()/TOTAL_EXTENSION;
    }

    public double getMotorPosition() //returns the motor position
    {
        return liftOne.getCurrentPosition();
    }
}
