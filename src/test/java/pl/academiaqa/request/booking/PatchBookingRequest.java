package pl.academiaqa.request.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import pl.academiaqa.dto.BookingDto;

import static io.restassured.RestAssured.given;

public class PatchBookingRequest {

    public static Response patchBooking(String bookingId,JSONObject json, String token){

        return given()
                .contentType(ContentType.JSON)
                .body(json.toString())
                .header("Cookie", "token=" + token) //ustawienie nagłówka, w którym zostanie wysłąny token    -H 'Cookie: token=abc123'
                .when()
                .patch("https://restful-booker.herokuapp.com/booking/" + bookingId) //id bookingu, który chcemy updatować
                //lub .patch(BookingUrl.BASE_URL + BookingUrl.BOOKING)
                .then()
                .statusCode(200)
                .extract()
                .response();



    }
}
