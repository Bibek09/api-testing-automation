import static io.restassured.RestAssured.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;
import org.hamcrest.CoreMatchers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class Stubbing {
    //https://www.youtube.com/watch?v=UU05kp24d_k
    //https://www.youtube.com/watch?v=zeN2xo-ttz4
    //java -jar wiremock-jre8-standalone-2.28.1.jar --port 8080 --verbose
    //http://wiremock.org/docs/configuration/

    //WireMockServer wm = new WireMockServer(options().port(8080));

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(8080));


    @Test
    public void getresponsefromstubbedserver() throws InterruptedException {
        wireMockRule.start();
        Thread.sleep(5000);
        given().
                when().
                get("http://localhost:8080/api/users").
                then().
                log().
                all();
        wireMockRule.stop();
    }



}
