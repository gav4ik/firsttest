package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoosePolicyPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class, 'btn btn-primary btn-large')][text() ='Оформить']")
    public WebElement btnForming;

    public ChoosePolicyPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
            }


}
