package Controller;

/*
 */

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
    private void getRatingFromUserInput (){
        String userInput = in.nextLine();
        playerRatings[ratingsIndex] = Double.parseDouble(userInput);
        ratingsIndex ++;
    }

    private void displayPrompt(Object[] objects, int i){
        out.println();
        out.print(System.lineSeparator() + objects[i]);
    }

    private double denominator(int[]match){
        double b = (double)(match[0] - match[1])/400;
        return Math.pow(10, b);
    }

    private double chanceToWin(double denominator){
        return 1/denominator;
    }
    public Calculator(InputStream input, OutputStream output){
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }
}
