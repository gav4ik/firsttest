import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        new ChoosePolicyPage(driver);

        FormingPage formingPage = new FormingPage(driver);
        formingPage.fillField("Фамилия застрахованного", "Иванов");
        formingPage.fillField("Имя застрахованного", "Иван");
        formingPage.fillField("Дата рождения застрахованного", "15.10.1990");
        formingPage.fillField("Фамилия страхователя", "Петров",wait);
        formingPage.fillField("Имя страхователя", "Петр");
        formingPage.fillField("Отчество страхователя", "Петрович");
        formingPage.fillField("Дата рождения страхователя", "21.12.1980");
        formingPage.fillField("Серия паспорта", "4510",wait);
        formingPage.fillField("Номер паспорта", "451009");
        formingPage.fillField("Дата выдачи паспорта", "30.09.2015");
        formingPage.fillField("Кем выдан паспорт", "ФМС России",wait);
        formingPage.buttonContinue.click();

        WebElement mistake = driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/alert-form[1]/div"));
        wait.until(ExpectedConditions.visibilityOf(mistake));
        Assert.assertEquals("При заполнении данных произошла ошибка", mistake.getText());
        Assert.assertEquals("Иванов", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Иван", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("15.10.1990", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Петров", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Петр", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Петрович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        Assert.assertEquals("21.12.1980", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        Assert.assertEquals("4510", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("451009", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("30.09.2015", driver.findElement(By.id("documentDate")).getAttribute("value"));
        Assert.assertEquals("ФМС России", driver.findElement(By.id("documentIssue")).getAttribute("value"));







    }
}
