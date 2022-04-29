package pl.academiaqa.dto;

import org.json.JSONObject;

public class AuthDto {

    public static JSONObject getDefaultAuth(){
        JSONObject authJson = new JSONObject();
        authJson.put("username", "admin");
        authJson.put("password", "password123");

        return authJson;
    }
}
