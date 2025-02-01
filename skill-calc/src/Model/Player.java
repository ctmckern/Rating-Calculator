package Model;

//Note the purpose here is to create a player object with a permanent skill rating.
//We want something that could be easily stored in a database.

//NOT A PRIORITY UNTIL PERSISTENCE LAYER IS STARTED
public class Player {
    //skillRating is the only variable for Elo.
    private double skillRating;
    private double skillVariance;
    private int matchesPlayed;

    Player(double skillRating, double skillVariance, int matchesPlayed){
        this.skillRating = skillRating;
        this.skillVariance = skillVariance;
        this.matchesPlayed = matchesPlayed;
    }

    Player(){

    }

    //Getters
    public double getSkillRating() {
        return skillRating;
    }
    public double getSkillVariance() {
        return skillVariance;
    }
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    //Setters
    public void setSkillRating(double skillRating){
        this.skillRating = skillRating;
    }
    public void setSkillVariance(double skillVariance){
        this.skillVariance = skillVariance;
    }
    public void setMatchesPlayed(int matchesPlayed){
        this.matchesPlayed = matchesPlayed;
    }
}
