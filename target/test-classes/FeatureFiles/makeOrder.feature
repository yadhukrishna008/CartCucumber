Feature: Make order for product and check out the cart

@makeOrder
Scenario Outline: Search for product in home page and check the cart
	Given User is on GreenKart landing page
	When User searched with short name "<Product>" and add "<Quantity>" of the product
	And Extracted actual name of product
	And Add the product to the cart
	And User opens the cart and proceed to check out page
	Then Check if the same name is displayed in the check out page
	And Check if the Apply button for Promo and place order button is visible
	
		Examples:
	| Product | Quantity |
	| Tom | 3 |