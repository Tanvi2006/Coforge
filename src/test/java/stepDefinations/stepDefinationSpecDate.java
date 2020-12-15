package stepDefinations;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinationSpecDate {
	
	Response resp2, resp3;
	int statCode;
	String resp;
	
	@Given("Rates API for Specific date Foreign Exchange rates")
	public void rates_API_for_Specific_date_Foreign_Exchange_rates() throws Throwable {
		System.out.println("Ratest API for specific Foreign Exchange rate :: >> ");
	}
	
	
	@When("The API is available2")
	public void the_API_is_available2() throws Throwable {
		resp2 = given().
		get("https://api.ratesapi.io/api/2020-12-15");		
	}
	
	@When("^A future date is provided in the URL \"([^\"]*)\"$")
	public void a_future_date_is_provided_in_the_url() throws Throwable {
		resp3 = given().
				get("https://api.ratesapi.io/api/2021-12-15");
	}
	
	@When("^A future date is provided in the url \"([^\"]*)\"$")
	public void a_future_date_is_provided_in_the_url(String sFutureDate) throws Throwable {

		resp = given().
					get("https://api.ratesapi.io/api/"+sFutureDate+""). 
			   then(). 
		  			contentType(ContentType.JSON).
		  			extract().
					path("date");
	}

	
	@Then("An automated test suite should run which will assert the success status of the response2")
	public void an_automated_test_suite_should_run_which_will_assert_the_success_status_of_the_response2() throws Throwable {
		
		statCode = resp2.statusCode();
		System.out.println("output ::>> expected response is '200' and current respose is >  "+statCode);
		stepDefination.verifyStausCode(statCode, 200);			
	}
	
	@Then("An automated test suite should run which will assert the response2")
	public void an_automated_test_suite_should_run_which_will_assert_the_response2() throws Throwable {
	   
		System.out.println("output ::>> expected response is '200' and current respose is >  "+statCode);
		stepDefination.verifyStausCode(statCode, 200);	
	}
	
	@Then("^An automated test suite should run which will validate that the response matches for the current date \"([^\"]*)\"$")
	public void an_automated_test_suite_should_run_which_will_validate_that_the_response_matches_for_the_current_date(String sCurrentDate) throws Throwable {
		System.out.println("Response is >>>>>>>>>>>>>>>>>> :: "+resp);		
		assertTrue("Condition to verify date is successfull .... >>>>>>>> ", resp.contentEquals(sCurrentDate));		
	}
	
	
}
