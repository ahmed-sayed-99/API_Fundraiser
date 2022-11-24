package APIs;

import ApiBase.RequestApi;
import URLs.URLs;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class NewLogin extends RequestApi{

    public static Response loginInvest(){

        URLs base = new URLs();

        String baseUrl = base.getDepositBaseUrl();

        String endPoint = URLs.investEndPoint();

        String fullUrl = baseUrl + endPoint;

        setRequestURL(fullUrl);

        setContentType(ContentType.URLENC);

        setFormParams("phone", "ahmed.saad@awaed.co");
        setFormParams("password", "Aa@12345");

        return getResponse("POST");


    }
}
