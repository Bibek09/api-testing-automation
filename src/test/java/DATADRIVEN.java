//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import com.tngtech.java.junit.dataprovider.*;
//
//
//@RunWith(DataProviderRunner.class)
//public class DATADRIVEN {
//
//
//    @Test
//    @DataProvider({
//            "1, Leanne Graham",
//            "2,Ervin Howell",
//            "3,Clementine Bauch"
//    }) //This is intellij Issue with junit, works in eclipse
//
//    public void PathParam(int userId, String exp){
//        given().
//                pathParam("userId",1).//replace 1 with exp userId
//                when().
//                get("http://jsonplaceholder.typicode.com/users/{userId}").
//                then().
//                assertThat().
//                body("name", equalTo("Leanne Graham")); //replace with exp
//    }
//
//    public void QueryParam{
//
//    }
//
//}