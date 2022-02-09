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

public class FormingPage {
    @FindBy(id = "surname_vzr_ins_0")
    WebElement surnameIns;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameIns;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthIns;

    @FindBy(id = "person_lastName")
    WebElement persLastName;

    @FindBy(id = "person_firstName")
    WebElement persFirstName;

    @FindBy(id = "person_middleName")
    WebElement persMiddleName;

    @FindBy(id = "person_birthDate")
    WebElement persBirth;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[2]/div/div/person-general-data/div/div[5]/div/form-control-label/div")
    WebElement gender;

    //@FindBy(className = "active")
   // WebElement activeGender;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[3]/online-person-passport/div/div[1]/div[1]/form-control-label/div/div/div[1]/input-filter/span/input")
    WebElement passSer;

    @FindBy(id = "passportNumber")
    WebElement passNum;

    @FindBy(id = "documentDate")
    WebElement docDate;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[3]/online-person-passport/div/div[2]/div/form-control-label/div/input-filter/span/input")
    WebElement docIssue;

    @FindBy(xpath = "//button[contains(@type, 'submit')][contains( text(), 'Продолжить')]")
    public WebElement buttonContinue;

    public FormingPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(buttonContinue)).click();
    }

    public void fillField(String fildName, String value) {
        getField(fildName).sendKeys(value);
    }

    public WebElement getField(String fildName) {
        switch (fildName) {
            case "Фамилия застрахованного":
                return surnameIns;
            case "Имя застрахованного":
                return nameIns;
            case "Дата рождения застрахованного":
                return birthIns;
            case "Фамилия страхователя":
                return persLastName;
            case "Имя страхователя":
                return persFirstName;
            case "Отчество страхователя":
                return persMiddleName;
            case "Дата рождения страхователя":
                return persBirth;
            case "Серия паспорта":
                return passSer;
            case "Номер паспорта":
                return passNum;
            case "Дата выдачи паспорта":
                return docDate;
            case "Кем выдан паспорт":
                return docIssue;
            default: throw new AssertionError("Поле '" +  fildName + "' не объявлено на странице." );
        }
    }

    public void fillField(String fildName, String value, Wait<WebDriver>wait) {
            WebElement element = getField(fildName);
            element.clear();
            element.click();
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

   /* protected void checkActive(WebElement element){
        if (!element.getAttribute("class").contains("active")){
            element.click();
        }
    }*/
}

//public void fillField(By locator, String value, Wait<WebDriver> wait) {
// WebElement we1 = driver.findElement(locator);
// wait.until(ExpectedConditions.visibilityOf(we1)).clear();
// we1.click();
//wait.until(ExpectedConditions.visibilityOf(we1)).sendKeys(value);
