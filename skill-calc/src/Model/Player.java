package Model;

//Note the purpose here is to create a player object with a permanent skill rating.
//We want something that could be easily stored in a database.

//NOT A PRIORITY UNTIL PERSISTENCE LAYER IS STARTED
public class Player {
    //skillRating is the only variable for Elo.
    private int skillRating;
    private int skillVariance;

    Player(int skillRating, int skillVariance){
        this.skillRating = skillRating;
        this.skillVariance = skillVariance;
    }

    Player(){

    }
}
