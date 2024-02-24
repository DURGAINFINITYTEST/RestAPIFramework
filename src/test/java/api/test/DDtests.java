package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.uitlities.DataProviders;
import io.restassured.response.Response;

public class DDtests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String email, String pass,
			String ph) throws Exception {

		User use = new User();
		use.setId(Integer.parseInt(userID));
		use.setUsername(userName);
		use.setFirstName(fname);
		use.setLastName(lname);
		use.setEmail(email);
		use.setPassword(pass);
		use.setPhone(ph);

		Response res = Userendpoints.createUser(use);
		Assert.assertEquals(res.getStatusCode(), 200);

	}

}
