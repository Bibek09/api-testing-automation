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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class Basics {

    @Test
    public static void getHeaderResponseBody(){
        given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().log()
                .all();

    }

    @Test
    public static void getResponseBody(){

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
    }

    @Test
    public static void getResponseStatusCodes(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get("http://demo.guru99.com/V4/sinkministatement.php").then().assertThat().statusCode(200);
    }

    @Test
    public static void getResponseHeaders(){
        System.out.println("The headers in the response "+
                get("http://demo.guru99.com/V4/sinkministatement.php").then().extract()
                        .headers());
    }

    @Test
    public static void getResponseTime(){
        System.out.println("The time taken to fetch the response "+get("http://demo.guru99.com/V4/sinkministatement.php")
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    @Test
    public static void getResponseContentType(){
        System.out.println("The content type of response "+
                get("http://demo.guru99.com/V4/sinkministatement.php").then().extract()
                        .contentType());
    }

    @Test( enabled=false )
    public static void getSpecificPartOfResponseBody(){

        ArrayList<String> amounts = when().get("http://demo.guru99.com/V4/sinkministatement.php").then().extract().path("result.statements.AMOUNT") ;
        int sumOfAll=0;
        for(String a:amounts){

            System.out.println("The amount value fetched is "+a);
            //sumOfAll=sumOfAll+Integer.valueOf(a);
        }
        //System.out.println("The total amount is "+sumOfAll);

    }
}
