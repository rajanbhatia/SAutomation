
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.Year;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoField;
//import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import main.resources.ConfigReader;
//import main.resources.ExcelDataConfig;
//import test.resources.Codes;
//import test.resources.ReportScreenshotUtility;
//import test.ClearanceChecks;

public class TEAWeeklyRun {
	//1,2,8,9 Auto test cases
	//private boolean acceptNextAlert = true;
	//private StringBuffer verificationErrors = new StringBuffer();
	String errormessage, exceptionerror;
	Set<String> beforepopup;
	Codes codes=new Codes();
	StringBuffer verificationErrors = new StringBuffer();
	public WebDriver driver;
	public ConfigReader propertyconfig;
	//public ExtentReports report;
	public ExtentTest logger;	//Main class to generate the Logs and add to the report
	//String firstn;
	String winhandlebefore, winhandlebefore_staff, winhandlebefore_loginAgain;
	Integer qualsearchcount=1;
	LocalDate localDate = new LocalDate(); //getdate
	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
	//DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MMM/yyyy");
	String dob;
	String usertype, stuID;
	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
	
	
@Test(dataProvider = "ParamData") 
public void Auto1TEASubmitApplication(String getusertype, String getfirstn, String getlastn,String getsecondname,String getothersecondname,String getprevfamilyname, String getdob, String getnstudentnumber, String getemail, String getremail, String getpassword,  String getrpassword, String getqualsearchtype, String getcoursename, String getresidencystatus, String getcountry, String getcontactcountry, String getlivinginNZ, String getethnicity1, String getethnicity2, String getethnicity3, String getiwi1, String getiwi2, String getiwi3, String getiwi4, String gethomephone, String getmobile, String getcontactaddressline1,String getcontactaddressline2,String getcontactaddressline3,String getcontactaddressline4, String getcity, String getpostcode, String getcurrentlyatsecondaryschool, String getcurrentlystudyingtowards, String getagreeNZQAresultscheckbox, String getlastsecschool, String getlastschoolyear, String gethighsecqual, String getprevtertiarystudyatuniv,String getfirstenrolter, String getinstitutiontype, String getinstitutionname, String getoverseasinstitutioncountry, String getqualificationtype, String getqualname, String getyearfrom, String getyearto, String getgender, String getcompletequal, String getanyotherqual) {
    // TEA-SPRINT2->Story/Feature #10049:ADOAP-U016 - As an applicant (general), I need a facility to view the Application Declaration, and confirm that I have read and agreed to the terms of the Application Declaration in order to submit an application to the University.
    // TEA-SPRINT2->Story/Feature #10041:ADOAP-U024 - As an applicant (general), I need a facility to select a proposed qualification and starting semester in order to apply to the University.
	// TEA-Sprint2->Story# 10043 (As an applicant (general), I need a mechanism to provide details off any previous tertiary study I may have completed in order to apply to the University.)
	// TEA-SPRINT3->Story #10037:ADOAP-U004 - Save and Exiting application (AC: 3,4,5,7)
    // TEA-Sprint3->Story#10050:ADOAP-U017 - Submitting my application (AC: 1,2,3[NZ Citizen option only])
    // TEA-Sprint3->Story#10287:ADOAP-U008 - Applicant Viewing Existing Applications(AC:1 [Submitted, UnSubmitted],2)
    // //PRE-REQ: Applicant is getting Registered and Submitting the FIRST application to the University. 
    // //Creating new variables: firstn, lastn, firstname, lastname, email, password, dob, coursename, courseyear, submitdate.
    // //Disable Popup blocker option of your browser
    // //Course selected:  	Bachelor of Tourism
    // ERROR: Caught exception [unknown command [forXml]]
	try {
		String courseyear, livinginNZcode, currentlyatsecondaryschoolcode=null, prevtertiarystudyatunivcode=null, completequalcode="", anyotherqualcode="";		
		logger = ReportScreenshotUtility.report.startTest("Auto1TEASubmitApplication - "+getemail);
		exceptionerror="false";
		String firstn = getfirstn;
	    String firstname = getfirstn.toUpperCase();
	    String lastn = getlastn;
	    String lastname = getlastn.toUpperCase();
	    String secondname = getsecondname;
	    String othersecondname=getothersecondname;
	    String prevfamilyname=getprevfamilyname;
	    dob = getdob;
	    String nstudentnumber=getnstudentnumber;
	    String email = getemail;   
	    String remail = getremail;
	    String password = getpassword;  
	    String rpassword = getrpassword;
	    String qualsearchtype = getqualsearchtype;
	    String coursename=getcoursename;
	    String residencystatus=getresidencystatus;
	    String country=getcountry;
	    String contactcountry=getcontactcountry; 
	    String livinginNZ=getlivinginNZ;    
	    String ethnicity1=getethnicity1; 
	    String ethnicity2=getethnicity2; 
	    String ethnicity3=getethnicity3;
	    String iwi1=getiwi1;
	    String iwi2=getiwi2; 
	    String iwi3=getiwi3; 
	    String iwi4=getiwi4; 
	    String homephone=gethomephone;
	    String mobile=getmobile; 
	    String contactaddressline1=getcontactaddressline1; 
	    String contactaddressline2=getcontactaddressline2;
	    String contactaddressline3=getcontactaddressline3;
	    String contactaddressline4=getcontactaddressline4;
	    String city=getcity;
	    String postcode=getpostcode; 
	    String currentlyatsecondaryschool=getcurrentlyatsecondaryschool;
	    String currentlystudyingtowards=getcurrentlystudyingtowards;
	    String agreeNZQAresultscheckbox=getagreeNZQAresultscheckbox;
	    String lastsecschool=getlastsecschool;
	    String lastschoolyear=getlastschoolyear; 
	    String prevtertiarystudyatuniv=getprevtertiarystudyatuniv;
	    String firstenrolter=getfirstenrolter;
	    String institutiontype=getinstitutiontype; 
	    String institutionname=getinstitutionname;
	    String overseasinstitutioncountry=getoverseasinstitutioncountry;
	    String qualificationtype=getqualificationtype;
	    String qualname=getqualname; 
	    String highsecqual=gethighsecqual; 
	    String yearfrom=getyearfrom;
	    String yearto=getyearto;
	    String gender=getgender;
	    String completequal=getcompletequal;
	    String anyotherqual=getanyotherqual;
		String courseintake, coursemonth=null; 
		int courserownumber=1;
		usertype=getusertype;
		Thread.sleep(2000);
	    String appurl= propertyconfig.getApplicationURL();
	    driver.get(appurl);  //URL picked from the Property file	

	switch (usertype)  // Data driven from Excel
	{
	case "Student":
		{
			 	assertEquals(driver.findElement(By.cssSelector("p.header-subtitle.sv-hidden-xs")).getText(), "Application");   
			    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Apply to Study at Waikato");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div/h2")).getText(), "Before you start your application");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/h4")).getText(), "What you need to know");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/p")).getText(), "Whether you're in New Zealand or you're an international student, there are a few things to know before you start.");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/p[2]")).getText(), "This application process asks you to choose your qualification. It will take you about 15 minutes to complete. You can save your application at any time and return to complete it later.");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/p[3]")).getText(), "What you'll need:");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/ul/li")).getText(), "An idea of which qualification you want to study. If you are unsure go to the Study @ Waikato webpage.");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/ul/li[2]")).getText(), "Information about your secondary schooling or tertiary study.");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/p[4]")).getText(), "If you are interested in English Language, ESOL Teacher Training, IELTS Testing, or Short Study Preparation Programmes, go to the Waikato Pathways College webpage.");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/h4[2]")).getText(), "International Students");
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_section']/div/div/div[2]/div[2]/p[5]")).getText(), "Apply here to study at Waikato. International students have to meet some additional requirements relating to English language, study visa/permits and medical insurance. More information about these requirements can be found here.");
			    assertEquals(driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div/div/h2")).getText(), "Create a new user");
			    assertEquals(driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div/h2")).getText(), "I'm a current student or have studied here before");
			    assertTrue(isElementPresent(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")));
			  
			    assertEquals(driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).getText(), "Login");
			    assertEquals(driver.findElement(By.cssSelector("h2.sv-col-md-3.sv-col-xs-12")).getText(), "Get in touch with us");
			    assertEquals(driver.findElement(By.cssSelector("p.sv-col-md-3.sv-col-xs-6 > span")).getText(), "In New Zealand");
			    assertEquals(driver.findElement(By.cssSelector("em > a")).getText(), "0800 WAIKATO");
			    assertEquals(driver.findElement(By.xpath("//p[2]/span")).getText(), "International");
			    assertEquals(driver.findElement(By.linkText("+64 7 856 2889")).getText(), "+64 7 856 2889");
			    assertEquals(driver.findElement(By.xpath("//img[@alt='University of Waikato Logo']")).getText(), "");
			    assertTrue(isElementPresent(By.xpath("//img[@alt='University of Waikato Logo']")));
			    assertEquals(driver.findElement(By.id("NEW_USER")).getAttribute("value"), "New User");
			    driver.findElement(By.id("NEW_USER")).click();
			    // Register - Provide Login Details  
			    assertEquals(driver.findElement(By.xpath("//div[@id='login_user']/label")).getText(),"Confirm email*");			    
			    // Email Validation
			    driver.findElement(By.id("IPU_CAEM.IPU.SRS")).clear();			   
			    driver.findElement(By.id("IPU_CAEM.IPU.SRS")).sendKeys("Testing@gmail");
			    WebElement webElement = driver.findElement(By.id("IPU_CAEM.IPU.SRS"));//You can use xpath, ID or name whatever you like
			    webElement.sendKeys(Keys.TAB);
			    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-15']/div")).getText(), "This value should be a valid email.");
			    driver.findElement(By.id("USERCODE.IPU.SRS")).sendKeys("Testing");
			    driver.findElement(By.id("PROCEED.DUM1.SRS")).click();
			    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-17']/div")).getText(), "This value should be the same.");	    
			    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-17']/div[2]")).getText(), "This value should be a valid email.");		    
			    // Email validation completed			    
			    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset[2]/div[3]/label")).getText(),"Password*");
			    driver.findElement(By.id("PASSWORD1.IPU.SRS")).clear();
			    driver.findElement(By.id("PASSWORD1.IPU.SRS")).sendKeys(password);
			    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset[2]/div[4]/label")).getText(),"Confirm password*");
			    driver.findElement(By.id("PASSWORD2.IPU.SRS")).clear();
			    driver.findElement(By.id("PASSWORD2.IPU.SRS")).sendKeys(rpassword);
			    
			    //Same Username validation
			    driver.findElement(By.id("IPU_CAEM.IPU.SRS")).clear();
			    driver.findElement(By.id("IPU_CAEM.IPU.SRS")).sendKeys("rbhatia@waikato.ac.nz");
			    driver.findElement(By.id("USERCODE.IPU.SRS")).clear();
			    driver.findElement(By.id("USERCODE.IPU.SRS")).sendKeys("rbhatia@waikato.ac.nz");
			    driver.findElement(By.id("IPU_FNM1.IPU.SRS")).clear();
			    driver.findElement(By.id("IPU_FNM1.IPU.SRS")).sendKeys(firstn);
			    driver.findElement(By.id("IPU_SURN.IPU.SRS")).clear();
			    driver.findElement(By.id("IPU_SURN.IPU.SRS")).sendKeys(lastn);
			    driver.findElement(By.id("IPU_DOB.IPU.SRS")).clear();
			    driver.findElement(By.id("IPU_DOB.IPU.SRS")).sendKeys(dob);
			    driver.findElement(By.id("PROCEED.DUM1.SRS")).click();
			    	    
			    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]")).getText(), "Please check the following mandatory fields or invalid entries:\nUsername already in use");			    
			    //Same Username validation Done //
			    
			    driver.findElement(By.id("USERCODE.IPU.SRS")).clear();
			    driver.findElement(By.id("USERCODE.IPU.SRS")).sendKeys(remail);
			  
			    //rest details in the common script below
			    break;
		}	
	case "Staff_Search":
		{
			// Register/Login Page
			staffSearchLogin(firstn, lastn, email, secondname, othersecondname, dob); //Login steps for Staff Search.
			winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
			getDriverWindowHandle();
			driver.findElement(By.linkText("Start a New Application")).click(); //
			switchDriver();					 
			break;
		}
	case "Staff_New":
		{			
			// Register/Login Page
			 driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).click();
			 assertEquals(driver.findElement(By.cssSelector("p.header-subtitle.sv-hidden-xs")).getText(), "e:Vision");
			 assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Log in to SITS e:Vision Portal");
			 assertEquals(driver.findElement(By.cssSelector("div.sv-page-header.sv-hidden-xs > p")).getText(), "This page is the SITS e:Vision Portal login screen. Please use the form below to supply your login details and click the \"Log in\" button to access the system.");
			 assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Portal Login");
			 assertEquals(driver.findElement(By.cssSelector("label")).getText(), "Username");
			 driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).clear();
			 driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).sendKeys("STAFF"); //provide staff  credentials
			 assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Password");
			 driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).clear();
			 driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).sendKeys("Testing@2");  // provide staff account password
			 assertEquals(driver.findElement(By.linkText("Forgotten your password?")).getText(),"Forgotten your password?");
			 driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS.1\"]")).click();
			 // Home Page
			 driver.findElement(By.id("PTAD01P")).click();
			 //Admission and Enrolment page 
			 assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(),"Admission and Enrolment");
			 assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Admission functions");
			 assertEquals(driver.findElement(By.cssSelector("a.sv-list-group-item.sv-list-group-item-overflow")).getText(), "Create account and start a new application");
			 assertEquals(driver.findElement(By.linkText("Student maintenance search")).getText(),"Student maintenance search");
			 winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
			 getDriverWindowHandle();
			 driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/a[1]")).click();
			 switchDriver();  // Staff login results in another window getting opened.
			 //Create Portal Login - Provide student details in the common script	
			 break;	
		}
	case "Agent":
		{
			// Register/Login Page
			 agentLogin();  //Call the Agent login steps
			 winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
			 getDriverWindowHandle();
			 driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div[1]/a")).click();
			 switchDriver();  // Staff login results in another window getting opened.
			 break;
		}
	}
	
    //this.executeScript();
	//courseyear="2017";  

	if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent"))  //Staff_Search will go directly to the qualification search screen.
	{
		assertEquals(driver.getTitle(), "New user screen - Application");
	    assertEquals(driver.findElement(By.cssSelector("p.header-subtitle.sv-hidden-xs")).getText(), "Application");
	    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Create Portal Login");
	    assertEquals(driver.findElement(By.cssSelector("div.sv-page-header > p")).getText(), "Before you can start your application, you need to register with us and create a new user account.");
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div/h2")).getText(), "New user details");
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset/legend")).getText(), "Personal details");
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset/div/label")).getText(),"First Name*");
	    assertTrue(isElementPresent(By.id("IPU_FNM1.IPU.SRS")));
	    driver.findElement(By.id("IPU_FNM1.IPU.SRS")).clear();
	    driver.findElement(By.id("IPU_FNM1.IPU.SRS")).sendKeys(firstn);
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset/div[2]/label")).getText(), "Second/Middle Name");
	    driver.findElement(By.id("IPU_FNM2.IPU.SRS")).clear();
	    driver.findElement(By.id("IPU_FNM2.IPU.SRS")).sendKeys(secondname);
	    assertTrue(isElementPresent(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset/div[2]/div/input")));
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset/div[3]/label")).getText(), "Other Second/Middle Name(s)");
	    driver.findElement(By.id("IPU_FNM3.IPU.SRS")).clear();
	    driver.findElement(By.id("IPU_FNM3.IPU.SRS")).sendKeys(othersecondname);
	    assertTrue(isElementPresent(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset/div[3]/div/input")));
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset/div[4]/label")).getText(),"Last Name/Family Name*");
	    driver.findElement(By.id("IPU_SURN.IPU.SRS")).clear();
	    driver.findElement(By.id("IPU_SURN.IPU.SRS")).sendKeys(lastn);
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset/div[5]/label")).getText(),"Date of Birth*");
	    driver.findElement(By.id("IPU_DOB.IPU.SRS")).clear();
	    driver.findElement(By.id("IPU_DOB.IPU.SRS")).sendKeys(dob);
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset[2]/legend")).getText(), "Account details");
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[2]/div/div/fieldset[2]/div/label")).getText(),"Email (username)*");  	   
	     
	    driver.findElement(By.id("IPU_CAEM.IPU.SRS")).clear();
	    driver.findElement(By.id("IPU_CAEM.IPU.SRS")).sendKeys(email);
	   
	    assertEquals(driver.findElement(By.xpath("//form[@id='ipp_new_form']/div/div/div/div[3]/div/div/input")).getAttribute("value"), "Cancel");
	    assertEquals(driver.findElement(By.id("PROCEED.DUM1.SRS")).getAttribute("value"), "Create account");
	    driver.findElement(By.id("PROCEED.DUM1.SRS")).click();
	 }	
		
    // Qualification Search
    // temp if (qualsearchcount<2) qualificationSearch(email);  // Call the Qualification search method to test all the qualifications at high level. Just execute once. Story# 10228, 10041
    assertEquals(driver.findElement(By.cssSelector("img[alt=\"University of Waikato\"]")).getText(), "");
    assertEquals(driver.findElement(By.cssSelector("p.header-subtitle.sv-hidden-xs")).getText(), "Application");
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Qualification Search");
    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Search criteria");
    assertEquals(driver.findElement(By.cssSelector("label.sv-col-sm-3.sv-control-label")).getText(), "Type of Qualification");
    assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Keyword");
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText(qualsearchtype);
    //  assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Keyword");
    assertEquals(driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).getAttribute("value"), "Search");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();      
    driver.findElement(By.linkText(coursename)).click();
    assertEquals(driver.findElement(By.name("BP101.DUMMY_B.MENSYS")).getAttribute("value"), "Back to Search Results");
    driver.findElement(By.name("BP101.DUMMY_B.MENSYS")).click();    
    driver.findElement(By.linkText(coursename)).click();
    // Qualification Selection
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Qualification selection");
    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Apply for the qualification: " + coursename);
    assertEquals(driver.findElement(By.xpath("//th/span")).getText(), "Please select when you wish to begin this qualification");
    assertEquals(driver.findElement(By.xpath("//tr[2]/th/span")).getText(), "Year");
    assertEquals(driver.findElement(By.xpath("//th[2]/span")).getText(), "Intake");
    assertEquals(driver.findElement(By.xpath("//th[3]/span")).getText(), "Apply");
    assertEquals(driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS\"]")).getAttribute("value"), "Back to Search Results");
    assertEquals(driver.findElement(By.name("APPLY.IPO.SRS.1")).getAttribute("value"), "Apply");        
    Object courseoptions[][]= courseChoice();
    //driver.findElement(By.xpath("//tbody/tr[2]/td[3]/span/input")).click(); 
    //courseyear = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/span")).getText(); //To be checked in the Summary page, Story#10287
    //courseintake= driver.findElement(By.xpath("//tbody/tr[1]/td[2]/span")).getText();  //To be checked in the Summary page, Story#10287
    //driver.findElement(By.name("APPLY.IPO.SRS.1")).click();
    
    driver.findElement(By.name("APPLY.IPO.SRS.2")).click(); //Click Apply button
    courseyear=(String)courseoptions[1][0]; //clicked 2nd row
    courseintake= (String)courseoptions[1][1];
    if(courseintake.contains(" "))
    {
        coursemonth = courseintake.substring(0, courseintake.indexOf(" ")); 
    }
    Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(coursemonth);
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int month1 = cal.get(Calendar.MONTH);     // To use this for Age verification in the ACD screen, once exact course start dates will appear.
    month1++;     
    if (month1<10)    coursemonth="0"+month1;  //to check in SITS
    else coursemonth=""+month1;
      
    //LocalDate birthdate = new LocalDate (1970, 1, 20);
    //LocalDate now = new LocalDate();
    //Years age = Years.yearsBetween(birthdate, now);
    
    // Personal Details Page
    assertEquals(driver.findElement(By.cssSelector("h4.progress-title")).getText(), "Personal details");
    assertEquals(driver.findElement(By.xpath("//li[2]/span[2]/h4")).getText(), "Contact details");
    assertEquals(driver.findElement(By.xpath("//li[3]/span[2]/h4")).getText(), "Education");
    assertEquals(driver.findElement(By.xpath("//li[4]/span[2]/h4")).getText(), "Documents");
    assertEquals(driver.findElement(By.xpath("//li[5]/span[2]/h4")).getText(), "Declaration");
    
    if (usertype.equals("Staff_Search")) 
    { 
	  	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/p")).getText(), "Identity details are not able to be changed in this form. If any of these details need updating, please request a change."); 	 
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/label")).getText(), "First Name*");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/label")).getText(), "Second/Middle Name(s)");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[4]/label")).getText(), "Other Second/Middle Name(s)");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/label")).getText(), "Last Name/Family Name*");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[6]/label")).getText(), "Preferred First Name");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/label")).getText(), "Previous Family Name (if applicable)");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/p")).getText(), "Gender*");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/label")).getText(), "Date of Birth*");	  
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div")).getText(),firstn.toUpperCase());
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/div")).getText(),secondname.toUpperCase());
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[4]/div")).getText(),othersecondname.toUpperCase());
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/div")).getText(), lastn.toUpperCase());
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/div")).getText(), dob);
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/div")).getText(),nstudentnumber);	      
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/div")).getText(),gender);
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/label")).getText(),"National Student Number");	 
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[11]/div")).getText(),residencystatus);
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[11]/label")).getText(), "Residency Status*");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[12]/label")).getText(), "Country of Citizenship*");
	 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[12]/div")).getText(),country);
    }
    else if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent")) 
    {
    	assertEquals(driver.findElement(By.cssSelector("li > a")).getText(), "Applications");
	  	assertEquals(driver.findElement(By.id("IPR_FNM1")).getAttribute("value"), firstname);
    	assertEquals(driver.findElement(By.id("IPR_FNM2")).getAttribute("value"), secondname.toUpperCase());
    	assertEquals(driver.findElement(By.id("IPR_FNM3")).getAttribute("value"), othersecondname.toUpperCase());
    	assertEquals(driver.findElement(By.id("IPR_SURN")).getAttribute("value"), lastname);
    	assertEquals(driver.findElement(By.id("IPR_FUSD")).getAttribute("value"), firstname);
    	driver.findElement(By.id("IPR_FUSD")).clear();
    	driver.findElement(By.id("IPR_FUSD")).sendKeys(firstname);
    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/div/input")).getAttribute("value"), firstname);
    	assertEquals(driver.findElement(By.id("IPR_DOB")).getAttribute("value"), dob);
    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/label")).getText(),"First Name*");
	   
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/label")).getText(), "Second/Middle Name(s)");
	    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/input")));
	   
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/label")).getText(), "Other Second/Middle Name(s)");
	    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/div/input")));
	    
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[4]/label")).getText(),"Last Name/Family Name*");
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/label")).getText(), "Preferred First Name");
	    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/div/input")));
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[6]/label")).getText(), "Previous Family Name (if applicable)");
	    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[6]/div/input")));
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/label")).getText(),"Date of Birth*");
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/p")).getText(),"Gender*");
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/label")).getText(), "National Student Number");
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/label")).getText(),"Residency Status*"); 
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[11]/label")).getText(),"Country of Citizenship*");
    	  
    }
  
    assertEquals(driver.findElement(By.xpath("//div/div/p")).getText(), "Logged in as: "+ firstn+" "+ lastn);
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div/h2")).getText(), "Personal details");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/legend")).getText(), "Identity details");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/legend")).getText(), "Other details");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div/p")).getText(),"Will you be living in New Zealand for the period of your study?*");   
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div/div/div/label")).getText(), "Yes");  
    assertTrue(isElementPresent(By.id("IPQ_ADOAP_LOCL2"))); 
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div/div/div[2]/label")).getText(), "No");
    if(livinginNZ.equalsIgnoreCase("Yes"))
    {
    	driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();
    	livinginNZcode="Y";
    }
    else
    {	
    	driver.findElement(By.id("IPQ_ADOAP_LOCL2")).click(); // Yes if none specified.
    	livinginNZcode="N";
    } 
  
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/label")).getText(),"Ethnicity*");
    
    if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent"))
    {
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/div/div[2]/label")).getText(), "Male");
		        driver.findElement(By.id("IPQ_ADOAP_PRVS")).sendKeys(prevfamilyname);
		    if(gender.equalsIgnoreCase("Male"))
		    	{
		    	driver.findElement(By.id("IPR_GEND_M")).click();
		    	}
		    else  if(gender.equalsIgnoreCase("Female"))
		    	{
		    	driver.findElement(By.id("IPR_GEND_F")).click();
		    	}
		    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/div/div/label/input")));
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/div/div/label")).getText(), "Female");
		  
		    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/div/input")));
		    if (nstudentnumber!=null)
		    {
		    driver.findElement(By.id("IPQ_ADOAP_NSN")).sendKeys(nstudentnumber);
		    }
		  
		    new Select(driver.findElement(By.id("IPQ_ADOAP_NID1"))).selectByVisibleText(residencystatus);   
		
		    
		    if(residencystatus.equals("NZ Citizen") || residencystatus.equals("Australian Citizen"))
		    {    	
		    	assertFalse(driver.findElement(By.id("IPQ_ADOAP_CODC")).isEnabled());
		    	//assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_CODC"))).getAllSelectedOptions().get(0).getText(),country);
		    	assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_CODC"))).getFirstSelectedOption().getText(),country);
		    }
		    else
		    {    	
		       	assertTrue(driver.findElement(By.id("IPQ_ADOAP_CODC")).isEnabled());
		       	new Select(driver.findElement(By.id("IPQ_ADOAP_CODC"))).selectByVisibleText(country);
		    }
		    //Select dropdowncitcountry=new Select(driver.findElement(By.id("IPQ_ADOAP_CODC")));
		    //assertTrue(dropdowncitcountry.getAllSelectedOptions().get(0).getText().equals(country));        
		    //System.out.println(driver.findElement(By.id("IPQ_ADOAP_CODC")).getText());  All the countries
		    //System.out.println(driver.findElement(By.id("IPQ_ADOAP_CODC")).getAttribute("value").equals(coursename));    
		    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedLabel | id=IPQ_ADOAP_CODC | ]]
		    // ERROR: Caught exception [ERROR: Unsupported command [isEditable | id=IPQ_ADOAP_CODC | ]]
		  
		   
		    new Select(driver.findElement(By.id("IPQ_ADOAP_ETH1"))).selectByVisibleText(ethnicity1);
		    if (ethnicity2!="")   new Select(driver.findElement(By.id("IPQ_ADOAP_ETH2"))).selectByVisibleText(ethnicity2);  //Making sure if the data exist, otherwise don't execute
		    if (ethnicity3!="")   new Select(driver.findElement(By.id("IPQ_ADOAP_ETH3"))).selectByVisibleText(ethnicity3);
		    
		    if (ethnicity1.equals("New Zealand Maori") || ethnicity2.equals("New Zealand Maori") || ethnicity3.equals("New Zealand Maori"))
		    {    
		    	if (iwi1!="")		
		    	{
		    		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[5]/label")).getText(), "Iwi");
		    		new Select(driver.findElement(By.id("IPQ_ADOAP_IWI1"))).selectByVisibleText(iwi1);    	
		    	}
		    	if (iwi2!="" && iwi1!="") 		new Select(driver.findElement(By.id("IPQ_ADOAP_IWI2"))).selectByVisibleText(iwi2);
		    	if (iwi3!="" && iwi2!="")	 	new Select(driver.findElement(By.id("IPQ_ADOAP_IWI3"))).selectByVisibleText(iwi3);
		    	if (iwi4!="" && iwi3!="") 		new Select(driver.findElement(By.id("IPQ_ADOAP_IWI4"))).selectByVisibleText(iwi4);
		    }    
		    else
		    {
		    	iwi1=""; iwi2=""; iwi3=""; iwi4="";  //To avoid script failure in case Iwi data is provided in the excel sheet.
		    }
    }
    driver.findElement(By.id("app-btn-next")).click();
  //Call Client to validate if the data is retrievable prior to saving or exiting
    if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent")) /// need to revisit this statement as migrated data won't be in the IPR and IPRQ screens 
    if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent")) // temp this.executeScript("beforesubmission",firstn, lastn, email, dob, null, null, null, country, coursename, null, null, null, null, gender, "", null, null, null, null, null, null, livinginNZcode, nstudentnumber, prevfamilyname, secondname, othersecondname, null, null, null, null, null, null, null, null, null, null, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2, iwi3, iwi4, residencystatus, courseyear, coursemonth);
    // Contact Details
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div/h2")).getText(), "Contact details");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div/label")).getText(), "Email");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div/div/input")).getAttribute("value"), email);
 
    //assertFalse(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div/div/input")).isEnabled());
    String readonly = driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div/div/input")).getAttribute("readonly");
    Assert.assertNotNull(readonly);  //Checks the value of the String to find out if the textbox is readonly.
   
    // ERROR: Caught exception [ERROR: Unsupported command [isEditable | //form[@id='app_form']/div/div[2]/div/div/div/div/input | ]]

    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[2]/label")).getText(), "Home Phone");
    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[2]/div/input")));
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[3]/label")).getText(), "Mobile");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[4]/label")).getText(),"Contact Address*");
    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[5]/div/input")));
    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[6]/div/input")));
    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[7]/div/input")));
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[8]/label")).getText(),"City/Town*");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[9]/label")).getText(),"Postcode*");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/p/small")).getText(),"Required fields are marked with (*)");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[9]/div/small")).getText(), "The postcode is only mandatory for NZ addresses. If you don't know your postcode use the NZ Postcode Finder");
    getDriverWindowHandle();  //get current browser details
    // click the link which creates the popup window
    driver.findElement(By.linkText("NZ Postcode Finder")).click();
    /***for (String winHandle : driver.getWindowHandles()) {  // Another method but not tested
        driver.switchTo().window(winHandle);
    } **/
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Address & Postcode Finder | New Zealand Post | ]]
    switchDriver();  //Switch to new browser
    Thread.sleep(500);
    assertEquals(driver.findElement(By.xpath("//div[@id='content']/div/h1")).getText(), "Address & Postcode Finder"); 
    assertEquals(driver.getCurrentUrl(), "https://www.nzpost.co.nz/tools/address-postcode-finder");
    assertEquals(driver.getTitle(), "Address & Postcode Finder | New Zealand Post");
    switchToEarlierDriver();  //switch back to previous browser
    
    if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent"))
    {
		    driver.findElement(By.id("IPR_CAT1")).clear();
		    driver.findElement(By.id("IPR_CAT1")).sendKeys(homephone);
		    driver.findElement(By.id("IPR_CAT3")).clear();
		    driver.findElement(By.id("IPR_CAT3")).sendKeys(mobile);
		   
		    driver.findElement(By.id("IPR_CAD1")).clear();
		    driver.findElement(By.id("IPR_CAD1")).sendKeys(contactaddressline1);
		    driver.findElement(By.id("IPR_CAD2")).clear();
		    driver.findElement(By.id("IPR_CAD2")).sendKeys(contactaddressline2);
		    driver.findElement(By.id("IPR_CAD3")).clear();
		    driver.findElement(By.id("IPR_CAD3")).sendKeys(contactaddressline3);
		    driver.findElement(By.id("IPR_CAD4")).clear();
		    driver.findElement(By.id("IPR_CAD4")).sendKeys(contactaddressline4);
		    
		    
		    driver.findElement(By.id("IPR_CAD5")).clear();
		    driver.findElement(By.id("IPR_CAD5")).sendKeys(city);
		    
		    driver.findElement(By.id("IPR_CAPC")).clear();
		    driver.findElement(By.id("IPR_CAPC")).sendKeys(postcode);
		    
		    driver.findElement(By.xpath("//div[@id='IPR_COD2_chosen']")).click();
		    driver.findElement(By.xpath("//div[@id='IPR_COD2_chosen']/div/div/input")).sendKeys(contactcountry);
		    driver.findElement(By.xpath("//div[@id='IPR_COD2_chosen']/div/div/input")).sendKeys(Keys.RETURN);	    
		    
    }
    
     
    
    //Checking the Postcode condition, as it's mandatory for NZ only
    if (contactcountry.equals("New Zealand"))
    {
    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[9]/label")).getText(),"Postcode*");
    	  driver.findElement(By.id("IPR_CAPC")).clear();
    	  driver.findElement(By.id("app-btn-next")).click();
    	  assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-21']/div")).getText(),"This value is required.");   
    	  driver.findElement(By.id("IPR_CAPC")).sendKeys(postcode);
    }	
    else
    {	
    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[9]/label")).getText(),"Postcode");
    }
    //driver.findElement(By.xpath("//ul[@id='IPR_COD2_ul']/li[150]")).click();    
    // ERROR: Caught exception [ERROR: Unsupported command [typeKeys | //div[@id='IPR_COD2_chosen']/div/div/input | New Zealand]]
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //ul[@id='IPR_COD2_ul']/li[150] | New Zealand]]
    driver.findElement(By.id("app-btn-next")).click();
    // Education Page
    if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent"))
    {
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div/h2")).getText(), "Education");
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/legend")).getText(), "Previous study");   
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/p")).getText(),"Are you currently at secondary school?*"); 
	    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/div/div/label/input")));  
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/div/div/label")).getText(), "Yes");
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/div/div[2]/label")).getText(), "No");
	    if(currentlyatsecondaryschool.equalsIgnoreCase("Yes"))
	    {
	    	driver.findElement(By.id("ADOAP_EDSSQ1")).click();
	    	currentlyatsecondaryschoolcode="Y";
	    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[2]/label")).getText(), "What are you currently studying towards?*");
	    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[10]/div/div/label")).getText(), "I agree to NZQA releasing my NCEA Level 2 results (or equivalent) to Waikato so that they can be used for assessing my eligibility for Waikato scholarships and awards");
	    	driver.findElement(By.id("IPQ_ADOAP_CSTY")).sendKeys(currentlystudyingtowards);    	
	    	if(agreeNZQAresultscheckbox.equalsIgnoreCase("Yes") && !driver.findElement(By.id("IPQ_ADOAP_EDCB")).isSelected()) 
	    	{
	    		driver.findElement(By.id("IPQ_ADOAP_EDCB")).click();  //check it
	    	}
	    	else if(agreeNZQAresultscheckbox.equalsIgnoreCase("No") && driver.findElement(By.id("IPQ_ADOAP_EDCB")).isSelected()) 
	    	{
	    		driver.findElement(By.id("IPQ_ADOAP_EDCB")).click();  //Uncheck it
	    	}
	    }
	    else
	    {
	    	currentlyatsecondaryschoolcode="N";
	    	currentlystudyingtowards="";
	    	driver.findElement(By.id("ADOAP_EDSSQ2")).click();
	    }   
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[4]/label")).getText(),"Last secondary school attended*");    
	    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']")).click();
	    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input")).sendKeys(lastsecschool);
	    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input")).sendKeys(Keys.RETURN);
	    // ERROR: Caught exception [ERROR: Unsupported command [typeKeys | //div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input | ACG Senior College]]
	    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //ul[@id='IPQ_ADOAP_EDLSCL_ul']/li[4] | ACG Senior College]]   
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/label")).getText(),"Last year at school*"); 
	    // ERROR: Caught exception [ERROR: Unsupported command [getSelectOptions | //form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/div/select | ]]
	    new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSTY"))).selectByVisibleText(lastschoolyear);   
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[6]/label")).getText(),"What is the highest secondary level qualification you have completed?*"); 
	    new Select(driver.findElement(By.id("IPQ_ADOAP_EDHQAL"))).selectByVisibleText(highsecqual);
	    if (highsecqual.equals("Overseas Qualification"))
	    {
	    	  	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/label")).getText(),"What qualification did you complete?*");
	    		driver.findElement(By.id("IPQ_ADOAP_EDQC")).sendKeys("Higher School Certificate");
	    }
	    	
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/p")).getText(),"Have you previously studied at tertiary level ( other than at the University of Waikato )?*");    
	    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/div/div[2]/label/input")));   
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/div/div/label")).getText(), "Yes"); 
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/div/div[2]/label")).getText(), "No"); 
	    //Story# 10043 (As an applicant (general), I need a mechanism to provide details of any previous tertiary study I may have completed in order to apply to the University.)
	    if(prevtertiarystudyatuniv.equalsIgnoreCase("Yes"))
	    {
	    	driver.findElement(By.id("ADOAP_EDPTS1")).click();
	    	prevtertiarystudyatunivcode="Y";
	        assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/label")).getText(),"Which year did you first enrol in tertiary study?*");    	 
	        new Select(driver.findElement(By.id("IPQ_Which year did you first enrol in tertiary study"))).selectByVisibleText(firstenrolter);
	        if (residencystatus.equals("NZ Citizen") || residencystatus.equals("NZ Permanent Resident") ||  residencystatus.equals("Cook Islands") || residencystatus.equals("Niue") || residencystatus.equals("Tokelau") || (residencystatus.equals("Australian Citizen") && livinginNZ.equalsIgnoreCase("Yes")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && livinginNZ.equals("Yes")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && livinginNZ.equalsIgnoreCase("Yes")))
	     	{ // Domestic only
		    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[11]/p")).getText(),"Have you studied at an institution that has a credit or pathway arrangement with us?*");
		    	driver.findElement(By.id("ADOAP_CRPTH2")).click();
	    	}
	        assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/legend")).getText(), "Previous tertiary study");    	
	        assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div/label")).getText(),"Institution Type*");    	  
	        new Select(driver.findElement(By.id("IPQ_ADOAP_EDIT"))).selectByVisibleText(institutiontype);    	 
	    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[2]/label")).getText(),"Institution Name*");    	
	    	driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDIN_chosen']")).click();
	    	driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDIN_chosen']/div/div/input")).sendKeys(institutionname);
	    	driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDIN_chosen']/div/div/input")).sendKeys(Keys.RETURN);
	    	    // ERROR: Caught exception [ERROR: Unsupported command [typeKeys | //div[@id='IPQ_ADOAP_EDIN_chosen']/div/div/input | ATC New Zealand]]
	    	    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | id=IPQ_ADOAP_EDIN24 | ATC New Zealand]]
	    	 if (institutionname.equals("Overseas Teachers College") || institutionname.equals("Overseas Technical Institute") || institutionname.equals("Overseas University"))
	    	 {
	    		 	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[3]/label")).getText(), "Country of Institution*"); 
	    		 	new Select(driver.findElement(By.id("IPQ_ADOAP_EDIC"))).selectByVisibleText(overseasinstitutioncountry);  //Institution country name
	    	 }
	    	 
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[4]/label")).getText(),"Qualification Type*");    	
	    	 new Select(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[4]/div/select"))).selectByVisibleText(qualificationtype);    	 
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[5]/label")).getText(),"Qualification Name*");    	 
	    	 driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[5]/div/input")).clear();
	    	 driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[5]/div/input")).sendKeys(qualname);    	  
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[6]/label")).getText(),"Year from*");
	    	  	    
	    	 // ERROR: Caught exception [ERROR: Unsupported command [getSelectOptions | id=IPQ_ADOAP_EDYF | ]]  //Put a condition to check years value in the drop down.
	    	 new Select(driver.findElement(By.id("IPQ_ADOAP_EDYF"))).selectByVisibleText(yearfrom);
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[7]/label")).getText(), "Year to");
	    
	    	 // ERROR: Caught exception [ERROR: Unsupported command [getSelectOptions | id=IPQ_ADOAP_EDYT | ]]   //Put a condition to check years value in the drop down.
	    	 if (!yearto.equals(""))    	 new Select(driver.findElement(By.id("IPQ_ADOAP_EDYT"))).selectByVisibleText(yearto);
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[8]/p")).getText(),"Did you complete this qualification?*");
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[8]/div/div/label")).getText(), "Yes");
	    	 assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[8]/div/div[2]/label/input")));
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[8]/div/div[2]/label")).getText(), "No");
	    
	    	 if(completequal.equalsIgnoreCase("Yes"))
	    	 {
	    		 	driver.findElement(By.id("IPQ_ADOAP_EDC-Y")).click();
	    		 	completequalcode="A";
	    	 }
	    	 else
	    	 {
	    	    	driver.findElement(By.id("IPQ_ADOAP_EDC-N")).click();
	    	    	completequalcode="P";
	    	 }    	
	    	 
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[9]/p")).getText(),"Do you have any other qualifications?");
	    	 assertTrue(isElementPresent(By.id("ADOAP_EDOQY")));
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[9]/div/div/label")).getText(), "Yes");
	    	 assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[9]/div/div[2]/label")).getText(), "No");
	    	 
	    	 if(anyotherqual.equalsIgnoreCase("Yes"))
	    	 {
	    	    	driver.findElement(By.id("ADOAP_EDOQY")).click();
	    	    	anyotherqualcode="Y";
	    	 }
	    	 else
	    	 {
	    	    	driver.findElement(By.id("ADOAP_EDOQN")).click();
	    	    	anyotherqualcode="N";
	    	 }
	    }
	    else
	    {
	    	firstenrolter=""; institutiontype=""; institutionname=""; overseasinstitutioncountry=""; qualname=""; qualificationtype=""; yearfrom=""; yearto=""; completequalcode=""; anyotherqualcode="";
	    	driver.findElement(By.id("ADOAP_EDPTS2")).click();
	    	prevtertiarystudyatunivcode="N";
	    }
	    if (currentlystudyingtowards.equals("Overseas Qualification"))
	    {
	    	driver.findElement(By.id("IPQ_ADOAP_EDQST")).sendKeys("Diploma in Mechanical");
	    }
	    driver.findElement(By.id("app-btn-next")).click();
	  
	 // tmep this.executeScript("beforesubmission", firstn, lastn, email, dob, city, postcode, mobile, country, coursename, contactaddressline1, contactaddressline2, contactaddressline3, contactaddressline4, gender, contactcountry, homephone, completequalcode, qualname, yearfrom, yearto, firstenrolter, livinginNZcode, nstudentnumber, prevfamilyname, secondname, othersecondname, anyotherqualcode, prevtertiarystudyatunivcode, currentlyatsecondaryschoolcode, currentlystudyingtowards, highsecqual, institutionname, institutiontype, qualificationtype, lastsecschool, lastschoolyear, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2, iwi3, iwi4, residencystatus, courseyear, coursemonth);
	    driver.findElement(By.id("app-btn-back")).click();
	    // Saving the Data for Story#10037
	    driver.findElement(By.id("app-btn-save")).click();
	    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Your application has been saved");
	    checkLinks10037(residencystatus, livinginNZ);
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
	    driver.findElement(By.linkText("Applications")).click();
	    // //Story#10287 (AC:1 [Un-Submitted], 2 - qual name and occurance)
	    courserownumber=getSummaryPageCourseRowNumber(coursename);
	    //if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
	    //else 
	    //{
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[1]")).getText(), courseyear);
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[2]")).getText(),coursename);
	    ///assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[4]")).getText(), "UnSubmitted");
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[4]")).getText(), "Incomplete");
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete");
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a")).getText(), "Continue");
	    driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a")).click(); //Click the corresponding 'Continue' button
		//}
	    // Verifying the Data for Story#10037
	    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedValue | id=IPQ_ADOAP_EDLSTY | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedLabel | id=IPQ_ADOAP_EDHQAL | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedValue | id=IPQ_Which year did you first enrol in tertiary study | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedLabel | id=IPQ_ADOAP_EDIT | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedLabel | id=IPQ_ADOAP_EDLS | ]]    
	
	    assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSTY"))).getFirstSelectedOption().getText(),lastschoolyear);
	 	assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDHQAL"))).getFirstSelectedOption().getText(),highsecqual);
	 	assertEquals(new Select(driver.findElement(By.id("IPQ_Which year did you first enrol in tertiary study"))).getFirstSelectedOption().getText(),firstenrolter);
	 	assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDIT"))).getFirstSelectedOption().getText(),institutiontype);
	 	assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDLS"))).getFirstSelectedOption().getText(),qualificationtype);
	   
	    assertEquals(driver.findElement(By.id("IPQ_ADOAP_EDQS")).getAttribute("value"),qualname);
	    //assertEquals(driver.findElement(By.id("IPQ_ADOAP_EDQS")).getAttribute("value"), qualname);
	    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedValue | id=IPQ_ADOAP_EDYF | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedValue | id=IPQ_ADOAP_EDYT | ]]
	    assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDYF"))).getFirstSelectedOption().getText(),yearfrom);
	    
	    if (!yearto.equalsIgnoreCase("")) assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDYT"))).getFirstSelectedOption().getText(),yearto);
	 
	}   
	 driver.findElement(By.id("app-btn-next")).click();
	    
	    
	 if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && livinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && livinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && livinginNZ.equalsIgnoreCase("No")))
	 {
	     //Additional Info Page for an International applicant
		 driver.findElement(By.id("ADOAP_INTAG1_2")).click();
		 driver.findElement(By.id("IPQ_ADOAP_INST")).sendKeys("Overseas University"); //Story# 10798
	 	 driver.findElement(By.id("app-btn-next")).click();
	 }
    //Documents page
    driver.findElement(By.id("app-btn-next")).click();
    // Declaration Page
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Qualification Application");  
    assertEquals(driver.findElement(By.cssSelector("h4.progress-title")).getText(), "Personal details");
    assertEquals(driver.findElement(By.xpath("//li[2]/a/span[2]/h4")).getText(), "Contact details");
    assertEquals(driver.findElement(By.xpath("//li[3]/a/span[2]/h4")).getText(), "Education");
    if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && livinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && livinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && livinginNZ.equalsIgnoreCase("No")))
    {
    	assertEquals(driver.findElement(By.xpath("//li[4]/a/span[2]/h4")).getText(), "Additional info");
      	assertEquals(driver.findElement(By.xpath("//li[5]/a/span[2]/h4")).getText(), "Documents");
     	assertEquals(driver.findElement(By.xpath("//li[6]/span[2]/h4")).getText(), "Declaration");    
    }
    else
    {
    	assertEquals(driver.findElement(By.xpath("//li[4]/a/span[2]/h4")).getText(), "Documents");  
    	assertEquals(driver.findElement(By.cssSelector("li.progress-step.is-active > span.progress-text > h4.progress-title")).getText(), "Declaration");
    }
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/p")).getText(), "I declare that the information I have provided in this application and in any attached documentation is true and correct, and that I have not withheld any information which could have a bearing on my application, enrolment or the conditions of my enrolment. I agree to supply any further documentation requested by the University of Waikato for the purpose of my application or enrolment. I have read the statement regarding the Privacy Act 1993 and I understand that the University of Waikato will hold, use and disclose information which I have provided as explained in that statement. I also understand that I have the right to have access to the information about me held by the University of Waikato and to request correction of that information, in the terms provided for under the Privacy Act 1993. Some personal information will be used by the Ministry of Education in an authorised information matching programme for the purposes of the National Student Index.");
    getDriverWindowHandle();
    driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/p/a")).click();
    switchDriver();
    Thread.sleep(2000);
    assertEquals(driver.getCurrentUrl(),"http://www.waikato.ac.nz/official-info/index/docs/privacyact");
    assertEquals(driver.getTitle(),"Personal Information and the Privacy Act 1993 - Official Information Index : University of Waikato");
   /// assertEquals(driver.findElement(By.xpath("//div[@id='content_div_58399']/h1")).getText(), "Personal Information and the Privacy Act 1993");
    switchToEarlierDriver();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
    driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button[3]")).click();
    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-multiple-ADOAP_DECC']/div")).getText(), "You must agree to submit your application.");
    driver.findElement(By.id("ADOAP_DECC")).click();
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/label/strong")).getText(),"I have read and agreed to the above declaration.*");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button[2]")).getText(), "Save and return later");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button")).getText(), "Back");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button[3]")).getText(), "Submit application");
    driver.findElement(By.xpath("//button[@id='app-btn-next']")).click();      
    
    Thread.sleep(5000);
    // Confirmation Page
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Qualification Application");
    if (usertype.equals("Staff_Search"))     assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/ol/li")).getText(), coursename + " " + courseyear); 
    else 									 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/ol/li[2]")).getText(), coursename + " " + courseyear);
    assertEquals(driver.findElement(By.xpath("//div/div/p")).getText(), "Logged in as: "+firstn+" "+lastn);
    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Your application has been submitted");
    assertEquals(driver.findElement(By.cssSelector("div.sv-form-horizontal > p")).getText(), "Thanks for submitting your application to study with us. We'll start considering your application straight away and will let you know, by email at "+email+" as soon as we've made a decision. We aim to provide a response to most applications within one week and will be in touch if we need any further information from you.");
    assertEquals(driver.findElement(By.xpath("//p[2]")).getText(), "You can login at any time to check the status of your application, or attach any documents we've requested.");
    assertEquals(driver.findElement(By.xpath("//p[3]")).getText(), "If you have any questions about your application feel free to call or email info@waikato.ac.nz. Or if you would like to talk to a Future Student Adviser please email recruitment@waikato.ac.nz");
    assertEquals(driver.findElement(By.cssSelector("div.sv-form-horizontal > p > strong")).getText(), email);
    assertEquals(driver.findElement(By.xpath("//p[4]")).getText(), "In the meantime you might want to collect further information to help with your studies from the links below.");
    // Check Studylink link for Story# 10050 (Residency status- All but not 'Other')
    
    if ((residencystatus.equals("Australian Citizen") && livinginNZ.equalsIgnoreCase("Yes")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && livinginNZ.equals("Yes")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && livinginNZ.equalsIgnoreCase("Yes")) || (residencystatus.equals("NZ Citizen")) || (residencystatus.equals("NZ Permanent Resident")) || (residencystatus.equals("Niue")) || (residencystatus.equals("Tokelau")) || (residencystatus.equals("Cook Islands")))
    {
    	getDriverWindowHandle();
    	driver.findElement(By.linkText("Studylink")).click();
    	switchDriver();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Studylink - StudyLink | ]]
    	assertEquals(driver.getCurrentUrl(),"https://www.studylink.govt.nz/");
    	assertEquals(driver.getTitle(),"Studylink - StudyLink");
  /**  try {
      assertEquals(driver.findElement(By.xpath("//div[@id='banner-blue']/div/a")).getText(), "StudyLink");
    } catch (Exception e) {
    System.out.println("Error:"+e.getMessage());
    }**/
   
    assertEquals(driver.findElement(By.xpath("//div[@id='content']/div/p")).getText(), "We help students make informed choices about their student finance, how to apply for it and manage it online.");

    switchToEarlierDriver();
    }
    else
    {
    	assertFalse(isElementPresent(By.linkText("Studylink")));
    }
    
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
    if (usertype.equals("Staff_Search")) 		  
	{
		driver.close();
		driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window  
	}
    else
    {
    driver.findElement(By.cssSelector("li > a")).click();
    // My Applications (Summary) Page
    // //Story#10287 (AC:1 [Submitted], 2 - qual name and occurance)
    //this.executeScript();      
    //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[4]")).getText(), "Submitted");
    assertEquals(driver.findElement(By.id("PTAD01S")).getText(), "Applications");
    assertEquals(driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/a")).getText(), firstn+" "+lastn);
    assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(), "Qualifications and Papers");
    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Current applications");
    }
    // temp this.executeScript("aftersubmission", firstn, lastn, email, dob, city, postcode, mobile, country, coursename, contactaddressline1, contactaddressline2, contactaddressline3, contactaddressline4, gender, contactcountry, homephone, completequalcode, qualname, yearfrom, yearto, firstenrolter, livinginNZcode, nstudentnumber, prevfamilyname, secondname, othersecondname, anyotherqualcode, prevtertiarystudyatunivcode, currentlyatsecondaryschoolcode, currentlystudyingtowards, highsecqual, institutionname, institutiontype, qualificationtype, lastsecschool, lastschoolyear, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2, iwi3, iwi4, residencystatus, courseyear, coursemonth);
    assertEquals(driver.findElement(By.linkText("Start a New Application")).getText(), "Start a New Application");
    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/thead/tr/th")).getText(), "Year");
    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/thead/tr/th[2]")).getText(), "Qualification");
    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/thead/tr/th[3]")).getText(), "Submitted");
    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/thead/tr/th[4]")).getText(), "Status");
    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/thead/tr/th[5]")).getText(), "Actions");
    //courserownumber = getSummaryPageCourseRowNumber(coursename);  //For staff home page. Staff home page not getting refreshed.
    if (!usertype.equals("Staff_Search"))  // 15280 bug logged for it
    {
    	courserownumber=getSummaryPageCourseRowNumber(coursename);
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td")).getText(), courseyear);
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[2]")).getText(), coursename);    
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[3]")).getText(), localDate.toString("dd/MMM/yyyy"));  //submitted date
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a")).getText(), "View");
	    driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[5]/a")).click();  // Click View button
		viewSubmittedCourseDetails(coursename, courseyear, firstname, secondname, othersecondname, lastname, prevfamilyname,nstudentnumber, gender, residencystatus, country, email, homephone, mobile, contactaddressline1, contactaddressline2, contactaddressline3, contactaddressline4, city, postcode, contactcountry,livinginNZ, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2,iwi3,iwi4);  // View the submitted course details
	}
    //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[5]/a[2]")).getText(), "Withdraw");
    //submitdate = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[3]")).getText();**/
    // changing location as two entries are coming up this.executeScript("aftersubmission", firstn, lastn, email, dob, city, postcode, mobile, country, coursename, contactaddressline1, contactaddressline2, contactaddressline3, contactaddressline4, gender, contactcountry, homephone, completequalcode, qualname, yearfrom, yearto, firstenrolter, livinginNZcode, nstudentnumber, prevfamilyname, secondname, othersecondname, anyotherqualcode, prevtertiarystudyatunivcode, currentlyatsecondaryschoolcode, currentlystudyingtowards, highsecqual, institutionname, institutiontype, qualificationtype, lastsecschool, lastschoolyear, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2, iwi3, iwi4, residencystatus, courseyear, coursemonth);
    // ERROR: Caught exception [unknown command [endForXml]]
    // ending xml tag
    if (usertype.equals("Staff_New") || usertype.equals("Agent")) 		  
    	{
    		driver.close();
    		driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window  
    	}
    	
    System.out.println("TEA-1Submit Online Application test case executed - "+email);
    System.out.println("--------------------------------------------------");
    logger.log(LogStatus.INFO,"TEA-1Submit Online Application test case executed");
	  } catch (Exception e) {
	      System.out.println("Error:"+e.getMessage());
	      exceptionerror="true";
	      errormessage=e.getMessage();}
  }

