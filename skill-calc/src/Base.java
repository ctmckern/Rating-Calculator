import Controller.Calculator;

import java.io.PrintWriter;


public class Base {

    private Calculator calculator;

    public Base(Calculator calculator) {
        this.calculator = calculator;
    }
    private static final String MAIN_MENU_PLAYER1_RATING_PROMPT = "Please enter player one's rating.";
    private static final String MAIN_MENU_PLAYER2_RATING_PROMPT = "Please enter player two's rating.";

    private double rating;
    private double expectation;
//Note the Elo expectation formula is logistic with base 10 where x = rating R of player a (Ra)
//Minus rating R of player b (Rb) divided by 400. This becomes 1/(1+10^((Rb-Ra)/400)

//Still need the rating adjustment formula and list of k factors

    public void run(){

    }

    public static void main(String[] args){
        Calculator calculator = new Calculator(System.in, System.out);

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
