package FSmokeSuit.FSmokeSuit;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationDriver {

	private static WebDriver objWebDriver = null;
	String testcasePath;
	String TCSheetName;
	String TCSnapPath;
	String TCLogPath;
	String TCReportPath;
	String TestCaseID;
	String Product;

	@DataProvider(name = "SmokeData")
	public Object[][] createTestData() throws IOException {

		Object[][] dataSet = null;

		try {
			testcasePath = System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("TESTCASE_PATH");
			//System.out.println("testcasePath>>>>>"+testcasePath);
			TCSheetName = AutomationUtilities.getDataFromPropertiesFile("TCSHEETNAME");
			TCSnapPath = System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("TCSNAPPATH");
			TCLogPath = System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("TCLOGPATH");
			TCReportPath = AutomationUtilities.getDataFromPropertiesFile("REPORT_PATH");
			Product = AutomationUtilities.getDataFromPropertiesFile("Product");

			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
			AutomationUtilities.LogPath = TCLogPath + "NewLog_" + myFormatObj.format(myDateObj).toString() + ".txt";
			AutomationUtilities.AutmSnapfile = new File(
					TCSnapPath + "NewSnap_" + myFormatObj.format(myDateObj).toString());
			TCLogPath = AutomationUtilities.LogPath;

			ArrayList<LoadManager> TestCasesNo;
			AutomationUtilities.LogSummary(TCLogPath, "Please Enter Product Name to start SmokeTest : (WC/GL)");
			TCSheetName = TCSheetName + "_" + Product;
			AutomationUtilities.LogSummary(TCLogPath, "Sheet Name : " + TCSheetName);
			AutomationUtilities.LogSummary(TCLogPath, "Product:" + Product);
			if (TCSheetName.contains("GL")) {
				TestCasesNo = ExcelUtil.excelGetAllData_GL(testcasePath, TCSheetName, 1, 0);
			} else {
				TestCasesNo = ExcelUtil.excelGetAllData_WC(testcasePath, TCSheetName, 1, 0);
			}
			int arraySize = TestCasesNo.size();
			dataSet = new Object[arraySize][];
			for (int count = 0; count < arraySize; count++) {
				dataSet[count] = new Object[1];
				if (TestCasesNo.get(count) != null) {
					dataSet[count][0] = TestCasesNo.get(count);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return dataSet;
	}

	String UserName;
	String Password;

	@Test(dataProvider = "SmokeData")
	public void AutomationDriverExecution(LoadManager objLoadManager) {

		TestCaseID = objLoadManager.getTestCaseId();
		AutomationUtilities.testCaseID = TestCaseID;
		AutomationUtilities.tcSnapPath = TCSnapPath;

		try {
			AutomationUtilities.LogSummary(TCLogPath, "========********************************========");
			AutomationUtilities.LogSummary(TCLogPath, "New Quote is getting Created.");
			System.out.println(
					objLoadManager.getTestCaseId() + "-" + objLoadManager.getTCScenarios() + " is getting Executed.");
			AutomationUtilities.LogSummary(TCLogPath,
					objLoadManager.getTestCaseId() + "-" + objLoadManager.getTCScenarios() + " is getting Executed.");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("CHROME_DRIVER_PATH"));
//			WebDriverManager.chromedriver().setup();
			objWebDriver = new ChromeDriver();
			UserName = AutomationUtilities.getDataFromPropertiesFile("USER_NAME");
			Password = AutomationUtilities.getDataFromPropertiesFile("PASSWORD");
			AutomationUtilities.LogSummary(TCLogPath, "UserName: " + UserName);
			AutomationUtilities.LogSummary(TCLogPath, "Password:" + Password);
			
			ChromeOptions options = new ChromeOptions();

			objWebDriver = new ChromeDriver(options);
			objWebDriver.manage().timeouts().implicitlyWait(130, TimeUnit.SECONDS);

			LoginPage objLoginPage = new LoginPage(objWebDriver);
			HomePage objhomepage = new HomePage(objWebDriver);
			GeneralLiability objgeneralliability = new GeneralLiability(objWebDriver);
			WorkersCompensation objworkerscompensation = new WorkersCompensation(objWebDriver);
			objWebDriver.manage().window().maximize();

			objWebDriver.get(AutomationUtilities.getDataFromPropertiesFile("URL"));
			AutomationUtilities.LogSummary(TCLogPath, "URL: " + AutomationUtilities.getDataFromPropertiesFile("URL"));
			objWebDriver.manage().timeouts().pageLoadTimeout(210, TimeUnit.SECONDS);
			AutomationUtilities.Screenshot(TCSnapPath, TestCaseID);

			objLoginPage.Agentlogin(objWebDriver, UserName, Password);
			AutomationUtilities.Screenshot(TCSnapPath, TestCaseID);

			objhomepage.SelectAgent(objLoadManager.getAgentName());
			AutomationUtilities.Screenshot(TCSnapPath, TestCaseID);

			objhomepage.CreateNewQuote(objWebDriver, objLoadManager.getProduct());

			if (objLoadManager.getProduct().contains("GL")) {

				objgeneralliability.GatekepeerQuestion(objWebDriver);
				objgeneralliability.Risklevel(objLoadManager);
				objgeneralliability.classPayroll(objLoadManager, objWebDriver);

				if (objLoadManager.getAI().equalsIgnoreCase("Yes")
						|| objLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
					objgeneralliability.AI(objWebDriver);
				} else {
					System.out.println("Additional Insured and Wavier is selected as No.");
					AutomationUtilities.LogSummary(TCLogPath, "Additional Insured and Wavier is selected as No.");
				}

				if (objLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
					objgeneralliability.IM(objLoadManager, objWebDriver);
				}

				objgeneralliability.ClassSpecificQues(objWebDriver, "No");
				objgeneralliability.Quote(objLoadManager, objWebDriver);
				AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.QuoteNo, objLoadManager,
						"Quote No.");

				objgeneralliability.Application(objLoadManager, objWebDriver);
				objgeneralliability.PolicyIssue(objLoadManager, objWebDriver);
				AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.PolicyNo, objLoadManager,
						"Policy No.");

			} else {

				objworkerscompensation.BusinessSummary(objLoadManager, objWebDriver);
				objworkerscompensation.GeneralQuestions(objLoadManager, objWebDriver);
				objworkerscompensation.Losses(objLoadManager, objWebDriver);
				objworkerscompensation.wcApplication(objLoadManager, objWebDriver);
				
			
				String sBusinessNameValue = WorkersCompensation.sBusinessName;
				System.out.println("sBusinessNameValue-----" +sBusinessNameValue);
				objworkerscompensation.wcApplication(objLoadManager, objWebDriver);
				objgeneralliability.PolicyIssue(objLoadManager, objWebDriver);
				System.out.println("WC Test Data is not been provided and incorporated. Please try Later.");
			}		

//			objWebDriver.close();
//			objWebDriver.quit();
			objWebDriver = null;

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			if (objWebDriver != null) {
//				objWebDriver.close();
//				objWebDriver.quit();
			}
		}
	}
}
