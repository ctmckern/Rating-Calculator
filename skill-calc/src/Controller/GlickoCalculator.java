package Controller;

public class GlickoCalculator {

    public GlickoCalculator(){

    }

    private double base = 10.0;
    private double q = Math.log(base)/400;
    private double ratingDeviation = 350;
    private double rating = 1500;

    private double g(){
        return 1/Math.sqrt( ( 1 + (3*q*q) * (ratingDeviation*ratingDeviation) ) / Math.PI );
    }

    public double expectation(double[] ratings){
        double a = ratings[0];
        double b = ratings[1];
        double skillDifference = (a - b)/400;
        double scalar = g() * -1;
        double scaledDifference = skillDifference * scalar;
        double denominator = 1 + Math.pow(10, scaledDifference);
        return 1/denominator;
    }
}
