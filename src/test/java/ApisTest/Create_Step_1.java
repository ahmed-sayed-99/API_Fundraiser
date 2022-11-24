package ApisTest;

import APIs.NewLogin;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Create_Step_1 {
      @Test
    public void CreateStep1(){
          AccessToken accessToken = new AccessToken();
          accessToken.auth();
          String token = accessToken.getToken();

          Response getResponse = NewLogin.loginInvest();



        JSONObject request = new JSONObject();
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
                  .get(baseURI+"/projects/create")
                  .then()
                  .statusCode(200)
                  .log()
                  .all();

    }
}
