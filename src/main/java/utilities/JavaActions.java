package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JavaActions {

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
	
	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException{
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}

}