@Test (dataProvider = "ParamData") //(dependsOnMethods={"Auto1TEASubmitApplication"}, dataProvider = "ParamData")
public void Auto2TEALogin_Confirm_UploadDocs(String getusertype, String getfirstn, String getlastn,String getsecondname,String getothersecondname,String getprevfamilyname, String getdob, String getnstudentnumber, String getemail, String getremail, String getpassword,  String getrpassword, String getqualsearchtype, String getcoursename, String getresidencystatus, String getcountry, String getcontactcountry, String getlivinginNZ, String getethnicity1, String getethnicity2, String getethnicity3, String getiwi1, String getiwi2, String getiwi3, String getiwi4, String gethomephone, String getmobile, String getcontactaddressline1,String getcontactaddressline2,String getcontactaddressline3,String getcontactaddressline4, String getcity, String getpostcode, String getcurrentlyatsecondaryschool, String getcurrentlystudyingtowards, String getagreeNZQAresultscheckbox, String getlastsecschool, String getlastschoolyear, String gethighsecqual, String getprevtertiarystudyatuniv,String getfirstenrolter, String getinstitutiontype, String getinstitutionname, String getoverseasinstitutioncountry, String getqualificationtype, String getqualname, String getyearfrom, String getyearto, String getgender, String getcompletequal, String getanyotherqual) {
//TEA-SPRINT2->Story/Feature #10045:ADOAP-U012 - As an applicant (general) who needs to complete a student statement, I need a facility to provide a student statement in order to apply to the University.

	// TEA-SPRINT3->Story #10048:ADOAP-U015 - Returning to application after save & exiting ---> Scenario to Sign out (Auto1) and login (Auto2) again...<<Check that the data entered previously is available>>.
	// TEA-SPRINT2->Story/Feature #10046:ADOAP-U013 - As an applicant (general), I need a facility to upload documents to my application in order to support my application to the University.
// 10046: Acceptance Criteria 5 & 6 -  More details required. Point 7 not covered here, it's covered in the Manual test cases.
// 12608: Clearance checks call from this method. 	
// //PRE-REQ: Application has been SUBMITTED through the test case 'TEA-Submit Application' and Student is registered.
// //Using 'TEA-Submit Application' test script variables: firstn, lastn, email, password, submitdate, coursename, courseyear.
// //Course selected:  	Bachelor of Laws, Music and Certificate of University Preparation
// BUGS: 11108
try {
 logger = ReportScreenshotUtility.report.startTest("Auto2TEALogin_Confirm_UploadDocs - "+getemail);
 String email, password, firstn, lastn, coursename, courseyear, qualsearchtype, residencystatus, clchkcoursename="";
 email=getemail;
 password=getpassword;
 firstn=getfirstn;
 lastn=getlastn;
 coursename=getcoursename;
 residencystatus=getresidencystatus;
 int i=1;  //Qualifications count
 int courserownumber, linkrownumber;
 WebElement fileInput;
 //courseyear=getcourseyear;
 //qualsearchtype=getqualsearchtype;
 exceptionerror="false";		
 Thread.sleep(1000);
 String url= propertyconfig.getApplicationURL();  //URL picked from the Property file
 driver.get(url);
 usertype=getusertype;
 //ClearanceChecks clchk = new ClearanceChecks();  // To call the Clearance Check class method
// Register/Login Page
 switch (usertype)
 {
 	case "Student":
 	{
		studentLogin(email, password);
	  
		 assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Current applications");
		 assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(), "Qualifications and Papers");
		 assertEquals(driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/a")).getText(), firstn+" "+lastn);
		 courserownumber=getSummaryPageCourseRowNumber(coursename);
		 //if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
		 //else
		 //{
		 assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[2]")).getText(), coursename);
		 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[4]")).getText(), "Incomplete");
		 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
		assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a")).getText(), "View");
		 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td")).getText(), courseyear);***/
		 ///assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[4]")).getText(), "Applicant in Clearing");
		///assertEquals(driver.findElement(By.linkText("Withdraw")).getText(), "Withdraw");
		 //}
		 assertEquals(driver.findElement(By.linkText("Start a New Application")).getText(), "Start a New Application");
		 driver.findElement(By.linkText("Start a New Application")).click();
		 break;
 	}
 	case "Agent":
 	{
 		agentLogin();
 		linkrownumber=getLinkRowNumberForAgent(stuID, coursename);
 		 //if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
 		 //else
 		 //{
 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), coursename);
		 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[5]")).getText(), "Applicant");
 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a")).getText(), "View");
 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).getText(), "Withdraw");
 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
 		winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
		getDriverWindowHandle();
		driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).click();  //Start a new application
		switchDriver();  // Staff login results in another window getting opened.
 		break;
 		//table[@id='uow-applications']/tbody/tr[1]/td[1]
 	}
 	case "Staff_New":
 	case "Staff_Search":
 	{
 		staffSearchLogin(firstn, lastn, email, getsecondname, getothersecondname, getdob);
 		courserownumber=getSummaryPageCourseRowNumber(coursename);
		 //if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
		 //else
		 //{
		assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[2]")).getText(), coursename);
		assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[4]")).getText(), "Applicant");
		 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[4]")).getText(), "Incomplete");
		 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
		assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a")).getText(), "View");
		assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Withdraw");
		winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
		getDriverWindowHandle();
		driver.findElement(By.linkText("Start a New Application")).click(); //
		switchDriver();	 
 	 	break;
 	}
 	
 }
 //Validate the course details i.e application submitted in the first test case. 



 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td")).getText(), courseyear);***/
 ///assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[4]")).getText(), "Applicant in Clearing");
