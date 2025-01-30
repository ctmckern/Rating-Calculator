import Controller.Calculator;

import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Base {

    private Calculator calculator;

    private Scanner in = new Scanner(System.in);

    public Base() {

    }

    public Base(Calculator calculator) {
        this.calculator = calculator;
    }

    //Everything the program might say is held in this block of code
    private static final String MAIN_MENU_PLAYER1_RATING_PROMPT = "Please enter player one's rating.";
    private static final String MAIN_MENU_PLAYER2_RATING_PROMPT = "Please enter player two's rating.";
    private static final String MAIN_MENU_CHANCE_TO_WIN = "Player one's chance to win is:";
    private static final String MAIN_MENU_CHANCE_TO_LOSE = "Player two's chance to win is:";
    private static final String MAIN_MENU_POSSIBLE_WINS_OR_LOSSES = "If they win their rating will go up:";
    private static final String MAIN_MENU_POSSIBLE_LOSSES = "If they lose their rating will go down:";

    private static final String[] MAIN_MENU_PROMPTS = {MAIN_MENU_PLAYER1_RATING_PROMPT,
            MAIN_MENU_PLAYER2_RATING_PROMPT, MAIN_MENU_CHANCE_TO_WIN, MAIN_MENU_CHANCE_TO_LOSE,
            MAIN_MENU_POSSIBLE_WINS_OR_LOSSES, MAIN_MENU_POSSIBLE_LOSSES};
    //This marks the end of the block of code containing everything the program says.

    int i;
    private double rating;
    private static double[] ratingArray;
    private double expectation;
    //kFactor variable below will be arbitrary 24. There is a formula for calculating but it's impractical here.
    private int[] kFactors = {16,24,32};
    private DecimalFormat defo = new DecimalFormat("#.##");
    //Note the Elo expectation formula is logistic with base 10 where x = rating R of player a (Ra)
    //Minus rating R of player b (Rb) divided by 400. This becomes 1/(1+10^((Rb-Ra)/400)

    //http://www.glicko.net/ratings/approx.pdf   use this for referring to skill ratings.

    /*
    To do
    Transfer pointsToGain to calculator class(after I'm sure it works though)
    Work on setting up extensions to calculator for specific skill rating algorithms
    Develop more prompts for readability and communication
     */

    private void getRatingFromUserInput(double[] ratings, int index) {
        String input = in.nextLine();
        rating = Double.parseDouble(input);
        ratings[index] = rating;
        System.out.println();
    }

    //pointsToGain should probably be in Calculator
    //https://rpubs.com/riazakhan94/logstcdistbasics Some basic info on the logistic distribution
    //which is what the Elo rating system uses
    private double pointsToGain(double[]ratings, int kFactorIndex, double expectedScore, double actualScore){
        double a = ratings[0];
        double b = ratings[1];
        double results = actualScore - expectedScore;
        return kFactors[kFactorIndex] * results;
    }

    private void setRatingArray(double[] Ratings, int index, double rating){
        Ratings[index] = rating;
    }

    private void displayRatings(double[] ratings) {
        for (int n = 0; n < ratings.length; n++) {
            int printableIndex = n+1;
            System.out.println("Player " + printableIndex  + "'s rating is: " + ratings[n]);
        }
    }

    private void displayPrompt(int index) {
        index ++;
        System.out.println("Please enter player " + index + "'s rating >>");
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int i = 0;
        Base cli = new Base(calc);
        double[] ratingArray = new double[2];
        while (i < 2) {
            cli.displayPrompt(i);
            cli.getRatingFromUserInput(ratingArray, i);
            i++;
        }
        cli.displayRatings(ratingArray);
        //This is also clunky, trying to get a clean percentage that I can communicate.
        System.out.println();
        System.out.println(Double.parseDouble(cli.defo.format(cli.calculator.chanceToWin(ratingArray)))*100);
        //This below is clunky, I'll need to clean it up.
        System.out.println();
        System.out.println(cli.defo.format(cli.pointsToGain(ratingArray,
                0,cli.calculator.chanceToWin(ratingArray), 1)) +
                " points will be gained on a win.");
    }
}
