package ApisTest;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import io.restassured.RestAssured;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AccessToken {
    public String token;

    public String getToken() {
        return token;
    }

    @Test
    public void auth(){

    RequestSpecification request = RestAssured.given();
    request.header("Content-Type","application/json");
    JSONObject requestParams = new JSONObject();
    requestParams.put("identity_input","ahmed.saad@awaed.co");
    requestParams.put("password","Aa@12345");


            request.body(requestParams.toJSONString());
    Response response = request.post("https://api-test.awaed.co/api/fundraiser/v1/auth/login").then().extract().
        response();
        this.token = response.path("data.access_token");

        System.out.println(response.body().asString());

        System.out.println(response.body().asString());

    }
}


