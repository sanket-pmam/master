package FSmokeSuit.FSmokeSuit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ObjectRepository {
	
	private static ObjectRepository objectrepository = null;
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	@FindBy(xpath = "//div[@class ='loading']") 
	private WebElement LoadingWait;
	
	@FindBy(xpath = "//input[@id='txtBranchId']") 
	private WebElement inpUserNameLogin;

	@FindBy(xpath = "//input[@id='txtPassword']")
	private WebElement inpPasswordLogin;

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	private WebElement btnLogin; 
	
//	@FindBy(xpath = "//Span[@title='-Select-']")
//	private WebElement dd_SelectAgent; 
	
	@FindBy(xpath = "//span[@class='selection']")
	private WebElement dd_SelectAgent; 
	
	
	@FindBy(xpath = "//button[@id='btnContinue']")
	private WebElement btnContinue; 
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement inpSearch; 
	
	@FindBy(xpath = "//a[@id='lnkNewQuote']")
	private WebElement btnNewQuote;
	
	@FindBy(xpath = "//input[@id='rdbGeneralLiability']")
	private WebElement btnrdbGeneralLiability;
	
//	@FindBy(xpath = "//input[@id='rdbWorkersComp']")
	@FindBy(xpath = "//input[@id='rdbWorkersComp' and @value='w']")
	
	private WebElement btnrdbWorkersComp;
	
	@FindBy(xpath = "//input[@id='txtFEIN']")
	private WebElement inpFEIN;
	
	@FindBy(xpath = "//button[@id='BtnSave']")
	private WebElement btnHContinue;
	
	@FindBy (xpath="//input[starts-with(@value,'SAVE')]")
	public WebElement btnsaveandcontinue;

	@FindBy (xpath="//span[@id='select2-ddlState-container']")
	public WebElement dpdstate;

	@FindBy (xpath="//input[@role='textbox']")
	public WebElement txtUniquetextbox;

	@FindBy (xpath="//input[@id='txtEffectiveDate']")
	public WebElement txtEffectiveDate;
				
	@FindBy (xpath="//span[@id='select2-ddlCounty-container']")
	public WebElement dpdCounty;

	@FindBy (xpath="//input[@id='txtNameOfInsured']")
	public WebElement txtBusinessName;

	@FindBy (xpath="//input[@id='txtIndividualFirstName']")
	public WebElement txtIndividualFirstName;

	@FindBy (xpath="//input[@id='txtIndividualLastName']")
	public WebElement txtIndividualLastName;

	@FindBy (xpath="//textarea[@id='txtDescriptionOfBusiness']")
	public WebElement txtDescriptionOfBusiness;

	@FindBy (xpath="//input[@id='txtYearsInBusiness']")
	public WebElement txtYearsInBusiness;  
					
	@FindBy (xpath="//input[@id='txtYearsInTrade']")
	public WebElement txtYearsInTrade;

	@FindBy (xpath="//input[@id='txtClaims']")
	public WebElement txtClaims;
					
	@FindBy (xpath="//label[@for='rbLapseDayYes']")
	public WebElement rbpriorinsuranceYes;

	@FindBy (xpath="//label[@for='rbLapseDayNo']")
	public WebElement rbpriorinsuranceNo;
					
	@FindBy (xpath="//span[@id='select2-ddlLiabilityLimit-container']")
	public WebElement dpdliabilitylimit;

	@FindBy (xpath="//span[@id='select2-ddlDeductible-container']")
	public WebElement dpdDeductiblelimit;
					
	@FindBy (xpath="//label[@for='rbAdditionalInsuredsYes']")
	public WebElement rbAdditionalInsuredsYes;

	@FindBy (xpath="//label[@for='rbAdditionalInsuredsNo']")
	public WebElement rbAdditionalInsuredsNo;

	@FindBy (xpath="//label[@for='rbWaiversYes']")
	public WebElement rbWaiversYes;

	@FindBy (xpath="//label[@for='rbWaiversNo']")
	public WebElement rbWaiversNo;

	@FindBy (xpath="//input[@id='rbInlandMarineYes']")
	public WebElement rbInlandMarineYes;

	@FindBy (xpath="//input[@id='rbInlandMarineNo']")
	public WebElement rbInlandMarineNo;

	@FindBy (xpath="//input[@id='txtNoofLocation']")
	public WebElement txtNoofLocation;

	@FindBy (xpath="//input[@id='txtNoofProject']")
	public WebElement txtNoofProject;

	@FindBy (xpath="//span[@id='select2-ddlClassification-container']")
	public WebElement dpdclasscode;
					
	@FindBy (xpath="//button[@id='btnAddClassification']")
	public WebElement btnAddClassCode;
	
	@FindBy (xpath="//input[@class='dynamicAdd form-control'][@name='percentage']")
	public WebElement ClasscodePercentage;
					
	@FindBy (xpath="//input[@id='expectedGrossReceipts']")
	public WebElement txtExpectedGrossAmount;

	@FindBy (xpath="//input[@id='insuredSubcontractorsCost']")
	public WebElement InSubcontractorCost;

	@FindBy (xpath="//input[@id='insuredSubcontractorsOperations']")
	public WebElement SubcontractorCostopdes;

	@FindBy (xpath="//input[@id='uninsuredSubcontractorsCost']")
	public WebElement UnSubcontractorCost;

	@FindBy (xpath="//Span[@id='select2-ddlClassCodes-container']")
	public WebElement SubClasscodes;

	@FindBy (xpath="//button[@id='btnAddClassCode']")
	public WebElement btnAddSubClassCode;

	@FindBy (xpath="//input[@class='dynamicAddClassCode form-control'][@name='percentage']")
	public WebElement SubClasscodePercentage;

	@FindBy (xpath="//input[@id='fullPartners']")
	public WebElement txtActivePartner;

	@FindBy (xpath="//span[@id='select2-ddACVLimitFloater-container']")
	public WebElement dpdinstallationfloater;
					
	@FindBy (xpath="//span[@id='select2-ddACVLimitHandTools-container']")
	public WebElement dpdContractorHandtools;

	@FindBy (xpath="//span[@id='select2-ddACVLimitLeasedEquipment-container']")
	public WebElement dpdleasedequipment;
	
	@FindBy (xpath="//input[@value='CLOSE']")
	public WebElement btnClose;
	
	@FindBy (xpath="//div[@class ='modal-body text-danger']/ul/li")
	public WebElement ErrorMessage;
//--------	
	@FindBy(xpath = "//label[@id='lblQuoteDate']")
	private WebElement lbl_QuoteDate;

	@FindBy(xpath = "//label[@id='lblTerm']")
	private WebElement lbl_Term;
	
	@FindBy(xpath = "//label[@id='lblCountyTerritory']")
	private WebElement lbl_CountyTerritory;

	@FindBy(xpath = "//label[@id='lblInsuredName']")
	private WebElement lbl_InsuredName;

	@FindBy(xpath = "//input[@id='txtProducerFee']")
	private WebElement txt_ProducerFee;
	
	@FindBy(xpath = "//span[@id='lblFWCIPremium']")
	private WebElement lbl_FWCIPremium;
	
	@FindBy(xpath = "//span[@id='lblCBPremium']")
	private WebElement lbl_CBPremium;
	
	@FindBy(xpath = "//span[@id='lblFWCIMGAPolicyFee']")
	private WebElement lbl_FWCIMGAPolicyFee;
	
	@FindBy(xpath = "//span[@id='lblCBMGAPolicyFee']")
	private WebElement lbl_CBMGAPolicyFee;

	@FindBy(xpath = "//span[@id='lblFWCIProducerFee']")
	private WebElement lbl_FWCIProducerFee;
	
	@FindBy(xpath = "//span[@id='lblCBProducerFee']")
	private WebElement lbl_CBProducerFee;
	
	@FindBy(xpath = "//span[@id='lblFWCITotalPremium']")
	private WebElement lbl_FWCITotalPremium;

	@FindBy(xpath = "//span[@id='lblCBTotalPremium']")
	private WebElement lbl_CBTotalPremium;
	
	@FindBy(xpath = "//label[@for='rdoFWCI']")
	private WebElement rdo_FWCIbutton;

	@FindBy(xpath = "//label[@for='rdoClearBlue']")
	private WebElement rdo_CBbutton;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement btn_ICSavebutton;

	@FindBy(xpath = "//input[@value='APPLICATION & ISSUE']")
	private WebElement btn_Appbutton;
	
	@FindBy(xpath = "//input[@id='btnSaveProducerFee']")
	private WebElement btn_SaveProducerFee;
	
	@FindBy(xpath = "//input[@value='CLOSE']")
	private WebElement btn_CloseProducerFee;
	
	@FindBy(xpath = "//input[@id='lnkDownloadFWCIQuote']")
	private WebElement lnk_DownloadFWCIQuote;
	
	@FindBy(xpath = "//input[@id='lnkDownloadCBQuote']")
	private WebElement lnk_DownloadCBQuote;

	@FindBy(xpath = "//label[@id='lblQuoteNo']")
	private WebElement lbl_QuoteNo;

	@FindBy(xpath = "//input[@id='txtApplicationDate']")
	private WebElement txtApplicationDate;
	
	@FindBy(xpath = "//span[@id='select2-ddlBusinessType-container']")
	private WebElement dpdBusinessType;
	
	@FindBy(xpath = "//input[@id='txtInspectionContact']")
	private WebElement txtInspectionContact;
	
	@FindBy(xpath = "//input[@id='txtLocationAddress1']")
	private WebElement txtFristAddressline;
	
	@FindBy(xpath = "//input[@id='txtLocationAddress2']")
	private WebElement txtSecAddressline;
	
	@FindBy(xpath = "//input[@id='txtLocationCity']")
	private WebElement txtLocationCity;
	
	@FindBy(xpath = "//input[@id='txtLocationZipCode']")
	private WebElement txtLocationZipCode;
	
	@FindBy(xpath = "//input[@id='txtBusinessPhone']")
	private WebElement txtBusinessPhone;
	
	@FindBy(xpath = "//input[@id='txtBusinessEmail']")
	private WebElement txtBusinessEmail;
	
	@FindBy(xpath = "//input[@id='txtBusinessFEINSSN']")
	private WebElement txtBusinessFEINSSN;
	
	@FindBy(xpath = "//label[@for='chkSameAddress']")
	private WebElement chkSameAddress;
	
	@FindBy(xpath = "//input[@id='txtExpirationDate']")
	private WebElement txtExpirationDate;
	
	@FindBy(xpath = "//input[@id='txtInsuranceCarrier']")
	private WebElement txtInsuranceCarrier;
	
	@FindBy(xpath = "//textarea[@id='txtGeneralRemarks']")
	private WebElement txtGeneralRemarks;
	
	@FindBy(xpath = "//label[@for='rdoAgree']")
	private WebElement rdoAgree;
	
	@FindBy(xpath = "//input[@id='btnPrintSubmit']")
	private WebElement btnPrintSubmit;
	
	@FindBy(xpath = "//input[@id='btnPaymentIssue']")
	private WebElement btnPaymentIssue;
	
	@FindBy(xpath = "//a[contains(text(),'Use as is')]")
	private WebElement Useasis;

	//----
	@FindBy(xpath = "//input[@id='txtIndustrial']")
	private WebElement txtIndustrial;
	
	@FindBy(xpath = "//input[@id='txtNewConstruction']")
	private WebElement txtNewConstruction;
	
	@FindBy(xpath = "//label[@for='rdoPerformContractYes']")
	private WebElement rdoPerformContractYes;
	
	@FindBy(xpath = "//input[@id='txtWorkSubcontracted']")
	private WebElement txtWorkSubcontracted;
	
	@FindBy(xpath = "//label[@for='rdoRequireCertificatesGLYes']")
	private WebElement rdoRequireCertificatesGLYes;
	
	@FindBy(xpath = "//label[@for='rdoRequireCertificatesWCYes']")
	private WebElement rdoRequireCertificatesWCYes;
	
	//---------------------
	@FindBy(xpath = "//button[@data-resin-target='download']")
	private static WebElement Applicationdownload;
	
	@FindBy(xpath = "//label[@for='chkIssue_1']")
	private WebElement chkIssue_Line1;
	
	@FindBy(xpath = "//input[@id='chkIssue_2']") //parent :: div// following-sibling :: label[@for='chkIssue_2']
	private WebElement chkIssue_Line2;
	
	@FindBy(xpath = "//input[@id='chkIssue_3']") //parent :: div// following-sibling :: label[@for='chkIssue_3']
	private WebElement chkIssue_Line3;
	
	@FindBy(xpath = "//label[@for='radio_44312']")
	private WebElement chkPaymentOpt_10pay;

	@FindBy(xpath = "//label[@for='radio_44313']")
	private WebElement chkPaymentOpt_4paybimonthly;
	
	@FindBy(xpath = "//*[text()='4 Pay Monthly']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_4paymonthly;
	
	@FindBy(xpath = "//*[text()='Full Pay']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_Fullpay;

	@FindBy(xpath = "//*[text()='Premium Finance']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_PremiumFinance;
	
	@FindBy(xpath = "//*[text()='FrankCrum Pay Go']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_FrankCrumpaygo;
	
	@FindBy(xpath = "//span[@id='select2-ddlDeposit-container']")
	private WebElement dpddepositpaymentmethod;
	 
	@FindBy(xpath = "//label[@id='lblNumber']")
	private WebElement txtPolicyNumber;
	
	@FindBy(xpath = "//a[@id='lnkDownloadEvidence']")
	private WebElement lnkDownloadEvidence;
	
	@FindBy(xpath = "//input[@value='SEND CHECK AND ISSUE POLICY']")
	private WebElement clkCheckPayment;

	@FindBy(xpath = "//input[@value='ISSUE POLICY']")
	private WebElement clkPremiumFinancePayment;

	@FindBy(xpath = "//input[@value='MAKE ONLINE PAYMENT & ISSUE POLICY']")
	private WebElement clkOnlinePayment;

	//------- Worker Compensation --------
	
	@FindBy (xpath="//span[@id='select2-ddlState1-container']")
	public WebElement WCState;
	
	@FindBy (xpath="//input[@id='txtClassCodes1']")
	public WebElement txtWCClassCodes;
	
	@FindBy (xpath="//input[@id='btnContinue']")
	public WebElement btnWCContinue;
	
	@FindBy (xpath="//input[@id='txtBussInsuredName']")
	public WebElement txtWCBussInsuredName;
	
	@FindBy (xpath="//span[@id='select2-ddlLegalEntity-container']")
	public WebElement dpdWCLegalEntity;
	
	@FindBy (xpath="//input[@id='txtDBAName']")
	public WebElement txtWCDBAName;
	
	@FindBy (xpath="//input[@id='txtAddress1']")
	public WebElement txtWCAddress1;
	
	@FindBy (xpath="//input[@id='txtAddress2']")
	public WebElement txtWCAddress2;
	
	@FindBy (xpath="//input[@id='txtZipCode']")
	public WebElement txtWCZipCode;
	
	@FindBy (xpath="//input[@id ='txtDateBussinessStart']")
	public WebElement txtWCDateBussinessStart;
	
	@FindBy (xpath="//input[@id ='txtEffectiveDate']")
	public WebElement txtWCEffectiveDate;
	
	@FindBy (xpath="//input[@id='rdoCurrExpModYes']")
	public WebElement lblWCrdoCurrExpModYes;
	
	@FindBy (xpath="//label[@for ='rdoCurrExpModNo']")
	public WebElement lblWCrdoCurrExpModNo;
	
	@FindBy (xpath="//input[@id ='txtExpMod']")
	public WebElement txtWCExpMod;
	
	@FindBy (xpath="//input[@id ='txtFirstName1']")
	public WebElement txtWCFirstName;
	
	@FindBy (xpath="//input[@id ='txtLastName1']")
	public WebElement txtWCLastName;
	
	@FindBy (xpath="//input[@id ='txtPerOwner1']")
	public WebElement txtWCPerOwner;
	
	@FindBy (xpath="//input[@id='radio1']")
	public WebElement txtWCIncluderd;
	
	@FindBy (xpath="//input[@id='radios1']")
	public WebElement txtWCExcluderd;
	
	@FindBy (xpath="//textarea[@id ='txtDescriptionOfOprations']")
	public WebElement txtWCdesc;
	
	@FindBy (xpath="//span[@id='select2-ddlEmpLiabLimit-container']")
	public WebElement dpdWCEmployerLimit;
	
	@FindBy (xpath="//input[@id='txtFTEmployee1']")
	public WebElement txtWCFTEmployee;
			
	@FindBy (xpath="//input[@id='txtPTEmployee1']")
	public WebElement txtWCPTEmployee;
	
	@FindBy (xpath="//input[@id='txtGrossannualPayroll1']")
	public WebElement txtWCGrossannualPayroll;
	
	@FindBy (xpath="//input[@id='BtnNext']")
	public WebElement BtnWCNext;
	
	@FindBy (xpath="//form[@id='frmBussiSumm']")
	public WebElement clkBusinessSummaryPage;
	
	
//	General Questions
	
	
	@FindBy (xpath="//input[@id='radio-1']")
	public WebElement rdQuestion_1;
	
	@FindBy (xpath="//input[@id='radio-2']")
	public WebElement rdQuestion_2;
	
	@FindBy (xpath="//input[@id='radio-3']")
	public WebElement rdQuestion_3;
	
	@FindBy (xpath="//input[@id='radio4']")
	public WebElement rdQuestion_4;
	
	@FindBy (xpath="//input[@id='radio-6']")
	public WebElement rdQuestion_5;
	
	@FindBy (xpath="//input[@id='radio-7']")
	public WebElement rdQuestion_6;
	
	@FindBy (xpath="//input[@id='radio-9']")
	public WebElement rdQuestion_7;
	
	@FindBy (xpath="//input[@id='radio-11']")
	public WebElement rdQuestion_8;
	
	@FindBy (xpath="//input[@id='radio-13']")
	public WebElement rdQuestion_9;
	
	@FindBy (xpath="//input[@id='radio-15']")
	public WebElement rdQuestion_10;
	
	@FindBy (xpath="//input[@id='radio-17']")
	public WebElement rdQuestion_11;
	
	@FindBy (xpath="//input[@id='radio-19']")
	public WebElement rdQuestion_12;
	
	@FindBy (xpath="//input[@id='radio-21']")
	public WebElement rdQuestion_13;
	
	@FindBy (xpath="//input[@id='IQchk534BeddingnbspPlants']")
	public WebElement chkBedding;
	
	//Industrial Questions
	
	@FindBy (xpath="//input[@id='IQradio-3']")
	public WebElement rdIQuestion_1;
	
	@FindBy (xpath="//input[@id='IQradio-4']")
	public WebElement rdIQuestion_2;
	
	@FindBy (xpath="//input[@id='IQradio-9']")
	public WebElement rdIQuestion_3;
	
	@FindBy (xpath="//input[@id='IQradio9']")
	public WebElement rdIQuestion_4;
	
	@FindBy (xpath="//input[@id='IQradio-11']")
	public WebElement rdIQuestion_5;
	
	@FindBy (xpath="//input[@id='IQradio-12']")
	public WebElement rdIQuestion_6;
	
	@FindBy (xpath="//input[@id='IQradio-13']")
	public WebElement rdIQuestion_7;
	
	@FindBy (xpath="//input[@id='IQradio13']")
	public WebElement rdIQuestion_8;
	
	@FindBy (xpath="//input[@id='IQradio14']")
	public WebElement rdIQuestion_9;
	
	@FindBy (xpath="//input[@id='IQradio-16']")
	public WebElement rdIQuestion_10;
	
	@FindBy (xpath="//input[@id='IQradio-17']")
	public WebElement rdIQuestion_11;
	
	@FindBy (xpath="//input[@id='IQradio-18']")
	public WebElement rdIQuestion_12;
	
	@FindBy (xpath="//input[@id='IQradio19']")
	public WebElement rdIQuestion_13;

	@FindBy (xpath="//input[@id='IQradio20']")
	public WebElement rdIQuestion_14;
	
	@FindBy (xpath="//input[@id='IQradio-22']")
	public WebElement rdIQuestion_15;
	
//	Losses Page elemnet
	
	@FindBy (xpath="//span[@id='select2-ddlHadCoverage2020-container']")
	public WebElement gethadCoverage;
	
	@FindBy (xpath="//input[@id='radioN2020']")
	public WebElement rdAnyLosses;
	
	@FindBy (xpath="//input[@id='BtnSubmit']")
	public WebElement btnSubmit;
	
	@FindBy (xpath="//input[@id='carrier0']")
	public WebElement gettxtLossCarrier;
	
	@FindBy (xpath="//span[@id='select2-ddlInsuredName-container']")
	public WebElement selWCNameInsured;
	
	@FindBy (xpath="//ul[@id='select2-ddlInsuredName-results']")
	public WebElement WCNameInsuredresult;
	
	@FindBy (xpath="//span[@id='select2-ddlRelationship-container']")
	public WebElement WCApplicationRelationsip;
	
	@FindBy (xpath="//input[@id='txtLocationAddress1']")
	public WebElement WAppliactionCAddress1;
	
	@FindBy (xpath="//input[@id='txtLocationCity']")
	public WebElement WCAppliactionCity;
	
	@FindBy (xpath="//span[@id='select2-ddlLocationState-container']")
	public WebElement WCAppliactionState;
	
	@FindBy (xpath="//span[@id='txtLocationZip']")
	public WebElement WCAppliactionZipcode;
	
	@FindBy (xpath="//input[@id='btnAddLocation']")
	public WebElement WCAppliactionAddLoact;
	
	
	@FindBy (xpath="//li[contains(text(), 'FCGA AUTM-361785710DB')]")
	public WebElement WCNameInsuredList1;
	
	@FindBy (xpath="//ul[@id='select2-ddlInsuredName-results']")
	public WebElement WCNameInsuredtxt;
	
	//------------------
	
	ObjectRepository(WebDriver driver) {
		PageFactory.initElements(driver, this); // 15, TimeUnit.SECONDS, this) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);
		this.driver = driver;

	}

	public static ObjectRepository getInstance(WebDriver driver) {
		objectrepository = new ObjectRepository(driver);
		return objectrepository;
	}
	
	
	public WebElement getLoadingWait() {
		return LoadingWait;
	}

	// ------ WC Changes --------
	
	public WebElement getWCState() {
		return WCState;
	}
	
	public WebElement gettxtWCClassCodes() {
		return txtWCClassCodes;
	}
	
	public WebElement getbtnWCContinue() {
		return btnWCContinue;
	}
	
	public WebElement gettxtWCBussInsuredName() {
		return txtWCBussInsuredName;
	}
	public WebElement getdpdWCLegalEntity() {
		return dpdWCLegalEntity;
	}
	
	public WebElement gettxtWCDBAName(){
		return txtWCDBAName;
	}
	
	public WebElement gettxtWCAddress1() {
		return txtWCAddress1;
	}
	
	public WebElement gettxtWCAddress2() {
		return txtWCAddress2;
	}
	
	public WebElement gettxtWCZipCode() {
		return txtWCZipCode;
	}
	
	public WebElement gettxtWCDateBussinessStart() {
		return txtWCDateBussinessStart;
	}
	
	public WebElement getdpdWCEmployerLimit() {
		return dpdWCEmployerLimit;
	}
	
	public WebElement gettxtWCEffectiveDate() {
		return txtWCEffectiveDate;
	}
	
	public WebElement getlblWCrdoCurrExpModNo() {
		return lblWCrdoCurrExpModNo;
	}
	public WebElement getlblWCrdoCurrExpModYes() {
		return lblWCrdoCurrExpModYes;
	}
	
	public WebElement gettxtWCExpMod() {
		return txtWCExpMod;
	}
	
	public WebElement gettxtWCFirstName() {
		return txtWCFirstName;
	}
	
	public WebElement gettxtWCLastName() {
		return txtWCLastName;
	}
	
	public WebElement gettxtWCPerOwner() {
		return txtWCPerOwner;
	}
	
	public WebElement gettxtWCIncluderd() {
		return txtWCIncluderd;
	}
	
	public WebElement gettxtWCExcluderd() {
		return txtWCExcluderd;
	}
	
	public WebElement gettxtWCdesc() {
		return txtWCdesc;
	}
	
	public WebElement gettxtWCFTEmployee() {
		return txtWCFTEmployee;
	}
	public WebElement gettxtWCPTEmployee() {
		return txtWCPTEmployee;
	}
	
	public WebElement gettxtWCGrossannualPayroll() {
		return txtWCGrossannualPayroll;
	}
	
	public WebElement getBtnWCNext() {
		return BtnWCNext;
	}
	//----- GL Changes -----------
	
	public static WebElement getApplicationdownload() {
		return Applicationdownload;
	}
	public WebElement getlnkDownloadEvidence() {
		return lnkDownloadEvidence;
	}
	public WebElement gettxtPolicyNumber() {
		return txtPolicyNumber;
	}
	public WebElement gettxtIndustrial() {
		return txtIndustrial;
	}
	
	public WebElement gettxtNewConstruction() {
		return txtNewConstruction;
	}
	
	public WebElement getrdoPerformContractYes() {
		return rdoPerformContractYes;
	}
	
	public WebElement gettxtWorkSubcontracted() {
		return txtWorkSubcontracted;
	}
	
	public WebElement getrdoRequireCertificatesGLYes() {
		return rdoRequireCertificatesGLYes;
	}
	
	public WebElement getrdoRequireCertificatesWCYes() {
		return rdoRequireCertificatesWCYes;
	}

	public WebElement getUseasis() {
		return Useasis;
	}
	public WebElement gettxtInspectionContact() {
		return txtInspectionContact;
	}
	public WebElement getlnk_DownloadFWCIQuote() {
		return lnk_DownloadFWCIQuote;
	}
	
	public WebElement getlnk_DownloadCBQuote() {
		return lnk_DownloadCBQuote;
	}
	
	public WebElement getlbl_QuoteNo() {
		return lbl_QuoteNo;
	}
	
	public WebElement getlbl_QuoteDate() {
		return lbl_QuoteDate;
	}
	
	public WebElement getlbl_Term() {
		return lbl_Term;
	}
	
	public WebElement getlbl_CountyTerritory() {
		return lbl_CountyTerritory;
	}

	public WebElement getlbl_InsuredName() {
		return lbl_InsuredName;
	}
	
	public WebElement gettxt_ProducerFee() {
		return txt_ProducerFee;
	}
	
	public WebElement getbtn_SaveProducerFee() {
		return btn_SaveProducerFee;
	}
	public WebElement getlbl_FWCIPremium() {
		return lbl_FWCIPremium;
	}
	
	public WebElement getlbl_CBPremium() {
		return lbl_CBPremium;
	}
	
	public WebElement getlbl_FWCIMGAPolicyFee() {
		return lbl_FWCIMGAPolicyFee;
	}
	
	public WebElement getlbl_CBMGAPolicyFee() {
		return lbl_CBMGAPolicyFee;
	}
	
	public WebElement getlbl_FWCIProducerFee() {
		return lbl_FWCIProducerFee;
	}
	
	public WebElement getlbl_CBProducerFee() {
		return lbl_CBProducerFee;
	}
	public WebElement getbtn_CloseProducerFee() {
		return btn_CloseProducerFee;
	}
	
	public WebElement getlbl_FWCITotalPremium() {
		return lbl_FWCITotalPremium;
	}
	
	public WebElement getlbl_CBTotalPremium() {
		return lbl_CBTotalPremium;
	}
	
	public WebElement getrdo_FWCIbutton() {
		return rdo_FWCIbutton;
	}
	
	public WebElement getrdo_CBbutton() {
		return rdo_CBbutton;
	}

	public WebElement getbtn_ICSavebutton() {
		return btn_ICSavebutton;
	}

	public WebElement getbtn_Appbutton() {
		return btn_Appbutton;
	}
	
	public WebElement getErrorMessage() {
		return ErrorMessage;
	}
	
	public WebElement getbtnClose() {
		return btnClose;
	}
	
	public WebElement getInpUserNameLogin() {
		return inpUserNameLogin;
	}

	public WebElement getInpPasswordLogin() {
		return inpPasswordLogin;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
    }

	public WebElement getBtnLogOff() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getBtnLogOffYes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public WebElement getSelectAgent() {
		return dd_SelectAgent;
	}
	
	public WebElement getSearchAgent() {
		return inpSearch;
	}	
	
	public WebElement getbtnContinue() {
		return btnContinue;
	}
	public WebElement getbtnNewQuote() {
		return btnNewQuote;
	}
	
	public WebElement getbtnrdbGeneralLiability () {
		return btnrdbGeneralLiability;
	}
	public WebElement getbtnrdbWorkersComp () {
		return btnrdbWorkersComp;
	}
	public WebElement getinpFEIN () {
		return inpFEIN;
	}
	public WebElement getbtnHContinue() {
		return btnHContinue;
	}
	public WebElement getbtnsaveandcontinue() {
		return btnsaveandcontinue;
	}

    public WebElement getdpdstate() {
		return dpdstate;
	}

    public WebElement gettxtUniquetextbox() {
		return txtUniquetextbox;
	}

    public WebElement gettxtEffectiveDate() {
		return txtEffectiveDate;
	}

    public WebElement getdpdCounty() {
		return dpdCounty;
	}

    public WebElement gettxtBusinessName() {
		return txtBusinessName;
	}

    public WebElement gettxtIndividualFirstName() {
		return txtIndividualFirstName;
	}

    public WebElement gettxtIndividualLastName() {
		return txtIndividualLastName;
	}

   public WebElement gettxtDescriptionOfBusiness() {
		return txtDescriptionOfBusiness;
	}

   public WebElement gettxtYearsInBusiness() {
		return txtYearsInBusiness;
	}

   public WebElement gettxtYearsInTrade() {
		return txtYearsInTrade;
	}

   public WebElement gettxtClaims() {
		return txtClaims;
	}

   public WebElement getrbpriorinsuranceYes() {
		return rbpriorinsuranceYes;
	}

   public WebElement getrbpriorinsuranceNo() {
		return rbpriorinsuranceYes;
	}

   public WebElement getdpdliabilitylimit() {
		return dpdliabilitylimit;
	}

   public WebElement getdpdDeductiblelimit() {
		return dpdDeductiblelimit;
	}

   public WebElement getrbAdditionalInsuredsYes() {
 		return rbAdditionalInsuredsYes;
	}

   public WebElement getrbAdditionalInsuredsNo() {
		return rbAdditionalInsuredsNo;
	}

   public WebElement getrbWaiversYes() {
		return rbWaiversYes;
	}

   public WebElement getrbWaiversNo() {
		return rbWaiversNo;
	}

  public WebElement getrbInlandMarineYes() {
		return rbInlandMarineYes;
	}

  public WebElement getrbInlandMarineNo() {
		return rbInlandMarineNo;
	}

  public WebElement gettxtNoofLocation() {
		return txtNoofLocation;
	}

  public WebElement gettxtNoofProject() {
		return txtNoofProject;
	}

  public WebElement getdpdclasscode() {
		return dpdclasscode;
	}

  public WebElement getbtnAddClassCode() {
		return btnAddClassCode;
	}

  public WebElement getClasscodePercentage() {
		return ClasscodePercentage;
	}

  public WebElement gettxtExpectedGrossAmount() {
		return txtExpectedGrossAmount;
	}

  public WebElement getInSubcontractorCost() {
		return InSubcontractorCost;
	}

  public WebElement getSubcontractorCostopdes() {
		return SubcontractorCostopdes;
	}

  public WebElement getUnSubcontractorCost() {
		return UnSubcontractorCost;
	}

  public WebElement getSubClasscodes() {
		return SubClasscodes;
	}

  public WebElement getbtnAddSubClassCode() {
		return btnAddSubClassCode;
	}

  public WebElement getSubClasscodePercentage() {
		return SubClasscodePercentage;
	}

  public WebElement gettxtActivePartner() {
		return txtActivePartner;
	}

  public WebElement getdpdinstallationfloater() {
		return dpdinstallationfloater;
	}

  public WebElement getdpdContractorHandtools() {
		return dpdContractorHandtools;
	}

  public WebElement getdpdleasedequipment() {
		return dpdleasedequipment;
	}
  
  public WebElement gettxtApplicationDate() {
	  return txtApplicationDate;
  }
	
  public WebElement gettxtcontactforinspection() {
	  return txtInspectionContact;
  }
  
  public WebElement getdpdBusinessType() {
	  return dpdBusinessType;
  }
  public WebElement gettxtFristAddressline() {
	  return txtFristAddressline;
  }
	
  public WebElement gettxtSecAddressline() {
	  return txtSecAddressline;
  }
 
  public WebElement gettxtLocationCity() {
	  return txtLocationCity;
  }
 
  public WebElement gettxtLocationZipCode() {
	  return txtLocationZipCode;
  }
 
  public WebElement gettxtBusinessPhone() {
	  return txtBusinessPhone;
  }
 
  public WebElement gettxtBusinessEmail() {
	  return txtBusinessEmail;
  }	
 
  public WebElement gettxtBusinessFEINSSN() {
	  return txtBusinessFEINSSN;
  }
	
  public WebElement getchkSameAddress() {
	  return chkSameAddress;
  }
	
  public WebElement gettxtExpirationDate() {
	  return txtExpirationDate;
  }
	
  public WebElement gettxtInsuranceCarrier() {
	  return txtInsuranceCarrier;
  }
	
  public WebElement gettxtGeneralRemarks() {
	  return txtGeneralRemarks;
  }
  
  public WebElement getrdoAgree() {
	  return rdoAgree;
  }
	
  public WebElement getbtnPrintSubmit() {
	  return btnPrintSubmit;
  }
  
  public WebElement getbtnPaymentIssue() {
  return btnPaymentIssue;
  }
  
  public WebElement getchkIssue_Line1() {
	  return chkIssue_Line1;
  }
  
  public WebElement getchkIssue_Line2() {
	  return chkIssue_Line2;
  }
  
  public WebElement getchkIssue_Line3() {
	  return chkIssue_Line3;
  }

  public WebElement getchkPaymentOpt_10pay() {
	  return chkPaymentOpt_10pay;
  }
  
  public WebElement getchkPaymentOpt_4paybimonthly() {
	  return chkPaymentOpt_4paybimonthly;
  }
  
  public WebElement getchkPaymentOpt_4paymonthly() {
	  return chkPaymentOpt_4paymonthly;
  }
  
  public WebElement getchkPaymentOpt_Fullpay() {
	  return chkPaymentOpt_Fullpay;
  }
  
  public WebElement getchkPaymentOpt_PremiumFinance() {
	  return chkPaymentOpt_PremiumFinance;
  }
  
  public WebElement getchkPaymentOpt_FrankCrumpaygo() {
	  return chkPaymentOpt_FrankCrumpaygo;
  }
  
  public WebElement getdpddepositpaymentmethod () {
	  return dpddepositpaymentmethod;
  }
  
  public WebElement getclkCheckPayment() {
	  return clkCheckPayment;
  }
  
  public WebElement getclkPremiumFinancePayment() {
	  return clkPremiumFinancePayment;
  }
  
  public WebElement getclkOnlinePayment() {
	  return clkOnlinePayment;
  }
  
  public WebElement clickOnBusinessSummaryPage() {
	  return clkBusinessSummaryPage;
  }
  
  //General Questions
  public WebElement rdQuestion_1() {
	  return rdQuestion_1;
  }
  public WebElement rdQuestion_2() {
	  return rdQuestion_2;
  }
  public WebElement rdQuestion_3() {
	  return rdQuestion_3;
  }
  public WebElement rdQuestion_4() {
	  return rdQuestion_4;
  }
  public WebElement rdQuestion_5() {
	  return rdQuestion_5;
  }
  public WebElement rdQuestion_6() {
	  return rdQuestion_6;
  }
  public WebElement rdQuestion_7() {
	  return rdQuestion_7;
  }
  public WebElement rdQuestion_8() {
	  return rdQuestion_8;
  }
  public WebElement rdQuestion_9() {
	  return rdQuestion_9;
  }
  public WebElement rdQuestion_10() {
	  return rdQuestion_10;
  }
  public WebElement rdQuestion_11() {
	  return rdQuestion_11;
  }
  public WebElement rdQuestion_12() {
	  return rdQuestion_12;
  }
  public WebElement rdQuestion_13() {
	  return rdQuestion_13;
  }
  
  public WebElement chkBedding() {
	  return chkBedding;
  }
  
  //industrial question
  
  public WebElement rdIQuestion_1() {
	  return rdIQuestion_1;
  }
  public WebElement rdIQuestion_2() {
	  return rdIQuestion_2;
  }
  public WebElement rdIQuestion_3() {
	  return rdIQuestion_3;
  }
  public WebElement rdIQuestion_4() {
	  return rdIQuestion_4;
  }
  public WebElement rdIQuestion_5() {
	  return rdIQuestion_5;
  }
  public WebElement rdIQuestion_6() {
	  return rdIQuestion_6;
  }
  public WebElement rdIQuestion_7() {
	  return rdIQuestion_7;
  }
  public WebElement rdIQuestion_8() {
	  return rdIQuestion_8;
  }
  public WebElement rdIQuestion_9() {
	  return rdIQuestion_9;
  }
  public WebElement rdIQuestion_10() {
	  return rdIQuestion_10;
  }
  public WebElement rdIQuestion_11() {
	  return rdIQuestion_11;
  }
  public WebElement rdIQuestion_12() {
	  return rdIQuestion_12;
  }
  public WebElement rdIQuestion_13() {
	  return rdIQuestion_13;
  }
  public WebElement rdIQuestion_14() {
	  return rdIQuestion_14;
  }
  public WebElement rdIQuestion_15() {
	  return rdIQuestion_15;
  }
  
  
  //Lossess
  public WebElement gethadCoverage() {
	  return gethadCoverage;
  }
  public WebElement rdAnyLosses() {
	  return rdAnyLosses;
  }
  public WebElement btnSubmit() {
	  return btnSubmit;
  }
  public WebElement gettxtLossCarrier() {
	  return gettxtLossCarrier;
  }
  
  public WebElement selWCNameInsured() {
	  return selWCNameInsured;
  }
  
  public WebElement WCNameInsuredresult() {
	  return WCNameInsuredresult;
  }
  
  
  public WebElement WCApplicationRelationsip() {
	  return WCApplicationRelationsip;
  }
  public WebElement WAppliactionCAddress1() {
	  return WAppliactionCAddress1;
  }
  
  public WebElement WAppliactionCity() {
	  return WCAppliactionCity;
  }
  public WebElement WAppliactionState() {
	  return WCAppliactionState;
  }
  public WebElement WCAppliactionZipcode() {
	  return WCAppliactionZipcode;
  }
  
  public WebElement WAppliactionAddLoact() {
	  return WCAppliactionAddLoact;
  }
  
  public WebElement WCNameInsuredList1() {
	  return WCNameInsuredList1;
  }
  public WebElement WCNameInsuredtxt() {
	  return WCNameInsuredtxt;
  }
  
	
  
  
}
