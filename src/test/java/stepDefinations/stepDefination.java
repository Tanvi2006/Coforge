package stepDefinations;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefination {

	Response resp, resp1, resp2, resp3;
	int statCode, statCode1, statCode2, statCode3;
	
	@Given("Rates API for Latest Foreign Exchange rates")
	public void rates_API_for_Latest_Foreign_Exchange_rates() throws Throwable {	    		
		
		System.out.println("Ratest API for Latest Foreign Exchange rate :: >> ");
			   		
	}

	@When("The API is available")
	public void the_API_is_available() throws Throwable {
		resp = given().
		get("https://api.ratesapi.io/api/latest HTTP/2");		
	}
	
	@When("^An incorrect or incomplete url is provided \"([^\"]*)\"$")
	public void an_incorrect_or_incomplete_url_is_provided(String sUrl) throws Throwable {
	    
		resp1 = given().
				get(sUrl);
	}
	
	@Then("An automated test suite should run which will assert the success status of the response")
	public void an_automated_test_suite_should_run_which_will_assert_the_success_status_of_the_response() throws Throwable {
		
		statCode = resp.statusCode();
		System.out.println("output ::>> expected response is '200' and current respose is >  "+statCode);
		verifyStausCode(statCode, 200);			
	}	
	
	@Then("An automated test suite should run which will assert the response")
	public void an_automated_test_suite_should_run_which_will_assert_the_response() throws Throwable {
	   
		System.out.println("output ::>> expected response is '200' and current respose is >  "+statCode);
		verifyStausCode(statCode, 200);	
	}

	@Then("Test case should assert the correct response supplied by the call")
	public void test_case_should_assert_the_correct_response_supplied_by_the_call() throws Throwable {
		statCode1 = resp1.statusCode();
		
		System.out.println("Status code for 1 is: >>>>>>>>>>>>> "+statCode1);
		verifyStausCode(statCode1, 400);
	}
	
	public static void verifyStausCode(int CurrentStatus, int ExpectedStatus) {
		
		if(CurrentStatus == ExpectedStatus)
		{
			System.out.println("Verification succesfull :: >> "+CurrentStatus);
			assertTrue("output ::>> expected response is "+ExpectedStatus+" and current respose is "+CurrentStatus+"", true);
			assertEquals(CurrentStatus, ExpectedStatus);
		}
		else
		{
			assertTrue("output ::>> expected response is "+ExpectedStatus+" and current respose is "+CurrentStatus+"", false);
			assertEquals(CurrentStatus, ExpectedStatus);		
		}		
	}
	
	
}
