package io.github.ronvohra;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.github.ronvohra.entity.Home;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class HomeResourceTest {

  @Test
  public void getHomesReturnsAllHomes() {
    given().when().get("/home").then().statusCode(200).body("size()", is(2));
  }

  @Test
  public void postHomesCreatesNewHome() {
    var home = createHome();
    given()
        .header("Content-Type", "application/json")
        .body(home)
        .when()
        .post("/home")
        .then()
        .statusCode(201)
        .body("url", is(home.url));
  }

  private static Home createHome() {
    var home = new Home();
    home.url = "http://zoopla.co.uk/nice-house";
    home.streetAddress = "1600 Pennsylvania Ave";
    home.numBedrooms = 100;
    home.numBathrooms = 200;
    home.nearestStation = "wdc";
    home.walkTimeToStation = 20;
    home.directCentralStation = "wdc";
    home.timeToCentral = 0;
    home.notes = "White House";
    return home;
  }
}
