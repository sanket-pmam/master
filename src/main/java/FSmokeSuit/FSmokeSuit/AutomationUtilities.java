package FSmokeSuit.FSmokeSuit;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.imageio.ImageIO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutomationUtilities {     
	
   private static final long DEFAULT_WAIT_4_PAGE = 0;
   private static final String DEFAULT_POOLING_TIME = null;
   public static WebDriver driver2;
   public static String LogPath;
   public static String fileContents="";
   public static int logcount = 1;
   public static File AutmSnapfile;
   public static String testCaseID;
   public static String tcSnapPath;
   public static String QuoteNo;
   public static String PolicyNo;
   public static WebDriverWait wait=null;
   public static Robot rbt;
   
  /* public void getDropDownList(WebDriver driver, WebElement element, String sLabel) {
	   System.out.println("getDropDownList function has been called...");
	   WebElement industries = driver.findElement(By.xpath("//ul[@id='select2-ddlInsuredName-results']"));
		List<WebElement> InsuredNameList = industries.findElements(By.tagName("li"));
		for (int i = 1; i < InsuredNameList.size(); i++)
		{
		    System.out.println("InsuredNameList :- "+InsuredNameList.get(i).getText());
		    if(i==1) {
		    	System.out.println("Skipped");
		    }
		    else{
		    	WebElement option = InsuredNameList.get(i);
		    	option.click();
		    
		    }
		}
	   
   }
   
   */
	public void selectDropdownlitag(WebDriver driver, WebElement element, String text, String sLabel)
			throws IOException, InterruptedException {
		System.out.println("Drop Down Fucntion has been called");
		String searchText = text;

		element.click(); 
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.tagName("li"));
		for (WebElement option : options) {
			if (option.getText().equals(searchText)) {
				System.out.println("Search Text is true" + searchText);
				option.click(); // click the desired option
				break;
			}
		}
	}
   public void selectDropdownByText(WebElement element, String text,String sLabel) throws IOException {
		try {		
			System.out.println("Drop Down Fucntion has been called");
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}
		catch(Exception e) {
			AutomationUtilities.LogSummary("fail", "Dropdown element "+sLabel+" could not be selected");
			
			e.printStackTrace();
		}
		
	}

   
   
   public static void checkCheckBox(WebDriver driver, WebElement element, int iTimeOutSeconds,
			String label) throws IOException {
		try {
			System.out.println("Checkbox Function has been called");
			System.out.println("Driver" + driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			AutomationUtilities.LogSummary("pass", label + " is clicked");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail :- " + label + "Element cannot be clicked due to" + e.getMessage());
			AutomationUtilities.LogSummary("fail", label + " cannot be clicked due to" + e.getMessage());
		}

	}

   
	public void javascriptExecutorClick(WebDriver driver, WebElement element, String label) throws IOException {
//		WebDriverWait wait = new WebDriverWait(driver,iTimeOutSeconds);
		try {

			Actions actionsTwo = new Actions(driver);
			JavascriptExecutor jseTwo = (JavascriptExecutor) driver;
//			new WebDriverWait(driver,iTimeOutSeconds).until(ExpectedConditions.visibilityOf(element));
			actionsTwo.moveToElement(element).click();
			jseTwo.executeScript("arguments[0].click()", element);
			
		} catch (Exception e) {
			
			AutomationUtilities.LogSummary(LogPath," : "+label+" is not working due to" + e.getMessage());
			System.out.println(label+" is not working due to" + e.getMessage());
		}
	}

   
   public static void drawBorder(WebElement element ) {		
		if (driver2 instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver2).executeScript("arguments[0].style.border='6.5px solid rgb(0, 230, 0)'", element);	        
		  }
	    }
   
