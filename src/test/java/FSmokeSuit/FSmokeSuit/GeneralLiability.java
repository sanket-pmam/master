package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GeneralLiability extends AutomationUtilities {
	
	@SuppressWarnings("unused")
	private static final OutputType<Object> Jpg = null;
	public static WebDriver driver=null;		
	public static ObjectRepository objectrepository = null;
	String QClassSpecACount= null;
	
//------------------------	
	String ElementNamexpath = "//td[@style= 'display:none'][@class='border-white']";
	String QuestionNamexpath = "//tr[@class='visibleTr']";
//-------------------------
	
	public GeneralLiability(WebDriver driver) {
		PageFactory.initElements(driver, this);
		objectrepository = ObjectRepository.getInstance(driver);
		driver.manage().timeouts().implicitlyWait(130,TimeUnit.SECONDS);
	}
		
	public static int LastQCount(WebDriver driver, String XPath) {
		
		List<WebElement> elementName = driver.findElements(By.xpath(XPath));
        int lastQ = elementName.size();
        return lastQ ;
     }
	
	public void GatekepeerQuestion(WebDriver driver) throws InterruptedException, IOException {
		
    for (int i =1; i<=LastQCount(driver,ElementNamexpath);i++) {
     
    	if(i==LastQCount(driver,ElementNamexpath)-1)	{
       	 driver.findElement(By.xpath("//label[@for='radio"+(i-1)+"']")).click(); // Yes button 
       }
       else {
    	driver.findElement(By.xpath("//label[@for='radio-"+i+"']")).click(); // No button 
       }
    }
    
    buttonClick(objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");

    System.out.println("Gatekeeper Question have been completed Sucessfully");
    AutomationUtilities.LogSummary(LogPath,"Gatekeeper Question have been completed Sucessfully");
	
  }
	

	public void Risklevel(LoadManager objGlLoadManager) throws InterruptedException, IOException, AWTException {
		

		    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    Date date = new Date();
		    
			EsendKeysToTextField(objectrepository.gettxtEffectiveDate(),dateFormat.format(date),"Effective Date");
			System.out.println("Effective Date of the Quote is :"+dateFormat.format(date));
			 
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			buttonClick(objectrepository.getdpdstate(),10,"Click on State");
			EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getState(),"State Name");
			
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			buttonClick(objectrepository.getdpdCounty(),10,"Click on County");
			EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getCounty(),"County Name");
			
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			String sBusinessName = "FCGA AUTM -"+ AutomationUtilities.getRandomString (9);
			sendKeysToTextField(objectrepository.gettxtBusinessName(),sBusinessName,"Business Name");
			
			System.out.println("Insured Name / Business Name is : "+sBusinessName);
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(sBusinessName.isEmpty()) {
				
				String sIFristName = "FCGA AUTM";
				sendKeysToTextField(objectrepository.gettxtIndividualFirstName(),sIFristName,"Frist Name");
				
				String sILastName = AutomationUtilities.getRandomString (9);
				sendKeysToTextField(objectrepository.gettxtIndividualFirstName(),sILastName,"Last Name");
			}
			
			String sDescription = "FCGA-"+ AutomationUtilities.getRandomString (9);
			sendKeysToTextField(objectrepository.gettxtDescriptionOfBusiness(),sDescription,"Business Description");
			sendKeysToTextField(objectrepository.gettxtYearsInBusiness(),objGlLoadManager.getExperience(),"Years In Business");
  
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(objectrepository.gettxtYearsInTrade().isEnabled()) {
				sendKeysToTextField(objectrepository.gettxtYearsInTrade(),objGlLoadManager.getExperience(),"Years In Trade");
				AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			}
			
			sendKeysToTextField(objectrepository.gettxtClaims(),objGlLoadManager.getClaims(),"No of Claims");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
            if(objGlLoadManager.getPriorInsurance().equalsIgnoreCase("Yes")) {
            	buttonClick(objectrepository.getrbpriorinsuranceYes(),10,"Prior Insurance as Yes");
            } else {
            	buttonClick(objectrepository.getrbpriorinsuranceNo(),10,"Prior Insurance as No");
            }
			
            AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
            buttonClick(objectrepository.getdpdliabilitylimit(),10,"Click on Liability Limit");
			EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getLiabilityLimit(),"Liability Limit");
			
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			buttonClick(objectrepository.getdpdDeductiblelimit(),10,"Click on Deductible Limit");
			EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getDeductible(),"Deductible");
			
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			 if(objGlLoadManager.getAI().equalsIgnoreCase("Yes")) {
				    buttonClick(objectrepository.getrbAdditionalInsuredsYes(),10,"Additional Insurance as Yes");
	            } else {
	            	buttonClick(objectrepository.getrbAdditionalInsuredsNo(),10,"Additional Insurance as No");
	            }
			 
			 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 if(objGlLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
				   buttonClick(objectrepository.getrbWaiversYes(),10,"Waivers as Yes");
	            } else {
	            	buttonClick(objectrepository.getrbWaiversNo(),10,"Waivers as No");
	            }
			 
			 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 sendKeysToTextField(objectrepository.gettxtNoofLocation(),objGlLoadManager.getLocationAgregate(),"No of Location");
			 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 sendKeysToTextField(objectrepository.gettxtNoofProject(),objGlLoadManager.getProjectAgregate(),"No of Project");
			 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 if(objGlLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
				   buttonClick(objectrepository.getrbInlandMarineYes(),10,"Inland Marine as Yes");
	            } else {
	            	buttonClick(objectrepository.getrbInlandMarineNo(),10,"Inland Marine as No");
	            }
			 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 buttonClick(objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");   
			 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 System.out.println("Risk Level have been completed Sucessfully");
			 AutomationUtilities.LogSummary(LogPath,"Risk Level have been completed Sucessfully");
		
	}
		public void classPayroll(LoadManager objGlLoadManager, WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			String[] ClassCode = objGlLoadManager.getClassCode().split("/");
			int classcodecount = ClassCode.length;
			if(classcodecount > 1) {
			int Eprecentage = 100/classcodecount;
			for(int i=0;i<classcodecount;i++) {
				
				buttonClick(objectrepository.getdpdclasscode(),10,"Click on Class Code Drop down");
				EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),ClassCode[i],"Class Codes");
				buttonClick(objectrepository.getbtnAddClassCode(),10,"Click on Add Button");
				
				if(i == classcodecount-1) {
					
					Eprecentage = 100 - (Eprecentage*i);  
				}
				driver.findElement(By.xpath("//td[@data-fieldid ='"+ClassCode[i]+"']//parent :: tr// following-sibling :: td//input[@class='dynamicAdd form-control'][@name='percentage']")).sendKeys(Integer.toString(Eprecentage));
				AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			}
			}
			else {
				
				buttonClick(objectrepository.getdpdclasscode(),10,"Click on Class Code Drop down");
				EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getClassCode(),"Class Codes");
				buttonClick(objectrepository.getbtnAddClassCode(),10,"Click on Add Button");
				
		       
			}
			
			sendKeysToTextField(objectrepository.gettxtExpectedGrossAmount(),objGlLoadManager.getExpectedGrossReceipts(),"Expected Gross Amount");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(!objGlLoadManager.getSubClassCode().isEmpty()) {
			
			sendKeysToTextField(objectrepository.getInSubcontractorCost(),objGlLoadManager.getSubContractorGrossReciepts(),"Expected Sub Class Code Gross Amount");
			sendKeysToTextField(objectrepository.getSubcontractorCostopdes(),"OK-Approved", "Sub Contractor Description");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			buttonClick(objectrepository.getSubClasscodes(),10," Click Sub Class Code");
			EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getSubClassCode(),"Sub Class Codes");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			buttonClick(objectrepository.getbtnAddSubClassCode(),10,"Click Add Button");
			sendKeysToTextField(objectrepository.getSubClasscodePercentage(),"100","Percentage");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			}

			sendKeysToTextField(objectrepository.getUnSubcontractorCost(),objGlLoadManager.getSubContractorGrossReciepts(),"Expected Sub Class Code Gross Amount");
			sendKeysToTextField(objectrepository.gettxtActivePartner(),objGlLoadManager.getActiveOwner(),"Active Owner");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(!(classcodecount > 1)) {
				
			    sendKeysToTextField(objectrepository.getClasscodePercentage(),"200","Enter Percentage");
			    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			    
			    buttonClick(objectrepository.getbtnsaveandcontinue(),10,"Click on Save & Continue Button");
			
			if(objectrepository.getbtnClose().isEnabled()) {
				
				System.out.println("Error Message generated is : "+ objectrepository.getErrorMessage().getText().toString()+".");
				AutomationUtilities.LogSummary(LogPath,"Error Message generated is : "+ objectrepository.getErrorMessage().getText().toString()+".");	
				Thread.sleep(6000);
				
				buttonClick(objectrepository.getbtnClose(),10,"Click on Button Close");
				sendKeysToTextField(objectrepository.getClasscodePercentage(),"100","Percentage");
				AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			  }
			}
			
			buttonClick(objectrepository.getbtnsaveandcontinue(),10,"Click on Save & Continue Button");
			System.out.println("Class & Payroll have been completed Sucessfully");
			AutomationUtilities.LogSummary(LogPath,"Class & Payroll have been completed Sucessfully");				
		}
		
		public void AI(WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,1000)");
			js.executeScript("window.scrollBy(0,1000)");
			
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			buttonClick(objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
			
			System.out.println("Aditional Insured have been completed Sucessfully");
			AutomationUtilities.LogSummary(LogPath,"Aditional Insured have been completed Sucessfully");
		}
		
		public void IM(LoadManager objGlLoadManager, WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        for (int i =1; i<=LastQCount(driver,ElementNamexpath);i++) {
	        	driver.findElement(By.xpath("//label[@for='radio-"+i+"']")).click(); // no button
	        }
	        
	        buttonClick(objectrepository.getdpdinstallationfloater(),10,"Click on Installation Floater Drop down");
	        EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getInstallationFloater(),"Installation Floater have been entered");
	        AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        
	        buttonClick(objectrepository.getdpdContractorHandtools(),10,"Click on Contractor's Hand Tools Drop down");
	        EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getContractorsHandTools(),"Contractor's Hand Tools have been entered");
	        AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        
	        buttonClick(objectrepository.getdpdleasedequipment(),10,"Click on Leased Equipment Drop down");
	        EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getContractorsHandTools(),"Click on Leased Equipment Drop down");
	        AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        
	        buttonClick(objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
			
	        System.out.println("Inland Marine have been completed Sucessfully");
	        AutomationUtilities.LogSummary(LogPath,"Inland Marine have been completed Sucessfully");
	        
		}
		

	public void ClassSpecificQues (WebDriver driver, String QAns) throws InterruptedException, IOException, AWTException {
        
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	
		  if (QAns.equalsIgnoreCase("No")) {
			  
			    String xpath = "//tr[@class='visibleTr']";

	        	for (int i =1; i<=LastQCount(driver,xpath);i++) {
	       
	        		QClassSpecACount = driver.findElement(By.xpath("//tr[@class='visibleTr']["+i+"]")).getAttribute("id").toString();
					driver.findElement(By.xpath("//tr[@class='visibleTr']//td[contains(text(),'Question')]//parent :: tr// following-sibling :: td//input[contains(@name,'question"+QClassSpecACount+"')]//parent :: div//label[starts-with(@for,'radio-')]")).click(); // no button
	        	}
		  }	
        
        AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
        buttonClick(objectrepository.getbtnsaveandcontinue(),20,"Click on Save and Continue");
        
        System.out.println("Class Specific have been completed Sucessfully");
        AutomationUtilities.LogSummary(LogPath,"Class Specific have been completed Sucessfully");
	}

	public void Quote (LoadManager objGlLoadManager,WebDriver driver) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		
		
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
        Thread.sleep(45000);
		
     System.out.println("Quote Date: "+ objectrepository.getlbl_QuoteDate().getText());
     AutomationUtilities.LogSummary(LogPath,"Quote Date : "+ objectrepository.getlbl_QuoteDate().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("Term: "+ objectrepository.getlbl_Term().getText());
     AutomationUtilities.LogSummary(LogPath,"Term: "+ objectrepository.getlbl_Term().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("County Name: "+ objectrepository.getlbl_CountyTerritory().getText());
     AutomationUtilities.LogSummary(LogPath,"County Name: "+ objectrepository.getlbl_CountyTerritory().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("Insured Name: "+ objectrepository.getlbl_InsuredName().getText());
     AutomationUtilities.LogSummary(LogPath,"Insured Name: "+ objectrepository.getlbl_InsuredName().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     if(objGlLoadManager.getState().equalsIgnoreCase("Texas")) {
    	 
			sendKeysToTextField(objectrepository.gettxt_ProducerFee(),"100","Enter Producer Fee");
			buttonClick(objectrepository.getbtn_SaveProducerFee(),10,"Click on Button Save");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			Thread.sleep(10000);
			buttonClick(objectrepository.getbtn_CloseProducerFee(),10,"Click on Button Close");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     }
     
     buttonClick(objectrepository.getlnk_DownloadFWCIQuote(),30,"Click on FWCI Quote Link");
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     
     AutomationUtilities.Traverse(driver,"FWCI Quote Doc");
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("Download FWCI Quote Document");
     AutomationUtilities.LogSummary(LogPath,"Download FWCI Quote Document");
     
     buttonClick(objectrepository.getlnk_DownloadCBQuote(),10,"Click on CB Quote Link");
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     AutomationUtilities.Traverse(driver,"CB Quote Doc");
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("Download CB Quote Document");
     AutomationUtilities.LogSummary(LogPath,"Download CB Quote Document");
     
     System.out.println("FWCI Premium: "+ objectrepository.getlbl_FWCIPremium().getText());
     AutomationUtilities.LogSummary(LogPath,"FWCI Premium: "+ objectrepository.getlbl_FWCIPremium().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("FWCI MGA Policy Fee: "+ objectrepository.getlbl_FWCIMGAPolicyFee().getText());
     AutomationUtilities.LogSummary(LogPath,"FWCI MGA Policy Fee: "+ objectrepository.getlbl_FWCIMGAPolicyFee().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("CB Premium: "+ objectrepository.getlbl_CBPremium().getText());
     AutomationUtilities.LogSummary(LogPath,"CB Premium: "+ objectrepository.getlbl_CBPremium().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("FWCI MGA Policy Fee: "+ objectrepository.getlbl_CBMGAPolicyFee().getText());
     AutomationUtilities.LogSummary(LogPath,"FWCI MGA Policy Fee: "+ objectrepository.getlbl_CBMGAPolicyFee().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     if(objGlLoadManager.getState().equalsIgnoreCase("Texas")) {
    	 
     System.out.println("FWCI Producer Fee: "+ objectrepository.getlbl_FWCIProducerFee().getText());
     AutomationUtilities.LogSummary(LogPath,"FWCI Producer Fee: "+ objectrepository.getlbl_FWCIProducerFee().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("CB Producer Fee: "+ objectrepository.getlbl_CBProducerFee().getText());
     AutomationUtilities.LogSummary(LogPath,"CB Producer Fee: "+ objectrepository.getlbl_CBMGAPolicyFee().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
	  }
     
     if(objGlLoadManager.getTypeofCompany().equalsIgnoreCase("FWCI")) {
    	 
    	 buttonClick(objectrepository.getrdo_FWCIbutton(),10,"Click on FWCI Insurance Company");
         
         System.out.println("Click on FWCI Insurance Company");
         AutomationUtilities.LogSummary(LogPath,"Click on FWCI Insurance Company");
         AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
         
     }else {
    	 
         buttonClick(objectrepository.getrdo_CBbutton(),10,"Click on CB Insurance Company");
         
         System.out.println("Click on CB Insurance Company");
         AutomationUtilities.LogSummary(LogPath,"Click on CB Insurance Company");
         AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     }
     
     buttonClick(objectrepository.getbtn_ICSavebutton(),10,"Click on Save Insurance Company");
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     Thread.sleep(5000);
	 buttonClick(objectrepository.getbtn_CloseProducerFee(),10,"Click on Button Close");
	 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	 
	 AutomationUtilities.QuoteNo = objectrepository.getlbl_QuoteNo().getText();
	 System.out.println("Quote No: "+ objectrepository.getlbl_QuoteNo().getText());
     AutomationUtilities.LogSummary(LogPath,"Quote No: "+ objectrepository.getlbl_QuoteNo().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
	 buttonClick(objectrepository.getbtn_Appbutton(),10,"Click on Application Button");
     System.out.println("Click on Application Button");
     AutomationUtilities.LogSummary(LogPath,"Click on Application Button");
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("Quote Page have been completed Sucessfully");
     AutomationUtilities.LogSummary(LogPath,"Quote Page have been completed Sucessfully");
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
	}

	public void Application (LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, IOException, AWTException, UnsupportedFlavorException {
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = new Date();
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, 35);
	    
		EsendKeysToTextField(objectrepository.gettxtApplicationDate(),dateFormat.format(date),"Effective Date");
		System.out.println("Application Date of the Quote is :"+dateFormat.format(date));
	    AutomationUtilities.LogSummary(LogPath,"Application Date of the Quote is :"+dateFormat.format(date));
	    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	     
	    buttonClick(objectrepository.getdpdBusinessType(),10,"Click on State");
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getBusinessType(),"Business Type Name");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		String sInspectionName = "Inspector -"+ AutomationUtilities.getRandomString (9);
		sendKeysToTextField(objectrepository.gettxtcontactforinspection(),sInspectionName,"Enter contact for inspection");
	    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    
		sendKeysToTextField(objectrepository.gettxtFristAddressline(),objGlLoadManager.getFristAddressline(),"Enter 1st line of Address"); 
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);

		sendKeysToTextField(objectrepository.gettxtSecAddressline(),objGlLoadManager.getSecAddressline(),"Enter 2nd line of Address");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		  
		sendKeysToTextField(objectrepository.gettxtLocationCity(),objGlLoadManager.getLocationCity(),"Enter City Name");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		 
		if(objectrepository.getUseasis().isDisplayed()) {
			
			buttonClick(objectrepository.getUseasis(),10,"Click on Use as is");
			}
		
		sendKeysToTextField(objectrepository.gettxtLocationZipCode(),objGlLoadManager.getLocationZipCode(),"Enter Zip Code");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtBusinessPhone(),objGlLoadManager.getBusinessPhone(),"Enter Business Phone Number");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		 
		sendKeysToTextField(objectrepository.gettxtBusinessEmail(),objGlLoadManager.getBusinessEmail(),"Enter Business Emails");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);

		String FEIN = AutomationUtilities.getRandomString (9);
		sendKeysToTextField(objectrepository.gettxtBusinessFEINSSN(),FEIN,"Enter Business FEIN");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		 
		buttonClick(objectrepository.getchkSameAddress(),10,"Click on Same Address check box");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
		sendKeysToTextField(objectrepository.gettxtExpirationDate(),dateFormat.format(cal.getTime()),"Enter Business Expiration Date");  
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		  
		sendKeysToTextField(objectrepository.gettxtInsuranceCarrier(),objGlLoadManager.getTypeofCompany(),"Enter Insurance Carrier");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
		sendKeysToTextField(objectrepository.gettxtGeneralRemarks(),"OK - Approved","Enter Insurance Carrier");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		  
		sendKeysToTextField(objectrepository.gettxtIndustrial(),"100","Enter Industrial Percentage");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtNewConstruction(),"100","Enter New Construction Percentage");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getrdoPerformContractYes(),10,"Click on Perform Contract as Yes");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		sendKeysToTextField(objectrepository.gettxtWorkSubcontracted(),"OK - Approved","Enter New Construction Percentage");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getrdoRequireCertificatesGLYes(),10,"Click on Perform Contract as Yes");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getrdoRequireCertificatesWCYes(),10,"Click on Perform Contract as Yes");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getrdoAgree(),10,"Click on Agree radio button");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getbtnPrintSubmit(),10,"Click on Print & Submit Application");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		Thread.sleep(15000);
		
		AutomationUtilities.Traverse(driver,"Download Application Document");
	    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(objectrepository.getbtnPaymentIssue(),10,"Click on Print & Submit Application");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		System.out.println("Application Page have been completed Sucessfully");
	    AutomationUtilities.LogSummary(LogPath,"Application Page have been completed Sucessfully");
	    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	
	}
	
	public void PolicyIssue (LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
		
		Thread.sleep(10000);
		//objectrepository.getchkIssue_Line1().click();
		/*************NEW CODE START**************/
		WebElement element = objectrepository.getchkIssue_Line1();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('chkIssue_1').click();", element);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		executor.executeScript("document.getElementById('chkIssue_2').click();", element);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		executor.executeScript("document.getElementById('chkIssue_3').click();", element);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		/*************NEW CODE ENDS**************/
		
		
		//buttonClick(objectrepository.getchkIssue_Line1(),10,"Click on Line1");
//		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
//		buttonClick(objectrepository.getchkIssue_Line2(),10,"Click on Line1");
//		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
//		buttonClick(objectrepository.getchkIssue_Line3(),10,"Click on Line1");
//		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		System.out.println("PaymentOption is:>>>>>" +objGlLoadManager.getPaymentOption());
		switch(objGlLoadManager.getPaymentOption()) {
		
		case "10pay": buttonClick(objectrepository.getchkPaymentOpt_10pay(),10,"Click on Payment Option 10 Pay");
		case "4paybimonthly" : buttonClick(objectrepository.getchkPaymentOpt_4paybimonthly(),10,"Click on Payment Option 4 Pay Bi Monthly");
		case "4paymonthly" : buttonClick(objectrepository.getchkPaymentOpt_4paybimonthly(),10,"Click on Payment Option 4 Pay Monthly");
		case "Fullpay" : buttonClick(objectrepository.getchkPaymentOpt_Fullpay(),10,"Click on Payment Option Full Pay");
		case "PremiumFinance" : buttonClick(objectrepository.getchkPaymentOpt_PremiumFinance(),10,"Click on Payment Option Premium Finance");
		case "FrankCrumpaygo" : buttonClick(objectrepository.getchkPaymentOpt_FrankCrumpaygo(),10,"Click on Payment Option Premium Finance");
		
		}
		
		buttonClick(objectrepository.getdpddepositpaymentmethod(),10,"Click on Deposit Payment Method");
		EsendKeysToTextField(objectrepository.gettxtUniquetextbox(),objGlLoadManager.getDepositPaymentMethod(),"Deposit Payment Method");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		if(objGlLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Check")) {
			
			buttonClick(objectrepository.getclkCheckPayment(),10,"Click on Check Issue Policy");
		
		}else if(objGlLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Online")) {
			
			buttonClick(objectrepository.getclkOnlinePayment(),10,"Click on Online Issue Policy");
			
		}else {
			
			buttonClick(objectrepository.getclkPremiumFinancePayment(),10,"Click on Online Issue Policy");
		}
		
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);

		buttonClick(objectrepository.getlnkDownloadEvidence(),10,"Clickon EOI Document");
		AutomationUtilities.Traverse(driver,"EOI Document");
	    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		
		AutomationUtilities.PolicyNo =objectrepository.gettxtPolicyNumber().getText() ;
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		AutomationUtilities.LogSummary(LogPath,"GL Policy Number :"+AutomationUtilities.PolicyNo);
		AutomationUtilities.LogSummary(LogPath,"Policy Issuance is completed successfully");
	}
}