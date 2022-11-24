package ApisTest;

import APIs.NewLogin;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Step_3_fund_details {
    @Test
    public void Step3fundDetails(){
        AccessToken accessToken = new AccessToken();
        accessToken.auth();
        String token = accessToken.getToken();

        Response getResponse = NewLogin.loginInvest();


        JSONObject request = new JSONObject();
        request.put("step","3");
        request.put("infos[1][key]","fundManager");
        request.put("infos[1][value]","dev");
        request.put("infos[1][file]","");
        request.put("infos[2][key]","fundDeveloper");
        request.put("infos[2][value]","man");
        request.put("infos[2][file]","");
        request.put("infos[3][key]","custodian");
        request.put("infos[3][value]","co");
        request.put("infos[3][file]","");
        request.put("infos[4][key]","auditor");
        request.put("infos[4][value]","acc");
        request.put("infos[4][file]","");



        baseURI = "https://api-test.awaed.co/api/fundraiser/v1";
        given()
                .header("Authorization", "Bearer "+token)
                .get(baseURI+"/projects/update/2/fund_details")
                .then()
                .statusCode(405)
                .log()
                .all();


    }
}
