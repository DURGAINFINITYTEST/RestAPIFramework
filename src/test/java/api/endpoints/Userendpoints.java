package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Userendpoints.java
//

public class Userendpoints {
	public static Properties prop;
	public static FileInputStream fis;

	public static Response createUser(User payload) throws Exception {

		prop = new Properties();
		fis = new FileInputStream(
				"C:\\Users\\katak\\eclipse-workspace\\RestAPIFramework\\src\\test\\java\\api\\uitlities\\data.properties");
		prop.load(fis);
		String postUrl = prop.getProperty("post_URL");

		Response resCreate = given()

				.contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(postUrl);

		return resCreate;

	}
public static Response getUser(String username) {
		
		String getUrl = prop.getProperty("get_URL");
		Response resGet = given()
				       .pathParam("username", username)

				//.when().get(Routes.get_URL);
				.when()
				.get(getUrl);
				

		return resGet;

	}


	public static Response updateUser(User payload, String userName) {
		
		String putUrl = prop.getProperty("put_URL");

		Response resUpdate = given()

				.contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName).body(payload)

				.when().put(putUrl);

		return resUpdate;

	}

	public static Response deleteUser(String userName) {
		
		String deleteUrl = prop.getProperty("delete_URL");

		Response resGet = given()
				.pathParam("username", userName)

				.when().delete(Routes.delete_URL); 

		return resGet;

	}

	
}
