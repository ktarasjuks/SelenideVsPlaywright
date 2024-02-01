package api_tests.DAO;

public class Deck {

    public Boolean getSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public Boolean getShuffled() {
        return shuffled;
    }

    public int getRemaining() {
        return remaining;
    }

    private Boolean success;
    private String deck_id;
    private Boolean shuffled;
    private int remaining;

}
