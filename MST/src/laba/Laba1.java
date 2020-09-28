package laba;

import java.util.Scanner;

public class Laba1 {
    private static final double k0 = 6E-5;
    private static final double SI_DENSITY = 2.57;


public void Laba1(){
    final double x = inputDouble("X"); //материал тигея растворилось см3
    final double y = inputDouble("Y"); //кол-во в массе г
    final double z = inputDouble("Z") * 10E18; // концентрация железа в материале
    final double p = inputDouble("P") / 100; //доля закристализававшегося материала затрвочная часть
    final double r = inputDouble("R") / 100; //доля закристализававшегося материала хвостовая часть
    final double c0 = (x * z) / (x + y / SI_DENSITY); // исходная концентрация
    final var resultTop = calculate(c0, p);
    final var resultBot = calculate(c0, r);
        System.out.println("Top: " + resultTop + "\nBottom: " + resultBot );
}


    private static double calculate ( final double c0, final double percentage){
        return k0 * c0 * Math.pow(1 - percentage, k0 - 1);
    }

    public static double inputDouble (String letter)
    {
        Scanner in = new Scanner(System.in);
        double numberDouble;
        System.out.println("Input " + letter);
        numberDouble = in.nextDouble();
        return numberDouble;
    }
}