///assertEquals(driver.findElement(By.linkText("Withdraw")).getText(), "Withdraw");
 //}

 ///assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[3]")).getText(), "submitdate");
///} catch (Exception e) {
///System.out.println("Error:"+e.getMessage());
///}
while (i<=3)  // test for 3 qualifications - Bachelor of Laws, Laws with Honours and 2 other conjoint degrees (Bachelor of Communication Studies/Bachelor of Laws, Bachelor of Arts/ Bachelor of Laws)
{
// Qualification Search Page
//new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Degree");
driver.findElement(By.id("KEYWORD.IPP.SRS")).clear();
// temp driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("bachelor of laws");
// temp new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Degree");
// temp driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
	switch(i)
	{
			case 1:
			{
				driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("bachelor of laws");
				new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Degree");
				driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
				driver.findElement(By.linkText("Bachelor of Laws")).click();
				clchkcoursename="Bachelor of Laws";
				break;
			}
			/**case 2:  //Not required, removed from the user story
			{
				driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("bachelor of laws");
				new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Honours");
				driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
				driver.findElement(By.linkText("Bachelor of Laws with Honours")).click(); 
				clchkcoursename="Bachelor of Laws with Honours";
				break;
			}**/
			case 2: 
			{
				driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("bachelor of laws");
				new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Conjoint");
				driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
				driver.findElement(By.linkText("Bachelor of Communication Studies/Bachelor of Laws")).click();
				clchkcoursename="Bachelor of Communication Studies/Bachelor of Laws";
				break;
			}
			case 3:
			{
				driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("bachelor of laws");
				new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Conjoint");
				driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
				driver.findElement(By.linkText("Bachelor of Arts/ Bachelor of Laws")).click();
				clchkcoursename="Bachelor of Arts/ Bachelor of Laws";
				break;	
			}
	}
			//assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[12]/a")).getText(), "Bachelor of Laws");
			//driver.findElement(By.xpath("//ul[@id='courses']/li[12]/a")).click();
			// Qualification Selection Page
			driver.findElement(By.name("APPLY.IPO.SRS.1")).click();
			// Personal details page
			if(getlivinginNZ.equalsIgnoreCase("Yes"))
		    {
		    	driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();		    	
		    }
		    else
		    {	
		    	driver.findElement(By.id("IPQ_ADOAP_LOCL2")).click(); // Yes if none specified.		    	
		    }
			//driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();
			driver.findElement(By.id("app-btn-next")).click();
			// Contact details Page
			driver.findElement(By.id("app-btn-next")).click();
			// Education Page
			driver.findElement(By.id("ADOAP_EDSSQ2")).click();   //Overriding it as user story 10046 (10428) is updated with this check (student not at secondary school))
			driver.findElement(By.id("ADOAP_EDPTS2")).click();
			driver.findElement(By.id("app-btn-next")).click();
			if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && getlivinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && getlivinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && getlivinginNZ.equalsIgnoreCase("No")))
			{
			//Additional Info Page
			driver.findElement(By.id("ADOAP_INTAG1_1")).click();
			driver.findElement(By.id("IPQ_ADOAP_INST")).sendKeys("Overseas University"); //Story# 10798
			driver.findElement(By.id("app-btn-next")).click();
			}
			Thread.sleep(2000);
			// Documents Page
			
			assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/h3")).getText(), "Student statement");
			assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/div/p")).getText(), "We need to know a little bit more about you to consider your application. Please upload a student statement. There is no right or wrong way to write a student statement (but please do check your spelling and grammar). You should aim to write between 200 and 300 words overall. Tell us about why you're interested in studying your chosen qualification and your study history or employment background or anything that will confirm that you are ready for University study. We will use this information when considering your preparedness for study in your chosen qualification.");
			assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/p")).getText(),"Student statement*");
			assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/small")).getText(), "Files cannot be larger than 5MB. You can upload 1 file. File types that can be uploaded are doc, docx, htm, html, jpeg, jpg, pdf, png.");
			assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label")).getText(), "Upload file");
							
				/** if(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[2]/div/div/table/tbody/tr/td/button")).isDisplayed())
				{
					  driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[2]/div/div/table/tbody/tr/td/button")).click();
				}**/
			fileInput = driver.findElement(By.id("FILEUPLOAD-ADOAP_UPST-1"));
			fileInput.sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\Test Doc to Upload.docx");
				//driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/input")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Automation\\TEA\\Sprint2\\Docs to Upload for Testing\\Test Doc to Upload.docx");
				//driver.findElement(By.id("FILEUPLOAD-ADOAP_UPST-1")).sendKeys("C:/Users/rbhatia/Google Drive/Project/Automation/TEA/Sprint2/Docs to Upload for Testing/Test Doc to Upload.docx");
			assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/th/a")).getText(), "Test Doc to Upload.docx");
			
				//driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button")).click();
				
			driver.findElement(By.id("app-btn-next")).click();
			// Declaration Page
			driver.findElement(By.id("ADOAP_DECC")).click();
			driver.findElement(By.xpath("//button[@id='app-btn-next']")).click();
			// Confirmation Page
			//clchk.callSITS(getfirstn, getlastn, getemail, getdob, clchkcoursename, getcontactcountry, residencystatus, getcurrentlystudyingtowards, gethighsecqual, getprevtertiarystudyatuniv, getfirstenrolter);	
			
			if (usertype.equalsIgnoreCase("Staff_Search") || usertype.equalsIgnoreCase("Staff_New"))
			{
				driver.close();
				driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window
				winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
				getDriverWindowHandle();
				driver.findElement(By.linkText("Start a New Application")).click(); //
				switchDriver();	 
			}
			else if (usertype.equalsIgnoreCase("Student"))
			{
				driver.findElement(By.linkText("Applications")).click();
				driver.findElement(By.linkText("Start a New Application")).click();
			}
			else if (usertype.equalsIgnoreCase("Agent"))
			{
				driver.close();
				driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window
				winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
				getDriverWindowHandle();
				linkrownumber=getLinkRowNumberForAgent(stuID, coursename);
				driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).click();  //Start a new application
				switchDriver();	 
			}									
			i++;
}  //end while
// Qualification Search Page
new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Foundation Certificate");
driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Certificate of University Preparation");
driver.findElement(By.xpath("//ul[@id='courses']/li/a")).click();
clchkcoursename="Certificate of University Preparation";
// Qualification Selection Page
driver.findElement(By.name("APPLY.IPO.SRS.1")).click();
// Personal details page
if(getlivinginNZ.equalsIgnoreCase("Yes"))
{
	driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();		    	
}
else
{	
	driver.findElement(By.id("IPQ_ADOAP_LOCL2")).click(); // Yes if none specified.		    	
}
//driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();
driver.findElement(By.id("app-btn-next")).click();
// Contact details Page
driver.findElement(By.id("app-btn-next")).click();
// Education Page
driver.findElement(By.id("ADOAP_EDPTS2")).click();
driver.findElement(By.id("app-btn-next")).click();
if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && getlivinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && getlivinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && getlivinginNZ.equalsIgnoreCase("No")))
{
//Additional Info Page
	driver.findElement(By.id("ADOAP_INTAG1_1")).click();
	driver.findElement(By.id("IPQ_ADOAP_INST")).sendKeys("Overseas University"); //Story# 10798
	driver.findElement(By.id("app-btn-next")).click();
}
// Documents Page
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/h3")).getText(), "Student statement");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/div/p")).getText(), "We need to know a little bit more about you to consider your application. Please upload a student statement. There is no right or wrong way to write a student statement (but please do check your spelling and grammar). You should aim to write between 200 and 300 words overall. Tell us about why you're interested in studying your chosen qualification and your study history or employment background or anything that will confirm that you are ready for University study. We will use this information when considering your preparedness for study in your chosen qualification.");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/p")).getText(),"Student statement*");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/small")).getText(), "Files cannot be larger than 5MB. You can upload 1 file. File types that can be uploaded are doc, docx, htm, html, jpeg, jpg, pdf, png.");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label")).getText(), "Upload file");

/**if(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[2]/div/div/table/tbody/tr/td/button")).isDisplayed())
{
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[2]/div/div/table/tbody/tr/td/button")).click();
}**/

fileInput = driver.findElement(By.id("FILEUPLOAD-ADOAP_UPST-1"));
fileInput.sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\user_manual.pdf");
//driver.findElement(By.id("FILEUPLOAD-ADOAP_UPST-1")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Automation\\TEA\\Sprint2\\Docs to Upload for Testing\\user_manual.pdf");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/th/a")).getText(), "user_manual.pdf");
driver.findElement(By.id("app-btn-next")).click();
// Declaration Page
driver.findElement(By.id("ADOAP_DECC")).click();
driver.findElement(By.xpath("//button[@id='app-btn-next']")).click();
// Confirmation Page
//clchk.callSITS(getfirstn, getlastn, getemail, getdob, clchkcoursename, getcontactcountry, residencystatus, getcurrentlystudyingtowards, gethighsecqual, getprevtertiarystudyatuniv, getfirstenrolter);	


//driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button")).click();
driver.findElement(By.linkText("Applications")).click();
driver.findElement(By.linkText("Start a New Application")).click();
// Qualification Search Page
new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Degree");
driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[8]/a")).getText(), "Bachelor of Music");
driver.findElement(By.xpath("//ul[@id='courses']/li[8]/a")).click();
// Qualification Selection Page
driver.findElement(By.name("APPLY.IPO.SRS.1")).click();
// Personal details page
if(getlivinginNZ.equalsIgnoreCase("Yes"))
{
	driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();		    	
}
else
{	
	driver.findElement(By.id("IPQ_ADOAP_LOCL2")).click(); // Yes if none specified.		    	
}
//driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();
driver.findElement(By.id("app-btn-next")).click();
// Contact details Page
driver.findElement(By.id("app-btn-next")).click();
// Education Page
if (getcurrentlyatsecondaryschool.equals("Yes")) driver.findElement(By.id("ADOAP_EDSSQ1")).click();  //to reset the check as had to select other option for the Bachelor of Laws course in Auto2 (checkbox was checked for this user story 10046 (10428))
driver.findElement(By.id("ADOAP_EDPTS2")).click();
driver.findElement(By.id("app-btn-next")).click();
if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && getlivinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && getlivinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && getlivinginNZ.equalsIgnoreCase("No")))
{
	//	Additional Info Page
	driver.findElement(By.id("ADOAP_INTAG1_1")).click();
	driver.findElement(By.id("IPQ_ADOAP_INST")).sendKeys("Overseas University"); //Story# 10798
	driver.findElement(By.id("app-btn-next")).click();
}

// Documents Page
// Warning: verifyTextNotPresent may require manual changes
assertNotEquals(driver.findElement(By.cssSelector("BODY")).getText(),"*Student statement*");
// Warning: verifyTextNotPresent may require manual changes
assertNotEquals(driver.findElement(By.cssSelector("BODY")).getText(), "We need to know a little bit more about you to consider your application. Please upload a student statement. There is no right or wrong way to write a student statement (but please do check your spelling and grammar). You should aim to write between 200 and 300 words overall. Tell us about why you're interested in studying your chosen qualification and your study history or employment background or anything that will confirm that you are ready for University study. We will use this information when considering your preparedness for study in your chosen qualification.*");
// Warning: verifyTextNotPresent may require manual changes
assertNotEquals(driver.findElement(By.cssSelector("BODY")).getText(),"Student statement*");
fileInput = driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label/input"));
fileInput.sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\Project Structure v1.5.jpg");
// driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label/input")).clear();
//driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label/input")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\Project Structure v1.5.jpg");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/th/a")).getText(), "Project Structure v1.5.jpg");
//driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/button")).click();
//driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label/input")).clear();
driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label/input")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\RACI Matrix.png");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr[2]/th/a")).getText(), "RACI Matrix.png");
//driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/button")).click();
//driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label/input")).clear();
//getDriverWindowHandle();
driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label/input")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\Framework Build Oversize.docx");
assertEquals(driver.findElement(By.id("sits_dialog")).getText(), "MAX filesize exceeded - allowed size: 5000kb");
//driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
//driver.findElement(By.className("ui-button-text")).click();
driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/button")).click();
// Same docs for the second control/option to upload files.

/**if(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr/td/button")).isDisplayed())
{
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr/td/button")).click();
}**/

driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr/td/div/label/input")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\Project Structure v1.5.jpg");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr/th/a")).getText(), "Project Structure v1.5.jpg");
//driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr/td/button")).click();
driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr/td/div/label/input")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\RACI Matrix.png");
assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr[2]/th/a")).getText(), "RACI Matrix.png");
driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr/td/button")).click(); //Delete the second doc as only 2 docs are allowed for English requirement
driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/div/div/table/tbody/tr/td/div/label/input")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\Framework Build Oversize.docx");
assertEquals(driver.findElement(By.id("sits_dialog")).getText(), "MAX filesize exceeded - allowed size: 5000kb");
driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/button")).click();
driver.findElement(By.id("app-btn-save")).click();
if (usertype.equals("Student"))
	{
		driver.findElement(By.linkText("Applications")).click();
	}
else 		  
	{
		driver.close();
		driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window  
	}

System.out.println("TEA-2Login_Confirm_UploadDocs test case executed - "+email);
System.out.println("--------------------------------------------------");
logger.log(LogStatus.INFO,"TEA-2Login_Confirm_UploadDocs test case executed.");
} catch (Exception e) {
    System.out.println("Error:"+e.getMessage());
    exceptionerror="true";
    errormessage=e.getMessage();}
}


