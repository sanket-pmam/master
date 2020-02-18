package FSmokeSuit.FSmokeSuit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends AutomationUtilities {

		public ObjectRepository objectrepository = null;

		public HomePage(WebDriver driver) {
			objectrepository = ObjectRepository.getInstance(driver);
		}
		
		public void SelectAgent(String sAgentName) throws InterruptedException, IOException 
		{
			
			System.out.println("Selecting Agent");
			Thread.sleep(2000);
			buttonClick(objectrepository.getSelectAgent(),50,"Agency Contact");
			
			EsendKeysToTextField(objectrepository.getSearchAgent(), sAgentName,"AgentName");
			
//		    buttonClick(objectrepository.getbtnContinue(), 30, "Continue Button");
		    buttonClickWithoutWait(objectrepository.getbtnContinue(), "Continue Button");
		    AutomationUtilities.LogSummary(LogPath,"Agent Name is selected Sucessfully");
		}
		
		public void CreateNewQuote (WebDriver driver, String sProductName) throws InterruptedException, IOException 
		{
			Thread.sleep(20000);
			System.out.println("On quote Page...");
			buttonClick(objectrepository.getbtnNewQuote(),10,"New Quote Button is clicked");
			String sRandomNumber = AutomationUtilities.getRandomString (9);
			
			if (sProductName.equalsIgnoreCase("GL")){
				
				buttonClick(objectrepository.getbtnrdbGeneralLiability(),30,"GL Radio Button is clicked");
				System.out.println("Selecting GL Radio Button");
			}
			else {
				System.out.println("Selecting WC Radio Button");
				Thread.sleep(5000);
				buttonClickWithoutWait(objectrepository.getbtnrdbWorkersComp(),"WC Radio Button is clicked");
//				buttonClick(objectrepository.getbtnrdbWorkersComp(),30,"WC Radio Button is clicked");
				
				
				sendKeysToTextField(objectrepository.getinpFEIN(),sRandomNumber,"FEIN Number is Entered");
				
			}
		    buttonClick(objectrepository.getbtnHContinue(), 10, "Continue Button is clicked");
		    AutomationUtilities.LogSummary(LogPath,"New Quote is going to be created");
		}
}