//	public static void buttonClick(WebElement element, int waitAfterClick, String label) throws InterruptedException, IOException {
   public static void buttonClick(WebElement element, int waitAfterClick, String label) throws InterruptedException, IOException {
			drawBorder(element);
			element.click(); 
			AutomationUtilities.LogSummary(LogPath," : "+label+" is completely working.");
			
		}	
	
	public static boolean waitTillClickable(WebDriver driver, WebElement element, int iTimeOut,
			String label) {
		System.out.println("waitTillClickable function has been called for "+iTimeOut +"seconds");
		System.out.println("Driver...:" + driver);
		wait = new WebDriverWait(driver, iTimeOut);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static void sleep(double d){
		try {
			Thread.sleep((long) (d*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void waitforpageload() {
		sleep(0.5);
		waitforpageload();
		//waitForSpinner();
		driver2.manage().timeouts().pageLoadTimeout(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
	}

	public static void buttonClickWithoutWait(WebElement eElement,String sLabel) {
		try {
			eElement.click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(sLabel + " cannot be clicked.."+e.getMessage());
		}
		
	}
	public static void buttonClick2(WebDriver driver,WebElement eElement, int iTimeOutSeconds,
			String sLabel) {
		try{
			if (waitTillClickable(driver, eElement, iTimeOutSeconds, sLabel)) {
				drawBorder(eElement);
				((JavascriptExecutor) driver).executeScript("arguments[0].click()",
						eElement);
				waitforpageload();
			} else {
				Assert.fail(sLabel + " cannot be clicked");
				
			}
		}
		catch(Exception e){
//			Report.log("fail", sLabel + " cannot be clicked");
			//Report.log("screenshot", getScreenshot(sLabel));
			Assert.fail(sLabel + " cannot be clicked"+e.getMessage());
			System.out.println(sLabel + " cannot be clicked"+e.getMessage());
			
		}

	}


	
   public static String getDataFromPropertiesFile(String propertyName) {
		File file = new File("./config.properties");
		
		FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return prop.getProperty(propertyName);
   }
   
public static void sendKeysToTextField(WebElement element, String text, String label) throws InterruptedException, IOException {
	drawBorder(element);
	element.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
	Thread.sleep(2000);
	element.sendKeys(Keys.TAB);
	AutomationUtilities.LogSummary(LogPath,"Current Label : "+label+" is completely working.");
	System.out.println("Current Label : "+label+" is completely working.");
}

public static void EsendKeysToTextField(WebElement element, String text, String label) throws InterruptedException {
	drawBorder(element);
	element.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
	element.sendKeys(Keys.ENTER);
	Thread.sleep(1000);
	System.out.println("Current Label : "+label+" is completely working.");
}


public static void PageWait(WebElement Element,WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 200);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Element.toString())));
}


 static String getRandomString(int n) 
 { 

     String AlphaNumericString = "0123456789";
     StringBuilder sb = new StringBuilder(n); 

     for (int i = 0; i < n; i++) { 
    	 
         int index 
             = (int)(AlphaNumericString.length() 
                     * Math.random()); 
         sb.append(AlphaNumericString 
                       .charAt(index)); 
     } 

     return sb.toString(); 
 } 

 public static void Screenshot(String SnapPath,String TCID) throws AWTException, IOException, InterruptedException 
 { 
	     Thread.sleep(1000);
	     Robot r = new Robot(); 
         LocalDateTime myDateObj = LocalDateTime.now();
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
	     
	     if (!AutmSnapfile.exists()) {
	            if (AutmSnapfile.mkdir()) {
	                System.out.println("Folder/Directory is created successfully");
	            } else {
	                System.out.println("Directory/Folder creation failed!!!");
	            }
	      } 
	     SnapPath = AutmSnapfile.getAbsolutePath()+"\\NewSnap_"+TCID+myFormatObj.format(myDateObj).toString() + ".jpg";
         Rectangle capture = new Rectangle((Toolkit.getDefaultToolkit().getScreenSize())); 
         BufferedImage Image = r.createScreenCapture(capture); 
         ImageIO.write(Image, "jpg", new File(SnapPath)); 
         System.out.println("Screenshot saved"); 
     } 
 
 
public static void LogSummary(String Path, String content) throws IOException {

	File file = new File(Path);
	fileContents = fileContents+"\n"+logcount+": "+content;
	
    if (file.createNewFile()){
      System.out.println("File is created!");
    }

    FileWriter writer = new FileWriter(file);
    writer.write(fileContents);
    writer.close();
    logcount++;
  }

public static void ExcelUpdate (String testcasePath,String tcSheetName,String Data, LoadManager objLoadManager, String ColName ) {
	
	File file =    new File(testcasePath);

    try {
       
        FileInputStream fis = new FileInputStream(file);
	    @SuppressWarnings("resource")
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet(tcSheetName);
	    XSSFRow headerRow = sheet.getRow(0);
	    String result = "";
	    int resultCol = -1;
	    for (Cell cell : headerRow){
	        result = cell.getStringCellValue();
	        if (result.equals(ColName)){
	            resultCol = cell.getColumnIndex();
	            break;
	         }
	    }
	    if (resultCol == -1){
	        System.out.println("Quote No. column not found in sheet");
	        return;
	    }   

	    for(int count = 1;count<=sheet.getLastRowNum();count++){
	    	 
	    	if(count == Integer.valueOf(objLoadManager.getTestCaseId())) {
	    	
	    	 XSSFRow row = sheet.getRow(count);
	         XSSFCell xssfCell = row.getCell(resultCol);
	         xssfCell.setCellValue(Data);
	        
	    	}
	    }
	    
	    fis.close();
	    FileOutputStream outputStream = new FileOutputStream(file);
	    wb.write(outputStream);
	    outputStream.close();
    }
    catch (IOException e) {
        System.out.println("Test data file not found");
    } 
}


public static String Traverse(WebDriver driver,String pdfName) throws AWTException, InterruptedException, UnsupportedFlavorException, IOException {
	
	String pdfFilePath="";
	  
	 String parentWindow= driver.getWindowHandle();
	 Set<String> allWindows = driver.getWindowHandles();
	 for(String curWindow : allWindows){
	     driver.switchTo().window(curWindow);
	 if(driver.getCurrentUrl().toString().toLowerCase().contains("pdf")) {
        	 break;
         } 	   
	 }
     
	 if(pdfName.equalsIgnoreCase("Download Application Document")) {
		 System.out.println("Download Application Document");
		 buttonClick(ObjectRepository.getApplicationdownload(),10,"Click on download application document");
		 Thread.sleep(30000);
		 pdfFilePath=AutomationUtilities.getDataFromPropertiesFile("PDFFILEPATH")+pdfName;

		 	
		 StringSelection stringSelection = new StringSelection(pdfFilePath);		
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		 
	 }else {
		 Thread.sleep(5000);

			
		 /******************** NEW START CODE ******************/
		 System.out.println("PDF Download.....");
		 	rbt = new Robot();
			rbt.keyPress(KeyEvent.VK_CONTROL);

//			Press ctrl + s
			rbt.keyPress(KeyEvent.VK_S);
			rbt.keyRelease(KeyEvent.VK_S);
			rbt.keyRelease(KeyEvent.VK_CONTROL);


			rbt.delay(5000);
			
			//Press Home button
			rbt.keyPress(KeyEvent.VK_HOME);
			rbt.keyRelease(KeyEvent.VK_HOME);

			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir") + "\\Test Report\\PDFFile\\");
			clipboard.setContents(stringSelection, null);
			
			rbt.delay(5000);
			//Copying path by pressing control + v
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			
			rbt.delay(5000);

			// Saving File by pressing enter
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			
			
			rbt.delay(5000);
	     
	     /******************** NEW END CODE ******************/
	 }
	 
	 System.out.println("Closing window");
	 driver.close();
	 driver.switchTo().window(parentWindow);
	 
     return pdfFilePath;
     
}

	

}