@Test (dataProvider="ParamData") //(dependsOnMethods={"Auto1TEASubmitApplication"}, dataProvider="ParamData")
public void Auto4TEASaveContinueDelete(String getusertype, String getfirstn, String getlastn,String getsecondname,String getothersecondname,String getprevfamilyname, String getdob, String getnstudentnumber, String getemail, String getremail, String getpassword,  String getrpassword, String getqualsearchtype, String getcoursename, String getresidencystatus, String getcountry, String getcontactcountry, String getlivinginNZ, String getethnicity1, String getethnicity2, String getethnicity3, String getiwi1, String getiwi2, String getiwi3, String getiwi4, String gethomephone, String getmobile, String getcontactaddressline1,String getcontactaddressline2,String getcontactaddressline3,String getcontactaddressline4, String getcity, String getpostcode, String getcurrentlyatsecondaryschool, String getcurrentlystudyingtowards, String getagreeNZQAresultscheckbox, String getlastsecschool, String getlastschoolyear, String gethighsecqual, String getprevtertiarystudyatuniv,String getfirstenrolter, String getinstitutiontype, String getinstitutionname, String getoverseasinstitutioncountry, String getqualificationtype, String getqualname, String getyearfrom, String getyearto, String getgender, String getcompletequal, String getanyotherqual) {
	// TEA-SPRINT3->Story #10037:ADOAP-U004 - Save and Exiting application
	// TEA-SPRINT3->Story #10048:ADOAP-U015 - Returning to application after save & exiting. check that data entered previously is available.	
	// TEA-SPRINT2->Story #10117:ADAPW-U002 - As an applicant (general), I need a facility to delete my application prior to submission in order to stop my application from being progressed further.
	// //PRE-REQ: User details exist in the system.
	// //Using existing applicant: firstn, lastn, email, password.
	// //coursename: "Bachelor of Business Analysis". It cannot use the SubmitApplication coursename as it's already submitted. Hard coded into the script but can be parameterised if required.
	  
	  // Bug:11235
		try {
		logger = ReportScreenshotUtility.report.startTest("Auto4TEASaveContinueDelete - "+getemail);
		Thread.sleep(1000);
		driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
		exceptionerror="false";
		String firstn = getfirstn;
	    String lastn = getlastn;
	    String secondname = getsecondname;
	    String othersecondname=getothersecondname;
	   // prevfamilyname=getprevfamilyname;
	    String dob = getdob;
	    String nstudentnumber=getnstudentnumber;
	    String email = getemail;   	    
	    String password = getpassword;	    
	   // String qualsearchtype = getqualsearchtype;
	    //String coursename="Bachelor of Business Analysis";
	    //String coursename="Diploma in Environmental Planning";
	   String coursename="Diploma in Health, Sport and Human Performance";
	    //String coursename="Graduate Certificate";
	    String residencystatus=getresidencystatus;
	    String country=getcountry;
	    String contactcountry=getcontactcountry; 
	    String livinginNZ=getlivinginNZ;
	    String getyear="";
	    String ethnicity1=getethnicity1; 
	    //ethnicity2=getethnicity2; 
	    //ethnicity3=getethnicity3;
	    //iwi1=getiwi1;
	    //iwi2=getiwi2; 
	    //iwi3=getiwi3; 
	    //iwi4=getiwi4; 
	    String homephone=gethomephone;
	    String mobile=getmobile; 
	    String contactaddressline1=getcontactaddressline1; 
	    String contactaddressline2=getcontactaddressline2;
	    String contactaddressline3=getcontactaddressline3;
	    String contactaddressline4=getcontactaddressline4;
	    String city=getcity;
	    String postcode=getpostcode; 
	    String currentlyatsecondaryschool=getcurrentlyatsecondaryschool;
	    String currentlystudyingtowards=getcurrentlystudyingtowards;
	    String agreeNZQAresultscheckbox=getagreeNZQAresultscheckbox;
	    String lastsecschool=getlastsecschool;
	    String lastschoolyear=getlastschoolyear; 
	    String prevtertiarystudyatuniv=getprevtertiarystudyatuniv;
	    String firstenrolter=getfirstenrolter;
	    String institutiontype=getinstitutiontype; 
	    String institutionname=getinstitutionname;
	    String qualificationtype=getqualificationtype;
	    String qualname=getqualname; 
	    String highsecqual=gethighsecqual; 
	    String yearfrom=getyearfrom;
	    String yearto=getyearto;
	    String gender=getgender;
		String completequal=getcompletequal;
		String anyotherqual=getanyotherqual;	    		
		usertype=getusertype;
		int courserownumber, linkrownumber;
	    switch (usertype)
	    {
	    case "Staff_Search":
	    case "Staff_New":
	    	{
	    				
	    		// Register/Login Page
				staffSearchLogin(firstn, lastn, email, secondname, othersecondname, getdob); //Login steps for Staff Search. using the same for Staff_New case also
				winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
				getDriverWindowHandle();
				driver.findElement(By.linkText("Start a New Application")).click(); //
				switchDriver();	 
				break;
	    	}
	    	
	    	
	    case "Student":
		    {
		  	  // Register/Login Page
		    	studentLogin(email, password);
			    driver.findElement(By.linkText("Start a New Application")).click();
			    break;
		    }
	    case "Agent":
	    	{
	    		// Register/Login Page
				agentLogin();  //Call the Agent login steps				 
				linkrownumber=getLinkRowNumberForAgent(stuID, getcoursename); //Send the first test case course to identify the row
	     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), getcoursename);
	    		//assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
	     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[5]")).getText(), "Applicant");
	     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a")).getText(), "View");
	     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).getText(), "Withdraw");
	     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
	     		winhandlebefore_loginAgain = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
	    		getDriverWindowHandle();
	    		driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).click();  //Start a new application
	    		switchDriver();  // Staff login results in another window getting opened.	     	 
				 
				 
				 /**if (!driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/h2")).equals("0 Results found"))
				 {
					 if (secondname.equals("") && othersecondname.equals(""))   
					 {
						 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+lastn))
						 {
							 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click();   //Additional validation before clicking on the student id.
						 }			 
					 }
					 else if(!secondname.equals("") && othersecondname.equals(""))
					 {
						 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+secondname+" "+lastn))
						 {
							 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click(); //Additional validation before clicking on the student id.
						 }	
					 }
					 else if (!secondname.equals("") && !othersecondname.equals(""))
					{
						 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+secondname+" "+othersecondname+" "+lastn))
						 {
							 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click(); //Additional validation before clicking on the student id.
						 }
					}
				 }**/
		 		 break;
	    	}
	    }
	    
	    // Qualification Search Page
	    //new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Degree");
	    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Diploma");
	    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
	    driver.findElement(By.linkText(coursename)).click();
	    // Qualification Selection Page
	    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Apply for the qualification: "+coursename);
	    Object courseoptions[][]= courseChoice();
	   
	    driver.findElement(By.xpath("//input[@name='APPLY.IPO.SRS.1']")).click();
	    getyear=(String)courseoptions[0][0]; //clicked first course
	
	  // Personal Details Page	 
	  assertEquals(driver.findElement(By.cssSelector("p.user-info")).getText(), "Logged in as: "+firstn+" "+lastn);
	  assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Qualification Application");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/p")).getText(), "Identity details are not able to be changed in this form. If any of these details need updating, please request a change.");
	 
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/label")).getText(), "First Name*");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/label")).getText(), "Second/Middle Name(s)");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[4]/label")).getText(), "Other Second/Middle Name(s)");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/label")).getText(), "Last Name/Family Name*");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[6]/label")).getText(), "Preferred First Name");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/label")).getText(), "Previous Family Name (if applicable)");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/p")).getText(), "Gender*");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/label")).getText(), "Date of Birth*");	  
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div")).getText(),firstn.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/div")).getText(),secondname.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[4]/div")).getText(),othersecondname.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/div")).getText(), lastn.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/div")).getText(), dob);
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/div")).getText(),nstudentnumber);	      
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/div")).getText(),gender);
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/label")).getText(),"National Student Number");	 
	  //new Select(driver.findElement(By.id("IPQ_ADOAP_NID1"))).selectByVisibleText("Other");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[11]/div")).getText(),residencystatus);
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[11]/label")).getText(), "Residency Status*");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[12]/label")).getText(), "Country of Citizenship*");
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[12]/div")).getText(),country);
	  //new Select(driver.findElement(By.id("IPQ_ADOAP_CODC"))).selectByVisibleText(country);	 
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div/p")).getText(), "Will you be living in New Zealand for the period of your study?*");
	  if (livinginNZ.equals("Yes"))
	  {
		  driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();		  
	  }
	  else
	  {
		  driver.findElement(By.id("IPQ_ADOAP_LOCL2")).click();		  
	  }
	  	 
	  assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div[2]/label")).getText(), "Ethnicity*");	 
	  new Select(driver.findElement(By.id("IPQ_ADOAP_ETH1"))).selectByVisibleText(ethnicity1);
	  assertTrue(isElementPresent(By.xpath("//button[@id='app-btn-save']")));
	  assertEquals(driver.findElement(By.xpath("//button[@id='app-btn-save']")).getText(), "Save and return later");
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button[2]")).click();
	  // Contact Details Page
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[8]/div/input")).clear();
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[8]/div/input")).sendKeys(city);
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[9]/div/input")).clear();
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[9]/div/input")).sendKeys(postcode);
	  assertTrue(isElementPresent(By.xpath("//button[@id='app-btn-save']")));
	  assertEquals(driver.findElement(By.xpath("//button[@id='app-btn-save']")).getText(), "Save and return later");
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button[3]")).click();
	  // Education Page
	  // //Checking the Save option with mandatory info blank.
	  assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSTY"))).getFirstSelectedOption().getText(), lastschoolyear);
	  new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSTY"))).selectByVisibleText("Please select");
	  assertTrue(isElementPresent(By.xpath("//button[@id='app-btn-save']")));
	  assertEquals(driver.findElement(By.xpath("//button[@id='app-btn-save']")).getText(), "Save and return later");
	  driver.findElement(By.xpath("//button[@id='app-btn-save']")).click();
	  // Confirmation Page - Application saved message
	  assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Your application has been saved");
	  assertEquals(driver.findElement(By.cssSelector("div.sv-form-horizontal > p")).getText(), "Thanks for saving your application to study with us. You can return to your application at any time by logging in to the 'Applications' page in the Applicant Portal to pick up where you left off and submit your application. Please use the email address and password you provided at the time of creating a user account with us.");
	  assertEquals(driver.findElement(By.xpath("//p[2]")).getText(), "In the meantime you might want to collect further information to help with your studies from the links below.");
      assertEquals(driver.findElement(By.linkText("Accommodation Options")).getText(), "Accommodation Options");
	  assertEquals(driver.findElement(By.linkText("Halls of Residence Online Application")).getText(), "Halls of Residence Online Application");

	    assertEquals(driver.findElement(By.linkText("Paper Catalogue")).getText(), "Paper Catalogue");
	 
	    assertEquals(driver.findElement(By.linkText("Fees")).getText(), "Fees");

	    assertEquals(driver.findElement(By.linkText("Student Support")).getText(), "Student Support");
	 
	    assertEquals(driver.findElement(By.xpath("//p[3]")).getText(), "Don't forget to follow us on social media.");
	 
	  // Below two options for the International students - Residency Status as 'Other', 'Aus NZ' and 'Aus Citizen'.
	    if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && livinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && livinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && livinginNZ.equalsIgnoreCase("No")))
	    {
		    assertEquals(driver.findElement(By.linkText("International Student Insurance")).getText(), "International Student Insurance");
		    assertEquals(driver.findElement(By.linkText("Immigration and Visas")).getText(), "Immigration and Visas");
		    // Check International Student Insurance link for Story# 10037
		    getDriverWindowHandle();  
		    driver.findElement(By.linkText("International Student Insurance")).click();
		    switchDriver();
		    Thread.sleep(1000);
		    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Insurance Policies for International Students : University of Waikato | ]]
		    assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/international/preparing-to-come-to-nz/insurance-policies-for-international-students");
		    assertEquals(driver.getTitle(), "Studentsafe - Inbound University Insurance : University of Waikato");
		    assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Insurance Policies for International Students");
		    assertEquals(driver.findElement(By.xpath("//section[@id='content']/p[2]")).getText(), "This will automatically be added and charged to your Enrolment Agreement. If you prefer you can choose to purchase an alternative approved policy and provide a copy of the cover to the university at least two weeks before the start of your course of study.");
		    switchToEarlierDriver();
		    // Check Immigration and Visas link for Story# 10037
		    getDriverWindowHandle();  
		    driver.findElement(By.linkText("Immigration and Visas")).click();
		    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Preparing to Come to NZ : University of Waikato | ]]
		    switchDriver();
		    assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/international/preparing-to-come-to-nz");
		    assertEquals(driver.getTitle(), "Preparing to Come to NZ : University of Waikato");
		    assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Preparing to Come to NZ");
		   // assertEquals(driver.findElement(By.xpath("//section[@id='content']/h2")).getText(), "Adjusting to life in New Zealand");
		    switchToEarlierDriver();
	    }
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
	    // Check Scholarships link for Story# 10037
	    getDriverWindowHandle();
	    assertEquals(driver.findElement(By.linkText("Scholarships")).getText(), "Scholarships");
	    driver.findElement(By.linkText("Scholarships")).click();
	    switchDriver();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Scholarships : University of Waikato | ]]
	    assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/scholarships");
	    assertEquals(driver.getTitle(), "Scholarships : University of Waikato");
	    assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Scholarships");
	    assertEquals(driver.findElement(By.xpath("//section[@id='content']/p")).getText(), "We know that a helping hand with fees and accommodation will go a long way towards turning a smart brain into a great mind. We have a broad range of scholarships available for school-leaver students, including:");
	    switchToEarlierDriver();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
	    if (usertype.equals("Staff_Search") || usertype.equals("Staff_New") || usertype.equals("Agent")) 		  
		{
			driver.close();
			driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window  
		}
	    else
	    {
	    	driver.findElement(By.linkText("Applications")).click();
	    }
	 // Applications summary page
	    driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/a")).click();
	    driver.findElement(By.linkText("Logout")).click();  //Logout to validate if the data was saved
	    driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
	    //Login
	    switch (usertype)
	    {
	    case "Student":
	    	{
	    		 	driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).click();	
	    		    driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).clear();
	    		    driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).sendKeys(email);
	    		    driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).clear();
	    		    driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).sendKeys(password);
	    		    driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS.1\"]")).click();
	    		    driver.findElement(By.linkText("Applications")).click();
	    		    break;
	    	}
	    case "Staff_New":
	    case "Staff_Search":
	    	{
				 driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).click();
		
				 driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).clear();
				 driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).sendKeys("STAFF"); //provide staff  credentials
		
				 driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).clear();
				 driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).sendKeys("Testing@2");  // provide staff account password
		
				 driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS.1\"]")).click();
				 // Home Page
				 driver.findElement(By.id("PTAD01P")).click();
				 //Admission and Enrolment page 
		
				 driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/a[2]")).click();
				 //switchDriver();  // Staff login results in another window getting opened.
			
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.")).clear();
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.")).sendKeys(firstn); //provide student first name
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.3.")).clear(); 
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.3.")).sendKeys(lastn); //provide student last name
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.")).clear();
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.")).sendKeys(dob); //provide student dob
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.5.")).clear();
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.5.")).sendKeys(email); //provide student email
				 driver.findElement(By.id("ANSWER.TTQ.MENSYS.7.")).click();  // Click Search
				 if (!driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/h2")).equals("0 Results found"))
				 {
					 if (secondname.equals("") && othersecondname.equals(""))   
					 {
						 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+lastn))
						 {
							 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click();   //Additional validation before clicking on the student id.
						 }			 
					 }
					 else if(!secondname.equals("") && othersecondname.equals(""))
					 {
						 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+secondname+" "+lastn))
						 {
							 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click(); //Additional validation before clicking on the student id.
						 }	
					 }
					 else if (!secondname.equals("") && !othersecondname.equals(""))
					{
						 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+secondname+" "+othersecondname+" "+lastn))
						 {
							 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click(); //Additional validation before clicking on the student id.
						 }
					}
				 }
				assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/h1")).getText(),"Student Maintenance");
				assertEquals(driver.findElement(By.xpath("//html/body/div[1]/ul/li/a")).getText(),"Applications");
				break;
	    	}
	    case "Agent":
    	{
    		// Register/Login Page
			agentLogin();  //Call the Agent login steps again
			linkrownumber=getLinkRowNumberForAgent(stuID, coursename); //Too continue the same test case
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), coursename);
    		//assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[5]")).getText(), "Incomplete");
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a")).getText(), "Continue");
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).getText(), "Delete");
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
     		//winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
    		//getDriverWindowHandle();
    		driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[1]")).click();  //Continue same application. It doesn't open another window
    		//switchDriver();  // Staff login results in another window getting opened.
    		break;
    	}
	    
	    }
	    if (usertype.equals("Staff_Search") || usertype.equals("Staff_New") || usertype.equals("Student"))
	    {
		    // Applications Summary Page
		    courserownumber=getSummaryPageCourseRowNumber(coursename);
		   // if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
		    //else
		    //{
		    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[2]")).getText(), coursename);
		    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[4]")).getText(), "Incomplete");
		    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete");
		    getDriverWindowHandle();
		    driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a")).click(); //Click the corresponding 'Continue' button
			//}
		    // Education Page
		    switchDriver();	 
	    }
	    driver.findElement(By.xpath("//html/body/div[1]/div/ul/li[1]/a/span[2]/h4")).click();  //Click on personal details link
	    // Personal details page
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div")).getText(),firstn.toUpperCase());
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/div")).getText(),secondname.toUpperCase());
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[4]/div")).getText(),othersecondname.toUpperCase());
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/div")).getText(), lastn.toUpperCase());
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/div")).getText(), dob);
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/div")).getText(),nstudentnumber);	      
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/div")).getText(),gender);
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[11]/div")).getText(),residencystatus);
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[12]/div")).getText(),country);
		if (livinginNZ.equals("Yes"))
		{
			assertTrue(driver.findElement(By.id("IPQ_ADOAP_LOCL1")).isSelected());				  
		}
		else
		{
			assertTrue(driver.findElement(By.id("IPQ_ADOAP_LOCL2")).isSelected());		  
		}
				
		assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_ETH1"))).getFirstSelectedOption().getText(), ethnicity1);
		
		driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button[2]")).click();
		// Contact Details Page
		assertEquals(driver.findElement(By.id("IPR_CAEM")).getAttribute("value"),email);
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[2]/div/input")).getAttribute("value"),homephone);
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[3]/div/input")).getAttribute("value"),mobile);
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[4]/div/input")).getAttribute("value"), contactaddressline1.toUpperCase());
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[5]/div/input")).getAttribute("value"), contactaddressline2.toUpperCase());
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[6]/div/input")).getAttribute("value"), contactaddressline3.toUpperCase());	      
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[7]/div/input")).getAttribute("value"), contactaddressline4.toUpperCase());		
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[8]/div/input")).getAttribute("value"),city.toUpperCase());
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[9]/div/input")).getAttribute("value"),postcode);
		
		assertEquals(new Select(driver.findElement(By.id("IPR_COD2"))).getFirstSelectedOption().getAttribute("value"), codes.getCountrycode(contactcountry));  //comparing the country code to validate the country ###
		
		//assertEquals(driver.findElement(By.id("IPR_COD2")).getText(), contactcountry);
				//assertEquals(driver.findElement(By.xpath("//div[@id='IPR_COD2_chosen']/a/span")).getAttribute("value"),contactcountry);
		driver.findElement(By.id("app-btn-next")).click();
	    // Education Page
	    driver.findElement(By.id("app-btn-back")).click();
	    driver.findElement(By.cssSelector("h4.progress-title")).click();
	    driver.findElement(By.id("app-btn-next")).click();
	    driver.findElement(By.id("app-btn-next")).click();
	    // Education Page
	            
	    
	    if (currentlyatsecondaryschool.equals("Yes"))
	    {
	    	assertTrue(driver.findElement(By.id("ADOAP_EDSSQ1")).isSelected());
	    	assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_CSTY"))).getFirstSelectedOption().getText(), currentlystudyingtowards);
	    	//assertEquals(driver.findElement(By.xpath("IPQ_ADOAP_CSTY")).getText(),currentlystudyingtowards);
	    	if (agreeNZQAresultscheckbox.equals("Yes"))
	    	{
	    		assertTrue(driver.findElement(By.id("IPQ_ADOAP_EDCB")).isSelected());
	    	}
	    	else
	    	{
	    		assertFalse(driver.findElement(By.id("IPQ_ADOAP_EDCB")).isSelected());
	    	}
	    }
	    else
	    {
	    	assertTrue(driver.findElement(By.id("ADOAP_EDSSQ2")).isSelected());	
	    }
	    assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSCL"))).getFirstSelectedOption().getAttribute("value"), codes.getLastsecschoolcode(lastsecschool));  //comparing the country code to validate the country ###
	    //assertEquals(driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/a/span")).getText(),lastsecschool);
	    new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSTY"))).selectByVisibleText(lastschoolyear);
	    //assertEquals(driver.findElement(By.xpath("IPQ_ADOAP_EDLSTY")).getText(),lastschoolyear);    
	    assertEquals(new Select(driver.findElement(By.id("IPQ_ADOAP_EDHQAL"))).getFirstSelectedOption().getText(), highsecqual);
	    //assertEquals(driver.findElement(By.xpath("IPQ_ADOAP_EDHQAL")).getText(),highsecqual);
	    // Story#10052: (5) 5. Applicant is not able to edit previously entered tertiary study details but are able to add more quals if circumstances have changed i.e. 
	    					//they have completed additional tertiary study since last application. Previously entered tertiary study will show to the applicant so they can see what has already been supplied but as read only.
	    if(prevtertiarystudyatuniv.equals("Yes"))
	    {
	    	driver.findElement(By.id("ADOAP_EDPTS1")).click();	    	
	    	//assertEquals(driver.findElement(By.xpath("IPQ_Which year did you first enrol in tertiary study")).getText(),firstenrolter);
	    	new Select(driver.findElement(By.id("IPQ_Which year did you first enrol in tertiary study"))).selectByVisibleText(firstenrolter);	    	
	    	//assertEquals(driver.findElement(By.xpath("IPQ_ADOAP_EDIT")).getText(),institutiontype);
	    	//assertEquals(driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDIN_chosen']/a/span")).getText(),highsecqual);
	    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div/table/tbody/tr/td")).getText(),institutionname);
	    	//Check if it's non-editable
	  	  	driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div/table/tbody/tr/td")).click();  //Click
	  	  	assertFalse(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div/table/tbody/tr/td")).isSelected()); //Then verify to see is it's selected
	    	//assertEquals(driver.findElement(By.xpath("IPQ_ADOAP_EDHQAL")).getText(),qualificationtype);
	    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div/table/tbody/tr/td[2]")).getText(),qualname);
	    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div/table/tbody/tr/td[3]")).getText(),yearfrom+" - "+yearto);
	    	//assertEquals(driver.findElement(By.xpath("IPQ_ADOAP_EDHYT")).getText(),yearto);
	    	
	    	if (completequal.equals("Yes"))
	    	{
	    		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div/table/tbody/tr/td[4]")).getText(),"Yes");
	    	}
	    	else
	    	{
	    		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div/table/tbody/tr/td[4]")).getText(),"No");
	    	}
	    	
	    	//Check that up to 5 tertiary qualifications details can be provided. 
	    	driver.findElement(By.id("ADOAP_EDOQY")).click();
	    	//2nd details
	    	driver.findElement(By.id("ADOAP_EDOQ1Y")).click();
	    	//3rd details
	    	driver.findElement(By.id("ADOAP_EDOQ2Y")).click();
	    	//4th details
	    	driver.findElement(By.id("ADOAP_EDOQ3Y")).click();
	    	//5th details
	    	assertFalse(isElementPresent(By.xpath("ADOAP_EDOQ4Y")));
	    	driver.findElement(By.id("ADOAP_EDOQN")).click();
	    	/**if (anyotherqual.equals("Yes"))
	    	{
	    		assertTrue(driver.findElement(By.id("ADOAP_EDOQY")).isSelected());
	    	}
	    	else
	    	{
	    		assertTrue(driver.findElement(By.id("ADOAP_EDOQN")).isSelected());
	    	}**/
	    	
	    }
	   /** else
	    {
	    	assertTrue(driver.findElement(By.id("ADOAP_EDPTS2")).isSelected());
	    } **/  
	    
	    driver.findElement(By.id("app-btn-next")).click();
	    if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && livinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && livinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && livinginNZ.equalsIgnoreCase("No")))
	    {
	    	//Additional Info Page
	    	driver.findElement(By.id("ADOAP_INTAG1_3")).click();
	    	driver.findElement(By.id("IPQ_ADOAP_INST")).sendKeys("Overseas University"); //Story# 10798
	    	driver.findElement(By.id("app-btn-next")).click();
	    }
	  // Documents Page  
	  assertTrue(isElementPresent(By.xpath("//button[@id='app-btn-save']")));  
	  assertEquals(driver.findElement(By.xpath("//button[@id='app-btn-save']")).getText(), "Save and return later");  
	  driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/table/tbody/tr/td/div/label/input")).sendKeys("C:\\Users\\rbhatia\\Google Drive\\Project\\Testing\\TEA\\Sprint2\\Docs to Upload for Testing\\Test Doc to Upload.docx");
	  driver.findElement(By.id("app-btn-next")).click();
	  // Declarations Page 
	  assertTrue(isElementPresent(By.xpath("//button[@id='app-btn-save']"))); 
	  assertEquals(driver.findElement(By.xpath("//button[@id='app-btn-save']")).getText(), "Save and return later");
	  driver.findElement(By.xpath("//button[@id='app-btn-save']")).click();
	  ///driver.findElement(By.id("ADOAP_DECC")).click();
	  ///driver.findElement(By.id("app-btn-next")).click();
	  
	  if (usertype.equals("Staff_Search") || usertype.equals("Staff_New"))// || usertype.equals("Agent")) 		  
		{
			driver.close();  //testing purpose
			driver.switchTo().window(winhandlebefore_staff);    //As relogin happened, it's expecting the same window.  
		}
	    else if (usertype.equals("Student"))
	    {
	    	// Saving Confirmation Page
	  	  	driver.findElement(By.linkText("Applications")).click();
	    }
	  if (usertype.equals("Agent"))
	   	{
		  		// Applications summary page  
		    	//driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/a")).click();
		    	//driver.findElement(By.linkText("Logout")).click();  //Logout to validate if the data was saved
		    	driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
		    	//	Login to get the refreshed results for agent
		  		// Register/Login Page
				agentLogin();  //Call the Agent login steps
				linkrownumber=getLinkRowNumberForAgent(stuID, coursename); //Too continue the same test case
	     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), coursename);
	    		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[5]")).getText(), "Incomplete");
	     		//getyear =  driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td")).getText();
	     		driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).click();//Click the corresponding 'Delete' button
	     		
	     		//winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
	    		//getDriverWindowHandle();
	    		//driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[1]")).click();  //Continue same application
	    		//switchDriver();  // Staff login results in another window getting opened.
	    		
	   }
	  else
	  {
	    // Warning: verifyTextPresent may require manual changes
	    courserownumber=getSummaryPageCourseRowNumber(coursename);
	    //if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
	    //else
	    // {
	    // assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[1]")).getText(), courseyear);
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[2]")).getText(),coursename);
	    ///assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[4]")).getText(), "UnSubmitted");
	    assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[4]")).getText(), "Incomplete");
	    //getyear =  driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td")).getText();
	    //Implementing Story# 10117(S2); Auto: 5 TEA-DeleteApplication
	    driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).click(); //Click the corresponding 'Delete' button
	  }
	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/h1")).getText(), "Delete Application");
	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[1]/h2")).getText(), "Confirm deletion");
	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/p")).getText(), "Are you sure you want to delete your application to "+coursename+" for "+getyear+"?");
	    driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[3]/div/input[2]")).click(); //Click 'Delete' button on the confirmation window
	    // Applications Summary Page
	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/p")).getText(), "Application deleted");
	    
	    if (usertype.equals("Agent"))
	    {
	    	linkrownumber=getLinkRowNumberForAgent(stuID, coursename); 
	    	assertEquals(linkrownumber,0);
	    }
	    else
	    {
	    	courserownumber=getSummaryPageCourseRowNumber(coursename);
	    	assertEquals(courserownumber,0);
	    }
	    //Call SITS //
	    Runtime runtimedelete = Runtime.getRuntime();
		String scriptpathdelete=propertyconfig.getCourseDeleteScriptPath();
		Process pDelete = null;
	    System.out.println("Script: "+scriptpathdelete+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+coursename+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\""+" "+"\""+getusertype+"\"");  
    	pDelete = runtimedelete.exec(scriptpathdelete+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+coursename+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\""+" "+"\""+getusertype+"\"");  
    	
    	BufferedReader inputdelete = new BufferedReader(new InputStreamReader(pDelete.getInputStream()));
		String line;
		while ((line = inputdelete.readLine()) != null) 
		{
		  System.out.println(line);
		  logger.log(LogStatus.INFO,line);
		 // String keyword= "Error:";
		  //Boolean found = Arrays.asList(line.split(" ")).contains(keyword); // To check 'Error' text in the returned lines
		  //System.out.println(found);
		  int exitCodeDelete;
		  exitCodeDelete = pDelete.waitFor();  //method waitFor() will make the current thread to wait until the external program finishes and returns the exit value.
		  assertEquals(exitCodeDelete, 0);   // This will cause the first test case (or calling test case) to fail if the exit code is not 0. 
			  // System.out.println("Exited with error code "+exitVal);
			//  if(found)
			  //{
				//  exceptionerror="true";
				 // errormessage="";
			  //}		    
		 }  
		// }
		//} catch (Exception e) {
		//	e.getMessage();
	  //	}
		
    	//Close SITS Window///
	 
	  System.out.println("TEA-4Save_Continue_Delete test case executed - "+email);
	  System.out.println("--------------------------------------------------");
	  logger.log(LogStatus.INFO,"TEA-Save_Continue_Delete test case executed.");
		  } catch (Exception e) {
		      System.out.println("Error:"+e.getMessage());
		      exceptionerror="true";
		      errormessage=e.getMessage();}
	}

