import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


import java.util.concurrent.TimeUnit;
import org.testng.Assert;
public class DELAYED_RESPONSE {
    @Test
    public void DelayedResponseCheck() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://reqres.in";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/users?delay=3");

        long timeInMS = response.time();
        long timeInS = response.timeIn(TimeUnit.SECONDS);
        Assert.assertEquals(timeInS, timeInMS/1000);

        //RestAssured.when().get("/api/users?delay=3").then().time(//lessThan(5000L));


    }
}