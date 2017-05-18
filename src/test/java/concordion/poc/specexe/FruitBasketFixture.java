package concordion.poc.specexe;


import org.junit.runner.RunWith;

import concordion.poc.sut.Basket;
import concordion.poc.sut.BasketException;

import org.concordion.api.ConcordionResources;
import org.concordion.api.option.ConcordionOptions;
import org.concordion.integration.junit4.ConcordionRunner;

@RunWith(ConcordionRunner.class)
public class FruitBasketFixture {

	private static final String BANANA_FRUIT = "banana";
	private static final String APPLE_FRUIT = "apple";
	private static final String LEMON_FRUIT = "lemon";
	private static final String ARTICLE_NOT_SUPPORTED_MESSAGE = "article not supported";
	private static final String WRONG_QUANTITY_MESSAGE = "wrong quantity";
	private Basket basket = new Basket();
	private String message;
	
	public double getBasketTotal() {

		//return (bananaPrice * bananaQuantity) + (applePrice * appleQuantity);
		return basket.total();
	}

	public String getMessage() {
		return message;
	}
	
	public void setPrice(String price, String fruit) {
		basket.setPrice(fruit, Double.parseDouble(price));
	}
	
	
	
	
	public void setBananaPrice(String price) {
		basket.setPrice(BANANA_FRUIT, Double.parseDouble(price));
	}

	public void setApplePrice(String price) {
		basket.setPrice(APPLE_FRUIT, Double.parseDouble(price));
	}

	public void setBananaQuantity(String quantity) throws NumberFormatException {
		try {
			basket.add(BANANA_FRUIT, Integer.parseInt(quantity));
		} catch (BasketException e) {
			message = e.getMessage();
		}
	}

	public void setAppleQuantity(String quantity) throws NumberFormatException {
		try {
			basket.add(APPLE_FRUIT, Integer.parseInt(quantity));
		} catch (BasketException e) {
			message = e.getMessage();
		}
	}
	
	public void setUnsupportedFruitQuantity(String quantity) throws NumberFormatException {
		try {
			basket.add(LEMON_FRUIT, Integer.parseInt(quantity));
		} catch (BasketException e) {
			message = e.getMessage();
		}
	}
	
	public void removeBananas(String quantity) throws NumberFormatException {
		try {
			basket.remove(BANANA_FRUIT, Integer.parseInt(quantity));
		} catch (BasketException e) {
			message = e.getMessage();
		}
	}
	
	public void removeApples(String quantity) throws NumberFormatException {
		try {
			basket.remove(APPLE_FRUIT, Integer.parseInt(quantity));
		} catch (BasketException e) {
			message = e.getMessage();
		}
	}

}