@Test (dataProvider="ParamData") //(dependsOnMethods={"Auto1TEASubmitApplication"}, dataProvider="ParamData")
public void Auto6TEASecondarySchoolDetails(String getusertype, String getfirstn, String getlastn,String getsecondname,String getothersecondname,String getprevfamilyname, String getdob, String getnstudentnumber, String getemail, String getremail, String getpassword,  String getrpassword, String getqualsearchtype, String getcoursename, String getresidencystatus, String getcountry, String getcontactcountry, String getlivinginNZ, String getethnicity1, String getethnicity2, String getethnicity3, String getiwi1, String getiwi2, String getiwi3, String getiwi4, String gethomephone, String getmobile, String getcontactaddressline1,String getcontactaddressline2,String getcontactaddressline3,String getcontactaddressline4, String getcity, String getpostcode, String getcurrentlyatsecondaryschool, String getcurrentlystudyingtowards, String getagreeNZQAresultscheckbox, String getlastsecschool, String getlastschoolyear, String gethighsecqual, String getprevtertiarystudyatuniv,String getfirstenrolter, String getinstitutiontype, String getinstitutionname, String getoverseasinstitutioncountry, String getqualificationtype, String getqualname, String getyearfrom, String getyearto, String getgender, String getcompletequal, String getanyotherqual) {
    // TEA-SPRINT2->Story/Feature #10042:ADOAP-U009 - As an applicant (general), I need a mechanism to provide details of my secondary school study in order to apply to the University.
    // TEA-SPRINT3->Story #10037:ADOAP-U004 - Save and Exiting application (AC: 3)
	// TEA-SPRINT2->Story #10058: ADAPW-U001 - As an applicant (general), I need a facility to withdraw my application after submission in order to notify the university that I no longer wish for my application to be considered.
    // //PRE-REQ: Student is registered.
    // //Using 'TEA-Submit Application' test script variables: email, password.
    // //Create its own coursename variable. (Bachelor of Engineering)
	try {
	logger = ReportScreenshotUtility.report.startTest("Auto6TEASecondarySchoolDetails - "+getemail);
	exceptionerror="false";
	String courseyear = null;
	String email=getemail;
	String password=getpassword;
	String residencystatus=getresidencystatus;
	usertype=getusertype;
	int linkrownumber, courserownumber=0; 
	//String coursename="Bachelor of Engineering - Software Engineering";
	String coursename="Bachelor of Computer Graphic Design";
	Thread.sleep(1000);
	driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
	
	switch (usertype)
	{
		case "Student":
		{
			    // Register/Login Page
				studentLogin(email, password);
			    // Applications Summary Page
			    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Current applications");
			    assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(), "Qualifications and Papers");
			    driver.findElement(By.linkText("Start a New Application")).click();
			    break;
		}
		case "Staff_Search":
		case "Staff_New":
		{
		    				
		    		// Register/Login Page
					staffSearchLogin(getfirstn, getlastn, email, getsecondname, getothersecondname, getdob); //Login steps for Staff Search. using the same for Staff_New case also
					winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
					getDriverWindowHandle();
					driver.findElement(By.linkText("Start a New Application")).click(); //
					switchDriver();	 
					break;
		}
		case "Agent":
    	{
    		// Register/Login Page
			agentLogin();  //Call the Agent login steps
			 
			linkrownumber=getLinkRowNumberForAgent(stuID, getcoursename); //Send the first test case course to identify the row
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), getcoursename);
    		//assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[5]")).getText(), "Applicant");
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a")).getText(), "View");
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).getText(), "Withdraw");
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
     		winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
    		getDriverWindowHandle();
    		driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).click();  //Start a new application
    		switchDriver();  // Staff login results in another window getting opened.
     	    break;
    	}
	}

    // Qualification Search
    new Select(driver.findElement(By.xpath("//*[@id=\"SELECTION.CRITERIA.SRS.1-1\"]"))).selectByVisibleText("Bachelors Degree");
    driver.findElement(By.xpath("//*[@id=\"BP102.DUMMY_B.MENSYS\"]")).click();
    driver.findElement(By.linkText(coursename)).click();
    // Qualification Selection
    Object courseoptions[][]= courseChoice();	   
    driver.findElement(By.xpath("//input[@name='APPLY.IPO.SRS.1']")).click();
    courseyear=(String)courseoptions[0][0]; //clicked first course
    //driver.findElement(By.name("APPLY.IPO.SRS.1")).click();
    // Personal Details
    if(getlivinginNZ.equalsIgnoreCase("Yes"))
    {
    	driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();		    	
    }
    else
    {	
    	driver.findElement(By.id("IPQ_ADOAP_LOCL2")).click(); // Yes if none specified.		    	
    }
    //driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();
    //new Select(driver.findElement(By.id("IPQ_ADOAP_NID1"))).selectByVisibleText("Australian Citizen");
    //new Select(driver.findElement(By.id("IPQ_ADOAP_CODC"))).selectByVisibleText("Australia");
    driver.findElement(By.id("app-btn-next")).click();
    // Contact Details
    driver.findElement(By.id("app-btn-next")).click();
    // Education page    
    assertTrue(isElementPresent(By.id("ADOAP_EDSSQ1")));  
    driver.findElement(By.id("ADOAP_EDSSQ1")).click();   
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/label")).getText(), "What are you currently studying towards?*");  
    new Select(driver.findElement(By.id("IPQ_ADOAP_CSTY"))).selectByVisibleText("Please select");
    driver.findElement(By.id("app-btn-next")).click();
    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-10']/div")).getText(), "This value is required.");
    new Select(driver.findElement(By.id("IPQ_ADOAP_CSTY"))).selectByVisibleText("NCEA Level 3 Certificate");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[4]/label")).getText(), "Last secondary school attended*");
  
    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']")).click();
    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input")).sendKeys("Please");
    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input")).sendKeys(Keys.RETURN);    
    driver.findElement(By.id("app-btn-next")).click();    
    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-14']/div")).getText(), "This value is required.");   

    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']")).click();
    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input")).sendKeys("Albany Senior High School");
    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input")).sendKeys(Keys.RETURN);
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[5]/label")).getText(), "Last year at school*");
    new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSTY"))).selectByVisibleText("Please select");
    driver.findElement(By.id("app-btn-next")).click();
    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-16']/div")).getText(), "This value is required.");
    new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSTY"))).selectByVisibleText("2016");
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[6]/label")).getText(), "What is the highest secondary level qualification you have completed?*");
    new Select(driver.findElement(By.id("IPQ_ADOAP_EDHQAL"))).selectByVisibleText("Please select");
    driver.findElement(By.id("app-btn-next")).click();
    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-18']/div")).getText(), "This value is required.");
    new Select(driver.findElement(By.id("IPQ_ADOAP_EDHQAL"))).selectByVisibleText("No formal secondary school qualification");
    driver.findElement(By.id("ADOAP_EDPTS2")).click();
    assertTrue(isElementPresent(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/div/div/label/input")));
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/div/div/label")).getText(), "I agree to NZQA releasing my NCEA Level 2 results (or equivalent) to Waikato so that they can be used for assessing my eligibility for Waikato scholarships and awards");
    driver.findElement(By.id("app-btn-next")).click();
   
    // Documents page
    driver.findElement(By.xpath("//li[3]/a/span[2]/h4")).click();
    
    // Education Page. Check both 'Overseas Qualification' options in the two drop downs for Story# 10042 
  //Currently studying towards option
    new Select(driver.findElement(By.id("IPQ_ADOAP_CSTY"))).selectByVisibleText("Overseas Qualification");  
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/label")).getText(),"What is the qualification you are studying towards?*");
    assertTrue(isElementPresent(By.id("IPQ_ADOAP_EDQST")));
    driver.findElement(By.id("app-btn-next")).click();
    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-12']/div")).getText(), "This value is required.");
    driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/div/input")).clear();
    driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[3]/div/input")).sendKeys("Secondary Qualification");
    
  //Highest secondary level qualification option
    new Select(driver.findElement(By.id("IPQ_ADOAP_EDHQAL"))).selectByVisibleText("Overseas Qualification"); 
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/label")).getText(),"What qualification did you complete?*");
    assertTrue(isElementPresent(By.id("IPQ_ADOAP_EDQC")));
    driver.findElement(By.id("app-btn-next")).click();
    assertEquals(driver.findElement(By.xpath("//span[@id='parsley-id-20']/div")).getText(), "This value is required.");
    driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/div/input")).clear();
    driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/div/input")).sendKeys("Oversease Secondary Qualification");
    
    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[10]/div/div/label")).getText(),"I agree to NZQA releasing my NCEA Level 2 results (or equivalent) to Waikato so that they can be used for assessing my eligibility for Waikato scholarships and awards");
    //check the checkbox to release the results, if not checked. 10042 - AC# 4
    if (!driver.findElement(By.id("IPQ_ADOAP_EDCB")).isSelected()) 
	{
		driver.findElement(By.id("IPQ_ADOAP_EDCB")).click();  //check it
	}
	    
    driver.findElement(By.id("app-btn-next")).click();
       
    if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && getlivinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && getlivinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && getlivinginNZ.equalsIgnoreCase("No")))
    {
    //Additional Info Page
    driver.findElement(By.id("ADOAP_INTAG1_4")).click();
    driver.findElement(By.id("app-btn-next")).click();
    }    
    
    // Documents page
    driver.findElement(By.id("app-btn-save")).click();
    
    // Saving Confirmation
    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Your application has been saved");
    assertEquals(driver.findElement(By.cssSelector("div.sv-form-horizontal > p")).getText(), "Thanks for saving your application to study with us. You can return to your application at any time by logging in to the 'Applications' page in the Applicant Portal to pick up where you left off and submit your application. Please use the email address and password you provided at the time of creating a user account with us.");
    // //Check links for Story# 10037 with non NZ Citizen or PR and without 'Other' selection. 
    checkLinks10037(residencystatus, getlivinginNZ);
    if (usertype.equals("Student"))    
    {
    	driver.findElement(By.linkText("Applications")).click();
    }
    else
    {
    	driver.close();
		driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window		
    }
    
    if (usertype.equals("Agent"))
    {
    	driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
    	agentLogin();  //Call the Agent login steps again
    	linkrownumber=getLinkRowNumberForAgent(stuID, coursename); //Too continue the same test case
		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), coursename);
		//	assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[5]")).getText(), "Incomplete");
		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a")).getText(), "Continue");
		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).getText(), "Delete");
		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
		//winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
	//getDriverWindowHandle();
	driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[1]")).click();  //Continue same application. It doesn't open another window
        
    }
	else if (usertype.equals("Student"))
	{
      
    	//get the actual row number of the course
    	courserownumber = getSummaryPageCourseRowNumber(coursename);
    	if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
    	else driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a")).click(); //Click the corresponding 'Continue' button
    	//	table[@id='DataTables_Table_0']/tbody/tr["+i+"]/td"
    	//	driver.findElement(By.linkText("Continue")).click();
    
	}
	else if (usertype.equals("Staff_Search") || usertype.equals("Staff_New"))
	{
		driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
		staffSearchLogin(getfirstn, getlastn, getemail, getsecondname, getothersecondname, getdob);
		courserownumber = getSummaryPageCourseRowNumber(coursename);
    	if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
    	else
    	{
    		winhandlebefore_staff = driver.getWindowHandle();
    		getDriverWindowHandle();
    		driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a")).click(); //Click the corresponding 'Continue' button
    		switchDriver();
    	}
		
	}
    // Documents page
    driver.findElement(By.id("app-btn-next")).click();
    // Declaration page
    driver.findElement(By.id("ADOAP_DECC")).click();
    driver.findElement(By.id("app-btn-next")).click();
    Thread.sleep(5000); // Two entries coming up
    // Confirmation page
    if (usertype.equals("Staff_Search") || usertype.equals("Staff_New"))// || usertype.equals("Agent")) 		  
	{
		driver.close();
		driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window  
	}
    else if (usertype.equals("Student"))
    {
    driver.findElement(By.linkText("Applications")).click();
    assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(), "Qualifications and Papers");
    }
    
    if (usertype.equals("Agent"))
   	{
	  		// Applications summary page  
	    	//driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/a")).click();
	    	//driver.findElement(By.linkText("Logout")).click();  //Logout to validate if the data was saved
	    	driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
	    	//	Login to get the refreshed results for agent
	  		// Register/Login Page
			agentLogin();  //Call the Agent login steps
			linkrownumber=getLinkRowNumberForAgent(stuID, coursename); //Too continue the same test case
     		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), coursename);
    		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).getText(), "Withdraw");
     		//getyear =  driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td")).getText();
     		driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).click();//Click the corresponding 'Withdraw' button
     		
     		//winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
    		//getDriverWindowHandle();
    		//driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[1]")).click();  //Continue same application
    		//switchDriver();  // Staff login results in another window getting opened.
    		
   }
    else if (usertype.equals("Student"))
   {
    //Applications summary page
    // Withdraw user story - 10058
    courserownumber = getSummaryPageCourseRowNumber(coursename);
	assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Withdraw");
	driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).click();
	//courseyear= driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[1]")).getText();
   }
   else if (usertype.equals("Staff_Search") || usertype.equals("Staff_New"))
   {
	  driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
	  staffSearchLogin(getfirstn, getlastn, getemail, getsecondname, getothersecondname, getdob);
	  courserownumber = getSummaryPageCourseRowNumber(coursename);
	  assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Withdraw");
	  driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).click();		
   }
	//Withdraw application page
	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/h1")).getText(), "Withdraw Application");
	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[1]/h2")).getText(), "Confirm withdrawal");
	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/p")).getText(), "To withdraw your application to "+ coursename+" for "+courseyear+ " please select a reason and click Withdraw.");
	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/div[1]/label")).getText(), "Reason for Withdrawal*");
		
	driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[3]/div/input[2]")).click(); // Click on Withdraw button to check the validation for the withdrawal reason
	assertEquals(driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.errorblock")).getText(), "This question is mandatory and cannot be left blank.");
	new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.2."))).selectByVisibleText("Going into employment");
	driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[3]/div/input[2]")).click(); // click Withdraw button
	
	//Application summary page
	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/p")).getText(), "Application withdrawn");
	courserownumber=getSummaryPageCourseRowNumber(coursename);
	if (usertype.equals("Student") || usertype.equals("Agent"))
	{				
		assertEquals(courserownumber,0);  // application not visible
	}
	else if (usertype.equals("Staff_Search") || usertype.equals("Staff_New"))
	{
		assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[4]")).getText(), "Withdrawn");
	}
    if (usertype.equals("Student")) //check this for staff type
    {
	    driver.findElement(By.xpath("//html/body/div[1]/div[4]/div/div/div[4]/div/div/div[2]/a")).click(); // Previous applications
	    //Previous Applications page
	    assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[1]/h1")).getText(), "Previous Applications");
	    assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[2]/div/h2")).getText(), "Application details");
	    assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[2]/div[2]/div/div/a")).getText(), "Current Applications");
		courserownumber=getSummaryPageCourseRowNumber(coursename);
		assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[2]")).getText(), coursename);
		assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[4]")).getText(), "Withdrawn");
	}		
	 //Call SITS //
    Runtime runtimewithdraw = Runtime.getRuntime();
	String scriptpathwithdraw=propertyconfig.getCourseWithdrawScriptPath();
	Process pWithdraw = null;
    System.out.println("Script: "+scriptpathwithdraw+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+coursename+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\""+" "+"\""+getusertype+"\"");  
	pWithdraw = runtimewithdraw.exec(scriptpathwithdraw+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+coursename+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\""+" "+"\""+getusertype+"\"");  
	
	BufferedReader inputwithdraw = new BufferedReader(new InputStreamReader(pWithdraw.getInputStream()));
	String line;
	while ((line = inputwithdraw.readLine()) != null) 
	{
	  System.out.println(line);
	  logger.log(LogStatus.INFO,line);
	 // String keyword= "Error:";
	  //Boolean found = Arrays.asList(line.split(" ")).contains(keyword); // To check 'Error' text in the returned lines
	  //System.out.println(found);
	  int exitCodeWithdraw;
	  exitCodeWithdraw = pWithdraw.waitFor();  //method waitFor() will make the current thread to wait until the external program finishes and returns the exit value.
	  assertEquals(exitCodeWithdraw, 0);   // This will cause the first test case (or calling test case) to fail if the exit code is not 0. 
  
	 }  
	
	//Close SITS Window///
    System.out.println("TEA-6SecondarySchoolDetails test case executed - "+email);
    System.out.println("--------------------------------------------------");
    logger.log(LogStatus.INFO,"TEA-SecondarySchoolDetails test case executed");
    } catch (Exception e) {
    System.out.println("Error:"+e.getMessage());
    exceptionerror="true";
    errormessage=e.getMessage();
    }    
  }

