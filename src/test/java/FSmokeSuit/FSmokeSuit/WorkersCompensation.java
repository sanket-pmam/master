package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

public class WorkersCompensation extends AutomationUtilities {

	public static WebDriver driver = null;
	public static ObjectRepository objectrepository = null;
	public static String sBusinessName;

	public WorkersCompensation(WebDriver driver) {
//		PageFactory.initElements(driver, this);
		objectrepository = ObjectRepository.getInstance(driver);
	}

	public String BusinessSummary(LoadManager objWCLoadManager, WebDriver driver)
			throws InterruptedException, IOException, AWTException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -15);

		buttonClick(objectrepository.getWCState(), 10, "Click on State");
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCState(), "State Name");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCClassCodes(), objWCLoadManager.getWCClassCode(), "Class Code");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		buttonClick(objectrepository.getbtnWCContinue(), 10, "Click on Continue");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sBusinessName = "FCGA AUTM-" + AutomationUtilities.getRandomString(9);
		sendKeysToTextField(objectrepository.gettxtWCBussInsuredName(), sBusinessName, "Business Name");
		System.out.println("Insured Name / Business Name is : " + sBusinessName);
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		AutomationUtilities.LogSummary(LogPath, "Insured Name / Business Name is : " + sBusinessName);

		buttonClick(objectrepository.getdpdWCLegalEntity(), 10, "Click on Legal Entity");
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCLegalEntity(), "State Name");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCDBAName(), sBusinessName + "DB",
				"Agent Entered DBA Name as Same as Business Name");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCAddress1(), objWCLoadManager.getWCAddress1(),
				"Address1 is been entered");
		Thread.sleep(10000);
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

