package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TravelInsurancePage {
   // @FindBy(xpath = "//*[@id=\"page-main\"]/div[1]/div/div/div/div/div/div[1]/h1")
    //WebElement title;

    @FindBy(xpath = "//SPAN[@class='kitt-button__text'][text()='Оформить онлайн']")
    public WebElement buttonForming;

    public TravelInsurancePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(buttonForming)).click();
    }
}
