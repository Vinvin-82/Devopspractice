package com.telecomdomain;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.listenerclass.ExtentReportListener.class)

public class Telecomdomainproject {
	
	 String token1;
	 String token2;
	 String userid;
	 String emailid;
	 
  @Test (priority=1)
  public void TC01_newuser() {
	  
	  String body = "{\n"
	  		+ "    \"firstName\": \"VinayaBai\",\n"
	  		+ "    \"lastName\": \"VamanaPrabhu\",\n"
	  		+ "    \"email\": \"testcase1testing"+System.currentTimeMillis()+"@testing.com\",\n"
	  		+ "    \"password\": \"myPassword\"\n"
	  		+ "}";
	  
	  Response response = RestAssured .given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .body(body)
	  .when().post("https://thinking-tester-contact-list.herokuapp.com/users");
 response.then().log().body();
	  
	  token1 =response.jsonPath().getString("token");
	  System.out.println("TC01: New User created with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());
	  
  }
  
  @Test (priority=2)
  public void TC02_getuser() {

	  Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+token1)
	 .when()
	 .get("https://thinking-tester-contact-list.herokuapp.com/users/me"+userid);
	 response.then().log().body();
	 
	  System.out.println("TC02: Found user with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());

  }
  
  @Test (priority=3)
  public void TC03_updateuser() {
	  
	  String body = "{\n"
	  		+ "    \"firstName\": \"VinayaBaiP\",\n"
	  		+ "    \"lastName\": \"VamanaPrabhuP\",\n"
	  		+ "    \"email\": \"vinvin"+System.currentTimeMillis()+"@gmail.com\",\n"
	  		+ "    \"password\": \"myNewPassword1\"\n"
	  		+ "}";
	 Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+token1)
	  .body(body)
	  .when().patch("https://thinking-tester-contact-list.herokuapp.com/users/me");
	  response.then().log().body();
	  
	  System.out.println("TC03: User details updated with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());
	  
  }

  @Test (priority=4)
  public void TC04_loginuser() {
	  
	  String body = "{\n"
		  		+ "    \"email\": \"vinvin@gmail.com\",\n"
		  		+ "    \"password\": \"myNewPassword1\"\n"
		  		+ "}";
	  Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .body(body)
	  .when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
	  response.then().log().body();
	  token2=response.jsonPath().getString("token");

	  System.out.println("TC04: User login in success with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());
	  
  }
  @Test (priority=5)
  public void TC05_addcontact() {
	  String body = "{\"firstName\": \"Pragya\",\n"
	  		+ "\"lastName\": \"VB\",\n"
	  		+ "\"birthdate\": \"2015-05-21\",\n"
	  		+ "\"email\": \"vbpp@ours.com\",\n"
	  		+ "\"phone\": \"9999999999\",\n"
	  		+ "\"street1\": \"My Steet\",\n"
	  		+ "\"street2\": \"No street\",\n"
	  		+ "\"city\": \"Tenkasi\",\n"
	  		+ "\"stateProvince\": \"TN\",\n"
	  		+ "\"postalCode\": \"225751\",\n"
	  		+ "\"country\": \"India\"\n"
	  		+ "}";
	  Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+token2)
	  .body(body)
	  .when().post("https://thinking-tester-contact-list.herokuapp.com/contacts");
	  response.then().log().body();
	  userid=response.jsonPath().getString("_id");
	  

	  System.out.println("TC05: Contact added with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());
	  
  }
  @Test (priority=6)
  public void TC06_getcontactlist() {

	  Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+token2)
	 .when()
	 .get("https://thinking-tester-contact-list.herokuapp.com/contacts");
	 response.then().log().body();
	 
	  System.out.println("TC06: Found contact with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());

  }
  
  @Test (priority=7)
  public void TC07_getcontact() {

	  Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+token2)
	 .when()
	 .get("https://thinking-tester-contact-list.herokuapp.com/contacts/");
	 response.then().log().body();
	 
	  System.out.println("TC07: Found contact with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());

  }  
  @Test (priority=8)
  public void TC08_updatecontact() {
	  
	  String body ="{\"firstName\": \"Pragya\",\n"
	  		+ "\"lastName\": \"VB\",\n"
	  		+ "\"birthdate\": \"2015-05-21\",\n"
	  		+ "\"email\": \"vbpp@ours.com\",\n"
	  		+ "\"phone\": \"8005554242\",\n"
	  		+ "\"street1\": \"13 School St.\",\n"
	  		+ "\"street2\": \"Apt. 5\",\n"
	  		+ "\"city\": \"Washington\",\n"
	  		+ "\"stateProvince\": \"QC\",\n"
	  		+ "\"postalCode\": \"A1A1A1\",\n"
	  		+ "\"country\": \"Canada\"\n"
	  		+ "}";

	  Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+token2)
	  .body(body)
	 .when()
	 .put("https://thinking-tester-contact-list.herokuapp.com/contacts/"+userid);
	 response.then().log().body();
	  System.out.println("TC08: Contact updated with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());
		  

  }  
  
  @Test (priority=9)
  public void TC09_updatecontact() {
	  
	  String body = "{\n"
	  		+ "\"firstName\": \"Pragya VB\",\n"
	  		+ "\"lastName\": \"VB\"\n"
	  		+ "\n"
	  		+ "}";
	  		  		

	  Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+token2)
	  .body(body)
	 .when()
	 .patch("https://thinking-tester-contact-list.herokuapp.com/contacts/"+userid);
	 response.then().log().body();
	 
	  System.out.println("TC09: Validated contact with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());

  } 
  
  @Test (priority=10)
  public void TC10_logoutuser() {
	  
	   Response response = RestAssured.given()
	  .header("Content-Type", "application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+token2)
	  .when()
	 .post("https://thinking-tester-contact-list.herokuapp.com/users/logout");
	 response.then().log().body();
	 
	  System.out.println("TC10: Logged out successfully  with status code: "+response.statusCode()+ " and output Message as:"
			  +response.getStatusLine());

  } 

}
