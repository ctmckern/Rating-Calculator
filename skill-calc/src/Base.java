import Controller.Calculator;

import java.io.PrintWriter;


public class Base {


    private static final String MAIN_MENU_PLAYER_RATING_PROMPT = "Please enter player's rating.";
//Note the Elo expectation formula is logistic with base 10 where x = rating R of player a (Ra)
//Minus rating R of player b (Rb) divided by 400. This becomes 1/(1+10^((Rb-Ra)/400)

//Still need the rating adjustment formula and list of k factors

    public static void main(String[] args){


        double firstRating = 1152;
        double secondRating = 1286;
        double testDifference = (double)(1152 - 1286)/400;
        double testNumber = Math.pow(10, testDifference);
        double kFactor = 32;
        double expectedScore = (1/(1+testNumber));
        double changeInRating = firstRating + kFactor * (1 - expectedScore);
        System.out.println(expectedScore);
        System.out.println("hello");
    }
}
