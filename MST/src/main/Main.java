package main;

import service.ChemicalFormulasService;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        ChemicalFormulasService service = new ChemicalFormulasService();
        double diameter = 4;
        double amountOfPodlozhki = 100;
            System.out.print("Diameter(sm) - ");
            diameter = inputDouble("Diameter");
            System.out.print("amount of podlozhki - ");
            amountOfPodlozhki = inputDouble("qwe");
        double HFVolume = service.calculateHFVolume(diameter, amountOfPodlozhki);
        double HNO3Volume = service.calculateHNO3Volume(diameter, amountOfPodlozhki);

        System.out.println("Si = " + );
        System.out.println("HF  = " + HFVolume + "\tHNO3  = " + HNO3Volume);

    }

    public static double inputDouble (String letter)
    {
        Scanner in = new Scanner(System.in);
        double numberDouble;
        //System.out.println("Input " + letter);
        numberDouble = in.nextDouble();
        return numberDouble;
    }

}





