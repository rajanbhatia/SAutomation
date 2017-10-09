import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class PersonalDetailsPage {
	
	public void personalDetails(WebDriver driver, String livinginNZ, String livinginNZcode, String flag, String getprevfamilyname, String gender, String getnstudentnumber, String residencystatus, String country, String ethnicity1, String ethnicity2, String ethnicity3, String iwi1, String iwi2, String iwi3, String iwi4)
	{
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
	    
	    if (flag.equals("New"))
	    {
		    driver.findElement(By.id("IPQ_ADOAP_PRVS")).sendKeys(getprevfamilyname);
			if(gender.equalsIgnoreCase("Male"))
			{
			   	driver.findElement(By.id("IPR_GEND_M")).click();
			}
			else  if(gender.equalsIgnoreCase("Female"))
			{
			  	driver.findElement(By.id("IPR_GEND_F")).click();
			}
			
			if (getnstudentnumber!=null)
			{
			    driver.findElement(By.id("IPQ_ADOAP_NSN")).sendKeys(getnstudentnumber);
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
			   	iwi1=""; iwi2=""; iwi3=""; iwi4="";  //To avoid script failure in case Iwi data is not provided in the excel sheet.
			 }
	    }	
		
		
		
		
	}

}
