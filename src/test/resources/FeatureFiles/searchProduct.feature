Feature: Search and place order for product

@orderProduct
Scenario Outline: Search experience for product in both home and Topdeals page
	Given User is on GreenKart landing page
	When User searched with short name "<Product>" and add "<Quantity>" of the product
	And Extracted actual name of product
	And User goes to Topdeal page
	Then User searched for same shortname <Product> in Topdeal page
	And Check if product exist

	Examples:
	| Product | Quantity |
	| Tom | 1 |
	| beet | 1 |