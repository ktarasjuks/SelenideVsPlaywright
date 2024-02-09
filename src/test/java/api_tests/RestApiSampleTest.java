package api_tests;

import api_tests.DAO.Deck;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RestApiSampleTest {

    private static long startTime;
    private static final String CARD_DECK_API = "https://deckofcardsapi.com/api/deck";

    @BeforeAll
    public static void setup() {
        startTime = System.currentTimeMillis();
        RestAssured.baseURI = CARD_DECK_API;
    }

    @AfterAll
    public static void tearDown() {
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time of tests " + totalTime);
    }

    @Test
    public void testAddPet() {
        Response response = given().get(CARD_DECK_API + "/new/shuffle/?deck_count=1");
        response.then()
                .statusCode(200)
                .assertThat()
                .body("shuffled", equalTo(true))
                .body("success", equalTo(true))
                .body("remaining", equalTo(52))
                .body("deck_id", notNullValue());
        Deck deck = response.as(Deck.class);
        System.out.println(deck.getDeck_id());
        System.out.println(deck.getShuffled());
        System.out.println(deck.getRemaining());
    }


}