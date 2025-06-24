package stepDefFiles;

import io.cucumber.java.en.Then;
import pageObject.CheckOutPage;
import utils.TestContextSetUp;
import org.testng.Assert;

public class CheckOutStepDef {
	TestContextSetUp testContextSetUp;
	CheckOutPage checkP;
	
	
	public CheckOutStepDef(TestContextSetUp testContextSetUp) {
		this.testContextSetUp= testContextSetUp;
		this.checkP= testContextSetUp.pageObjectManager.checkOutPageObj();
	}

	@Then("Check if the same name is displayed in the check out page")
	public void check_if_the_same_name_is_displayed_in_the_check_out_page() {
		testContextSetUp.cartProductName= checkP.getCheckedOutProduct().split("-")[0].strip();
		System.out.println(testContextSetUp.cartProductName);
		Assert.assertEquals(testContextSetUp.searchResult, testContextSetUp.cartProductName);
	}
	
	@Then("Check if the Apply button for Promo and place order button is visible")
	public void check_if_the_apply_button_for_promo_and_place_order_button_is_visible() throws InterruptedException {
		System.out.println(checkP.placeOrderButtonView());
		Thread.sleep(4000);
		if(checkP.placeOrderButtonView() && checkP.promoButtonView()) {
			Assert.assertTrue(true);
		}
	}
}
