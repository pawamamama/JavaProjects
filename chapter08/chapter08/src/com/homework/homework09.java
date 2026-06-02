package com.homework;

public class homework09 {
}
class Point {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
class LabeledPoint extends Point {//标记点
    private String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }
}