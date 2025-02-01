package Controller;

import java.io.*;

public class Calculator {
    private double[] playerRatings;
    private int ratingsIndex = 0;
//Worth noting that logisticScalar is arbitrary and just used for stretching out the curve.
    private final double logisticScalar = 400;
    private final double mu = 0;
    private int[] kFactors = {16,24,32};
//Mu is the mean, and in this case called the location parameter. In Elo's case the mean is considered the opposing
//player's skill and the current player's distance is then measured against the scale of the model to determine
//likelihood that i>j

    public Calculator(){

    }

    private double makeDenominator(double[]match){
        double b = (double)(match[0] - match[1])/logisticScalar;
        return Math.pow(10, b);
    }

    public double chanceToWin(double []match){
        double denominator = makeDenominator(match);
        return 1/(1+denominator);
    }

    public double pointsToGain(double[]ratings, double expectedScore, double actualScore){
        double a = ratings[0];
        double b = ratings[1];
        int kFactor = 0;
        if (a > 2400){
            kFactor = 16;
        }
        else if (a < 2100){
            kFactor = 32;
        }
        else {
            kFactor = 24;
        }
        double results = actualScore - expectedScore;
        return kFactor * results;
    }


}
