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

//    private static final String MAIN_MENU_PLAYER1_RATING_PROMPT = "Please enter player one's rating.";
//    private static final String MAIN_MENU_PLAYER2_RATING_PROMPT = "Please enter player two's rating.";
//    private static final String MAIN_MENU_CHANCE_TO_WIN = "Player one's chance to win is:";
//    private static final String MAIN_MENU_CHANCE_TO_LOSE = "Player two's chance to win is:";
//    private static final String MAIN_MENU_POSSIBLE_WINS_OR_LOSSES = "If they win their rating will go up:";
//    private static final String MAIN_MENU_POSSIBLE_LOSSES = "If they lose their rating will go down:";
//
//    private static final String[] MAIN_MENU_PROMPTS = {MAIN_MENU_PLAYER1_RATING_PROMPT,
//            MAIN_MENU_PLAYER2_RATING_PROMPT, MAIN_MENU_CHANCE_TO_WIN, MAIN_MENU_CHANCE_TO_LOSE,
//            MAIN_MENU_POSSIBLE_WINS_OR_LOSSES, MAIN_MENU_POSSIBLE_LOSSES};

    int i;
    private double rating;
    private static double[] ratingArray;
    private double expectation;
    //Need to move kFactor array to calculator class.
    private int[] kFactors = {16,24,32};
    //When formatting remember DecimalFormat.format returns a string you will need to cast back to a double
    private DecimalFormat defo = new DecimalFormat("#.##");
    //http://www.glicko.net/ratings/approx.pdf   use this for referring to skill ratings.

    /*
    To do
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

    private void displayChances(double formattedChance){
        System.out.println();
        System.out.println("Player one has a " + formattedChance + "% chance to win.");
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

        double chance = cli.calculator.chanceToWin(ratingArray);
        double formattedChance = Double.parseDouble(cli.defo.format(chance))*100;
        //actualScore is hardcoded, might be better if I make a prompt for more accurate flexibility
        double pointsToGain = cli.calculator.pointsToGain(ratingArray, chance, 1);

        cli.displayChances(formattedChance);
        //This below is clunky, I'll need to clean it up.
        System.out.println();
        System.out.println(cli.defo.format(pointsToGain) +
                " points will be gained on a win.");
    }
}
