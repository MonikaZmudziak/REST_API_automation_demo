package pl.academiaqa.dto;

import org.json.JSONObject;

public class BookingDto {

    //twworzenie obiektu

    public static JSONObject getDefaultBooking(){
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

        return booking;
    }
}
