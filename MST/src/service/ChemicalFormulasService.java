package service;

public class ChemicalFormulasService {
    // TODO: 16.09.2020 kak blyat podlozhki na angliyskom
    private static final double DEPTH_OF_PROCESSING = 0.002;//глубина обработки
    private static final double PI = 3.14;
    private static final double SI_MOLAR_VOLUME = 12.1;
    private static final double HNO3_MOLAR_MASS = 63;
    private static final double HF_MOLAR_MASS = 20;
    private static final double HF_DENSITY = 0.99;
    private static final double HNO3_DENSITY = 1.5;

    public double calculateHFVolume(double diameter, double amountOfPodlozhki) {//считаем объем
        double siMolls = calculateMollsOfSi(diameter);
        double HFMolls = siMolls * 18;
        double HFMass = HFMolls * HF_MOLAR_MASS;
        return HFMass / HF_DENSITY * amountOfPodlozhki;
    }

    public double calculateHNO3Volume(double diameter, double amountOfPodlozhki) {//считаем объем
        double siMolls = calculateMollsOfSi(diameter);
        double HNO3Molls = siMolls * 4;
        double HNO3Mass = HNO3Molls * HNO3_MOLAR_MASS;
        return HNO3Mass / HNO3_DENSITY * amountOfPodlozhki;
    }

    private double calculateMollsOfSi(double diameter) {//считаем сколько выйдет молей кремния
        double radius = diameter / 2;
        double siVolume = radius * radius * PI * DEPTH_OF_PROCESSING;
        System.out.println("Si = " + siVolume);
        return siVolume / SI_MOLAR_VOLUME / 3;
    }
}
