package ApisTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class update_Step_1 {
    @Test
    public void UpdateStep1(){

        AccessToken accessToken = new AccessToken();
        accessToken.auth();
        String token = accessToken.getToken();


        JSONObject request = new JSONObject();
        request.put("_method","PUT");
        request.put("step","1");
        request.put("name[ar]","احمد سيد");
        request.put("name[en]","Ahmed Sayed");
        request.put("full_description[ar]","احمد سيد تيست");
        request.put("capital_type","equity");
        request.put("full_description[en]","Test describtion");
        request.put("short_descriptions[ar]","تيست د");
        request.put("short_descriptions[en]","TestD");

        baseURI = "https://api-test.awaed.co/api/fundraiser/v1";
        given()
                .header("Authorization", "Bearer "+token)
                .get(baseURI+"/projects/update/2")
                .then()
                .statusCode(405)
                .log()
                .all();



    }
}
