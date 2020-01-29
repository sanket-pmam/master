package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WorkersCompensation extends AutomationUtilities {

	public static WebDriver driver=null;		
	public static ObjectRepository objectrepository = null;
	
	public WorkersCompensation(WebDriver driver) {
//		PageFactory.initElements(driver, this);
		objectrepository = ObjectRepository.getInstance(driver);
	}
	
	public void BusinessSummary(LoadManager objWCLoadManager,WebDriver driver) throws InterruptedException, IOException, AWTException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = new Date();
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -15);
	    
		buttonClick(objectrepository.getWCState(),10,"Click on State");
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objWCLoadManager.getWCState(),"State Name");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCClassCodes(),objWCLoadManager.getWCClassCode(),"Class Code");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getbtnWCContinue(),10,"Click on Continue");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		String sBusinessName = "FCGA AUTM-"+AutomationUtilities.getRandomString (9);
		sendKeysToTextField(objectrepository.gettxtWCBussInsuredName(),sBusinessName,"Business Name");
		System.out.println("Insured Name / Business Name is : "+sBusinessName);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		AutomationUtilities.LogSummary(LogPath,"Insured Name / Business Name is : "+sBusinessName);
		
		buttonClick(objectrepository.getdpdWCLegalEntity(),10,"Click on Legal Entity");
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objWCLoadManager.getWCLegalEntity(),"State Name");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCDBAName(),sBusinessName+"DB","Agent Entered DBA Name as Same as Business Name");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCAddress1(),objWCLoadManager.getWCAddress1(),"Address1 is been entered");
		Thread.sleep(10000);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
//		sendKeysToTextField(objectrepository.gettxtWCAddress2(),objWCLoadManager.getWCAddress2(),"Address2 is been entered");
		sendKeysToTextField(objectrepository.gettxtWCAddress2(),"Test2_Address","Address2 is been entered"); //*****Temp Changes put static address
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCZipCode(),objWCLoadManager.getWCZipCode(),"Zipcode is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    
		EsendKeysToTextField(objectrepository.gettxtWCDateBussinessStart(),dateFormat.format(cal.getTime()),"Bussiness Start Date is entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getdpdWCEmployerLimit(),10,"Click on EmployerLimit");
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objWCLoadManager.getWCEmployerLimit(),"Employer Limit");
		
		
		sendKeysToTextField(objectrepository.gettxtWCEffectiveDate(),dateFormat.format(date),"Effective date is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		if(objWCLoadManager.getWCExpMod() != null) {
		System.out.println("Clcking Current Experience Mod radio button");
		WebElement element = objectrepository.getlblWCrdoCurrExpModYes();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('rdoCurrExpModYes').click();", element);
		System.out.println("Radio button has been selected");
		Thread.sleep(2000);
		
		sendKeysToTextField(objectrepository.gettxtWCExpMod(),"0.5","Current Experience Mod is entered");
		
		}else {
			
			buttonClick(objectrepository.getlblWCrdoCurrExpModNo(),10,"Current Experience Mod is selected as No");
		}
		
		sendKeysToTextField(objectrepository.gettxtWCFirstName(),objWCLoadManager.getWCFirstName(),"Owner/Officer First Name is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCLastName(),objWCLoadManager.getWCLastName(),"Owner/Officer Last Name is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCPerOwner(),objWCLoadManager.getWCPerOwner(),"Owner/Officer percentage is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		if(objWCLoadManager.getWCInclude().equalsIgnoreCase("Yes")) {
			System.out.println("value of radio button is"+objWCLoadManager.getWCInclude());
			
			System.out.println("driver ---"+driver);
//			javascriptExecutorClick( driver, objectrepository.gettxtWCIncluderd(), "Include radio button is clicked");
//			buttonClick(objectrepository.gettxtWCIncluderd(),10,"Include radio button is clicked");
			
		}else {
			System.out.println("value of radio button is"+objWCLoadManager.getWCInclude());
			Thread.sleep(2000);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("document.getElementById('radios1').click();");
			
			
//			javascriptExecutorClick(objectrepository.gettxtWCExcluderd(), "Exclude radio button is clicked");
			buttonClick(objectrepository.gettxtWCExcluderd(),10,"Exclude radio button is clicked");
		}
		
		sendKeysToTextField(objectrepository.gettxtWCdesc(),"XYZ","Description is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCFTEmployee(),objWCLoadManager.getWCFTEmployee(),"Full time Employee is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCPTEmployee(),objWCLoadManager.getWCPTEmployee(),"Part time Employee is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWCGrossannualPayroll(),objWCLoadManager.getWCGrossannualPayroll(),"Gross Annual Payroll is been entered");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getBtnWCNext(),10,"Next button is saved sucessfully.");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		System.out.println("Business Summary have been completed Sucessfully");
		
		AutomationUtilities.LogSummary(LogPath,"Business Summary have been completed Sucessfully");
	
	}
	
	public void GeneralQuestions(LoadManager objWCLoadManager,WebDriver driver) throws IOException, InterruptedException {
		System.out.println("General Question Function has been called");
		Thread.sleep(50000);
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
		
		checkCheckBox(driver, objectrepository.chkBedding(),10,"Bedding Plants");
		
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("document.getElementById('radios1').click();");
	}
}
