package pl.academiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class GetAllBookingDtoIdsTest {

    //metoda,ktora odczyta wszystkie ID

    @Test
    void getBookingIdsTest(){

        final Response response = given()
                .when() // kiedy wyślę..
                .get("https://restful-booker.herokuapp.com/booking") //.. metodę GET na podany adres...
                .then() //sprawdzenie lub wyciągniecie odpowiedzi
                // .statusCode(200) zamiast  assertThat(response.getStatusCode()).isEqualTo(200);
                .extract()//wyciągniecie odpowiedzi
                .response();//ALT+ENTER - deklaracja zmiennej finalnej         final Response response = given()



        // lub zamiast powyższego  -> Response response = GetBookingIdsRequest.getAllBookingIds();


        assertThat(response.getStatusCode()).isEqualTo(200); //assercie z assertj

        JsonPath json = response.jsonPath(); // łatwiejszy do obróbki format
        assertThat(json.getList("bookingid").size()).isPositive(); // czy lista booking id jest większa od zera
        // ALT + ENTER STATYCZNY IMPORT
    }
}
