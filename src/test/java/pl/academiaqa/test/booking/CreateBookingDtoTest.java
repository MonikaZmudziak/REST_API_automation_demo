package pl.academiaqa.test.booking;

import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static org.assertj.core.api.Assertions.*;

public class CreateBookingDtoTest {


    @Test
    void createBookingTest(){

        // zamiast poniższego tworzenia obietku -->final JSONObject booking = Booking.getDefaultBooking();

        //utworzenie obiektu JavaScript [JSON - JavaScript Object Notation]

//        -d '{
//        "firstname" : "Jim",
//                "lastname" : "Brown",
//                "totalprice" : 111,
//                "depositpaid" : true,
//                "bookingdates" : {
//            "checkin" : "2018-01-01",
//                    "checkout" : "2019-01-01"
//        },
//        "additionalneeds" : "Breakfast"
//    }'

        JSONObject bookingdates = new JSONObject();//mały obiekt
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        JSONObject booking = new JSONObject();
        booking.put("firstname", "Monika"); // dodanie klucza i wartości
        booking.put("lastname", "Testowa");
        booking.put("totalprice", "1000");
        booking.put("depositpaid", "true");
        booking.put("additionalneeds", "sauna");
        booking.put("bookingdates",bookingdates);//dodanie mniejszego obiektu (pierwsze tworzymy małe obiekty potem duże)




        // zamiast poniższego responsa -->Response response = PostBookingRequest.createBooking(booking);
        Response response = given()//wyslanie nowego requesta przy użyciu biblioteki RestAssured
                .contentType(ContentType.JSON)
                .body(booking.toString()) //przy używaniu obiektów Json to w sekcji body trzeba zaminić je na String
                .when() // kiedy wyśle POSTa
                .post("https://restful-booker.herokuapp.com/booking")//na adres
                .then()
                .statusCode(200)
                .extract() //wyciągnij
                .response();// odpowiedź + ALT+ENTER aby całą odpowiedź przypisac do zmiennej

        //sprawdzenie imienia i  nazwiska w odpowiedzi

        JsonPath json = response.jsonPath();// ALT+Enter (w Json łatwiej czytać dane)
        assertThat(json.getString("booking.firstname")).isEqualTo("Monika");
        assertThat(json.getString("booking.lastname")).isEqualTo("Testowa");


    }

}