@Test (dataProvider="ParamData") //(dependsOnMethods={"Auto1TEASubmitApplication"}, dataProvider="ParamData")
public void Auto8TEAApplicationForMasterOfAppliedPsychology(String getusertype, String getfirstn, String getlastn,String getsecondname,String getothersecondname,String getprevfamilyname, String getdob, String getnstudentnumber, String getemail, String getremail, String getpassword,  String getrpassword, String getqualsearchtype, String getcoursename, String getresidencystatus, String getcountry, String getcontactcountry, String getlivinginNZ, String getethnicity1, String getethnicity2, String getethnicity3, String getiwi1, String getiwi2, String getiwi3, String getiwi4, String gethomephone, String getmobile, String getcontactaddressline1,String getcontactaddressline2,String getcontactaddressline3,String getcontactaddressline4, String getcity, String getpostcode, String getcurrentlyatsecondaryschool, String getcurrentlystudyingtowards, String getagreeNZQAresultscheckbox, String getlastsecschool, String getlastschoolyear, String gethighsecqual, String getprevtertiarystudyatuniv,String getfirstenrolter, String getinstitutiontype, String getinstitutionname, String getoverseasinstitutioncountry, String getqualificationtype, String getqualname, String getyearfrom, String getyearto, String getgender, String getcompletequal, String getanyotherqual) {
    // TEA-SPRINT2->Story/Feature #10445:ADOAP-U026 - As an applicant (general) applying for the Master of Applied Psychology, I need a facility to view additional qualification-specific information and download forms in order to apply for this qualification.
    // //PRE-REQ: Application has been SUBMITTED through the test case 'TEA-Submit Application' and Student is registered.
    // //Using 'TEA-Submit Application' test script variables: email, password
    
    // Register/Login Page
	  try {		  
		  logger = ReportScreenshotUtility.report.startTest("Auto8TEAApplicationForMasterOfAppliedPsychology - "+getemail);
		  exceptionerror="false";
		  String email=getemail;
		  String password=getpassword;
		  String residencystatus=getresidencystatus;
		  usertype=getusertype;
		  Thread.sleep(1000);
		  String url=propertyconfig.getApplicationURL();
		  driver.get(url);  //URL picked from the Property file
		  int i=1, linkrownumber;
		  String coursename="";
		  
			switch (usertype)
			{
				case "Student":
				{
					    // Register/Login Page
						studentLogin(email, password);
					    // Applications Summary Page
					    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Current applications");
					    assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(), "Qualifications and Papers");
					    driver.findElement(By.linkText("Start a New Application")).click(); //
					    break;
				}
				case "Staff_Search":
				case "Staff_New":
				{
				    				
				    		// Register/Login Page
							staffSearchLogin(getfirstn, getlastn, email, getsecondname, getothersecondname, getdob); //Login steps for Staff Search. using the same for Staff_New case also
							winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
							getDriverWindowHandle();
							driver.findElement(By.linkText("Start a New Application")).click(); //
							switchDriver();	 
							break;
				}
				case "Agent":
			 	{
			 		agentLogin();  //Call the Agent login steps
					linkrownumber=getLinkRowNumberForAgent(stuID, getcoursename); //Too continue the same test case
			 		
		
			 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[5]")).getText(), "Applicant");
					 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
			 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), getcoursename);
			 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a")).getText(), "View");
			 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).getText(), "Withdraw");
			 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
			 		winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
					getDriverWindowHandle();
					driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).click();
					switchDriver();  // login results in another window getting opened.
			 		break;
			 		//table[@id='uow-applications']/tbody/tr[1]/td[1]
			 	}
			}
    while(i<=3)                    // execute for all 3 courses of Master of Applied Psychology
    {
 //   assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Current applications"); 
  //  assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(), "Qualifications and Papers"); 
   // driver.findElement(By.linkText("Start a New Application")).click();
    // Qualification Search Page
    driver.findElement(By.id("KEYWORD.IPP.SRS")).clear();
    driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("Applied Psychology");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    
    switch(i)
    {
    case 1: coursename="Master of Applied Psychology in Organisational Psychology";
    break;
    case 2: coursename="Master of Applied Psychology in Community Psychology";
    break;
    case 3: coursename="Master of Applied Psychology in Behaviour Analysis";
    break;
    }
   // if (usertype.equals("Student"))   	driver.findElement(By.linkText("Start a New Application")).click();   
    driver.findElement(By.linkText(coursename)).click();
    // Qualification Selection Page
    driver.findElement(By.name("APPLY.IPO.SRS.1")).click();
    // Personal details page
    if(getlivinginNZ.equalsIgnoreCase("Yes"))
    {
    	driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();		    	
    }
    else
    {	
    	driver.findElement(By.id("IPQ_ADOAP_LOCL2")).click(); // Yes if none specified.		    	
    }
    //driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();
    driver.findElement(By.id("app-btn-next")).click();
    // Contact details page
    driver.findElement(By.id("app-btn-next")).click();
    // Education page
    driver.findElement(By.id("ADOAP_EDPTS2")).click();
    new Select(driver.findElement(By.id("IPQ_ADOAP_EDHQAL"))).selectByVisibleText("NCEA Scholarship");
    driver.findElement(By.id("app-btn-next")).click();
    // Additional info page
    if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && getlivinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && getlivinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && getlivinginNZ.equalsIgnoreCase("No")))
    {
    	 driver.findElement(By.id("ADOAP_INTAG1_4")).click();    	 
    }
      assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div/h2")).getText(), "Additional info");
      assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/h3")).getText(), "Master of Applied Psychology");
      assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/p")).getText(), "Because you are applying for a Master of Applied Psychology (MAppPsy), you also need to download the applicable MAppPsy form below. Then, please continue with your online application.");
      assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/p[2]/b")).getText(), "Please note: Guidelines for enrolling into the MAppPsy can be found in the Year 1 MAppPsy application form.");
      assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/p[3]/a")).getText(), "New application to the MAppPsy programme (for students commencing the first year of the MAppPsy and level 500 papers)");
      assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/p[4]/a")).getText(), "Continuation from 1st year to the 2nd year of the MAppPsy");
      assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/p[5]/a")).getText(), "Students who have completed the PGDip or Hons seeking entry to the 2nd year of the MAppPsy");
      getDriverWindowHandle();  //get current browser details
      driver.findElement(By.linkText("New application to the MAppPsy programme (for students commencing the first year of the MAppPsy and level 500 papers)")).click();
      // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Forms Template - MAppPsy-Year-1-Application-Form.pdf | ]]
      switchDriver();
    //  Thread.sleep(2000);
      assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/__data/assets/pdf_file/0010/149464/MAppPsy-Year-1-Application-Form.pdf");    
     // assertEquals(driver.findElement(By.xpath("//div[@id='viewer']/div/div[2]/div[4]")).getText(), "Year 1 & Guidelines");
      //assertEquals(driver.findElement(By.xpath("//div[@id='viewer']/div/div[2]/div")).getText(), "Masters in Applied Psychology (MAppPs");
      //assertEquals(driver.getTitle(), "Forms Template - MAppPsy-Year-1-Application-Form.pdf");
      switchToEarlierDriver();
      getDriverWindowHandle();
      // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
      driver.findElement(By.linkText("Continuation from 1st year to the 2nd year of the MAppPsy")).click();
      // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Forms Template - MAppPsy-Year-2-ApplicationForm.pdf | ]]
      switchDriver();
      assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/__data/assets/pdf_file/0003/149466/MAppPsy-Year-2-ApplicationForm.pdf");
      //assertEquals(driver.getTitle(), "Forms Template - MAppPsy-Year-2-Application-Form.pdf");
      //assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[2]")).getText(), "in Applied Psychology (MAppPsy)");
      //assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[4]")).getText(), "Year 2");
      switchToEarlierDriver();
      // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
      getDriverWindowHandle();
      driver.findElement(By.linkText("Students who have completed the PGDip or Hons seeking entry to the 2nd year of the MAppPsy")).click();
      // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Forms Template - Masters-Enrolment-and-Supervisors-Form.pdf | ]]
      switchDriver();
      assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/__data/assets/pdf_file/0010/149473/Masters-Enrolment-and-Supervisors-Form.pdf");
      //assertEquals(driver.getTitle(), "Forms Template - Masters-Enrolment-and-Supervisors-Form.pdf");
      //assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div")).getText(), "Masters Enrolment and Supervisors' Approval Form");  
      switchToEarlierDriver();
      driver.findElement(By.id("app-btn-save")).click();
      if (usertype.equals("Student"))
      {
    	  	// 	Confirmation Page
    	  	driver.findElement(By.linkText("Applications")).click();
    	  	driver.findElement(By.linkText("Start a New Application")).click(); //
  	  }
      else if (usertype.equals("Agent"))
      {
    	  	driver.close();
    	  	driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window
    	  	driver.get(propertyconfig.getApplicationURL());
    	  	agentLogin();  //Call the Agent login steps
			linkrownumber=getLinkRowNumberForAgent(stuID, getcoursename); 
	 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), getcoursename);
	 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
	 		winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
			getDriverWindowHandle();
			driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).click();
			switchDriver();  // login results in another window getting opened.    	  
      }
      else
  	  {
    	 	driver.close();
			driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window
			winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
			getDriverWindowHandle();
			driver.findElement(By.linkText("Start a New Application")).click(); //
			switchDriver();	 
  	  }   
            
      // Application Summary Page
      i++;
    }
      System.out.println("TEA-8Application for Master of Applied Psychology test case executed - "+email);
      System.out.println("--------------------------------------------------");   
      logger.log(LogStatus.INFO,"TEA-8Application for Master of Applied Psychology test case executed.");
	  } catch (Exception e) {
	      System.out.println("Error:"+e.getMessage());
	      exceptionerror="true";
	      errormessage=e.getMessage();}  
  }


@Test (dataProvider="ParamData") //(dependsOnMethods={"Auto1TEASubmitApplication"}, dataProvider="ParamData")
public void Auto9TEATeachingProgrammeAdditionalInfo(String getusertype, String getfirstn, String getlastn,String getsecondname,String getothersecondname,String getprevfamilyname, String getdob, String getnstudentnumber, String getemail, String getremail, String getpassword,  String getrpassword, String getqualsearchtype, String getcoursename, String getresidencystatus, String getcountry, String getcontactcountry, String getlivinginNZ, String getethnicity1, String getethnicity2, String getethnicity3, String getiwi1, String getiwi2, String getiwi3, String getiwi4, String gethomephone, String getmobile, String getcontactaddressline1,String getcontactaddressline2,String getcontactaddressline3,String getcontactaddressline4, String getcity, String getpostcode, String getcurrentlyatsecondaryschool, String getcurrentlystudyingtowards, String getagreeNZQAresultscheckbox, String getlastsecschool, String getlastschoolyear, String gethighsecqual, String getprevtertiarystudyatuniv,String getfirstenrolter, String getinstitutiontype, String getinstitutionname, String getoverseasinstitutioncountry, String getqualificationtype, String getqualname, String getyearfrom, String getyearto, String getgender, String getcompletequal, String getanyotherqual) {
    // TEA-SPRINT2->Story/Feature #10044:ADOAP-U011 - As an applicant (general) who is applying for a teaching programme, I need a facility to provide additional information specific to teaching applicants in order to complete my application. 
    // //PRE-REQ: 1) Application has been SUBMITTED through the test case 'TEA-Submit Application' and Student is registered. 
	  ////        2) A student should have NZ PR or citizenship.
	  	////		3) Currently at secondaruy school should be 'Yes'
    // //Using 'TEA-Submit Application' test script variables: email, password
    // // While loop used with i variable for the three courses. Created one more variable courselink to parameterise the courses names.
    // //Course selected:  	Bachelor of Teaching, Master of Teaching and Learning, Graduate Diploma of Teaching
	  //// 
    try {
    logger = ReportScreenshotUtility.report.startTest("Auto9TEATeachingProgrammeAdditionalInfo - "+getemail);
    String email=getemail;
	String password=getpassword;
	String residencystatus=getresidencystatus;
	
    int i, linkrownumber=0;
    exceptionerror="false";
    String courselink="";
    Thread.sleep(2000);
    String url=propertyconfig.getApplicationURL();
	driver.get(url);  //URL picked from the Property file
    usertype=getusertype;
	switch (usertype)
	{
		case "Student":
		{
			    // Register/Login Page
				studentLogin(email, password);
			    // Applications Summary Page
			    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Current applications");
			    assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(), "Qualifications and Papers");
			   
			    break;
		}
		case "Staff_Search":
		case "Staff_New":
		{
		    				
		    		// Register/Login Page
					staffSearchLogin(getfirstn, getlastn, email, getsecondname, getothersecondname, getdob); //Login steps for Staff Search. using the same for Staff_New case also
					winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
					getDriverWindowHandle();
					driver.findElement(By.linkText("Start a New Application")).click(); //
					switchDriver();	 
					break;
		}
		case "Agent":
	 	{
	 		agentLogin();
	 		linkrownumber=getLinkRowNumberForAgent(stuID, getcoursename); //Too continue the same test case
	 		 //if (courserownumber==0) logger.log(LogStatus.INFO,"Course record not found on the Applications Summary page.");
	 		 //else
	 		 //{
	 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[5]")).getText(), "Applicant");
			 //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Delete"); Delete won't come after submission
	 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), getcoursename);
	 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a")).getText(), "View");
	 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[2]")).getText(), "Withdraw");
	 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
	 		winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
			getDriverWindowHandle();
			driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).click();
			switchDriver();  // Staff login results in another window getting opened.
	 		break;
	 		//table[@id='uow-applications']/tbody/tr[1]/td[1]
	 	}
	}

    i=1;
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | 1 | ]]
    // While loop to execute the script for all the three Teaching qualifications - (BTCHG, GRADDIPT or MTCHGLN)
    // ERROR: Caught exception [unknown command [while]]
	
   while (i<=3)
   {
			if (usertype.equals("Student"))   	driver.findElement(By.linkText("Start a New Application")).click();
		    // Qualification Search Page
		    // ERROR: Caught exception [unknown command [if]]
			if (i==1)    courselink = "Bachelor of Teaching";
			else if (i==2) courselink = "Master of Teaching and Learning in Primary Sector";
		    // ERROR: Caught exception [unknown command [elseIf]]
		    // ERROR: Caught exception [unknown command [elseIf]]
			else if (i==3) courselink = "Graduate Diploma of Teaching in Early Childhood (GradDipT)";
		    // ERROR: Caught exception [unknown command [endIf]]
		    driver.findElement(By.id("KEYWORD.IPP.SRS")).clear();
		    driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("teaching");
		    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
		    driver.findElement(By.linkText(courselink)).click();
		    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
		    // Qualification Selection Page
		    driver.findElement(By.name("APPLY.IPO.SRS.1")).click();
		    // Personal details page
		    if(getlivinginNZ.equalsIgnoreCase("Yes"))
		    {
		    	driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();		    	
		    }
		    else
		    {	
		    	driver.findElement(By.id("IPQ_ADOAP_LOCL2")).click(); // Yes if none specified.		    	
		    }
		    //driver.findElement(By.id("IPQ_ADOAP_LOCL1")).click();
		    driver.findElement(By.id("app-btn-next")).click();
		    // Contact details page
		    driver.findElement(By.id("app-btn-next")).click();
		    // Education page
		    driver.findElement(By.id("ADOAP_EDPTS2")).click();
		    new Select(driver.findElement(By.id("IPQ_ADOAP_CSTY"))).selectByVisibleText("Cambridge International Exams");
		    driver.findElement(By.id("app-btn-next")).click();
		    // Additional info page
		    if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && getlivinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && getlivinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && getlivinginNZ.equalsIgnoreCase("No")))
		    {
		    driver.findElement(By.id("ADOAP_INTAG1_4")).click();
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[1]/h2")).getText(), "Additional info");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/legend")).getText(), "International");
		    //assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[1]/p")).getText(), "Are you coming through one of our approved Sponsorship or Scholarship Agencies?*");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[1]/p")).getText(), "Are you one of the following?");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[1]/div/div[1]/label")).getText(), "Yes");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[1]/div[1]/div/div[2]/label")).getText(), "No");    
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/legend")).getText(), "Teacher Education Information");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[2]/div/p")).getText(),"Are you currently registered as a teacher in New Zealand? *");
		    driver.findElement(By.id("IPQ_ADOAP_TEACHY")).click();
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[1]/h5")).getText(), "Information for applicants upgrading their qualification");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[1]/p")).getText(), "If you wish to upgrade your teaching diploma or equivalent qualification to a degree, please view our Information for registered teachers.");
		    }
		    else
		    {
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div/h2")).getText(), "Additional info");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/legend")).getText(), "Teacher Education Information");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/p")).getText(),"Are you currently registered as a teacher in New Zealand? *");
		    driver.findElement(By.id("IPQ_ADOAP_TEACHY")).click();
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div/h5")).getText(), "Information for applicants upgrading their qualification");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div/p")).getText(), "If you wish to upgrade your teaching diploma or equivalent qualification to a degree, please view our Information for registered teachers.");
		    }
		    getDriverWindowHandle();
		    driver.findElement(By.linkText("Information for registered teachers.")).click();
		    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | BTchg (Upgrade) (Early Childhood & Primary) | Te Kura Toi Tangata | ]]
		    switchDriver();
		    Thread.sleep(1000);
		    assertEquals(driver.findElement(By.xpath("//article[@id='post-1484']/h1")).getText(), "BTchg (Upgrade) (Early Childhood & Primary)");
		    assertEquals(driver.getTitle(), "BTchg (Upgrade) (Early Childhood & Primary) | Te Kura Toi Tangata");
		    assertEquals(driver.findElement(By.xpath("//article[@id='post-1484']/div/p")).getText(), "Upgrading a teaching diploma or equivalent qualification to a degree can enhance current teaching and learning practices and has salary benefits.  The Bachelor of Teaching (Upgrade) is for qualified and registered early childhood and primary school teachers wanting to upgrade their current teaching qualification to a Bachelor of Teaching degree.");
		    switchToEarlierDriver();
		    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
		    driver.findElement(By.id("IPQ_ADOAP_TEACHN")).click();
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[2]/h5")).getText(), "Information for applicants for teaching qualifications");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[2]/p")).getText(), "Applying for a teaching qualification is a two-step process. You complete this online application and fill out a Teacher Education Supplementary Form.");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[2]/p[2]")).getText(), "Please post the completed form to:");
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div[2]/p[3]")).getText(), "Centre for Teacher Education\nFaculty of Education,\nUniversity of Waikato\nPrivate Bag 3105\nWaikato Mail Centre\nHamilton 3240");
		    getDriverWindowHandle();
		    driver.findElement(By.linkText("Teacher Education Supplementary Form.")).click();
		    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | 1805-FEDU-Teacher-Education-Supplementary-Form_Web-OCT-2016.pdf | ]]
		    switchDriver();
		    Thread.sleep(1000);
		    assertEquals(driver.getCurrentUrl(), "https://education.waikato.ac.nz/wp-content/uploads/2016/10/1805-FEDU-Teacher-Education-Supplementary-Form_Web-OCT-2016.pdf");	
		    /**  assertEquals(driver.getTitle(), "1805-FEDU-Teacher-Education-Supplementary-Form_Web-OCT-2016.pdf");
		      assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div[2]/div")).getText(),"Checklist - have you?");
		      assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[45]")).getText(), "How to Apply");
		      assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[46]")).getText(), "Step 1");   
		      assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[50]")).getText(), "Step 2");   
		      assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[47]")).getText(), "Apply online at enrol.waikato.ac.nz");   
		      assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[48]")).getText(), "We prefer online applications, but we can supply a");   
		      assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[53]")).getText(), "Supplementary Form (TSF)");   
		      assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer1']/div[2]/div[55]")).getText(), "For a PDF version of this form, please visit:");   
		      assertEquals(driver.findElement(By.xpath("//div[@id='pageContainer2']/div[2]/div")).getText(), "Selection Process and Dates");**/
		    switchToEarlierDriver();
		    driver.findElement(By.id("app-btn-next")).click();
		    //Documents page
		    driver.findElement(By.id("app-btn-next")).click();
		    // Declaration Page
		    driver.findElement(By.id("ADOAP_DECC")).click();
		    driver.findElement(By.xpath("//button[@id='app-btn-next']")).click();
		    // Confirmation Page
		// temp    ClearanceChecks clchk = new ClearanceChecks();
		// temp <<need to fix Clearancecheck SITS part first>>   clchk.callSITS(getfirstn, getlastn, getemail, getdob, courselink, getcontactcountry, residencystatus, getcurrentlystudyingtowards, gethighsecqual, getprevtertiarystudyatuniv, getfirstenrolter);	

		  //  driver.findElement(By.id("app-btn-save")).click();
		    
		    if (usertype.equals("Student"))
		    {
		  	  	// 	Confirmation Page
		  	  	driver.findElement(By.linkText("Applications")).click();
			}
		    else if (usertype.equals("Agent"))
		    {
		    	  	driver.close();
		    	  	driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window
		    	  	driver.get(propertyconfig.getApplicationURL());
		    	  	agentLogin();  //Call the Agent login steps
					linkrownumber=getLinkRowNumberForAgent(stuID, getcoursename); 
			 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[4]")).getText(), getcoursename);
			 		assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).getText(), "Lodge another application");
			 		winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
					getDriverWindowHandle();
					driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+linkrownumber+"]/td[6]/a[3]")).click();
					switchDriver();  // login results in another window getting opened.    	  
		    }
		    else 		  
			{
		  	 	driver.close();
				driver.switchTo().window(winhandlebefore_staff);    // Close the additional student window
				winhandlebefore_staff = driver.getWindowHandle(); //   get  Driver Window Handle to use at the end, to close student window;
				getDriverWindowHandle();
				driver.findElement(By.linkText("Start a New Application")).click(); //
				switchDriver();	 
			}	    
		    
		    // Application Summary Page
		    // ERROR: Caught exception [ERROR: Unsupported command [getEval | storedVars.i=storedVars.i+1 | ]]
		    
		    i++;
   	} // closing While loop
    // ERROR: Caught exception [unknown command [endWhile]]
    System.out.println("TEA-9TeachingProgramme Additional Info test case executed - "+email);
    System.out.println("--------------------------------------------------");    
    logger.log(LogStatus.INFO,"TEA-9TeachingProgramme Additional Info test case executed.");
    } catch (Exception e) {
	      System.out.println("Error:"+e.getMessage());
	      exceptionerror="true";
	      errormessage=e.getMessage();}
  }






public Object[][] courseChoice() throws Exception   // Load Data Excel  
{	  		  	
  	//int sheetnumber = 0;
	//String excelpath=propertyconfig.getExcelSheetPath();
  	//ExcelDataConfig excelconfig = new ExcelDataConfig(excelpath);
  	
	//ExcelDataConfig excelconfig = new ExcelDataConfig("C:/Users/rbhatia/workspace/SMS/TestData/InputData.xlsx");
  	
	//int rows=excelconfig.getRowCount(sheetnumber);  //rows in the first sheet
	//int cols=excelconfig.getColCount(sheetnumber);  //cols in the first sheet
	Object[][] courseoptions = new Object[2][2];	
	for(int i=0;i<2;i++)   //Initializing Array 
	{
		for (int j=0;j<2;j++)  //Columns value is one more than the index so less than sign
		{
			courseoptions[i][j]= driver.findElement(By.xpath("//tbody/tr["+(i+1)+"]/td["+(j+1)+"]/span")).getText(); 
			//System.out.println(courseoptions[i][j]+"\n");
		}					
	}
  	return courseoptions;
}


