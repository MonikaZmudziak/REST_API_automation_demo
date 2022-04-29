package pl.academiaqa.request.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    public static Response createBooking(JSONObject booking){
        return given()//wyslanie nowego requesta przy użyciu biblioteki RestAssured
                .contentType(ContentType.JSON)
                .body(booking.toString()) //przy używaniu obiektów Json to w sekcji body trzeba zaminić je na String
                .when() // kiedy wyśle POSTa
                .post("https://restful-booker.herokuapp.com/booking")//na adres
                //lub .post(BookingUrl.BASE_URL + BookingUrl.BOOKING)
                .then()
                .statusCode(200)
                .extract() //wyciągnij
                .response();// od
    }
}
