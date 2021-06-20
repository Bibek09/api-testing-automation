import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;
import org.hamcrest.CoreMatchers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.matcher.RestAssuredMatchers.*;
public class PARAMETERIZED {
    @Test
    public void countries(){
        baseURI = "http://restcountries.eu/rest/v1/";
        basePath="name/";

        // Here the key name 'country' must match the url parameter {country}
                given()
                .pathParam("country", "Finland")
                .when()
                .get("{country}")
                .then()
                .body("capital", containsString("Helsinki"));

    }

    @Test
    public void requestzipcodes(){

        given().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[0].'place name'",equalTo("Beverly Hills")).
                and().
                body("places[0].'longitude'",equalTo("-118.4065"));


    }
    @Test(enabled=false)
    public void readjson(){
        JsonPath expectedJson = new JsonPath(new File("/Users/bibekkhatiwara/IdeaProjects/api-testing-automation/src/main/resources/expected.json"));
        System.out.println(expectedJson.getMap("country").toString());
    }

    @Test
    public void comparewholeJSONresponseHardCoded(){
        RestAssured
                // Construct request
                .given()
                .log()
                .all()
                .baseUri("https://gorest.co.in/public-api/")
                .basePath("users/{id}")
                .pathParam("id", "178")
                // Hit API
                .when()
                .get()
                .then()
                // Assert response
                .log()
                .all()
                .assertThat()
                // Pass full expected response body with Hamcrest matchers

                //convert it into single line using https://tools.knowledgewalls.com/online-multiline-to-single-line-converter
                .body(Matchers.equalTo("{\"code\":200,\"meta\":null,\"data\":{\"id\":178,\"name\":\"Sanya Kakkar DC\",\"email\":\"dc_kakkar_sanya@orn.net\",\"gender\":\"Male\",\"status\":\"Active\",\"created_at\":\"2021-06-19T03:50:06.208+05:30\",\"updated_at\":\"2021-06-19T03:50:06.208+05:30\"}}"));
    }
    @Test
    public void comparewholeJSONresponsewithJSonSavedLocally() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("/Users/bibekkhatiwara/IdeaProjects/api-testing-automation/src/main/resources/employees.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
        private static void parseEmployeeObject(JSONObject employee)
        {
            //Get employee object within list
            JSONObject employeeObject = (JSONObject) employee.get("places");

            //Get employee first name
            String firstName = (String) employeeObject.get("places.place name");
            System.out.println(firstName);

        }
    }


