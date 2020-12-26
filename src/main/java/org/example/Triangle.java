package org.example;

public class Triangle {

    public static double triangleArea( int a, int b, int c )
    {
        double pp = (a + b + c) / 2.0;  // полупериметр
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c)); // по формуле Герона
    }
}
