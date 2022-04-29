package pl.academiaqa.request.booking;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingIdsRequest {

    public static Response getAllBookingIds() {
        return given()
                .when() // kiedy wyślę..
                .get("https://restful-booker.herokuapp.com/booking") //.. metodę GET na podany adres...
                //lub .get(BookingUrl.BASE_URL + BookingUrl.BOOKING)
                .then() //sprawdzenie lub wyciągniecie odpowiedzi
                // .statusCode(200) zamiast  assertThat(response.getStatusCode()).isEqualTo(200);
                .extract()//wyciągniecie odpowiedzi
                .response();//ALT+ENTER - deklaracja zmiennej finalnej         final Response response = given()

    }


}
