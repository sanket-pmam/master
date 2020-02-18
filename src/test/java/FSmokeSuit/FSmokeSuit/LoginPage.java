package FSmokeSuit.FSmokeSuit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AutomationUtilities {
	public ObjectRepository objectrepository = null;

	public LoginPage(WebDriver driver) {
		objectrepository = ObjectRepository.getInstance(driver);
	}

	public void Agentlogin(WebDriver driver, String sUserName, String sPassword)
			throws InterruptedException, IOException {

		if (objectrepository.getInpUserNameLogin().isDisplayed()) {
			sendKeysToTextField2(driver, objectrepository.getInpUserNameLogin(), sUserName, "Username"); // Temp changing the this function to pass the webdriver in order to highlight the element 
			sendKeysToTextField(objectrepository.getInpPasswordLogin(), sPassword, "Password");
			buttonClick(objectrepository.getBtnLogin(), 10, "Login");

			AutomationUtilities.LogSummary(LogPath, "Agent Log In is done Sucessfully");

		}
	}

}
