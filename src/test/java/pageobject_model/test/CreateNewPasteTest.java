package pageobject_model.test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePagePasteBin;



public class CreateNewPasteTest {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Just test, JIRA binding can be here")
    public void createNewPaste()  {
        HomePagePasteBin page = new HomePagePasteBin(driver)
                .openPage()
                .setText("Hello from WebDriver")
                .selectPasteExpirationField()
                .setPasteExpiration()
                .setPasteTitle("helloweb");
        page.createNewPaste();



        Assert.assertTrue(true);


    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }


}
