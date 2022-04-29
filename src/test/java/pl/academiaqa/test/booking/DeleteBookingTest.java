package pl.academiaqa.test.booking;

import io.restassured.response.Response;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.academiaqa.dto.AuthDto;
import pl.academiaqa.dto.BookingDto;
import pl.academiaqa.request.auth.PostAuthRequest;
import pl.academiaqa.request.booking.DeleteBookingRequest;
import pl.academiaqa.request.booking.PatchBookingRequest;
import pl.academiaqa.request.booking.PostBookingRequest;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBookingTest {
    private static String token;

    @BeforeAll //tworzenie tokenu
    static void setup(){
        JSONObject defaultAuth = AuthDto.getDefaultAuth();
        //wysłanie requestu POST o utworzenia tokenu
        token = PostAuthRequest.createToken(defaultAuth);

        // System.out.println("TOKEN "+ token);


    }

    @Test
    void deleteBookingTest(){


        // Tworzenie nowego bookingu (by później go usunąć)
        JSONObject defaultBooking = BookingDto.getDefaultBooking();
        Response createResponse = PostBookingRequest.createBooking(defaultBooking);
        String bookingid =createResponse.jsonPath().getString("bookingid");

        // Wysłanie DELETE na booking
        Response deleteResponse = DeleteBookingRequest.deleteBooking(bookingid, token);


        //Asercje
        assertThat(deleteResponse.getStatusCode()).isEqualTo(201);


    }

}

