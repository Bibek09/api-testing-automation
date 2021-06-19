import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompareJSONObjects {

    String JsonObject1;
    String jsonObject2;
    ObjectMapper objectMapper;
    JsonNode jsonNode1;
    JsonNode jsonNode2;

    @Test
    public void compareTwoJsonObjects() throws JsonMappingException, JsonProcessingException {
        JsonObject1 = "{\n" +
                "   \"post code\": \"90210\",\n" +
                "   \"country\": \"United States\",\n" +
                "   \"country abbreviation\": \"US\",\n" +
                "   \"places\": [\n" +
                "      {\n" +
                "         \"place name\": \"Beverly Hills\",\n" +
                "         \"longitude\": \"-118.4065\",\n" +
                "         \"state\": \"California\",\n" +
                "         \"state abbreviation\": \"CA\",\n" +
                "         \"latitude\": \"34.0901\"\n" +
                "      }\n" +
                "   ]\n" +
                "}";

        jsonObject2 = "{\n" +
                "   \"post code\": \"90210\",\n" +
                "   \"country\": \"United States\",\n" +
                "   \"country abbreviation\": \"US\",\n" +
                "   \"places\": [\n" +
                "      {\n" +
                "         \"place name\": \"Beverly Hills\",\n" +
                "         \"longitude\": \"-118.4065\",\n" +
                "         \"state\": \"California\",\n" +
                "         \"state abbreviation\": \"CA\",\n" +
                "         \"latitude\": \"34.0901\"\n" +
                "      }\n" +
                "   ]\n" +
                "}";



        objectMapper = new ObjectMapper();
        jsonNode1 = objectMapper.readTree(JsonObject1);
        jsonNode2 = objectMapper.readTree(jsonObject2);

        // Checking if both json objects are same
        System.out.println(jsonNode1.equals(jsonNode2));
    }
}