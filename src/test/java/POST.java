import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST {
    @Test
    public void PostWeatherDetails() {
        RestAssured.baseURI = "https://reqres.in/";
        String endpoint="api/";
        RequestSpecification httpRequest = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Bibek");
        requestParams.put("job", "K");

        // Add a header stating the Request body is a JSON
        httpRequest.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = httpRequest.post(endpoint+"users");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 201);

        //Verify part of the updated response
        String successCode = response.jsonPath().get("name");
        Assert.assertEquals( successCode,"Bibek");
    }
}
