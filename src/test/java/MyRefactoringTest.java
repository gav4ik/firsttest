import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

public class MyRefactoringTest extends BaseTest{
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(10));

    @Test
    public void newInsuranceTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия");

        TravelInsurancePage page = new TravelInsurancePage(driver);
        WebElement button = page.buttonForming;
        button.click();

        new QrOrSitePage(driver).buttonFormingOnSite.click();

//        String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
       for (String winHandle : driver.getWindowHandles()) {
          driver.switchTo().window(winHandle);
      }

        new ChoosePolicyPage(driver).btnForming.click();

        FormingPage formingPage = new FormingPage(driver);
        formingPage.fillFieldWait("Фамилия застрахованного", "Иванов", wait);
        formingPage.fillFieldWait("Имя застрахованного", "Иван", wait);
        formingPage.fillFieldWait("Дата рождения застрахованного", "15.10.1990", wait);
        formingPage.fillFieldWait("Фамилия страхователя", "Петров",wait);
        formingPage.fillFieldWait("Имя страхователя", "Петр", wait);
        formingPage.fillFieldWait("Отчество страхователя", "Петрович", wait);
        formingPage.fillFieldWait("Дата рождения страхователя", "21.12.1980", wait);
        formingPage.fillFieldWait("Серия паспорта", "4510",wait);
        formingPage.fillFieldWait("Номер паспорта", "451009", wait);
        formingPage.fillFieldWait("Дата выдачи паспорта", "30.09.2015", wait);
        formingPage.fillFieldWait("Кем выдан паспорт", "ФМС России",wait);
        formingPage.buttonContinue.click();

        WebElement mis= formingPage.getMistake();

        Assert.assertEquals("При заполнении данных произошла ошибка", mis.getText());
        Assert.assertEquals("Иванов", formingPage.getTextById("surname_vzr_ins_0"));
        Assert.assertEquals("Иван", formingPage.getTextById("name_vzr_ins_0"));
        Assert.assertEquals("15.10.1990", formingPage.getTextById("birthDate_vzr_ins_0"));
        Assert.assertEquals("Петров", formingPage.getTextById("person_lastName"));
        Assert.assertEquals("Петр", formingPage.getTextById("person_firstName"));
        Assert.assertEquals("Петрович", formingPage.getTextById("person_middleName"));
        Assert.assertEquals("21.12.1980", formingPage.getTextById("person_birthDate"));
        Assert.assertEquals("4510", formingPage.getTextById("passportSeries"));
        Assert.assertEquals("451009", formingPage.getTextById("passportNumber"));
        Assert.assertEquals("30.09.2015", formingPage.getTextById("documentDate"));
        Assert.assertEquals("ФМС России", formingPage.getTextById("documentIssue"));







    }
}
