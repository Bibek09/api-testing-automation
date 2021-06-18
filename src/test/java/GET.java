import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.hamcrest.Matchers.*;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
public class GET {
    @Test
    public void GetWeatherDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://reqres.in";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/users?page=2");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Let us print the total pages variable to see what we got
        System.out.println("total_pages received from Response " + jsonPathEvaluator.get("total_pages"));

        // Nested value
        System.out.println("email received from Response " + jsonPathEvaluator.get("data.email[0]"));
    }
    public static void getResponseBody(){
        RestAssured.given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().log()
                .all();

    }
}
