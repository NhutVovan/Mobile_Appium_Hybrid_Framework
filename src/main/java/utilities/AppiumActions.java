package utilities;

import java.util.List;
import org.openqa.selenium.WebElement;


public class AppiumActions {

	public Double convertPriceFromStringToDouble(String priceString) {
		 return Double.parseDouble(priceString.substring(1));
	}
	
	public Double summaryPriceInCart(List<WebElement> productsPrice) {
		int count = productsPrice.size();
		Double sum = 0.0;
		for (int i=0; i<count; i++) {
			String amountString = productsPrice.get(i).getText();
			sum = sum + convertPriceFromStringToDouble(amountString);
		}
		return sum;
	}
	

}
