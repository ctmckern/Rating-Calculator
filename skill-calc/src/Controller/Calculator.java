package Controller;

/*
 */

import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calculator {
//    private int playerRating = 0;
//    private int[] match;
    private PrintWriter out;
    private Scanner in;
    private double[] playerRatings;
    private int ratingsIndex = 0;

//    private void setMatch(int playerRating, int playerCount){
//        match[playerCount] = playerRating;
//    }

    public Calculator(){

    }

    /*Currently an unused constructor

    public Calculator(InputStream input, OutputStream output){
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }
    Above is the unused constructor*/

    private void setRatingFromUserInput (){
        String userInput = in.nextLine();
        playerRatings[ratingsIndex] = Double.parseDouble(userInput);
        ratingsIndex ++;
    }

    public void displayPrompt(Object[] objects, int i){
        out.println("hello");
    }

    private double makeDenominator(double[]match){
        double b = (double)(match[0] - match[1])/400;
        return Math.pow(10, b);
    }

    public double chanceToWin(double []match){
        double denominator = makeDenominator(match);
        return 1/denominator;
    }


}
