package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//li[contains(@class,'kitt-top-menu__item kitt-top-menu__item_first')]/*[contains(text(),'Страхование')]")
    WebElement mainMenu;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[4]/nav/div/ul/li[9]/div/div[1]/ul/li[3]/a ")
    WebElement subMenu;

    public MainPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath("//li[contains(@class,'kitt-top-menu__item kitt-top-menu__item_first')]/*[contains(text(),'" + menuItem + "')]")).click();
    }
        public void selectSubMenu(String menuItem){
            mainMenu.findElement(By.xpath("//li[contains(@class,'kitt-top-menu__item')]/*[contains(text(),'"+menuItem+"')]")).click();


        }
}
