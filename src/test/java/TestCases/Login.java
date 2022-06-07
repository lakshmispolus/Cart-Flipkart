package TestCases;

import java.io.IOException;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.BaseClass;


public class Login extends BaseClass{
	  LoginPage loginpage;
  @Test
  public void addToCart() { 	 
	  loginpage = new LoginPage(driver);
	  loginpage.searchTextbox("Poco M2 Pro mobile");
	 // loginpage.navSearchSubmitButton();
	 // arjun
	  loginpage.itemClick();
	  loginpage.dontChange();
	  String mainWindowHandle = driver.getWindowHandle();
      Set allWindowHandles = driver.getWindowHandles();
      java.util.Iterator iterator =  allWindowHandles.iterator();
      while (iterator.hasNext()) {
          String ChildWindow = (String) iterator.next();
              if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
              driver.switchTo().window(ChildWindow);
              loginpage.addToCartButton();
             
          }
  }
  }
  
  @BeforeTest
  @Parameters({ "Browser" })
	public void beforeTest(String Browser) throws InterruptedException, IOException {	
		driver = launchBrowser1("https://www.amazon.com/");

	}
}
