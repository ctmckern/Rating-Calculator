package Controller;

public class GlickoCalculator {

    public GlickoCalculator(){

    }

    //Note that the glicko system can accommodate arrays of matches
    private double base = 10.0;
    private double q = Math.log(base)/400;
    private double ratingDeviation = 350;
    private double rating = 1500;

    private double g(){
        return 1/Math.sqrt( ( 1 + (3*q*q) * (ratingDeviation*ratingDeviation) ) / Math.PI );
    }
    //To-do
    //Flesh out the d^2 formula(p and q are ready to go)
    //Get the r' and RD' methods worked out(not immediate since there is no persistence layer)


    //if probability/expectation is p then 1 - expectation is q
    //This leads d^2 to become q^2*g(RD)^2*p*q which is far more digestible than the full version of this
    public double expectation(double[] ratings){
        double a = ratings[0];
        double b = ratings[1];
        double skillDifference = (a - b)/400;
        double scalar = g() * -1;
        double scaledDifference = skillDifference * scalar;
        double denominator = 1 + Math.pow(10, scaledDifference);
        return 1/denominator;
    }

    public double expectationAgainst(double[] ratings){
        double expectedValue = expectation(ratings);
        return 1-expectedValue;
    }
}
