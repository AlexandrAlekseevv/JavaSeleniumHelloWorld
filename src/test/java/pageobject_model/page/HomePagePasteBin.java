package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePagePasteBin {

    private static final String HOME_PAGE_URL = "https://pastebin.com";

    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement textArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(xpath = "//*[@class='select2-results__option' and text()= '10 Minutes']")
    private WebElement pasteExpiration10Minutes;

    @FindBy(id = "postform-name")
    private WebElement pasteTitleField;

    @FindBy(xpath = "//*[@class=\"btn -big\"]")
    private WebElement createNewPasteButton;


    public HomePagePasteBin(WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public HomePagePasteBin openPage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"btn -big\"]")));
        return this;
    }

    public  HomePagePasteBin setText(String term){
        textArea.sendKeys(term);
        return this;
    }

    public HomePagePasteBin selectPasteExpirationField(){
        pasteExpiration.click();
        return this ;

    }
    public HomePagePasteBin setPasteExpiration(){
        pasteExpiration10Minutes.click();
        return this;
    }

    public HomePagePasteBin setPasteTitle(String title){
        pasteTitleField.sendKeys(title);
        return this;
    }

    public  void createNewPaste(){
        createNewPasteButton.click();
    }


}
