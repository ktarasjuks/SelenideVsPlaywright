package api_tests;

import api_tests.DAO.Deck;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RestApiSampleTest {

    private static long startTime;
    private Response response;
    private String deckID;
    private int cardAmount;
    private int drawnCardAmount;
    private ValidatableResponse json;
    private RequestSpecification request;
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
        ;
    }

    @Test
    public void testAddPet() {
     shuffleDeck();

    }





    public void shuffleDeck() {
        response = given().get(CARD_DECK_API + "/new/shuffle/?deck_count=1");

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