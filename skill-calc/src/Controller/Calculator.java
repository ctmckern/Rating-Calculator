package Controller;

import java.io.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calculator {
    private PrintWriter out;
    private Scanner in;
    private double[] playerRatings;
    private int ratingsIndex = 0;
//Worth noting that logisticScalar is arbitrary and just used for stretching out the curve.
    private final double logisticScalar = 400;
    private final double mu = 0;
//Mu is the mean, and in this case called the location parameter. In Elo's case the mean is considered the opposing
//player's skill and the current player's distance is then measured against the scale of the model to determine
//likelihood that i>j

    public Calculator(){

    }

    private void setRatingFromUserInput (){
        String userInput = in.nextLine();
        playerRatings[ratingsIndex] = Double.parseDouble(userInput);
        ratingsIndex ++;
    }

    private double makeDenominator(double[]match){
        double b = (double)(match[0] - match[1])/logisticScalar;
        return Math.pow(10, b);
    }

    public double chanceToWin(double []match){
        double denominator = makeDenominator(match);
        return 1/(1+denominator);
    }


}
