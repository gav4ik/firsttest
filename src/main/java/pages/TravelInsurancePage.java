package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePage extends BasePage{
    @FindBy(xpath = "//h1[@class='kitt-heading  page-teaser-dict__header kitt-heading_size_l'][text()='Страхование путешественников']")
    WebElement title;

    @FindBy(xpath = "//SPAN[@class='kitt-button__text'][text()='Оформить онлайн']")
    public WebElement buttonForming;

    public TravelInsurancePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        
    }

    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("///SPAN[@class='kitt-button__text'][text()='Оформить онлайн']")))).click();
    }
}
