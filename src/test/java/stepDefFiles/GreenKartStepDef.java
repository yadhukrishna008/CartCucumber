package stepDefFiles;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.LandingPage;
import utils.TestContextSetUp;


public class GreenKartStepDef {
	TestContextSetUp testContextSetUp;
	LandingPage LP;
	
	public GreenKartStepDef(TestContextSetUp testContextSetUp) {
		this.testContextSetUp= testContextSetUp;
		this.LP= testContextSetUp.pageObjectManager.LandingPageObj();
	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		Assert.assertTrue(LP.getLandingPageTitle().contains("GreenKart"));
	}
	
//	@When("^User searched with short name (.+) and extracted actual name of product$")
//	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
//		LP= testContextSetUp.pageObjectManager.LandingPageObj();
//		LP.searchItem(shortName);
//	    Thread.sleep(2000);
//	    testContextSetUp.searchResult= LP.getSearchResultEl().split("-")[0].trim();
////	    System.out.println("search page" + testContextSetUp.searchResult);
//	}
	
	@When("User searched with short name {string} and add {string} of the product")
	public void user_searched_with_short_name_and_add_of_the_product(String prod, String quantity) throws InterruptedException {
		LP.searchItem(prod);
	    Thread.sleep(2000);
	    
	    for(int i=1; i<Integer.parseInt(quantity); i++) {
	    	LP.clickItemIncrement();
	    }
	}
	
	@When("User goes to Topdeal page")
	public void user_goes_to_topdeal_page() {
	    LP.clickTopDealsLink();
	}
	
	@When("Extracted actual name of product")
	public void Extracted_actual_name_of_product() {
		testContextSetUp.searchResult= LP.getSearchResultEl().split("-")[0].trim();
	}
	@When("Add the product to the cart")
	public void add_the_product_to_the_cart() {
		LP.clickAdd2Cart();
	}
	
	@When("User opens the cart and proceed to check out page")
	public void user_opens_the_cart_and_proceed_to_check_out_page() {
		LP.clickCartIcon();
		LP.proceed2Checkout();
	}
}
