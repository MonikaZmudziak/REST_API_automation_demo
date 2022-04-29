package pl.academiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.academiaqa.dto.AuthDto;
import pl.academiaqa.dto.BookingDto;
import pl.academiaqa.request.auth.PostAuthRequest;
import pl.academiaqa.request.booking.PatchBookingRequest;
import pl.academiaqa.request.booking.PostBookingRequest;

import static org.assertj.core.api.Assertions.*;

public class PatchBookingTest {

    private static String token;

   @BeforeAll //tworzenie tokenu
   static void setup(){
       JSONObject defaultAuth = AuthDto.getDefaultAuth();
       //wysłanie requestu POST o utworzenia tokenu
       token = PostAuthRequest.createToken(defaultAuth);

       // System.out.println("TOKEN "+ token);


   }

    @Test
    void partialUpdateBookingTest(){


        //Utworzyć booking (wysłac Post), zapisać Id bookingu, utworzyć nowy obiekt gdzie zmienimy imię i nazwisko, wyslać patcha
        //ktory zmieni te dane, napisac asercje sprawdzającą czy ten obiekt się napewno updateował

        // Tworzenie nowego bookingu
        JSONObject defaultBooking = BookingDto.getDefaultBooking();
        Response createResponse = PostBookingRequest.createBooking(defaultBooking);

        // Wyciągnięcie ID bookingu
        String bookingid = createResponse.jsonPath().getString("bookingid");

        // Obiekt z nowymi danymi
        JSONObject patchBooking = new JSONObject();
        patchBooking.put("firstname","Tomek");
        patchBooking.put("lastname","Czarny");

        // Wysłanie Patch na booking (aby zupdatować dane)
        Response patchResponse = PatchBookingRequest.patchBooking(bookingid, patchBooking,token);

        //Asercje
        JsonPath jsonPath = patchResponse.jsonPath();

        assertThat(jsonPath.getString("firstname")).isEqualTo("Tomek");
        assertThat(jsonPath.getString("lastname")).isEqualTo("Czarny");

        System.out.println(patchResponse.asString());


    }

}
