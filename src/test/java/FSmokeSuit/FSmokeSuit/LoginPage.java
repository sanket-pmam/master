package FSmokeSuit.FSmokeSuit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class LoginPage extends AutomationUtilities 
{
	public ObjectRepository objectrepository = null;

	public LoginPage(WebDriver driver)
	{		
      objectrepository = ObjectRepository.getInstance(driver);
	}

public void Agentlogin(String sUserName, String sPassword) throws InterruptedException, IOException 
{
	
	if (objectrepository.getInpUserNameLogin().isDisplayed()) {	
sendKeysToTextField(objectrepository.getInpUserNameLogin(), sUserName,
		"Username");
sendKeysToTextField(objectrepository.getInpPasswordLogin(), sPassword,
		"Password");
buttonClick(objectrepository.getBtnLogin(), 10, "Login");

AutomationUtilities.LogSummary(LogPath,"Agent Log In is done Sucessfully");

}
}

}
