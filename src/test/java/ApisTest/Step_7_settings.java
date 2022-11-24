package ApisTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Step_7_settings {
    @Test
    public void Step7Settings(){
        AccessToken accessToken = new AccessToken();
        accessToken.auth();
        String token = accessToken.getToken();

        JSONObject request = new JSONObject();
        request.put("project_id","2");
        request.put("category_limit[0][min_shares]","1");
        request.put("category_limit[0][max_shares]","400");
        request.put("category_limit[0][status]","1");
        request.put("category_limit[0][vip]","0");
        request.put("category_limit[0][category_id]","1");
        request.put("category_limit[0][invest_limit]","");
        request.put("category_limit[1][min_shares]","1");
        request.put("category_limit[1][max_shares]","400");
        request.put("category_limit[1][status]","1");
        request.put("category_limit[1][vip]","1");
        request.put("category_limit[1][category_id]","1");
        request.put("category_limit[1][invest_limit]","");
        request.put("private_waiting_list[0]","1");
        request.put("private_waiting_list[1]","2");
        request.put("private_user_id[0]","222");
        request.put("private_waiting_list_is_show","1");
        request.put("private_user_is_show","1");
        request.put("is_public","1");

        baseURI = "https://api-test.awaed.co/api/fundraiser/v1";
        given()
                .header("Authorization", "Bearer "+token)
                .get(baseURI+"/projects/update_settings")
                .then()
                .statusCode(200)
                .log()
                .all();


    }
}
