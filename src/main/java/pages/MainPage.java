package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    @FindBy(xpath = "//nav[contains(@aria-label,'Основное меню')]")
    WebElement mainMenu;

    @FindBy(xpath = "//div[contains(@class,' kitt-top-menu__column kitt-top-menu__column_3  kitt-top-menu__column_subaction')]/ul")
    WebElement subMenu;

    public MainPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath("//li[contains(@class,'kitt-top-menu__item kitt-top-menu__item_first')]/*[contains(text(),'" + menuItem + "')]")).click();
    }
        public void selectSubMenu(String menuItem){
            subMenu.findElement(By.xpath("//*/a[contains(text(),'"+menuItem+"')]")).click();


        }
}