private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  @DataProvider(name="ParamData")  //Parameterizing @Test code for the Excel records
	public Object[][] passData() throws Exception   // Load Data Excel  
	{	  		  	
	  	int sheetnumber = 0;		
		String excelpath=propertyconfig.getExcelSheetPath();	
	  	ExcelDataConfig excelconfig = new ExcelDataConfig(excelpath);
	  	
		//ExcelDataConfig excelconfig = new ExcelDataConfig("C:/Users/rbhatia/workspace/SMS/TestData/InputData.xlsx");
	  	
		int rows=excelconfig.getRowCount(sheetnumber);  //rows in the first sheet
		int cols=excelconfig.getColCount(sheetnumber);  //cols in the first sheet
		Object[][] data = new Object[rows-1][cols];	
		for(int i=0;i<rows-1;i++)   //Initializing Array to just one row, so rows-1. First row is just headings and make sure every column cell has a text
		{
			for (int j=0;j<cols;j++)  //Columns value is one more than the index so less than sign
			{
				data[i][j]=excelconfig.getData(sheetnumber, i+1, j);  //Picking data from the 2nd row in excel sheet, so i+1
				if (j==6)   //As date field is in the 7th col (6th index)
				{
					//Calling the function to change the date format from mm/dd/yy to dd/mm/yyyy//
				//	dobforage[i]= (String) data[i][j];
					String datevalue = (String) data[i][j]; 
					String datechange = excelconfig.changeDateFormat(datevalue);  
					data[i][j]=datechange;
					 	
					// -----------------------------------------------------------------     //		
				}
			}					
		}
		
	  	return data;
	}
  
  public void checkLinks10037(String residencystatus, String getlivinginNZ)
  {
	// Check links for Story# 10037 (Different Residency status)
	    try{
	    switch(residencystatus) {
		    case "NZ Citizen":
	        case "NZ Permanent Resident":
	        case "Cook Islands":
	        case "Niue": 
	        case "Tokelau": 
	        {
	        	assertTrue(!isElementPresent(By.linkText("International Student Insurance")));
	        	assertTrue(!isElementPresent(By.linkText("Immigration and Visas")));
	        	assertEquals(driver.findElement(By.linkText("Studylink")).getText(), "Studylink");
	        	getDriverWindowHandle();
	            driver.findElement(By.linkText("Studylink")).click();
	            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Studylink - StudyLink | ]]
	            switchDriver();
	            Thread.sleep(1000);
	            assertEquals(driver.getCurrentUrl(), "https://www.studylink.govt.nz/");
	            assertEquals(driver.getTitle(), "Studylink - StudyLink");
	          /**  try {
	              assertEquals(driver.findElement(By.xpath("//div[@id='banner-blue']/div/a")).getText(), "StudyLink");
	            } catch (Exception e) {
	            System.out.println("Error:"+e.getMessage());
	            } **/
	            // temp assertEquals(driver.findElement(By.xpath("//div[@id='content']/div/p")).getText(), "We help students make informed choices about their student finance, how to apply for it and manage it online.");
	            switchToEarlierDriver();
	        	break;
	        }
	        case "Australian and NZ Permanent Resident":
	        case "Australian Permanent Resident":
	        case "Australian Citizen":
	        {
	        	if (getlivinginNZ.equals("Yes"))
	        	{
	        	assertEquals(driver.findElement(By.linkText("Studylink")).getText(), "Studylink");
	        	assertTrue(!isElementPresent(By.linkText("International Student Insurance")));
	        	assertTrue(!isElementPresent(By.linkText("Immigration and Visas")));
	        	getDriverWindowHandle();
	            driver.findElement(By.linkText("Studylink")).click();
	            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Studylink - StudyLink | ]]
	            switchDriver();
	            assertEquals(driver.getCurrentUrl(), "https://www.studylink.govt.nz/");
	            assertEquals(driver.getTitle(), "Studylink - StudyLink");
	            // temp assertEquals(driver.findElement(By.xpath("//div[@id='content']/div/p")).getText(), "We help students make informed choices about their student finance, how to apply for it and manage it online.");
	            switchToEarlierDriver();
	        	}
	        	else if (getlivinginNZ.equals("No"))
	        	{
	        	 	assertFalse(isElementPresent(By.linkText("Studylink")));
	        		assertEquals(driver.findElement(By.linkText("International Student Insurance")).getText(), "International Student Insurance");          
		            getDriverWindowHandle();  
		            driver.findElement(By.linkText("International Student Insurance")).click();
		            switchDriver();
		            Thread.sleep(1000);
		            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Insurance Policies for International Students : University of Waikato | ]]
		            assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/international/preparing-to-come-to-nz/insurance-policies-for-international-students");
		            assertEquals(driver.getTitle(), "Studentsafe - Inbound University Insurance : University of Waikato");
		     ///       assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Studentsafe - Inbound University Insurance");
		        ///    assertEquals(driver.findElement(By.xpath("//section[@id='content']/p[2]")).getText(), "This will automatically be added and charged to your Enrolment Agreement. If you prefer you can choose to purchase an alternative approved policy and provide a copy of the cover to the university at least two weeks before the start of your course of study.");
		           
		           // Check Immigration and Visas link for Story# 10037
		            switchToEarlierDriver();
		            assertEquals(driver.findElement(By.linkText("Immigration and Visas")).getText(), "Immigration and Visas");
		            getDriverWindowHandle();  
		            driver.findElement(By.linkText("Immigration and Visas")).click();
		            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Preparing to Come to NZ : University of Waikato | ]]
		            switchDriver();
		            Thread.sleep(1000);
		            assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/international/preparing-to-come-to-nz");
		            assertEquals(driver.getTitle(), "Preparing to Come to NZ : University of Waikato");
		           /// assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Preparing to Come to NZ");
		            //assertEquals(driver.findElement(By.xpath("//section[@id='content']/h2")).getText(), "Adjusting to life in New Zealand");
		            switchToEarlierDriver();	           
		        	//assertNotEquals(driver.findElement(By.linkText("Studylink")).getText(), "Studylink");
		        	//assertTrue(driver.findElement(By.linkText("Studylink")).size() < 1);
	        	}
	            break;
	        }
	        case "Other":
	        {
	           	assertTrue(!isElementPresent(By.linkText("Studylink")));
	        	//Checking Other - story# 10037
	        	
	        	assertEquals(driver.findElement(By.linkText("International Student Insurance")).getText(), "International Student Insurance");          
	            getDriverWindowHandle();  
	            driver.findElement(By.linkText("International Student Insurance")).click();
	            switchDriver();
	            Thread.sleep(1000);
	            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Insurance Policies for International Students : University of Waikato | ]]
	            assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/international/preparing-to-come-to-nz/insurance-policies-for-international-students");
	            assertEquals(driver.getTitle(), "Studentsafe - Inbound University Insurance : University of Waikato");
	            ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Studentsafe - Inbound University Insurance");
	            ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/p[2]")).getText(), "This will automatically be added and charged to your Enrolment Agreement. If you prefer you can choose to purchase an alternative approved policy and provide a copy of the cover to the university at least two weeks before the start of your course of study.");
	           
	           // Check Immigration and Visas link for Story# 10037
	            switchToEarlierDriver();
	            assertEquals(driver.findElement(By.linkText("Immigration and Visas")).getText(), "Immigration and Visas");
	            getDriverWindowHandle();  
	            driver.findElement(By.linkText("Immigration and Visas")).click();
	            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Preparing to Come to NZ : University of Waikato | ]]
	            switchDriver();
	            Thread.sleep(1000);
	            assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/international/preparing-to-come-to-nz");
	            assertEquals(driver.getTitle(), "Preparing to Come to NZ : University of Waikato");
	            ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Preparing to Come to NZ");
	            //assertEquals(driver.findElement(By.xpath("//section[@id='content']/h2")).getText(), "Adjusting to life in New Zealand");
	            switchToEarlierDriver();	           
	        	//assertNotEquals(driver.findElement(By.linkText("Studylink")).getText(), "Studylink");
	        	//assertTrue(driver.findElement(By.linkText("Studylink")).size() < 1);
	            break;
	        } 
	        default:
	            //Do nothing or something else..
	            break;
	    }   
	        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
	    // Check Accommodation Options link for Story# 10037
	    getDriverWindowHandle();
	    driver.findElement(By.linkText("Accommodation Options")).click();
	    Thread.sleep(500);
	    switchDriver();
	    assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/student-life/accommodation/on-campus");
	    assertEquals(driver.getTitle(), "Halls of Residence : University of Waikato");
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | On Campus : University of Waikato | ]]
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Halls of Residence");
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/p[2]")).getText(), "Our four halls of residence are the perfect place to settle into university life, meet new people and gain more independence in a safe and secure environment.");
	    switchToEarlierDriver();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
	    // Check Halls of Residence Online Application link for Story# 10037
	    assertEquals(driver.findElement(By.linkText("Halls of Residence Online Application")).getText(), "Halls of Residence Online Application");
	    getDriverWindowHandle();
	    driver.findElement(By.linkText("Halls of Residence Online Application")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Accommodation : University of Waikato | ]]
	    switchDriver();
	    Thread.sleep(500);
	    assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/apply/accommodation");
	    assertEquals(driver.getTitle(), "Accommodation : University of Waikato");
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Accommodation");
	    ///assertEquals(driver.findElement(By.xpath("//div[@id='tab-24445']/h2")).getText(), "Apply for Halls of Residence");
	    switchToEarlierDriver();
	    
	    // Check Paper Catalogue link for Story# 10037
	    assertEquals(driver.findElement(By.linkText("Paper Catalogue")).getText(), "Paper Catalogue");
	    getDriverWindowHandle();
	    driver.findElement(By.linkText("Paper Catalogue")).click();
	    switchDriver();
	    Thread.sleep(500);
	    assertEquals(driver.getCurrentUrl(), "https://papers.waikato.ac.nz/");
	    assertEquals(driver.getTitle(), "2018 Catalogue of Papers");
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "2018 Catalogue of Papers");
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/p")).getText(), "The Catalogue of Papers contains a brief introduction to the subjects and papers to be offered by the University. For more information on individual papers offered, please contact the relevant Faculty or School.");
	    switchToEarlierDriver();
	 
	    // Check Fee link for Story# 10037
	    assertEquals(driver.findElement(By.linkText("Fees")).getText(), "Fees");
	    getDriverWindowHandle();
	    driver.findElement(By.linkText("Fees")).click();
	    switchDriver();
	    Thread.sleep(500);
	    assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/costs");
	    assertEquals(driver.getTitle(), "Fees and Costs : University of Waikato");
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Fees and Costs : University of Waikato | ]]
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Fees and Costs");
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h2")).getText(), "Tuition fees");
	    switchToEarlierDriver();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
	    // Check Student Support link for Story# 10037
	    getDriverWindowHandle();
	    driver.findElement(By.linkText("Student Support")).click();
	    switchDriver();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Student Services : University of Waikato | ]]
	    assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/student-life/student-services");
	    assertEquals(driver.getTitle(), "Student Services : University of Waikato");
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Student Services");
	    ///assertEquals(driver.findElement(By.xpath("//nav[@id='section-menu']/h3/a")).getText(), "Student Life"); 
	    switchToEarlierDriver();
	    // Check Scholarships link for Story# 10037
	    getDriverWindowHandle();
	    driver.findElement(By.linkText("Scholarships")).click();
	    switchDriver();
	    assertEquals(driver.getCurrentUrl(), "http://www.waikato.ac.nz/study/scholarships");
	    assertEquals(driver.getTitle(), "Scholarships : University of Waikato");
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h1")).getText(), "Scholarships");
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h2")).getText(), "School-leaver scholarships"); 
	    ///assertEquals(driver.findElement(By.xpath("//section[@id='content']/h2[2]")).getText(), "International scholarships"); 
	    switchToEarlierDriver();
	 
	    } catch (Exception e) {
		      System.out.println("Error:"+e.getMessage());
		      exceptionerror="true";
		      errormessage=e.getMessage();}  
  }
  
  
  public void qualificationSearch(String email)
  {
	  // Auto 7 : TEA-SPRINT2->Story/Feature #10228:ADOAP-U023 - As an applicant (general), I need a facility to search qualifications offered by the University based on selected criteria in order to be able to apply for a qualification of interest.
	    // TEA-SPRINT2->Story/Feature #10041 (AC 1,3,4,5,6):ADOAP-U024 - As an applicant (general), I need a facility to select a proposed qualification and starting semester in order to apply to the University.
	    // //PRE-REQ: Applicant is getting Registered and Submitting the FIRST application to the University. 
	    // // // All new independent variables related to Qualification Search page
	  // Qualification Search
	  try{ 
      assertEquals(driver.findElement(By.cssSelector("p.header-subtitle.sv-hidden-xs")).getText(), "Application");
      assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Qualification Search");
      assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Search criteria");
      assertEquals(driver.findElement(By.cssSelector("label.sv-col-sm-3.sv-control-label")).getText(), "Type of Qualification");
      assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Keyword");
      assertEquals(driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).getAttribute("value"), "Search");
      // ERROR: Caught exception [ERROR: Unsupported command [getSelectOptions | id=SELECTION.CRITERIA.SRS.1-1 | ]]
     /// assertEquals(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1")).equals(obj)
    
      // Bachelors Conjoint Degrees      
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Conjoint");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    // Verify the first and last entries of the search for the selected Qualification types. Results available for the below options only.
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Bachelor of Teaching/Bachelor of Social Sciences");
    
    // Bachelors Degrees
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Degree");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[4]/div/div/div[2]/ul/li[1]/a")).getText(), "Bachelor of Tourism");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[34]/a")).getText(), "Bachelor of Arts");
  
    // Bachelors Honours
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Honours");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Bachelor of Tourism with Honours");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[65]/a")).getText(), "Bachelor of Arts with Honours in Anthropology");
  
    // Certificate
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Certificate");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Certificate in Tourism");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[11]/a")).getText(), "Certificate in Arts");
    
    // Foundation Certificate
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Foundation Certificate");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Certificate of University Preparation");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[4]/a")).getText(), "Certificate of Attainment in Academic English");
  
    // Postgraduate Certificate
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Postgraduate Certificate");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Postgraduate Certificate in Women's and Gender Studies");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[74]/a")).getText(), "Postgraduate Certificate in Accounting");
  
    // Diploma
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Diploma");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Diploma in Tourism");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[11]/a")).getText(), "Diploma in Arts");
   
    // Postgraduate Diploma
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Postgraduate Diploma");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Postgraduate Diploma of Computer Graphic Design");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[84]/a")).getText(), "Postgraduate Diploma in Accounting");
   
    // Graduate Certificate
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Graduate Certificate");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Graduate Certificate in Writing Studies");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[69]/a")).getText(), "Graduate Certificate in Accounting");
    
    // Graduate Diploma
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Graduate Diploma");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Graduate Diploma of Teaching in Secondary (GradDipT)");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[77]/a")).getText(), "Graduate Diploma in Accounting");
   
    // Higher Doctorate
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Higher Doctorate");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Doctor of Science in Women's and Gender Studies");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[60]/a")).getText(), "Doctor of Laws");
  
    // Individual paper credit
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Individual paper credit");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Individual Paper Credit");
  
    // Masters Degree
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Masters Degree");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Master of Teaching and Learning in Secondary Sector");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[115]/a")).getText(), "Master of Applied Psychology in Behaviour Analysis");
   
    // Master of Philosophy
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Master of Philosophy");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Master of Philosophy in Women's and Gender Studies");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[52]/a")).getText(), "Master of Philosophy in Accounting");
    
    // Doctor of Philosophy/Higher Degrees
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Doctor of Philosophy/Higher Degrees");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Doctor of Philosophy in Women's and Gender Studies");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[67]/a")).getText(), "Doctor of Education");
   
    // Seacrh by keyword only
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("Bachelors Degree");
    driver.findElement(By.id("KEYWORD.IPP.SRS")).clear();
    driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("teaching");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Bachelor of Teaching");
  
    new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText("");
    driver.findElement(By.id("KEYWORD.IPP.SRS")).clear();
    driver.findElement(By.id("KEYWORD.IPP.SRS")).sendKeys("teaching");
    driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li/a")).getText(), "Postgraduate Diploma in Second Language Teaching");
    assertEquals(driver.findElement(By.xpath("//ul[@id='courses']/li[16]/a")).getText(), "Bachelor of Teaching");
    driver.findElement(By.id("KEYWORD.IPP.SRS")).clear();
      
    //String coursename = driver.findElement(By.xpath("//ul[@id='courses']/li[10]/a")).getText();
    //driver.findElement(By.xpath("//ul[@id='courses']/li[10]/a")).click();
   /** // Qualification Selection
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Qualification selection");
    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Apply for the qualification: " + coursename);
    driver.findElement(By.name("APPLY.IPO.SRS.1")).click();
    driver.findElement(By.xpath("//form[@id='app_form']/div/div[3]/div/button")).click();
    // Confirmation Page
    driver.findElement(By.linkText("Applications")).click();**/
    ///   assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[4]")).getText(), "Incomplete");
    ///assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText(), "Bachelor of Teaching");
  
    qualsearchcount++;
    System.out.println("TEA-QualificationsSearch test case executed.");
    System.out.println("--------------------------------------------------");
    logger.log(LogStatus.INFO,"TEA-QualificationsSearch test case executed - "+email);
	  } catch (Exception e) {
	      System.out.println("Error:"+e.getMessage());
	      exceptionerror="true";
	      errormessage=e.getMessage();}
  }
  
  /**@BeforeMethod   //executed after every method. Creating to capture the results of Failure.
	 public void setUp() throws Exception
	 {
  	  propertyconfig = new ConfigReader(); //Read the Config Property value
	  String url= propertyconfig.getApplicationURL();  //URL picked from the Property file
	  driver.get(url);
	 }**/
	
  @AfterMethod   //executed after every method. Creating to capture the results of Failure.
	 public void tearD(ITestResult result) throws Exception
	 {
	  if(ITestResult.FAILURE==result.getStatus() || (exceptionerror.equals("true")))  //Check if Test case has failed
	  {
	  	 String screenshot_path = ReportScreenshotUtility.captureScreenshot(driver,propertyconfig.getScreenShotPath(),result.getName());   //Take screenshot if Test Case fails
	  	 String image=logger.addScreenCapture(screenshot_path);
	  	 logger.log(LogStatus.FAIL, "Failed", image);
	  	 if(ITestResult.FAILURE==result.getStatus())		logger.log(LogStatus.FAIL, "Exception Message", result.getThrowable());
	  	 if (exceptionerror=="true")  logger.log(LogStatus.FAIL, "Exception Message", errormessage);
	  }
	  else if (ITestResult.SUCCESS==result.getStatus() && (exceptionerror.equals("false")))   //Check if Test case has passed
	  {
	  	logger.log(LogStatus.PASS, "Passed");	
	  }
	  else if (ITestResult.SKIP==result.getStatus())  //Check if Test case has passed
	  {
		logger.log(LogStatus.SKIP, "Test case Skipped"+result.getThrowable());	
	  }		
		 ReportScreenshotUtility.report.endTest(logger);
		 ReportScreenshotUtility.report.flush();
	 }
  
  public void executeScript(String workflowstatus, String getfirstn, String getlastn, String getemail, String getdob, String getcity, String getpostcode, String getmobile, String getcountry, String getcoursename, String getcontactaddressline1, String getcontactaddressline2, String getcontactaddressline3, String getcontactaddressline4, String getgender, String getcontactcountry, String gethomephone, String getcompletequalcode, String getqualname, String getyearfrom,  String getyearto, String getfirstenrolter, String getlivinginNZcode, String getnstudentnumber, String getprevfamilyname, String getsecondname, String getothersecondname, String getanyotherqualcode, String getprevtertiarystudyatunivcode, String getcurrentlyatsecondaryschoolcode, String getcurrentlystudyingtowards, String gethighsecqual, String getinstitutionname, String getinstitutiontype, String getqualificationtype, String getlastsecschool, String getlastschoolyear, String getethnicity1, String getethnicity2, String getethnicity3, String getiwi1, String getiwi2, String getiwi3, String getiwi4, String getresidencystatus, String getcourseyear, String getcoursemonth) throws IOException	{
	  	try{
	  	String countrycode, contactcountrycode;
	  	String currentlystudyingtowardscode;
	  	String highsecqualcode;
	  	String institutionnamecode;
	  	String institutiontypecode;
	  	String qualificationtypecode;
	  	String lastsecschoolcode;
		String lastschoolyearcode;
		String ethnicity1code, ethnicity2code, ethnicity3code;
		String iwi1code, iwi2code, iwi3code, iwi4code;
		String residencystatuscode;			
		Runtime runtime = Runtime.getRuntime();
		String scriptpath=propertyconfig.getScriptPath(workflowstatus);
		Process p = null;
		//Process pstu = null;
		//if (!getcountry.equalsIgnoreCase(null))
		if (getlastsecschool != null)
		{
			lastsecschoolcode=codes.getLastsecschoolcode(getlastsecschool);
		}
		else
		{
			lastsecschoolcode=null;
		}
		
		if (gethighsecqual != null)
		{
			highsecqualcode=codes.getHighsecqualcode(gethighsecqual);	//get Higher Secondary level qualification code
		}
		else
		{
			highsecqualcode=null;
		}
		
		if (getcurrentlystudyingtowards != null)
		{
			currentlystudyingtowardscode = codes.getCurrentlystudyingtowardscode(getcurrentlystudyingtowards);  //get currently studying towards qualification code for the SITS client verification
		}
		else
		{
			currentlystudyingtowardscode = null;
		}
		
		if (getcontactcountry !=null)
		{
			contactcountrycode = codes.getCountrycode(getcontactcountry);  //get countrycode for the SITS client verification
		}
		else
		{
			contactcountrycode = null;
		}
		
		if (workflowstatus.equals("beforesubmission"))
		{
			if (getcountry !=null)
			{
				countrycode = codes.getCountrycode(getcountry);  //get countrycode for the SITS client verification
			}
			else
			{
				countrycode = null;
			}
							
			if (getinstitutionname != null)
			{
				institutionnamecode=codes.getInstitutionnamecode(getinstitutionname);   //get Institution name code
			}
			else
			{
				institutionnamecode=null;
			}
			
			if (getinstitutiontype != null)
			{
				institutiontypecode=codes.getInstitutiontypecode(getinstitutiontype);   //get Institution type code
			}
			else
			{
				institutiontypecode=null;
			}
			
			if (getqualificationtype != null)
			{
				qualificationtypecode=codes.getQualificationtypecode(getqualificationtype);   //get Qualification type code
			}
			else
			{
				qualificationtypecode=null;
			}
			
			
			
			if (getlastschoolyear != null)
			{
				lastschoolyearcode=codes.getLastschoolyearcode(getlastschoolyear);
			}
			else
			{
				lastschoolyearcode=null;
			}
			
			if (getethnicity1 != null)
			{
				ethnicity1code=codes.getEthnicitycode(getethnicity1);
			}
			else
			{
				ethnicity1code=null;
			}
			
			if (getethnicity2 != null)
			{
				ethnicity2code=codes.getEthnicitycode(getethnicity2);
			}
			else
			{
				ethnicity2code=null;
			}
			
			if (getethnicity3 != null)
			{
				ethnicity3code=codes.getEthnicitycode(getethnicity3);
			}
			else
			{
				ethnicity3code=null;
			}
			
			if (getiwi1 != null)
			{
				iwi1code=codes.getIwicode(getiwi1);
			}
			else
			{
				iwi1code=null;
			}
			
			if (getiwi2 != null)
			{
				iwi2code=codes.getIwicode(getiwi2);
			}
			else
			{
				iwi2code=null;
			}
			
			if (getiwi3 != null)
			{
				iwi3code=codes.getIwicode(getiwi3);
			}
			else
			{
				iwi3code=null;
			}
			
			if (getiwi4 != null)
			{
				iwi4code=codes.getIwicode(getiwi4);
			}
			else
			{
				iwi4code=null;
			}
			
			if (getresidencystatus != null)
			{
				residencystatuscode= codes.getResidencystatuscode(getresidencystatus);
			}
			else
			{
				residencystatuscode=null;
			}
					
			///Get Created/submitted date, if form submitted	    
		   
		  //  LocalDate localDate = LocalDate.now();
		    	    ///
		 
		    	System.out.println("Script: "+scriptpath+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getemail+"\""+" "+"\""+getdob+"\""+" "+"\""+getcity+"\""+" "+"\""+getpostcode+"\""+" "+"\""+getmobile+"\""+" "+"\""+getcountry+"\""+" "+"\""+getcoursename+"\""+" "+"\""+getcontactaddressline1+"\""+" "+"\""+getgender+"\""+" "+"\""+countrycode+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+gethomephone+"\""+" "+"\""+getcontactaddressline2+"\""+" "+"\""+getcontactaddressline3+"\""+" "+"\""+getcontactaddressline4+"\""+" "+"\""+currentlystudyingtowardscode+"\""+" "+"\""+getcompletequalcode+"\""+" "+"\""+highsecqualcode+"\""+" "+"\""+institutionnamecode+"\""+" "+"\""+institutiontypecode+"\""+" "+"\""+qualificationtypecode+"\""+" "+"\""+lastsecschoolcode+"\""+" "+"\""+lastschoolyearcode+"\""+" "+"\""+getqualname+"\""+" "+"\""+getyearfrom+"\""+" "+"\""+getyearto+"\""+" "+"\""+getfirstenrolter+"\""+" "+"\""+ethnicity1code+"\""+" "+"\""+ethnicity2code+"\""+" "+"\""+ethnicity3code+"\""+" "+"\""+iwi1code+"\""+" "+"\""+iwi2code+"\""+" "+"\""+iwi3code+"\""+" "+"\""+iwi4code+"\""+" "+"\""+getlivinginNZcode+"\""+" "+"\""+residencystatuscode+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+getprevfamilyname+"\""+" "+"\""+getsecondname.toUpperCase()+"\""+" "+"\""+getothersecondname.toUpperCase()+"\""+" "+"\""+getanyotherqualcode+"\""+" "+"\""+getprevtertiarystudyatunivcode+"\""+" "+"\""+getcurrentlyatsecondaryschoolcode+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\"");  //dtf.format(localDate)
		    	p = runtime.exec(scriptpath+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getemail+"\""+" "+"\""+getdob+"\""+" "+"\""+getcity+"\""+" "+"\""+getpostcode+"\""+" "+"\""+getmobile+"\""+" "+"\""+getcountry+"\""+" "+"\""+getcoursename+"\""+" "+"\""+getcontactaddressline1+"\""+" "+"\""+getgender+"\""+" "+"\""+countrycode+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+gethomephone+"\""+" "+"\""+getcontactaddressline2+"\""+" "+"\""+getcontactaddressline3+"\""+" "+"\""+getcontactaddressline4+"\""+" "+"\""+currentlystudyingtowardscode+"\""+" "+"\""+getcompletequalcode+"\""+" "+"\""+highsecqualcode+"\""+" "+"\""+institutionnamecode+"\""+" "+"\""+institutiontypecode+"\""+" "+"\""+qualificationtypecode+"\""+" "+"\""+lastsecschoolcode+"\""+" "+"\""+lastschoolyearcode+"\""+" "+"\""+getqualname+"\""+" "+"\""+getyearfrom+"\""+" "+"\""+getyearto+"\""+" "+"\""+getfirstenrolter+"\""+" "+"\""+ethnicity1code+"\""+" "+"\""+ethnicity2code+"\""+" "+"\""+ethnicity3code+"\""+" "+"\""+iwi1code+"\""+" "+"\""+iwi2code+"\""+" "+"\""+iwi3code+"\""+" "+"\""+iwi4code+"\""+" "+"\""+getlivinginNZcode+"\""+" "+"\""+residencystatuscode+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+getprevfamilyname+"\""+" "+"\""+getsecondname.toUpperCase()+"\""+" "+"\""+getothersecondname.toUpperCase()+"\""+" "+"\""+getanyotherqualcode+"\""+" "+"\""+getprevtertiarystudyatunivcode+"\""+" "+"\""+getcurrentlyatsecondaryschoolcode+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\"");
		
		}
	    else if (workflowstatus.equals("aftersubmission"))
	    {
	    	//calculate age////
	    	int day=0;
	        String dobmonth="";
	        int year=0;
	        if(dob.contains("/"))
	        {
	            day = Integer.parseInt(dob.substring(0, dob.indexOf("/")));
	            int index= dob.indexOf("/");
	            dobmonth= dob.substring(index+1, index+4);
	            year=Integer.parseInt(dob.substring(index+5));
	          //  System.out.println("Day:"+day+" Month:"+dobmonth+" Year:"+year);
	        }
	        Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(dobmonth);
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        int month = cal.get(Calendar.MONTH);
	       		    	        
	        LocalDate birthdate = new LocalDate(year, month+1, day);          //Birth date
	        LocalDate now = new LocalDate();                    //Today's date
	        Period period = new Period(birthdate, now, PeriodType.yearMonthDay());
	        //System.out.println("Age:"+period.getYears());
	    	///////////// Age calculated/////////////////////////////
	    		    	    			    
		    System.out.println("Script: "+scriptpath+" "+"\""+getfirstn.toUpperCase()+"\""+" "+"\""+getlastn.toUpperCase()+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+"AP"+"\""+" "+"\""+"UOW"+"\""+" "+"\""+getcoursename+"\""+" "+"\""+getcourseyear+"\""+" "+"\""+getcoursemonth+"\""+" "+"\""+getsecondname.toUpperCase()+"\""+" "+"\""+getothersecondname.toUpperCase()+"\""+" "+"\""+getprevfamilyname.toUpperCase()+"\""+" "+"\""+contactcountrycode+"\""+" "+"\""+"C"+"\""+" "+"\""+getgender+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+highsecqualcode+"\""+" "+"\""+lastsecschoolcode+"\""+" "+"\""+getlastschoolyear+"\""+" "+"\""+getfirstenrolter+"\""+" "+"\""+currentlystudyingtowardscode+"\""+" "+"\""+getcontactaddressline1.toUpperCase()+"\""+" "+"\""+getcontactaddressline2.toUpperCase()+"\""+" "+"\""+getcontactaddressline3.toUpperCase()+"\""+" "+"\""+getcontactaddressline4.toUpperCase()+"\""+" "+"\""+getemail+"\""+" "+"\""+getpostcode+"\""+" "+"\""+getcity.toUpperCase()+"\""+" "+"\""+gethomephone+"\""+" "+"\""+getmobile+"\""+" "+"\""+period.getYears()+"\""+" "+"\""+usertype+"\"");
	    	p = runtime.exec(scriptpath+" "+"\""+getfirstn.toUpperCase()+"\""+" "+"\""+getlastn.toUpperCase()+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+"AP"+"\""+" "+"\""+"UOW"+"\""+" "+"\""+getcoursename+"\""+" "+"\""+getcourseyear+"\""+" "+"\""+getcoursemonth+"\""+" "+"\""+getsecondname.toUpperCase()+"\""+" "+"\""+getothersecondname.toUpperCase()+"\""+" "+"\""+getprevfamilyname.toUpperCase()+"\""+" "+"\""+contactcountrycode+"\""+" "+"\""+"C"+"\""+" "+"\""+getgender+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+highsecqualcode+"\""+" "+"\""+lastsecschoolcode+"\""+" "+"\""+getlastschoolyear+"\""+" "+"\""+getfirstenrolter+"\""+" "+"\""+currentlystudyingtowardscode+"\""+" "+"\""+getcontactaddressline1.toUpperCase()+"\""+" "+"\""+getcontactaddressline2.toUpperCase()+"\""+" "+"\""+getcontactaddressline3.toUpperCase()+"\""+" "+"\""+getcontactaddressline4.toUpperCase()+"\""+" "+"\""+getemail+"\""+" "+"\""+getpostcode+"\""+" "+"\""+getcity.toUpperCase()+"\""+" "+"\""+gethomephone+"\""+" "+"\""+getmobile+"\""+" "+"\""+period.getYears()+"\""+" "+"\""+usertype+"\"");
	    
	    //	pstu = runtime.exec(scriptpath+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getsecondname+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+contactcountrycode+"\""+" "+"\""+getdob+"\""+" "+"\""+"AP"+"\""+" "+"\""+"C"+"\""+" "+"\""+getgender+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+highsecqualcode+"\""+"\""+" "+"\""+lastsecschoolcode+"\""+"\""+" "+"\""+getlastschoolyear+"\""+"\""+" "+"\""+getfirstenrolter+"\""+"\""+" "+"\""+currentlystudyingtowardscode+"\""+"\""+" "+"\""+getcontactaddressline1+"\""+"\""+"\""+" "+"\""+getcontactaddressline2+"\""+"\""+"\""+" "+"\""+getcontactaddressline3+"\""+"\""+"\""+" "+"\""+getcontactaddressline4+"\""+"\""+"\""+" "+"\""+getemail+"\""+"\""+"\""+" "+"\""+getpostcode+"\""+"\""+"\""+" "+"\""+getcity+"\""+"\""+"\""+" "+"\""+gethomephone+"\""+"\""+"\""+" "+"\""+getmobile+"\"");
	    }
		
		//runtime.getRuntime().exec("path to the autoIt exe file");
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = input.readLine()) != null) 
		{
		  System.out.println(line);
		  logger.log(LogStatus.INFO,line);
		  if (line.contains("Student ID:"))
		  {
			  int loc=line.indexOf(":");
			  stuID= line.substring(loc+1);  //Get STudent ID to be used on the Staff and Agent summary pages 			  
		  }
		 // String keyword= "Error:";
		  //Boolean found = Arrays.asList(line.split(" ")).contains(keyword); // To check 'Error' text in the returned lines
		  //System.out.println(found);
		  int exitCode;
		  
			  exitCode = p.waitFor();  //method waitFor() will make the current thread to wait until the external program finishes and returns the exit value.
			  assertEquals(exitCode, 0);   // This will cause the first test case (or calling test case) to fail if the exit code is not 0. 
			  // System.out.println("Exited with error code "+exitVal);
			//  if(found)
			  //{
				//  exceptionerror="true";
				 // errormessage="";
			  //}		    
		  
		 }
		} catch (Exception e) {
			e.getMessage();
	  	}  		
	}
  
  
  
  public void getDriverWindowHandle()    //Method to get the current browser info
  {
	  	winhandlebefore = driver.getWindowHandle(); 
	  // get all the window handles before the popup window appears
	     beforepopup = driver.getWindowHandles();
  }
  public void switchDriver()			//Method to switch to new popup browser
  {
	   // get all the window handles after the popup window appears
	   Set<String> afterPopup = driver.getWindowHandles();

	   // remove all the handles from before the popup window appears
	   afterPopup.removeAll(beforepopup);

	   // there should be only one window handle left
	   if(afterPopup.size() == 1) {
	             driver.switchTo().window((String)afterPopup.toArray()[0]);
	    }	    
  }
  
  public void switchToEarlierDriver() 		//Method to switch back to previous actual application browser
  {
	  driver.close();
	  driver.switchTo().window(winhandlebefore);  
  }  
  
  
  public int getSummaryPageCourseRowNumber(String coursen)
  {
	  int i=1, rownumber=0;
	  String coursename=coursen, id=null;
	 // if (!usertype.equals("Agent")) //|| usertype.equals("Student") || usertype.equals("Student"))
		//  {
		  		id="//table[@id='DataTables_Table_0']/tbody/tr["+i+"]/td";
		  		while(isElementPresent(By.xpath(id)) && (!driver.findElement(By.xpath(id)).getText().equalsIgnoreCase("No information available")))
		  		{		  		  
		  		  id="//table[@id='DataTables_Table_0']/tbody/tr["+i+"]/td[2]";		
		  		  
		  		  if (driver.findElement(By.xpath(id)).getText().equals(coursename)) 
		  		  {
		  			  return i;
		  		  }			 
		  		  i++;
		  		  id="//table[@id='DataTables_Table_0']/tbody/tr["+i+"]/td";
		  		}	  
		  //}	 
	/**  if (usertype.equals("Agent")) 								
		  {
		  		id= "//table[@id='uow-applications']/tbody/tr["+i+"]/td";
		  		while(isElementPresent(By.xpath(id)) && (!driver.findElement(By.xpath(id)).getText().equalsIgnoreCase("No information available")))
		  		{		  		  
		  		  id="//table[@id='uow-applications']/tbody/tr["+i+"]/td[4]";		
		  		  
		  		  if (driver.findElement(By.xpath(id)).getText().equals(coursename)) 
		  		  {
		  			  return i;
		  		  }			 
		  		  i++;
		  		  id="//table[@id='uow-applications']/tbody/tr["+i+"]/td";
		  		}	  
		  }**/
	  //while(!driver.findElement(By.xpath(id)).getText().equals(null))
	  
	  return rownumber;
  }
  
  public int getLinkRowNumberForAgent(String studentID, String coursename) //For this to execute, atleast one call to SITS is required for StuID.
  {
	  int i=1, rownumber=0;
	  String id=null;
	  id= "//table[@id='uow-applications']/tbody/tr["+i+"]/td";
	  while(isElementPresent(By.xpath(id)) && (!driver.findElement(By.xpath(id)).getText().equalsIgnoreCase("No information available")))
	  {		  		  
		 		  if (driver.findElement(By.xpath(id)).getText().equals(studentID) && driver.findElement(By.xpath("//table[@id='uow-applications']/tbody/tr["+(i)+"]/td[4]")).getText().equals(coursename)) 
		  		  {
		  			  return i;
		  		  }
		 		//  else if (driver.findElement(By.xpath("//li[@id='uow-applications_next']/a")).isEnabled()
		  		  i++;
		  		  
		  		  if (i == 11 && driver.findElement(By.id("uow-applications_next")).isEnabled())
		  		  {
		  			driver.findElement(By.xpath("//li[@id='uow-applications_next']/a")).click();
		  			  
		  			//String readonly = driver.findElement(By.id("uow-applications_next")).getAttribute("readonly");
		  			//System.out.print(readonly);
		  			//Assert.assertNull(readonly);  //Checks the value of the String to find out if the textbox is readonly.
		  			i=1; // Reset 'i' as the next page IDs will start from 1  
		  		
		  		  }
		  		id="//table[@id='uow-applications']/tbody/tr["+i+"]/td";
	  }	  
		 
	  //while(!driver.findElement(By.xpath(id)).getText().equals(null))
	  
	  return rownumber;
  }
  
  
  public void agentLogin()
  {
	// Register/Login Page
		 driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).click();
		 assertEquals(driver.findElement(By.cssSelector("p.header-subtitle.sv-hidden-xs")).getText(), "e:Vision");
		 assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Log in to SITS e:Vision Portal");
		 assertEquals(driver.findElement(By.cssSelector("div.sv-page-header.sv-hidden-xs > p")).getText(), "This page is the SITS e:Vision Portal login screen. Please use the form below to supply your login details and click the \"Log in\" button to access the system.");
		 assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Portal Login");
		 assertEquals(driver.findElement(By.cssSelector("label")).getText(), "Username");
		 driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).clear();
		 driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).sendKeys("AGENT"); //provide staff  credentials
		 assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Password");
		 driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).clear();
		 driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).sendKeys("Testing@2");  // provide staff account password
		 assertEquals(driver.findElement(By.linkText("Forgotten your password?")).getText(),"Forgotten your password?");
		 driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS.1\"]")).click();
		 // Home Page
		 assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(),"Home");
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[1]/div/div/h2")).getText(),"Applications");
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div[1]/a")).getText(),"Create account and start a new application");
		 assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/thead/tr/th[1]")).getText(),"Applicant ID");
		 assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/thead/tr/th[2]")).getText(),"Applicant name");
		 assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/thead/tr/th[3]")).getText(),"Date updated or submitted");
		 assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/thead/tr/th[4]")).getText(),"Qualification");
		 assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/thead/tr/th[5]")).getText(),"Status");
		 assertEquals(driver.findElement(By.xpath("//table[@id='uow-applications']/thead/tr/th[6]")).getText(),"Actions"); 
  }
  
  public void studentLogin(String email, String password)
  {
	  // Register/Login Page
	    driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).click();	
	  //  assertEquals(driver.findElement(By.cssSelector("img[alt=\"University of Waikato\"]")).getText(), "");  
	    assertEquals(driver.findElement(By.cssSelector("p.header-subtitle.sv-hidden-xs")).getText(), "MyWaikato"); 
	    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Log in to SITS e:Vision Portal");  
	    assertEquals(driver.findElement(By.cssSelector("div.sv-page-header.sv-hidden-xs > p")).getText(), "This page is the SITS e:Vision Portal login screen. Please use the form below to supply your login details and click the \"Log in\" button to access the system.");
	    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Portal Login");
	    assertEquals(driver.findElement(By.cssSelector("label")).getText(), "Username");
	    driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).clear();
	    driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).sendKeys(email);
	    assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Password");
	    driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).clear();
	    driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).sendKeys(password);
	    assertEquals(driver.findElement(By.linkText("Forgotten your password?")).getText(),"Forgotten your password?");
	    driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS.1\"]")).click();
	    // Applications Summary Page
	    driver.findElement(By.id("PTAD01S")).click();
  }
  
  public void staffNewLogin()
  {
	  
  }
  
  public void staffSearchLogin(String firstn, String lastn, String email, String secondname, String othersecondname, String dob)
  {
	// Register/Login Page
		 driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).click();
		 assertEquals(driver.findElement(By.cssSelector("p.header-subtitle.sv-hidden-xs")).getText(), "e:Vision");
		 assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Log in to SITS e:Vision Portal");
		 assertEquals(driver.findElement(By.cssSelector("div.sv-page-header.sv-hidden-xs > p")).getText(), "This page is the SITS e:Vision Portal login screen. Please use the form below to supply your login details and click the \"Log in\" button to access the system.");
		 assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Portal Login");
		 assertEquals(driver.findElement(By.cssSelector("label")).getText(), "Username");
		 driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).clear();
		 driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).sendKeys("STAFF"); //provide staff  credentials
		 assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Password");
		 driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).clear();
		 driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).sendKeys("Testing@2");  // provide staff account password
		 assertEquals(driver.findElement(By.linkText("Forgotten your password?")).getText(),"Forgotten your password?");
		 driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS.1\"]")).click();
		 // Home Page
		 driver.findElement(By.id("PTAD01P")).click();
		 //Admission and Enrolment page 
		 assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(),"Admission and Enrolment");
		 assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Admission functions");
		 assertEquals(driver.findElement(By.cssSelector("a.sv-list-group-item.sv-list-group-item-overflow")).getText(), "Create account and start a new application");
		 assertEquals(driver.findElement(By.linkText("Student maintenance search")).getText(),"Student maintenance search");
		 //getDriverWindowHandle();
		 driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/a[2]")).click();
		 //switchDriver();  // Staff login results in another window getting opened.
	
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/h1")).getText(),"Applicant/Student Search");
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div/div/div[1]/h2")).getText(),"Search criteria");
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div/div/div[2]/div/div/fieldset/div[1]/label")).getText(),"Student ID");
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div/div/div[2]/div/div/fieldset/div[2]/label")).getText(),"First Name");
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div/div/div[2]/div/div/fieldset/div[3]/label")).getText(),"Surname");
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div/div/div[2]/div/div/fieldset/div[4]/label")).getText(),"Date of Birth");
		 assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div/div/div[2]/div/div/fieldset/div[5]/label")).getText(),"Email");

		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.")).clear();
		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.")).sendKeys(firstn); //provide student first name
		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.3.")).clear(); 
		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.3.")).sendKeys(lastn); //provide student last name
		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.")).clear();
		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.")).sendKeys(dob); //provide student dob
		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.5.")).clear();
		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.5.")).sendKeys(email); //provide student email
		 driver.findElement(By.id("ANSWER.TTQ.MENSYS.7.")).click();  // Click Search
		 if (!driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/h2")).equals("0 Results found"))
		 {
			 if (secondname.equals("") && othersecondname.equals(""))   
			 {
				 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+lastn))
				 {
					 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click();   //Additional validation before clicking on the student id.
				 }			 
			 }
			 else if(!secondname.equals("") && othersecondname.equals(""))
			 {
				 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+secondname+" "+lastn))
				 {
					 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click(); //Additional validation before clicking on the student id.
				 }	
			 }
			 else if (!secondname.equals("") && !othersecondname.equals(""))
			{
				 if (driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equals(firstn+" "+secondname+" "+othersecondname+" "+lastn))
				 {
					 driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click(); //Additional validation before clicking on the student id.
				 }
			}
		 }
		assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/h1")).getText(),"Student Maintenance");
		assertEquals(driver.findElement(By.xpath("//html/body/div[1]/ul/li/a")).getText(),"Applications");
		
	  
  }
  
  public void viewSubmittedCourseDetails(String coursename, String courseyear, String firstn, String secondname, String othersecondname, String lastn, String prevfamilyname, String nstudentnumber, String gender, String residencystatus, String country, String email, String homephone, String mobile, String contactaddressline1, String contactaddressline2, String contactaddressline3, String contactaddressline4, String city, String postcode, String contactcountry, String livinginNZ, String ethnicity1, String ethnicity2, String ethnicity3, String iwi1, String iwi2, String iwi3, String iwi4)
  {
	  //View Application details
	  assertEquals(driver.getTitle(), "View applications full details - MyWaikato");
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div/h1")).getText(), coursename+" "+courseyear);
	  //Personal details
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div/h2")).getText(), "Personal details");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/h3")).getText(), "Identity details");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt")).getText(), "First Name");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[2]")).getText(), "Second/Middle Name(s)");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[3]")).getText(), "Other Second/Middle Name(s)");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[4]")).getText(), "Last Name/Family Name");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[5]")).getText(), "Preferred First Name");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[6]")).getText(), "Previous Family Name");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[7]")).getText(), "Gender");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[8]")).getText(), "Date of Birth");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[9]")).getText(),"National Student Number");	 
	  //new Select(driver.findElement(By.id("IPQ_ADOAP_NID1"))).selectByVisibleText("Other");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[10]")).getText(), "Residency Status");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dt[11]")).getText(), "Country of Citizenship");	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[1]")).getText(),firstn.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[2]")).getText(),secondname.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[3]")).getText(),othersecondname.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[4]")).getText(), lastn.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[5]")).getText(),firstn.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[6]")).getText(), prevfamilyname.toUpperCase());
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[7]")).getText(),gender);	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[8]")).getText(), dob);
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[9]")).getText(),nstudentnumber);     
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[10]")).getText(),residencystatus);
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl/dd[11]")).getText(),country);	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/h3[2]")).getText(), "Other details");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dt[1]")).getText(), "Will you be living in New Zealand for the period of your study?");
	  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dd[1]")).getText(), livinginNZ);
	 
	  //Check Ethnicity  
	  if (!ethnicity2.equals(""))
	  {
		  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dt[2]")).getText(), "Ethnicity");
		  if (!ethnicity3.equals(""))
		  {
			  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dd[2]")).getText(), ethnicity1+"\n"+ethnicity2+"\n"+ethnicity3);
		  }
		  else
		  {
			  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dd[2]")).getText(), ethnicity1+"\n"+ethnicity2);
		  }
		
	  }
	  else
	  {
		  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dd[2]")).getText(), ethnicity1);
	  }
	  
	  // Check iwi
	  if (ethnicity1.equals("New Zealand Maori") || ethnicity2.equals("New Zealand Maori") || ethnicity3.equals("New Zealand Maori"))
	  {
		  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dt[3]")).getText(), "Iwi");
		  
		  if (!iwi2.equals(""))
		  {
			  if (!iwi3.equals(""))
			  {
				  if (!iwi4.equals(""))
				  {
					  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dd[3]")).getText(), iwi1+"\n"+iwi2+"\n"+iwi3+"\n"+iwi4);
				  }
				  else
				  {
					  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dd[3]")).getText(), iwi1+"\n"+iwi2+"\n"+iwi3);
				  }
			  }
			  else
			  {
				  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dd[3]")).getText(), iwi1+"\n"+iwi2);
			  }
			  
		  }
		  else
		  {
			  assertEquals(driver.findElement(By.xpath("//div[@id='uow-personal-details']/div[2]/dl[2]/dd[3]")).getText(), iwi1);
		  }
		  
	   }  
	
	  //Contact details
	  driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]")).click();
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div/h2")).getText(), "Contact details");
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dt[1]")).getText(), "Email");	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dt[2]")).getText(), "Home Phone");
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dt[3]")).getText(), "Mobile");
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dt[4]")).getText(), "Contact Address");	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dd[1]")).getText(), email);
	  //Check if it's non-editable
	  driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dd[1]")).click();  //Click
	  assertFalse(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dd[1]")).isSelected()); //Then verify to see is it's selected
	
	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dd[2]")).getText(), homephone);
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dd[3]")).getText(), mobile);
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[4]/div[2]/dl/dd[4]")).getText(), contactaddressline1.toUpperCase()+"\n"+contactaddressline2.toUpperCase()+"\n"+contactaddressline3.toUpperCase()+"\n"+contactaddressline4.toUpperCase()+"\n"+city.toUpperCase()+", "+postcode+"\n"+contactcountry.toUpperCase());
	  
	//Education details
	  driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]")).click();
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div/h2")).getText(), "Education");
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div[2]/h3")).getText(), "Previous study");
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div[2]/dl/dt[1]")).getText(), "Are you currently in secondary school?");
	/**  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div[2]/dl/dt[2]")).getText(), "What are you currently studying towards?");	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div[2]/dl/dt[3]")).getText(), "Last secondary school attended");	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div[2]/dl/dt[4]")).getText(), "Last year at school");	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div[2]/dl/dt[5]")).getText(), "What is the highest secondary level qualification you have completed?");	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div[2]/dl/dt[6]")).getText(), "Have you previously studied at tertiary level (other than at Waikato University)?");	  
	  assertEquals(driver.findElement(By.xpath("//div[@id='sitspagecontent']/div[5]/div[2]/dl/dt[7]")).getText(), "I agree to NZQA releasing my NCEA results (or equivalent) to Waikato so that they can be used for assessing my eligibility for Waikato scholarships and awards");	  
	  	**/ 
	  
  }
  
