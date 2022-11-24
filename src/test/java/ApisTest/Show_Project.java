package ApisTest;

import APIs.NewLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Show_Project {

    @Test
    public void ShowProject(){



        AccessToken accessToken = new AccessToken();
        accessToken.auth();
        String token = accessToken.getToken();

        Response getResponse = NewLogin.loginInvest();
        baseURI = "https://api-test.awaed.co/api/fundraiser/v1";
        given()
                .header("Authorization", "Bearer "+token)
                .get(baseURI+"/projects/show/309")
                .then()
                .statusCode(200)
                .log()
                .all();



    }
}
