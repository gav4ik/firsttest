package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QrOrSitePage {
    @FindBy(xpath = "//SPAN[@class='kitt-button__text'][text()='Оформить на сайте']")
    public WebElement buttonFormingOnSite;

    public QrOrSitePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(buttonFormingOnSite)).click();
    }
}
