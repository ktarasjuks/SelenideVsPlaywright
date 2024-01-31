package api_tests.DAO;

public class Deck {



    public String getDeck_id() {
        return deck_id;
    }

    public Boolean getShuffled() {
        return shuffled;
    }

    public int getRemaining() {
        return remaining;
    }

    private String deck_id;
    private Boolean shuffled;
    private int remaining;

}