//		sendKeysToTextField(objectrepository.gettxtWCAddress2(),objWCLoadManager.getWCAddress2(),"Address2 is been entered");
		sendKeysToTextField(objectrepository.gettxtWCAddress2(), "Test2_Address", "Address2 is been entered"); // *****Temp
																												// Changes
																												// put
																												// static
																												// address
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCZipCode(), objWCLoadManager.getWCZipCode(),
				"Zipcode is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		EsendKeysToTextField(objectrepository.gettxtWCDateBussinessStart(), dateFormat.format(cal.getTime()),
				"Bussiness Start Date is entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		buttonClick(objectrepository.getdpdWCEmployerLimit(), 10, "Click on EmployerLimit");
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCEmployerLimit(),
				"Employer Limit");

		sendKeysToTextField(objectrepository.gettxtWCEffectiveDate(), dateFormat.format(date),
				"Effective date is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		if (objWCLoadManager.getWCExpMod() != null) {
			System.out.println("Clcking Current Experience Mod radio button");
			WebElement element = objectrepository.getlblWCrdoCurrExpModYes();

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.getElementById('rdoCurrExpModYes').click();", element);
			System.out.println("Radio button has been selected");
			Thread.sleep(2000);

			sendKeysToTextField(objectrepository.gettxtWCExpMod(), "0.5", "Current Experience Mod is entered");

		} else {

			buttonClick(objectrepository.getlblWCrdoCurrExpModNo(), 10, "Current Experience Mod is selected as No");
		}

		sendKeysToTextField(objectrepository.gettxtWCFirstName(), objWCLoadManager.getWCFirstName(),
				"Owner/Officer First Name is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCLastName(), objWCLoadManager.getWCLastName(),
				"Owner/Officer Last Name is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCPerOwner(), objWCLoadManager.getWCPerOwner(),
				"Owner/Officer percentage is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		if (objWCLoadManager.getWCInclude().equalsIgnoreCase("Yes")) {
			System.out.println("value of radio button is" + objWCLoadManager.getWCInclude());

			System.out.println("driver ---" + driver);
//			javascriptExecutorClick( driver, objectrepository.gettxtWCIncluderd(), "Include radio button is clicked");
//			buttonClick(objectrepository.gettxtWCIncluderd(),10,"Include radio button is clicked");

		} else {
			System.out.println("value of radio button is" + objWCLoadManager.getWCInclude());
			Thread.sleep(2000);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.getElementById('radios1').click();");

//			javascriptExecutorClick(objectrepository.gettxtWCExcluderd(), "Exclude radio button is clicked");
			buttonClick(objectrepository.gettxtWCExcluderd(), 10, "Exclude radio button is clicked");
		}

		sendKeysToTextField(objectrepository.gettxtWCdesc(), "XYZ", "Description is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCFTEmployee(), objWCLoadManager.getWCFTEmployee(),
				"Full time Employee is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCPTEmployee(), objWCLoadManager.getWCPTEmployee(),
				"Part time Employee is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		sendKeysToTextField(objectrepository.gettxtWCGrossannualPayroll(), objWCLoadManager.getWCGrossannualPayroll(),
				"Gross Annual Payroll is been entered");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		buttonClick(objectrepository.getBtnWCNext(), 10, "Next button is saved sucessfully.");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		System.out.println("Business Summary have been completed Sucessfully");

		AutomationUtilities.LogSummary(LogPath, "Business Summary have been completed Sucessfully");

		return sBusinessName;
	}

	public void GeneralQuestions(LoadManager objWCLoadManager, WebDriver driver)
			throws IOException, InterruptedException, AWTException {
		System.out.println("General Question Function has been called");
		Thread.sleep(5000);
		javascriptExecutorClick(driver, objectrepository.rdQuestion_1(), "Question-1");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_2(), "Question-2");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_3(), "Question-3");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_4(), "Question-4");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_5(), "Question-5");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_6(), "Question-6");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_7(), "Question-7");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_8(), "Question-8");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_9(), "Question-9");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_10(), "Question-10");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_11(), "Question-11");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_12(), "Question-12");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_13(), "Question-13");

		System.out.println("Clicking Bedding plants checkbox...");

		checkCheckBox(driver, objectrepository.chkBedding(), 2, "Bedding Plants");

		javascriptExecutorClick(driver, objectrepository.rdIQuestion_1(), "Question-1");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_2(), "Question-2");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_3(), "Question-3");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_4(), "Question-4");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_5(), "Question-5");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_6(), "Question-6");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_7(), "Question-7");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_8(), "Question-8");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_9(), "Question-9");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_10(), "Question-10");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_11(), "Question-11");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_12(), "Question-12");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_13(), "Question-13");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_14(), "Question-14");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_15(), "Question-15");

		System.out.println("Click on Next Button");
		buttonClick(objectrepository.getBtnWCNext(), 10, "Next button is saved sucessfully.");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		System.out.println("General & Industrial Questions have been completed Sucessfully");

	}

	public void Losses(LoadManager objWCLoadManager, WebDriver driver)
			throws IOException, InterruptedException, AWTException {
		System.out.println("Losses function has been called");

		Thread.sleep(5000);
		selectDropdownlitag(driver, objectrepository.gethadCoverage(), "Yes", "Had a coverage Yes/No");
//		selectDropdownByText(objectrepository.gethadCoverage(), "Yes", "Had a coverage Yes/No"); 
		javascriptExecutorClick(driver, objectrepository.rdAnyLosses(), "Any Losses Yes/No");

		/*
		 * ****************
		 * 
		 * // sendKeysToTextField(objectrepository.gettxtLossCarrier(),objWCLoadManager.
		 * getLPCarrier(),"Loss Page Carrier");
		 * 
		 * // Need to add a data set in Excel sheet so temporarily adding new line with
		 * static text
		 */

		sendKeysToTextField(objectrepository.gettxtLossCarrier(), "Test", "Loss Page Carrier");

		buttonClick(objectrepository.btnSubmit(), 10, "Submit Losses");

		System.out.println("Losses Page has been completed");
	}

	public void wcApplication(LoadManager objWCLoadManager, WebDriver driver, String sBusinessNameValue)
			throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		System.out.println("Application function has been called");
		System.out.println("Driver" + driver);
		Thread.sleep(10000);

		System.out.println("Drop Down to select name insured");
		Thread.sleep(3000);
		System.out.println("Clicking on Name Insured Drop Down");
		WebElement selWCNameInsured_element = objectrepository.selWCNameInsured();
		selWCNameInsured_element.click();
		
		System.out.println("Clicking on Name Insured Drop Down Text box...");
		WebElement WCNameInsuredtxt_element =  objectrepository.WCNameInsuredtxt();
		WCNameInsuredtxt_element .click();

		Thread.sleep(3000);
		System.out.println("Selecting WCNameInsuredList1");
		
//		selectDropdownlitag(driver, objectrepository.WCNameInsuredList1(), "Primary", "Relaionship");
		
		System.out.println("Selecting relationship" );
		
		selectDropdownlitag(driver, objectrepository.WCApplicationRelationsip(), "Primary", "Relaionship");
		sendKeysToTextField(objectrepository.WAppliactionCAddress1(), "Test","WC Application Address");
//		sendKeysToTextField(objectrepository.WAppliactionCity(), "Test","WC Application City"); // Temp commenting this line to add city
		sendKeysToTextField(objectrepository.WAppliactionCity(),"Tampa","WC Application City");
		buttonClick(objectrepository.WAppliactionState(),10,"WC Application State drop down"); 
		Thread.sleep(2000);
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(), "Florida","State Name");
		sendKeysToTextField(objectrepository.WCAppliactionZipcode(),"33604","WC Application Zipcode");
		buttonClick(objectrepository.WAppliactionAddLoact(),10,"Add Location button");
		
		


	}

//		AutomationUtilities.Traverse(driver,"Download Quote Document");

}
