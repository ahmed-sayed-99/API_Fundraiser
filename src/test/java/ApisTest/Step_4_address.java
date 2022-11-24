package ApisTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Step_4_address {
    @Test
    public void Step4address(){
        AccessToken accessToken = new AccessToken();
        accessToken.auth();
        String token = accessToken.getToken();


        JSONObject request = new JSONObject();
        request.put("building","10 ggr");
        request.put("line1","Alhasou");
        request.put("line2","Almalqa, 4445");
        request.put("line3","");
        request.put("zip","13561");
        request.put("country","Riyadh");
        request.put("country_code","SA");
        request.put("city_id","4");
        request.put("lat","30.0986754");
        request.put("lng","31.3427151");

        baseURI = "https://api-test.awaed.co/api/fundraiser/v1";
        given()
                .header("Authorization", "Bearer "+token)
                .get(baseURI+"/projects/update/31/address")
                .then()
                .statusCode(405)
                .log()
                .all();


    }
}
