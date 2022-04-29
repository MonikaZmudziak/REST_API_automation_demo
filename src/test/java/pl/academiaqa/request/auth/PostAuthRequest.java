package pl.academiaqa.request.auth;

import io.restassured.http.ContentType;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {

    public static String createToken(JSONObject json){ //token jest Stringiem

         return given()
                .contentType(ContentType.JSON)
                .body(json.toString())
                .when() //kiedy
                .post("https://restful-booker.herokuapp.com/auth")//wyślę na ten adres
                 //lub .post(BookingUrl.BASE_URL + BookingUrl.AUTH)
                .then()//wtedy
                .statusCode(200)//sprawdzam status kod 200
                .extract()
                .response()
                .jsonPath() //zamiana odpowiedzi na JsonPath
                .getString("token"); //pobieram wartość klucza o nazwie token


    }
}
