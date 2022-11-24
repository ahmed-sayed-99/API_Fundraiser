package ApisTest;

import APIs.NewLogin;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Step_2_invest_details {
    @Test
    public void Step2InvestDetails(){

        AccessToken accessToken = new AccessToken();
        accessToken.auth();
        String token = accessToken.getToken();


           JSONObject request = new JSONObject();
        request.put("_method","PUT");
        request.put("step","2");
        request.put("number_of_shares","0");
        request.put("price_per_share","1000");
        request.put("interest_rate","0");
        request.put("interest_rate_type","annual");
        request.put("target_date","2023-10-03");
        request.put("project_period","24");
        request.put("min_commitment_shares","1");
        request.put("max_commitment_shares","200");
        request.put("open_date","2022-12-03");
        request.put("close_date","2022-10-03");
        request.put("level_of_risk","low");
        request.put("investor_fees","2");



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
