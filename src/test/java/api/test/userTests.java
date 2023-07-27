package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payload.User;
import io.restassured.response.Response;

public class userTests {
	User upay;
	Faker faker;

	@BeforeClass
	public void setupData() {

		faker = new Faker();
		upay = new User();
		upay.setId(faker.idNumber().hashCode());
		upay.setUsername(faker.name().username());
		upay.setFirstName(faker.name().firstName());
		upay.setLastName(faker.name().lastName());
		upay.setEmail(faker.internet().safeEmailAddress());
		upay.setPassword(faker.internet().password(5, 10));
		upay.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testPostUser() throws Exception {

		Response res = Userendpoints.createUser(upay);
		res.then().log().all();

		Assert.assertEquals(res.getStatusCode(), 200);

	}

	@Test(priority = 2)
	public void testGetserByName() {
		Response respo = Userendpoints.getUser(this.upay.getUsername());
		Assert.assertEquals(respo.getStatusCode(), 200);
		respo.then().log().all();

	}

	@Test(priority = 3)
	public void testupdateUser() {
		upay.setUsername(faker.name().username());
		upay.setFirstName(faker.name().firstName());
		upay.setLastName(faker.name().lastName());

		Response res = Userendpoints.updateUser(upay, this.upay.getUsername());
		res.then().log().all();
		res.then().log().body().statusCode(200);

		Assert.assertEquals(res.getStatusCode(), 200);
		// checking the data after the update

	}

	@Test(priority = 4)
	private void testDeleteUser() {

		Response res1 = Userendpoints.deleteUser(this.upay.getUsername());
		Assert.assertEquals(res1.getStatusCode(), 200);

	}

}
