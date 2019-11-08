package org.firstinspires.ftc.teamcode.util;

public class MathUtil {
    public static boolean approxEqual(int tolerance, int a, int b)
    {
        return Math.abs(a - b) <= tolerance;
    }
}
