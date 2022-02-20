package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QrOrSitePage extends BasePage{
    @FindBy(xpath = "//SPAN[@class='kitt-button__text'][text()='Оформить на сайте']")
    public WebElement buttonFormingOnSite;

    public QrOrSitePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
            }

    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//SPAN[@class='kitt-button__text'][text()='Оформить на сайте']")))).click();
    }
}
