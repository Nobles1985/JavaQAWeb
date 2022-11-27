package org.example;

public class Triangle {

    public  double square (int a, int b, int c) throws WrongSideException{
        if (a < 0 || b < 0 || c < 0) throw new WrongSideException ();
        if (a == 0 || b == 0 || c == 0) throw new NullSideException("Строна треугольника не можут быть 0!");
        int p = (a + b + c)/2;
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return Math.floor(S);
    }
}
