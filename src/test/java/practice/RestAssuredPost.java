package practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rest.assured.pojo.Category;
import com.rest.assured.pojo.Pet;
import com.rest.assured.pojo.Tags;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RestAssuredPost {



    @Test
    public static void makePostCallForUploadImageToPetStore() throws MalformedURLException {

        Response response = given().accept(ContentType.JSON)
                .contentType("multipart/form-data")
                .multiPart("additionalMetadata", "jerry.png")
                .multiPart("file", new File("C:\\Users\\mdisl\\projects\\solve-problems\\src\\main\\resources\\testDataFile\\Sample.png"))
                .when().post(new URL("https://petstore.swagger.io/v2/pet/336/uploadImage"));
        response.getBody().prettyPrint();
        assert response.statusCode() == 200;
        Map body = response.getBody().as(Map.class);
        assert (Integer) body.get("code") == 200;
        assert body.get("message").toString().contains("additionalMetadata: jerry.png");
        assert body.get("message").toString().contains("File uploaded to ./Sample.png, 87123 bytes");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat((Integer) body.get("code")).isEqualTo(200);
        assertThat(body.get("message").toString()).contains("additionalMetadata: jerry.png");
        assertThat(body.get("message").toString()).contains("File uploaded to ./Sample.png, 87123 bytes");

    }


    @Test
    public void testing(){
        Response response;
        RequestSpecification requestSpecification = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON).when();
        URI uri = URI.create("https://www.patreon.com/media-url/aHR0cHM6Ly9pLnl0aW1nLmNvbS92aS8yTVdaUmRLV0RIVS9tYXhyZXNkZWZhdWx0LmpwZw==");
                response = requestSpecification.get(uri);
        response.getBody().prettyPrint();
    }

    @Test
    public static void makePostCallForCreateInPetStore()  {
        Pet pet = new Pet();
        Category category = new Category();
        Tags tags = new Tags();
        tags.setId(12);
        category.setId(12);
        category.setName("Tommy1");
        pet.setId(12);
        pet.setCategory(category);
        pet.setTags(Arrays.asList(tags));
        pet.setStatus("Available");


        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .when().post(URI.create("https://petstore.swagger.io/v2/pet"));
        response.getBody().prettyPrint();
        assertThat(response.statusCode()).isEqualTo(200);
        JSONObject body = new JSONObject(response.getBody().as(Map.class));
        assertThat(body.get("id")).isEqualTo(12);
        assertThat(body.query("/category/id")).isEqualTo(12);
        assertThat(body.query("/category/name")).isEqualTo("Tommy1");
        assertThat(body.get("status")).isEqualTo("Available");




    }
    /*{
  "id": 9222968140491052000,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}*/


    static String body = "{\n" +
            "  \"id\": 12,\n" +
            "  \"category\": {\n" +
            "    \"id\": 12,\n" +
            "    \"name\": \"Tommy\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 12,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";

}

