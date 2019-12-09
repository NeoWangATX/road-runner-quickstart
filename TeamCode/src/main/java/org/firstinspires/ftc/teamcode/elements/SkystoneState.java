package org.firstinspires.ftc.teamcode.elements;

public enum SkystoneState {
    UPPER(2),
    MIDDLE(1),
    LOWER(0);

    public static double SKYSTONE_LENGTH = 8;
    public static double SKYSTONE_WIDTH = 4;
    public static double FIELD_RADIUS = 141 / 2.0;

    // Distance to center
    public static double ABS_SKYSTONE_Y_DIST = FIELD_RADIUS - 49;

    public int index;
    SkystoneState(final int index) { this.index = index; }

    public double y() {
        return ABS_SKYSTONE_Y_DIST;
    }

    public double upperX() {
        return lowerX() + SKYSTONE_LENGTH * 3;
    }

    public double lowerX() {
        return -FIELD_RADIUS + (index + 0.5) * SKYSTONE_LENGTH;
    }
}