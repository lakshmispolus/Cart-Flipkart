package TestCases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.ExcelRead;

public class DownloadFileChecking extends BaseClass {

	@BeforeTest
	@Parameters({ "Browser" })
	public void beforeTest(String Browser) throws InterruptedException, IOException {
		driver = launchBrowser1(
				"https://filesamples.com/formats/csv#google_vignette");

	}

	@Test
	public void downloadFile() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//center//span[@class='ezmob-footer-close'][normalize-space()='x']")).click();
		
		
	WebElement fileClick = driver.findElement(By.xpath("//main[@class='col-12 main-content rounded-bg marg-top padd-top']//div[1]//a[1]"));
	fileClick.click();
	
	Thread.sleep(6000);
	
	String location="C:\\Users\\HP\\Downloads\\sample4.csv";
	Path path= Paths.get(location);
	
	
	File fileLocation=new File("C:\\Users\\HP\\Downloads");
	File[] totalFiles=fileLocation.listFiles();
	
	
	
	
	for(File file: totalFiles)
	{
		if(file.getName().equals("sample4.csv"))
		{
			
			long filesizeBytes=Files.size(path);
			 filesizeBytes=filesizeBytes/1024;
			if(filesizeBytes!=0)
			{
			System.out.println("File downloaded in your system");
			System.out.println("File size ="+filesizeBytes);
			
			
			}
			break;
		}		
	}
	driver.close();
		
	}

}
