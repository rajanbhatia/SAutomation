import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TEADailyRun {
	//Story# 13867:	//1. A domestic applicant who has done Bachelor of Science at a New Zealand university, now applying for BA at UoW, CCLs mentioned below generated automatically when the application is Tran'd:
							// a Evidence of graduation for completed Tertiary qualifications
							// b Tertiary Academic Records (including Grading Scale)
							// c University admission CCL
				    //2. The status of all clearance checks generated is �Not Checked�
	// Courses: Bachelor of Science (New); Bachelor of Arts (Existing)	
	
	public WebDriver driver;
	public ConfigReader propertyconfig;
	public ExtentTest logger;	//Main class to generate the Logs and add to the report
	String errormessage, exceptionerror, stuID="";
	LocalDate localDate = new LocalDate(); ///getdate	
	Login lgn;
	QualSearch qsearch;
	PersonalDetailsPage pdpage;
	//SoftAssert softAssert = new SoftAssert(); 
	WebDriverWait wait;
	
	@Test(dataProvider = "ParamData")
	public void AutoTEAWorkflow(String flag, String getfirstn, String getlastn,String getsecondname,String getothersecondname,String getprevfamilyname, String getdob, String getnstudentnumber, String getemail, String getremail, String getpassword,  String getrpassword, String getqualsearchtype, String getcoursename, String getresidencystatus, String getcountry, String getcontactcountry, String getlivinginNZ, String getethnicity1, String getethnicity2, String getethnicity3, String getiwi1, String getiwi2, String getiwi3, String getiwi4, String gethomephone, String getmobile, String getcontactaddressline1,String getcontactaddressline2,String getcontactaddressline3,String getcontactaddressline4, String getcity, String getpostcode, String getcurrentlyatsecondaryschool, String getcurrentlystudyingtowards, String getagreeNZQAresultscheckbox, String getlastsecschool, String getlastschoolyear, String gethighsecqual, String getprevtertiarystudyatuniv,String getfirstenrolter, String getinstitutiontype, String getinstitutionname, String getoverseasinstitutioncountry, String getqualificationtype, String getqualname, String getyearfrom, String getyearto, String getgender, String getcompletequal, String getanyotherqual) {
	try {		
		String courseyear, livinginNZcode=null, currentlyatsecondaryschoolcode=null, prevtertiarystudyatunivcode=null, completequalcode="", anyotherqualcode="";		
		
		exceptionerror="false";
		Calendar cal = Calendar.getInstance();
		if (flag.equals("New")) //No need to change for the existing student
		{			
			if (getemail.equals(getremail))
				{
					getemail=mData(getemail,cal);  //change data
					getremail=getemail;  //no need to call the function again and a test case was failing with different data values.
				}
			else 	
				{
					getemail=mData(getemail,cal);
					getremail=mData(getremail,cal); 
				}
			getfirstn=mData(getfirstn,cal);
			getlastn=mData(getlastn,cal);
		}
		System.out.println(getlastn+", "+getemail);
		logger = ReportScreenshotUtility.report.startTest("AutoTEAWorkflow - "+getemail);
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
		//callSITS("assessment", getfirstn, getlastn, getemail, getdob, coursename, contactcountry, "2018", coursemonth, flag);
		//Login
		Thread.sleep(2000);
		lgn=new Login();
		lgn.login(driver, propertyconfig,flag, getpassword, getrpassword, getemail, getremail, getfirstn, getsecondname, getothersecondname, getlastn, getdob); // call the method
		
		if (flag.equals("Existing"))
		{
   	 	// Applications Summary Page
		    driver.findElement(By.id("PTAD01S")).click();
		    driver.findElement(By.linkText("Start a new application")).click();
		    System.out.println("Email: "+getemail);
		}
	    /// Qualification Search & Selection
		qsearch = new QualSearch();
		Object courseoptions[][] = qsearch.qualSearchSelection(driver, qualsearchtype, coursename); //call the function
		Thread.sleep(500);
	    courseyear=(String)courseoptions[0][0];
	    courseintake= (String)courseoptions[0][1];
	    if(courseintake.contains(" "))
	    {
	        coursemonth = courseintake.substring(0, courseintake.indexOf(" ")); 
	    }
	    Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(coursemonth);
	    //Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    int month1 = cal.get(Calendar.MONTH);     // To use this for Age verification in the ACD screen, once exact course start dates will appear.
	    month1++;
	    if (month1<10)    coursemonth="0"+month1;  //to check in SITS
	    else coursemonth=""+month1;
	    
	    // Location and subject selection	    
/**	    if (coursename.equals("Bachelor of Business"))
	    {	    	
	    	assertEquals(driver.findElement(By.xpath("//*[@id='app_form']/div/div[2]/div/div/fieldset/div/label")).getText(), "Major*");
	    	assertEquals(driver.findElement(By.xpath("//*[@id='app_form']/div/div[2]/div/div/fieldset[2]/div/label")).getText(), "Where do you want to study?*");
	    	new Select(driver.findElement(By.id("IPQ_ADOAP_MAJ1"))).selectByVisibleText("Digital Business (Hamilton only)");
	    }**/
	    
	    assertEquals(driver.findElement(By.xpath("//*[@id='app_form']/div/div[2]/div/div/fieldset/div/label")).getText(), "Where do you want to study?*");		    
	    
	    new Select(driver.findElement(By.id("IPQ_ADOAP_LCA"))).selectByVisibleText("Hamilton"); //Hamilton location
	    assertEquals(driver.findElement(By.xpath("//*[@id='app_form']/div/div[1]/h2")).getText(), "Location and subject selection");
	    driver.findElement(By.id("app-btn-next")).click();
	    Thread.sleep(500);
	    // Personal Details Page  
	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/p")).getText(), "Logged in as: "+ getfirstn+" "+ getlastn);
	    pdpage = new PersonalDetailsPage();
	    pdpage.personalDetails(driver, livinginNZ, livinginNZcode, flag, getprevfamilyname, gender, getnstudentnumber, residencystatus, country, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2, iwi3, iwi4); // call the method
   		driver.findElement(By.id("app-btn-next")).click();
	
   		//Call Client to validate if the data is retrievable prior to saving or exiting
   		//	temp if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent")) /// need to revisit this statement as migrated data won't be in the IPR and IPRQ screens 
   		// temp if (usertype.equals("Student") || usertype.equals("Staff_New") || usertype.equals("Agent"))  this.executeScript("beforesubmission",firstn, lastn, email, dob, null, null, null, country, coursename, null, null, null, null, gender, "", null, null, null, null, null, null, livinginNZcode, nstudentnumber, prevfamilyname, secondname, othersecondname, null, null, null, null, null, null, null, null, null, null, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2, iwi3, iwi4, residencystatus, courseyear, coursemonth);
   
   		// Contact Details
		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div/div/input")).getAttribute("value"), getemail);
		//assertFalse(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/div/div/input")).isEnabled());
   
		if (flag.equals("New"))
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
    
	    driver.findElement(By.id("app-btn-next")).click();
	    // 	Education Page
    
	    if (flag.equals("New"))
	    {
		    if(currentlyatsecondaryschool.equalsIgnoreCase("Yes"))
		    {
		    	driver.findElement(By.id("ADOAP_EDSSQ1")).click();
		    	currentlyatsecondaryschoolcode="Y";
		   
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
	         
		    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']")).click();
		    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input")).sendKeys(lastsecschool);
		    driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDLSCL_chosen']/div/div/input")).sendKeys(Keys.RETURN);
		    new Select(driver.findElement(By.id("IPQ_ADOAP_EDLSTY"))).selectByVisibleText(lastschoolyear);   
		    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[6]/label")).getText(),"What is the highest secondary level qualification you have completed?*"); 
		    new Select(driver.findElement(By.id("IPQ_ADOAP_EDHQAL"))).selectByVisibleText(highsecqual);
		    if (highsecqual.equals("Overseas Qualification"))
		    {
		    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[7]/label")).getText(),"What qualification did you complete?*");
	    		driver.findElement(By.id("IPQ_ADOAP_EDQC")).sendKeys("Higher School Certificate");
		    }
	    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[8]/p")).getText(),"Have you previously studied at tertiary level ( other than at the University of Waikato )?*");    
	     
		    //	Story# 10043 (As an applicant (general), I need a mechanism to provide details of any previous tertiary study I may have completed in order to apply to the University.)
		    if(prevtertiarystudyatuniv.equalsIgnoreCase("Yes"))
		    {
		    	driver.findElement(By.id("ADOAP_EDPTS1")).click();
		    	prevtertiarystudyatunivcode="Y";
		    	//Reference Check : HIST04	Evidence of graduation for completed tertiary qualifications	STU	STU	Which year did you first enrol in tertiary study = populated //
		    	//Reference Check : HIST03	Tertiary academic records (including grading scale)	STU	STU	Which year did you first enrol in tertiary study = populated
		    	//Both Clearance checks depend upon the below question to be populated
		    	assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[9]/label")).getText(),"Which year did you first enrol in tertiary study?*");    	 
		    	new Select(driver.findElement(By.id("IPQ_Which year did you first enrol in tertiary study"))).selectByVisibleText(firstenrolter); 
		    	if (residencystatus.equals("NZ Citizen") || residencystatus.equals("NZ Permanent Resident") ||  residencystatus.equals("Cook Islands") || residencystatus.equals("Niue") || residencystatus.equals("Tokelau") || (residencystatus.equals("Australian Citizen") && livinginNZ.equalsIgnoreCase("Yes")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && livinginNZ.equals("Yes")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && livinginNZ.equalsIgnoreCase("Yes")))
		     	{ // Domestic only
			    	assertEquals(driver.findElement(By.xpath("//*[@id='app_form']/div/div[2]/div/div/fieldset/div[11]/p")).getText(),"Have you studied at an institution that has a credit or pathway arrangement with us?*");
			    	driver.findElement(By.id("ADOAP_CRPTH2")).click();
		    	}

		    	
		    	new Select(driver.findElement(By.id("IPQ_ADOAP_EDIT"))).selectByVisibleText(institutiontype);    	 
		    	driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDIN_chosen']")).click();
		    	driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDIN_chosen']/div/div/input")).sendKeys(institutionname);
		    	driver.findElement(By.xpath("//div[@id='IPQ_ADOAP_EDIN_chosen']/div/div/input")).sendKeys(Keys.RETURN);
	    	
		    	if (institutionname.equals("Overseas Teachers College") || institutionname.equals("Overseas Technical Institute") || institutionname.equals("Overseas University"))
		    	{
	    		 		assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[3]/label")).getText(), "Country of Institution*"); 
	    		 		new Select(driver.findElement(By.id("IPQ_ADOAP_EDIC"))).selectByVisibleText(overseasinstitutioncountry);  //Institution country name
		    	}
	    	 	    	    	
		    	new Select(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[4]/div/select"))).selectByVisibleText(qualificationtype);    	 
	    	   	driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[5]/div/input")).clear();
		    	driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset[3]/div[5]/div/input")).sendKeys(qualname);    	  
		    	new Select(driver.findElement(By.id("IPQ_ADOAP_EDYF"))).selectByVisibleText(yearfrom);
		    	    	    	
		    	if (!yearto.equals(""))    	 new Select(driver.findElement(By.id("IPQ_ADOAP_EDYT"))).selectByVisibleText(yearto);
		    	    
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
	    }
	    driver.findElement(By.id("app-btn-next")).click();
	  
	    // temp this.executeScript("beforesubmission", firstn, lastn, email, dob, city, postcode, mobile, country, coursename, contactaddressline1, contactaddressline2, contactaddressline3, contactaddressline4, gender, contactcountry, homephone, completequalcode, qualname, yearfrom, yearto, firstenrolter, livinginNZcode, nstudentnumber, prevfamilyname, secondname, othersecondname, anyotherqualcode, prevtertiarystudyatunivcode, currentlyatsecondaryschoolcode, currentlystudyingtowards, highsecqual, institutionname, institutiontype, qualificationtype, lastsecschool, lastschoolyear, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2, iwi3, iwi4, residencystatus, courseyear, coursemonth);
	    Thread.sleep(500);	      
	    if (residencystatus.equals("Other") || (residencystatus.equals("Australian Citizen") && livinginNZ.equalsIgnoreCase("No")) || (residencystatus.equalsIgnoreCase("Australian Permanent Resident") && livinginNZ.equals("No")) || (residencystatus.equalsIgnoreCase("Australian and NZ Permanent Resident") && livinginNZ.equalsIgnoreCase("No")))
	    {
	    //Additional Info Page
	  
	    	driver.findElement(By.id("ADOAP_INTAG1_4")).click();
	    	driver.findElement(By.id("app-btn-next")).click();
	    }
	    Thread.sleep(500);
	    //Documents page
	    driver.findElement(By.id("app-btn-next")).click();
	    // Declaration Page	    
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div/p")).getText(), "I declare that the information I have provided in this application and in any attached documentation is true and correct, and that I have not withheld any information which could have a bearing on my application, enrolment or the conditions of my enrolment. I agree to supply any further documentation requested by the University of Waikato for the purpose of my application or enrolment.\nI have read the statement regarding the Privacy Act 1993 and I understand that the University of Waikato will hold, use and disclose information which I have provided as explained in that statement.\nI also understand that I have the right to have access to the information about me held by the University of Waikato and to request correction of that information, in the terms provided for under the Privacy Act 1993.\nSome personal information will be used by the Ministry of Education in an authorised information matching programme for the purposes of the National Student Index.");    
	    driver.findElement(By.id("ADOAP_DECC")).click();
	    assertEquals(driver.findElement(By.xpath("//form[@id='app_form']/div/div[2]/div/div/fieldset/div[2]/div/div/label/strong")).getText(),"I have read and agreed to the above declaration.*");
        driver.findElement(By.xpath("//button[@id='app-btn-next']")).click();
        Thread.sleep(1000);
	    // 	Confirmation Page     
	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/ol/li[2]")).getText(), coursename + " " + courseyear);
	    assertEquals(driver.findElement(By.xpath("//div/div/p")).getText(), "Logged in as: "+getfirstn+" "+getlastn);
	    assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Your application has been submitted");
	    Thread.sleep(3000);
    // Check Studylink link for Story# 10050 (Residency status- All but not 'Other')
            
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow |  | ]]
    
    driver.findElement(By.cssSelector("li > a")).click();
    // My Applications (Summary) Page
    // //Story#10287 (AC:1 [Submitted], 2 - qual name and occurance)
    //this.executeScript();
      
    //assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[4]")).getText(), "Submitted");
    assertEquals(driver.findElement(By.id("PTAD01S")).getText(), "Qualifications and Papers");  
    assertEquals(driver.findElement(By.id("sitsportalpagetitle")).getText(), "Qualifications and Papers");
    //assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Qualifications overview");  
    //assertEquals(driver.findElement(By.linkText("Start a new application")).getText(), "Start a New Application");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/thead/tr/th[1]")).getText(), "Year");
    										  
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/thead/tr/th[2]")).getText(), "Qualification");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/thead/tr/th[3]")).getText(), "Submitted");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/thead/tr/th[4]")).getText(), "Status");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/thead/tr/th[5]")).getText(), "Actions");    
   
    courserownumber=getSummaryPageCourseRowNumber(coursename);  //get the courserownumber
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+courserownumber+"]/td")).getText(), courseyear);
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+courserownumber+"]/td[2]")).getText(), coursename);    
	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+courserownumber+"]/td[3]")).getText(), localDate.toString("dd/MMM/yyyy"));  //submitted date
	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+courserownumber+"]/td[5]/a")).getText(), "View");
	
	//assertEquals(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[5]/a[2]")).getText(), "Withdraw");
    //submitdate = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[3]")).getText();
	
    callSITS("assessment", getfirstn, getlastn, getemail, getdob, coursename, contactcountry, courseyear, coursemonth, flag,currentlystudyingtowards); //currentlystudyingtowards to test the auto Conditional offer for the NCEA Level 3 studying student
    //  Applications summary page
    driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/a")).click();
    driver.findElement(By.linkText("Logout")).click();  //Logout to view the offer
        
    //Login
 	lgn.login(driver, propertyconfig, "Existing", getpassword, getrpassword, getemail, getremail, getfirstn, getsecondname, getothersecondname, getlastn, getdob);
    driver.findElement(By.linkText("Qualifications and Papers")).click();
    courserownumber=getSummaryPageCourseRowNumber(coursename);  //get the courserownumber
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+courserownumber+"]/td[5]/a[2]")).getText(), "Respond to offer");
    									
    driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+courserownumber+"]/td[5]/a[2]")).click();   //Click on Respond to offer
    
    //Respond to offer page
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/h1")).getText(), "Respond to offer");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[1]/h2")).getText(), "About your offer");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/p[1]")).getText(), "Congratulations on your offer from the University of Waikato for the "+coursename+".");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/p[3]")).getText(), "To accept your offer please select the Accept button below. If you do not wish to accept a place at the University, please select the Decline button to inform us of your decision.");
    if (currentlystudyingtowards.equalsIgnoreCase("NCEA Level 3 Certificate"))
    {
    	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/p[2]/strong[1]")).getText(), "Conditional Offer");
    	driver.findElement(By.xpath("//*[@id='ANSWER.TTQ.MENSYS.4.']")).click();   //Click to Accept the offer
    }
    else
    {
    	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/p[2]/strong[1]")).getText(), "Unconditional Offer");
    	 driver.findElement(By.xpath("//*[@id='ANSWER.TTQ.MENSYS.3.']")).click();   //Click to Accept the offer
    }   
   
 
    //Offer confirmation page
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[1]/h2")).getText(), "Offer accepted");
    assertEquals(driver.findElement(By.xpath("/html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/div/p[1]")).getText(), "Thanks for accepting your Offer of Place to the "+coursename+" for 2018.");
    										
  /**  assertEquals(driver.findElement(By.xpath("/html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/div/p[2]")).getText(), "You can now choose papers and complete your enrolment.");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/p[3]")).getText(), "If you wish to find out more about the student experience at the University please click here.");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/p[4]")).getText(), "If you are an international applicant and would like additional information about studying abroad please click here.");**/
    driver.findElement(By.name("SAVEX.DUMMY.MENSYS.1")).click();   //Exit
    //Application Summary page//
    
    // Call SITS again to check the data
    //  this.callSITS("assessment", getfirstn, getlastn, getemail, getdob, city, postcode, mobile, country, coursename, contactaddressline1, contactaddressline2, contactaddressline3, contactaddressline4, gender, contactcountry, homephone, completequalcode, qualname, yearfrom, yearto, firstenrolter, livinginNZcode, getnstudentnumber, getprevfamilyname, getsecondname, getothersecondname, anyotherqualcode, prevtertiarystudyatunivcode, currentlyatsecondaryschoolcode, currentlystudyingtowards, highsecqual, institutionname, institutiontype, qualificationtype, lastsecschool, lastschoolyear, ethnicity1, ethnicity2, ethnicity3, iwi1, iwi2, iwi3, iwi4, residencystatus, courseyear, coursemonth);
    this.callSITS("after_acceptance", getfirstn, getlastn, getemail, getdob, coursename, contactcountry, courseyear, coursemonth, flag,currentlystudyingtowards);
    
    //ENROLMENT
    lgn.login(driver, propertyconfig,"Existing", getpassword, getrpassword, getemail, getremail, getfirstn, getsecondname, getothersecondname, getlastn, getdob); // call the method
    driver.findElement(By.id("PTAD01S")).click(); //click 'Qualifications and Papers' link
    Thread.sleep(2000);
    //Qualifications and Papers
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[1]/h3")).getText(), coursename);
    driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[3]/div/div/a")).click(); //click 'Complete enrolment' button
   
    //Qualification Selection page
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[1]/h2")).getText(), "Select the qualification(s) you would like to enrol in");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[2]/div/div/fieldset/div/div/div/label")).getText(), coursename);
    driver.findElement(By.id("ANSWER.RECPICKER.MENSYS.1-2")).click(); //click checkbox
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.")).click(); //click 'Next' button
    //Enrolment Welcome Page
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[1]/h2")).getText(), "Welcome to your enrolment "+ getfirstn + " " +getlastn);
        
	WebElement completeNowButtonPersonal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[1]/div/div[2]/a")));
    completeNowButtonPersonal.click();
	//driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[1]/div/div[2]/a")).click(); //click 'Complete now' button for Personal details
    							
    //Review Personal Details
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div/div/div/div[1]/h2")).getText(), "Check and confirm your personal details");
    assertEquals(driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.")).getAttribute("Value"), getfirstn.toUpperCase());
    
    if(livinginNZ.equalsIgnoreCase("Yes"))
    {
    	assertTrue(driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.1")).isSelected());    	
    }
    else
    {	
    	assertTrue(driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.2")).isSelected());    	
    }
    assertEquals(new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.5."))).getFirstSelectedOption().getText(),ethnicity1); // To validate the selected dropdown value
    
    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click(); //click 'Next' button
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[1]/div/div[2]/a")).getText(), "Review");    
    driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[2]/div/div[2]/a")).click(); //click 'Complete now' button for Contact Details
    
    //Review Contact Details
    assertEquals(driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.")).getAttribute("Value"), contactaddressline1.toUpperCase());
   
    assertEquals(driver.findElement(By.id("ANSWER.TTQ.MENSYS.8.")).getAttribute("Value"), city.toUpperCase());    
    assertEquals(driver.findElement(By.id("ANSWER_TTQ_MENSYS_10__chosenspan")).getText(),contactcountry); 
    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click(); //click 'Update' button on the Contact Details
    Thread.sleep(1000);
    //Emergency contact details
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div/div/div/div[1]/h2")).getText(), "Your emergency contact details");
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.1.")).sendKeys("EFname"); //Emergency first name
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.")).sendKeys("ELName"); //Emergency last name
    new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.3."))).selectByVisibleText("Legal guardian");
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.1")).click(); // Yes, speak english
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.6.")).sendKeys("123987456"); //Emergency Phone number
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.7.")).sendKeys("email@fake.com"); //Emergency Email
    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click(); //Click Update button
    
    //Back to Enrolment page
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/p")).getText(), "Emergency contact updated");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[2]/div/div[2]/a")).getText(), "Review");
    driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[3]/div/div[2]/a")).click(); //click 'Complete now' button for Annual questions
    Thread.sleep(500);
    //Annual Questions
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/h1")).getText(), "Annual Questions");
    new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.1."))).selectByVisibleText("Polytechnic student");
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.1")).click(); //Yes
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.3.1")).click(); //Full-time
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.4.1")).click(); //Disability yes
    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click(); // click Next
 
    //Back to Enrolment page
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/p")).getText(), "Annual questions submitted");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[3]/div/div[2]/a")).getText(), "Review");
    driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[4]/div[2]/div[2]/a")).click();  // click Confirm button 
    
    //Subject Selection
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/h1")).getText(), "Subject Selection");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div/div/div/div[2]/div/div/fieldset/div/label")).getText(), "Major*");
    //new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.2."))).selectByIndex(1); // select the first element
    if (coursename.equals("Bachelor of Business"))		new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.2."))).selectByVisibleText("Digital Business (Hamilton)"); // select major for Bachelor of Business
    else if (coursename.equals("Bachelor of Arts"))		new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.2."))).selectByVisibleText("Economics (Hamilton)"); // select major for Bachelor of Arts
    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click(); // click Next
    
    //Back to Enrolment page
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/p")).getText(), "Subject selections confirmed");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[4]/div[2]/div[2]/a")).getText(), "Review");
    driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[5]/div/div[2]/a")).click();  // click Complete Now button 
   
    //Paper Selection page
    driver.findElement(By.xpath("/html/body/div[1]/form/div[2]/div[2]/a")).click(); // Add papers 
    							
    //Pre Paper Selection page
    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click(); // click Next  
    
    //Select papers
    assertEquals(driver.findElement(By.xpath("//*[@id='sitspagecontent']/div[1]/h1")).getText(), "Paper Selection");
    assertEquals(driver.findElement(By.xpath("//*[@id='sme_spr_block']/div/div/div/div[2]/div/div/fieldset/div/div/p")).getText(), coursename);
  
    //Paper selection    
    //driver.findElement(By.id("sme_global_search_box")).sendKeys("music"); //Global search text
    driver.findElement(By.id("sme_view_list_button_001")).click(); //click View List
    //driver.findElement(By.xpath("//*[@id='sme_search_link001']")).click(); //Show Advanced option
    ///driver.findElement(By.id("sme_search_box001")).sendKeys("music");
    //new Select(driver.findElement(By.id("sme_search_advanced001_field1"))).selectByVisibleText("Location");
    //driver.findElement(By.id("sme_search_advanced001_value1")).sendKeys("HAM");
    driver.findElement(By.id("sme_search_button001")).click(); //Paper Search
    Thread.sleep(500);
    if (coursename.equals("Bachelor of Business"))
    {
    	driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[1]/td[6]/button")).click();  //Add first paper
        Thread.sleep(1000);	
    }
    else if (coursename.equals("Bachelor of Arts"))
    {
    	driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[1]/td[6]/button")).click();  //Add first paper
        Thread.sleep(1000);	
        driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[4]/td[6]/button")).click();  //Add fourth paper
        Thread.sleep(1000);
    }

    //driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[1]/td[6]/button")).click();  //Add first paper
    //Thread.sleep(1000);			
    //driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[2]/td[6]/button")).click();  //Add second paper
    //Thread.sleep(1000);
    //driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[3]/td[6]/button")).click();  //Add third paper
    //Thread.sleep(1000);
   // driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[4]/td[6]/button")).click();  //Add fourth paper
    //Thread.sleep(1000);
    //driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[5]/td[6]/button")).click();  //Add fifth paper
    //Thread.sleep(1000);
    //driver.findElement(By.xpath("//*[@id='sme_search_results_grid001']/tbody/tr[6]/td[6]/button")).click();  //Add sixth paper
    //Thread.sleep(1000);    
    driver.findElement(By.id("sme_submit_button")).click(); // click Submit Selections button
    
    //Confirmed Papers
    WebElement confirmedPapersText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/form/div[1]/h1")));
    //assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/h1")).getText(), "Confirmed Papers");
    assertEquals(confirmedPapersText.getText(), "Confirmed Papers");
    driver.findElement(By.name("BP108.DUMMY_B.MENSYS.1")).click(); //Click Next
    Thread.sleep(1000);
    //Review your selection
    /**
    WebElement reviewSelectionsText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[1]/h2")));
    																								
    //assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div/div/div[1]/h2")).getText(), "Review your selections");
    assertEquals(reviewSelectionsText.getText(), "Review your selections");**/
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.3.")).click(); //click Confirm Selections
    
    //Enrolment Declaration
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/h1")).getText(), "Enrolment Declaration");  
    driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.")).click();	//click declaration checkbox
    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click();	//Click Submit button
    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click();	//Click Next button on the What to expect next
    
    //Paper selections confirmed
    WebElement paperSelectionsConfirmedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[1]/p")));
    //assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/p")).getText(), "Paper selections confirmed");
    assertEquals(paperSelectionsConfirmedText.getText(), "Paper selections confirmed");
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[4]/div/div/div[4]/div/div/div[2]/div[1]/div/h3")).getText(), courseyear);
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[4]/div/div/div[4]/div/div/div[2]/div[1]/h3")).getText(), coursename);
    if (coursename.equals("Bachelor of Business"))
    {
    	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[4]/div/div/div[4]/div/div/div[2]/div[1]/small")).getText(), "Major : Digital Business");
    }
    else if(coursename.equals("Bachelor of Arts"))
    {
    	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[4]/div/div/div[4]/div/div/div[2]/div[1]/small")).getText(), "Major : Economics");
    } 
    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[4]/div/div/div[4]/div/div/div[2]/div[2]/small")).getText(), "Status: Pending approval");
    
    //Login as a staff
	    lgn.loginStaff(driver, propertyconfig, "testuser", "Testing@2");
	    driver.findElement(By.xpath("//*[@id='PTAD01P']")).click(); //click 'Admission and Enrolment' link
	    driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div[2]/div[4]/a")).click(); //click 'Enrolment approval search' link
	    
	    //Enrolment Approval Search page
	    driver.findElement(By.id("ANSWER.TTQ.MENSYS.1.")).clear();
	    driver.findElement(By.id("ANSWER.TTQ.MENSYS.1.")).sendKeys(stuID);
	    
	    new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.6."))).selectByVisibleText("Pending approval"); 
	    new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.10."))).selectByVisibleText("2018");
	    driver.findElement(By.id("ANSWER.TTQ.MENSYS.15.")).click();	//click Search button
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[1]/a[2]")).click(); //click on StuID

	    //Enrolment Approval
	    assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/dl/dd[1]")).getText(), stuID);	    										
	  
	   
	    
	    if (coursename.equals("Bachelor of Business"))	// 1 paper
	    {
	    	driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div[4]/table/tbody/tr[1]/td[10]/a[1]/i")).click(); //tick the papers
	 	    Thread.sleep(1500);
	    	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div[4]/table/tbody/tr[1]/td[9]/span")).getText(), "Approved"); //Papers approved
		    //assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div[4]/table/tbody/tr[2]/td[9]/span")).getText(), "Approved"); //Papers approved
	    }
	    else if(coursename.equals("Bachelor of Arts")) // 2 papers
	    {
	    	driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div[4]/table/tbody/tr[1]/td[10]/a[1]/i")).click(); //tick the papers
	    	Thread.sleep(1500);
	    	driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div[4]/table/tbody/tr[2]/td[10]/a[1]/i")).click();//tick the papers
		    Thread.sleep(1500);
	    	assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div[4]/table/tbody/tr[1]/td[9]/span")).getText(), "Approved"); //Papers approved
		    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/form/div[1]/div[4]/table/tbody/tr[2]/td[9]/span")).getText(), "Approved"); //Papers approved
	    } 
	    
	    driver.findElement(By.id("ANSWER.TTQ.MENSYS.5.")).click(); //click Approve
	    
	    //Confirm
	    driver.findElement(By.name("NEXT.DUMMY.MENSYS.1")).click(); //click Confirm Decision
	    
	    //Enrolment approved
	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/p")).getText(), "Enrolment approved"); 
    
	//Login as a student
	    lgn.login(driver, propertyconfig,"Existing", getpassword, getrpassword, getemail, getremail, getfirstn, getsecondname, getothersecondname, getlastn, getdob); // call the method
	    driver.findElement(By.id("PTAD01S")).click(); //click 'Qualifications and Papers' link
	    if (currentlystudyingtowards.equalsIgnoreCase("NCEA Level 3 Certificate"))   // Student getting conditional offer only and no option to accept as results are not in yet.
	    {
	    	assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/small")).getText(), "Status: Enrolment approved - conditional");
	    }
	    else
	    {
	    	assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/small")).getText(), "Status: Enrolment approved - unconditional");
	    	driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[3]/div/div/a")).click(); //click Complete Enrolment
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	    	WebElement completeNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[6]/div/div[2]/a")));
	    	completeNowButton.click();	//Click Complete now
	    	//driver.findElement(By.xpath("//html/body/div[1]/form/div[2]/div[2]/section[6]/div/div[2]/a")).click();  //Click Complete now
	  	   	  	    	  	    
	  	    //Offer of Enrolment
	  	    driver.findElement(By.id("ANSWER.TTQ.MENSYS.2.1")).click();  //accept the terms
	  	    new Select(driver.findElement(By.id("ANSWER.TTQ.MENSYS.4."))).selectByVisibleText("Student Loan"); //Payment option
	  	    driver.findElement(By.id("ANSWER.TTQ.MENSYS.8.")).click(); //Confirm button
	  	    Thread.sleep(1000);
	  	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/p")).getText(), "Enrolment Agreement accepted"); 
	  	    driver.findElement(By.id("PTAD01S")).click(); //click 'Qualifications and Papers' link
	  	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[3]/div/div[2]/div/table/tbody/tr[1]/td[8]/span")).getText(), "Enrolled"); //check 2 papers 
	  	    assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[3]/div/div[2]/div/table/tbody/tr[2]/td[8]/span")).getText(), "Enrolled"); //check 2 papers
	    }
	    
	  	  
	    
    System.out.println("TEA - Smoke Workflow test case executed - "+getemail);
    System.out.println("--------------------------------------------------");
    logger.log(LogStatus.INFO,"TEA - Smoke Workflow test case executed");
    //assertAll();
	  } catch (Exception e) {
	      System.out.println("Error:"+e.getMessage());
	      exceptionerror="true";
	      errormessage=e.getMessage();}
  }
	
	public void callSITS(String getstage, String getfirstn, String getlastn, String getemail, String getdob, String getcoursename, String getcontactcountry, String getcourseyear, String getcoursemonth, String flag, String currentlystudyingtowards) throws IOException	{
	  	try{		
		Runtime runtime = Runtime.getRuntime();
		String scriptpath=propertyconfig.getSmokeWorkflowScriptPath();
		Process p = null;
		//Process pstu = null;
		//if (!getcountry.equalsIgnoreCase(null))	
			///Get Created/submitted date, if form submitted		   
		  //  LocalDate localDate = LocalDate.now();		    	    ///		 
	//	    	System.out.println("Script: "+scriptpath+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getemail+"\""+" "+"\""+getdob+"\""+" "+"\""+getcity+"\""+" "+"\""+getpostcode+"\""+" "+"\""+getmobile+"\""+" "+"\""+getcountry+"\""+" "+"\""+getcoursename+"\""+" "+"\""+getcontactaddressline1+"\""+" "+"\""+getgender+"\""+" "+"\""+countrycode+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+gethomephone+"\""+" "+"\""+getcontactaddressline2+"\""+" "+"\""+getcontactaddressline3+"\""+" "+"\""+getcontactaddressline4+"\""+" "+"\""+currentlystudyingtowardscode+"\""+" "+"\""+getcompletequalcode+"\""+" "+"\""+highsecqualcode+"\""+" "+"\""+institutionnamecode+"\""+" "+"\""+institutiontypecode+"\""+" "+"\""+qualificationtypecode+"\""+" "+"\""+lastsecschoolcode+"\""+" "+"\""+lastschoolyearcode+"\""+" "+"\""+getqualname+"\""+" "+"\""+getyearfrom+"\""+" "+"\""+getyearto+"\""+" "+"\""+getfirstenrolter+"\""+" "+"\""+ethnicity1code+"\""+" "+"\""+ethnicity2code+"\""+" "+"\""+ethnicity3code+"\""+" "+"\""+iwi1code+"\""+" "+"\""+iwi2code+"\""+" "+"\""+iwi3code+"\""+" "+"\""+iwi4code+"\""+" "+"\""+getlivinginNZcode+"\""+" "+"\""+residencystatuscode+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+getprevfamilyname+"\""+" "+"\""+getsecondname.toUpperCase()+"\""+" "+"\""+getothersecondname.toUpperCase()+"\""+" "+"\""+getanyotherqualcode+"\""+" "+"\""+getprevtertiarystudyatunivcode+"\""+" "+"\""+getcurrentlyatsecondaryschoolcode+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\"");  //dtf.format(localDate)
	//	    	p = runtime.exec(scriptpath+" "+"\""+getfirstn+"\""+" "+"\""+getlastn+"\""+" "+"\""+getemail+"\""+" "+"\""+getdob+"\""+" "+"\""+getcity+"\""+" "+"\""+getpostcode+"\""+" "+"\""+getmobile+"\""+" "+"\""+getcountry+"\""+" "+"\""+getcoursename+"\""+" "+"\""+getcontactaddressline1+"\""+" "+"\""+getgender+"\""+" "+"\""+countrycode+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+gethomephone+"\""+" "+"\""+getcontactaddressline2+"\""+" "+"\""+getcontactaddressline3+"\""+" "+"\""+getcontactaddressline4+"\""+" "+"\""+currentlystudyingtowardscode+"\""+" "+"\""+getcompletequalcode+"\""+" "+"\""+highsecqualcode+"\""+" "+"\""+institutionnamecode+"\""+" "+"\""+institutiontypecode+"\""+" "+"\""+qualificationtypecode+"\""+" "+"\""+lastsecschoolcode+"\""+" "+"\""+lastschoolyearcode+"\""+" "+"\""+getqualname+"\""+" "+"\""+getyearfrom+"\""+" "+"\""+getyearto+"\""+" "+"\""+getfirstenrolter+"\""+" "+"\""+ethnicity1code+"\""+" "+"\""+ethnicity2code+"\""+" "+"\""+ethnicity3code+"\""+" "+"\""+iwi1code+"\""+" "+"\""+iwi2code+"\""+" "+"\""+iwi3code+"\""+" "+"\""+iwi4code+"\""+" "+"\""+getlivinginNZcode+"\""+" "+"\""+residencystatuscode+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+getprevfamilyname+"\""+" "+"\""+getsecondname.toUpperCase()+"\""+" "+"\""+getothersecondname.toUpperCase()+"\""+" "+"\""+getanyotherqualcode+"\""+" "+"\""+getprevtertiarystudyatunivcode+"\""+" "+"\""+getcurrentlyatsecondaryschoolcode+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\"");
			
	    
	    	//calculate age////
	    int day=0;
	    String dobmonth="";
	    int year=0;
	    if(getdob.contains("/"))
	    {
	        day = Integer.parseInt(getdob.substring(0, getdob.indexOf("/")));
	        int index= getdob.indexOf("/");
	        dobmonth= getdob.substring(index+1, index+4);
	        year=Integer.parseInt(getdob.substring(index+5));
	        //System.out.println("Day:"+day+" Month:"+dobmonth+" Year:"+year);
	    }
	    Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(dobmonth);
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    int month = cal.get(Calendar.MONTH);
	    LocalDate birthdate = new LocalDate(year, month+1, day);          //Birth date
	    LocalDate now = new LocalDate();                    //Today's date
	    Period period = new Period(birthdate, now, PeriodType.yearMonthDay());
	    //System.out.println("Age:"+period.getYears());
	    //////////// Age calculated/////////////////////////////	        
	    System.out.println("Script: "+scriptpath+" "+"\""+getfirstn.toUpperCase()+"\""+" "+"\""+getlastn.toUpperCase()+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+getcoursename+"\""+" "+"\""+period.getYears()+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\""+" "+"\""+getstage+"\""+" "+"\""+getcourseyear+"\""+" "+"\""+getcoursemonth+"\""+" "+"\""+flag+"\""+" "+"\""+currentlystudyingtowards+"\"");
	    p = runtime.exec(scriptpath+" "+"\""+getfirstn.toUpperCase()+"\""+" "+"\""+getlastn.toUpperCase()+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+getcoursename+"\""+" "+"\""+period.getYears()+"\""+" "+"\""+localDate.toString("dd/MMM/yyyy")+"\""+" "+"\""+getstage+"\""+" "+"\""+getcourseyear+"\""+" "+"\""+getcoursemonth+"\""+" "+"\""+flag+"\""+" "+"\""+currentlystudyingtowards+"\"");
	    //System.out.println("Script: "+scriptpath+" "+"\""+getfirstn.toUpperCase()+"\""+" "+"\""+getlastn.toUpperCase()+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+"AP"+"\""+" "+"\""+"UOW"+"\""+" "+"\""+getcoursename+"\""+" "+"\""+getcourseyear+"\""+" "+"\""+getcoursemonth+"\""+" "+"\""+getsecondname.toUpperCase()+"\""+" "+"\""+getothersecondname.toUpperCase()+"\""+" "+"\""+getprevfamilyname.toUpperCase()+"\""+" "+"\""+contactcountrycode+"\""+" "+"\""+"C"+"\""+" "+"\""+getgender+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+highsecqualcode+"\""+" "+"\""+lastsecschoolcode+"\""+" "+"\""+getlastschoolyear+"\""+" "+"\""+getfirstenrolter+"\""+" "+"\""+currentlystudyingtowardscode+"\""+" "+"\""+getcontactaddressline1.toUpperCase()+"\""+" "+"\""+getcontactaddressline2.toUpperCase()+"\""+" "+"\""+getcontactaddressline3.toUpperCase()+"\""+" "+"\""+getcontactaddressline4.toUpperCase()+"\""+" "+"\""+getemail+"\""+" "+"\""+getpostcode+"\""+" "+"\""+getcity.toUpperCase()+"\""+" "+"\""+gethomephone+"\""+" "+"\""+getmobile+"\""+" "+"\""+period.getYears()+"\"");
		//p = runtime.exec(scriptpath+" "+"\""+getfirstn.toUpperCase()+"\""+" "+"\""+getlastn.toUpperCase()+"\""+" "+"\""+getcontactcountry+"\""+" "+"\""+getdob+"\""+" "+"\""+"AP"+"\""+" "+"\""+"UOW"+"\""+" "+"\""+getcoursename+"\""+" "+"\""+getcourseyear+"\""+" "+"\""+getcoursemonth+"\""+" "+"\""+getsecondname.toUpperCase()+"\""+" "+"\""+getothersecondname.toUpperCase()+"\""+" "+"\""+getprevfamilyname.toUpperCase()+"\""+" "+"\""+contactcountrycode+"\""+" "+"\""+"C"+"\""+" "+"\""+getgender+"\""+" "+"\""+getnstudentnumber+"\""+" "+"\""+highsecqualcode+"\""+" "+"\""+lastsecschoolcode+"\""+" "+"\""+getlastschoolyear+"\""+" "+"\""+getfirstenrolter+"\""+" "+"\""+currentlystudyingtowardscode+"\""+" "+"\""+getcontactaddressline1.toUpperCase()+"\""+" "+"\""+getcontactaddressline2.toUpperCase()+"\""+" "+"\""+getcontactaddressline3.toUpperCase()+"\""+" "+"\""+getcontactaddressline4.toUpperCase()+"\""+" "+"\""+getemail+"\""+" "+"\""+getpostcode+"\""+" "+"\""+getcity.toUpperCase()+"\""+" "+"\""+gethomephone+"\""+" "+"\""+getmobile+"\""+" "+"\""+period.getYears()+"\"");	    	    			    
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
	

	@DataProvider(name="ParamData")  //Parameterizing @Test code for the Excel records
	public Object[][] passData() throws Exception   // Load Data Excel  
	{	  		  	
	  	int sheetnumber = 1; //TEA Smoke specific data
		String excelpath=propertyconfig.getExcelSheetPath();
	  	ExcelDataConfig excelconfig = new ExcelDataConfig(excelpath);	  	  	
		int rows=excelconfig.getRowCount(sheetnumber);  //rows in the first sheet
		int cols=excelconfig.getColCount(sheetnumber);  //cols in the first sheet
		Object[][] data = new Object[rows-1][cols];	
		for(int i=0;i<rows-1;i++)   //Initializing Array to just one row, so rows-1. First row is just headings and make sure every column cell has a text
		{
			for (int j=0;j<cols;j++)  //Columns value is one more than the index so less than sign
			{
				data[i][j]=excelconfig.getData(sheetnumber, i+1, j);  //Picking data from the 2nd row in excel sheet, so i+1
				if (j==6)   //As DoB field is in the 7th col (6th index)
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
  
	public int getSummaryPageCourseRowNumber(String coursen)
	 {
		  int i=1, rownumber=0;
		  String coursename=coursen, id=null;	
			  		id="//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td";
			  		while(isElementPresent(By.xpath(id)) && (!driver.findElement(By.xpath(id)).getText().equalsIgnoreCase("No information available")))
			  		{		  		  
			  		  id="//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[2]";				  		  
			  		  if (driver.findElement(By.xpath(id)).getText().equals(coursename)) 
			  		  {
			  			  return i;
			  		  }			 
			  		  i++;
			  		  id="//html/body/div[1]/div[3]/div/div/div[4]/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td";
			  		}	 
		  return rownumber;
	  }		
	
	//html/body/div[1]/form/div[2]/div[2]/div/div[2]/div/table/tbody/tr[3]/td[1]/a[2]
	
	//*[@id="DataTables_Table_0"]/tbody/tr[3]/td[1]/a[2]
	//*[@id="DataTables_Table_0"]/tbody/tr[3]/td[2]
	//*[@id="DataTables_Table_0"]/tbody/tr[3]/td[3]
	
	
	private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }
	 
	/**public Object[][] courseChoice() throws Exception   // Load Data Excel  
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
	}	**/
	
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
	
	@BeforeClass(alwaysRun=true)
	public void setUp() throws Exception 
	{		
		propertyconfig = new ConfigReader(); //Read the Config Property value		
		//System.setProperty("webdriver.gecko.driver", propertyconfig.getGeckoPath());  //gecko is required for Selenium 3
		System.setProperty("webdriver.chrome.driver", propertyconfig.getChromePath());		

		//ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--disable-gpu");             
        //driver = new ChromeDriver(chromeOptions);


		driver = new ChromeDriver();
		//report = new ExtentReports(System.getProperty("user.dir")+ propertyconfig.getReportPath()); //Set the HTML Execution Report Path. Putting another parameter TRUE will overwrite the file everytime.
		ReportScreenshotUtility.GetExtent();
		//ReportScreenshotUtility.report.loadConfig(new File(System.getProperty("user.dir")+"/src/main/resources/extent-config.xml")); //Load the config settings frot he report from xml.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
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
	
	public String mData(String string, Calendar cal)
	{
		//string=new Timestamp(System.currentTimeMillis()).getTime()+""+cal.get(Calendar.DATE)+string;
		string=System.currentTimeMillis()+""+cal.get(Calendar.DATE)+string;
		return string;
	}
  
}
