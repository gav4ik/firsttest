package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChoosePolicyPage {
    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-setup-product/div/form/div/div[1]/div/button")
    public WebElement btnForming;

    public ChoosePolicyPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(btnForming)).click();
    }
}
