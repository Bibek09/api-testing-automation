import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DELETE {
    @Test
    public void delrequest(){
        int userid = 2;

        RestAssured.baseURI = "https://reqres.in";
        String endpoint="/api/";

        RequestSpecification request = RestAssured.given();

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        /* Delete the request and check the response
         * The actual request being passed equalizes to http://dummy.restapiexample.com/api/v1/delete/15410
         * Here, we capture the response for DELETE request by passing the associated empID in the baseURI */
        Response response = request.delete("users/"+ userid);

        int statusCode = response.getStatusCode();
        //System.out.println(response.asString());
        Assert.assertEquals(statusCode, 204);

        //String jsonString =response.asString();
        //Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);

    }
}
