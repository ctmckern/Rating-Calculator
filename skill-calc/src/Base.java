import Controller.Calculator;

import java.io.InputStream;
import java.io.PrintWriter;
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
    private double kFactor = 24;
    //Note the Elo expectation formula is logistic with base 10 where x = rating R of player a (Ra)
    //Minus rating R of player b (Rb) divided by 400. This becomes 1/(1+10^((Rb-Ra)/400)

    //http://www.glicko.net/ratings/approx.pdf   use this for referring to skill ratings.

    /*
    To do
    Initial prompt for user input
    Scanner to read said input
    A method to pass the input into(I believe calculator has one for this)
     */

    private void getRatingFromUserInput(double[] ratings, int index) {
        String input = in.nextLine();
        rating = Double.parseDouble(input);
        ratings[index] = rating;
        System.out.println();
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

    public void run() {
        calculator.displayPrompt(MAIN_MENU_PROMPTS, 0);
    }

    public static void main(String[] args) {
        int i = 0;
        Base cli = new Base();
        double[] ratingArray = new double[2];
        while (i < 2) {
            cli.displayPrompt(i);
            cli.getRatingFromUserInput(ratingArray, i);
            i++;
        }
        cli.displayRatings(ratingArray);
    }
}