@BeforeClass(alwaysRun=true)
	public void setUp() throws Exception 
	{			
	propertyconfig = new ConfigReader(); //Read the Config Property value
	System.setProperty("webdriver.gecko.driver", propertyconfig.getGeckoPath());  //gecko is required for Selenium 3
	System.setProperty("webdriver.chrome.driver", propertyconfig.getChromePath());
	driver = new ChromeDriver();
	//driver = new InternetExplorerDriver();
	
		//report = new ExtentReports(System.getProperty("user.dir")+ propertyconfig.getReportPath()); //Set the HTML Execution Report Path. Putting another parameter TRUE will overwrite the file everytime.
		ReportScreenshotUtility.GetExtent();
		//ScreenshotUtility.report.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml")); //Load the config settings frot he report from xml.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver = new InternetExplorerDriver();
	    //baseUrl = "http://www.waikato.ac.nz/";
		//driver = new FirefoxDriver();	 
	
	}


@AfterClass(alwaysRun=true)
 	public void tearDown() throws Exception 
 	 {	
	 
	  	StringBuffer verificationErrors = new StringBuffer();  
	  	//ScreenshotUtility.report.close();
 	    driver.quit();
 	    String verificationErrorString = verificationErrors.toString();
 	    if (!"".equals(verificationErrorString)) {
 	      AssertJUnit.fail(verificationErrorString);
 	    }
 		//System.out.print("##################Setup ##################");  
 	 
 	  }
  
 
 
}
