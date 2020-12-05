package io.github.ronvohra;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;

import io.github.ronvohra.entity.Home;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class HomeResourceTest {

  public static final String ADDRESS_YEMEN_ROAD = "14 Yemen Road, Yemen";
  public static final String ADDRESS_BAKER_STREET = "221b Baker Street";

  @BeforeAll
  static void setUp() {
    var home1 =
        createHome(ADDRESS_YEMEN_ROAD, 2, 2, "station1", 5, "centralStation1", 10, "good shizz");
    var home2 =
        createHome(ADDRESS_BAKER_STREET, 3, 1, "Baker Street", 4, "Baker Street", 0, "elementary");
    PanacheMock.mock(Home.class);
    var mockedHomes = List.of(home1, home2);
    // This is valid and required, since Mockito.when... doesn't work when you create mockedHomes
    // as above (type conflict - List<Home> v/s the expected List<PanacheBaseEntity>).
    PanacheMock.doReturn(mockedHomes).when(Home.class).listAll();
    Mockito.when(Home.count()).thenReturn((long) mockedHomes.size());
    PanacheMock.doNothing().when(Home.class).persist();
  }

  @Test
  public void getHomesReturnsAllHomes() {
    given()
        .when()
        .get("/homes")
        .then()
        .statusCode(200)
        .body(containsString(ADDRESS_YEMEN_ROAD), containsString(ADDRESS_BAKER_STREET));
  }

  @Test
  public void postHomesCreatesNewHome() {
    var home = createHome("1600 Pennsylvania Ave", 100, 200, "wdc", 20, "wdc", 0, "White House");
    var mockHome = Mockito.mock(Home.class, Mockito.RETURNS_DEEP_STUBS);
    Mockito.when(mockHome.find(anyString(), anyString()).firstResult()).thenReturn(home);
    given()
        .header("Content-Type","application/json" )
        .body(home)
        .when()
        .post("/homes")
        .then()
        .statusCode(200)
        .body(containsString("White House"));
  }

  private static Home createHome(
      String streetAddress,
      int numBedrooms,
      int numBathrooms,
      String nearestStation,
      int walkTimeToStation,
      String directCentralStation,
      int timeToCentral,
      String notes) {
    var home = new Home();
    home.streetAddress = streetAddress;
    home.numBedrooms = numBedrooms;
    home.numBathrooms = numBathrooms;
    home.nearestStation = nearestStation;
    home.walkTimeToStation = walkTimeToStation;
    home.directCentralStation = directCentralStation;
    home.timeToCentral = timeToCentral;
    home.notes = notes;
    return home;
  }
}
