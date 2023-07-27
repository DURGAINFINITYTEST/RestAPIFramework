package api.endpoints;

//domain  https://petstore.swagger.io/

//get -https://petstore.swagger.io/#/user
//https://petstore.swagger.io/#/user{username}

public class Routes {

	// UESR MODULE

	public static String base_URL = "https://petstore.swagger.io/v2";

	public static String post_URL = base_URL+"/user";
	public static String get_URL = base_URL+"/user/{username}";
	public static String put_URL = base_URL+"/user/{username}";
	public static String delete_URL = base_URL+"/user/{username}";

	// store module

	// pet module

}
