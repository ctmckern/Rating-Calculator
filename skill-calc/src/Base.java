import Controller.Calculator;

import java.io.PrintWriter;


public class Base {

    private Calculator calculator;

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

    private double rating;
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

        private void displayPrompts(Object object){

        }
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
