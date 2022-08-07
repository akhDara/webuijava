package com.geekbrains.lesson4;

public class Triangle {
    public static double evaluateArea(double a, double b, double c) throws AreaOfTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new AreaOfTriangleException("Введены некорректные значения переменных");
        }

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p -c));

    }

}
