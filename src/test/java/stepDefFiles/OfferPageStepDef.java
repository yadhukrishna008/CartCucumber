package stepDefFiles;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObject.TopDealsPage;
import utils.TestContextSetUp;


public class OfferPageStepDef {
	TestContextSetUp testContextSetUp;
	TopDealsPage TDP;
	
	public OfferPageStepDef(TestContextSetUp testContextSetUp) {
		this.testContextSetUp= testContextSetUp;
		this.TDP= testContextSetUp.pageObjectManager.topDealPageObj();
	}
	
	
	@Then("^User searched for same shortname (.+) in Topdeal page$")
	public void user_searched_for_same_shortname_in_topdeal_page(String searchName) throws InterruptedException  {
		testContextSetUp.genericUtils.switchToChildSite();
		
		TDP.searchItem(searchName);
	    testContextSetUp.dealResult= TDP.SearchResultText();
	    Thread.sleep(2000);
	}

	@Then("Check if product exist")
	public void check_if_product_exist() {
		Assert.assertEquals(testContextSetUp.searchResult, testContextSetUp.dealResult, "May have a bug");
	}
}
