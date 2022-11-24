package ApisTest;

import APIs.NewLogin;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.asynchttpclient.util.Assertions;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class List_For_Projects {


    @Test
    public static void ListForProject() {

        AccessToken accessToken = new AccessToken();
        accessToken.auth();
        String token = accessToken.getToken();

       // Response getResponse = NewLogin.loginInvest();
        baseURI = "https://api-test.awaed.co/api/fundraiser/v1";
        given()
            .header("Authorization", "Bearer "+token)
            .get(baseURI+"/projects")
            .then()
            .statusCode(200)
            .log()
            .all();

    }
}
