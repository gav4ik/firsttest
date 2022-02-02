import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InsuranceTest {

    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl=" http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test

    public void testInsurance() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        Wait<WebDriver> wait=new WebDriverWait(driver, Duration.ofSeconds(15),Duration.ofSeconds(10));
        var el1 = driver.findElement(By.xpath("(//DIV[@class='kitt-top-menu__icon-img'])[9]"));
        wait.until(ExpectedConditions.visibilityOf(el1)).click();
//        driver.findElement(By.xpath("(//DIV[@class='kitt-top-menu__icon-img'])[9]")).click();
        var el2 =driver.findElement(By.xpath("//A[@class='kitt-top-menu__link kitt-top-menu__link_second'][text()='Путешествия']"));
        wait.until(ExpectedConditions.visibilityOf(el2)).click();
//        driver.findElement(By.xpath("//A[@class='kitt-top-menu__link kitt-top-menu__link_second'][text()='Путешествия']")).click();


        WebElement title = driver.findElement(By.xpath("//*[@id=\"page-main\"]/div[1]/div/div/div/div/div/div[1]/h1"));
//        WebElement title = driver.findElement(By.xpath("//H2[@_ngcontent-c1=''][text()='Страхование путешественников']"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Страхование путешественников", title.getText());

        WebElement sendButton1 = driver.findElement(By.xpath("//SPAN[@class='kitt-button__text'][text()='Оформить онлайн']"));
        wait.until(ExpectedConditions.visibilityOf(sendButton1)).click();

        WebElement sendButton2 = driver.findElement(By.xpath("//SPAN[@class='kitt-button__text'][text()='Оформить на сайте']"));
        wait.until(ExpectedConditions.visibilityOf(sendButton2)).click();

        String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        var testText = driver.findElement(By.xpath("//H2[@_ngcontent-c1=''][text()='Страхование путешественников']"));
        WebElement sendButton3 = driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-setup-product/div/form/div/div[1]/div/button"));
        wait.until(ExpectedConditions.visibilityOf(sendButton3)).click();
        fillField(By.id("surname_vzr_ins_0"), "Иванов",wait);
        fillField(By.id("name_vzr_ins_0"), "Иван",wait);
        fillField(By.id("birthDate_vzr_ins_0"), "31.01.1990",wait);
        fillField((By.id("person_lastName")), "Петров",wait);
        fillField(By.id("person_firstName"), "Петр",wait);
        fillField(By.id("person_middleName"), "Петрович",wait);
        fillField(By.id("person_birthDate"), "15.02.1995",wait);
        //WebElement gender = driver.findElement(By.xpath("//LABEL[@class='btn ng-untouched ng-pristine ng-valid'][text()='Мужской']"));
        //wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
        //driver.findElement(By.xpath("//LABEL[@class='btn ng-untouched ng-pristine ng-valid active']")).click();
        fillField(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[3]/online-person-passport/div/div[1]/div[1]/form-control-label/div/div/div[1]/input-filter/span/input"), "4505",wait);
        fillField(By.id("passportNumber"), "987654",wait);
        fillField(By.id("documentDate"), "11.12.2015",wait);
        fillField(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[3]/online-person-passport/div/div[2]/div/form-control-label/div/input-filter/span/input"), "ФМС 66789",wait);
        WebElement pressKey = driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/div[3]/div/div[2]/button"));
        wait.until(ExpectedConditions.visibilityOf(pressKey)).click();
        WebElement mistake = driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/alert-form[1]/div"));
        wait.until(ExpectedConditions.visibilityOf(mistake));
        Assert.assertEquals("При заполнении данных произошла ошибка", mistake.getText());
        Assert.assertEquals("Иванов", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Иван", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("31.01.1990", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Петров", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Петр", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Петрович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        Assert.assertEquals("15.02.1995", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        //Assert.assertEquals("Мужской", driver.findElement(By.xpath("//LABEL[@class='btn ng-untouched ng-pristine ng-valid active']")).getText());
        Assert.assertEquals("4505", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("987654", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("11.12.2015", driver.findElement(By.id("documentDate")).getAttribute("value"));
        Assert.assertEquals("ФМС 66789", driver.findElement(By.id("documentIssue")).getAttribute("value"));


    }

    public void fillField(By locator, String value, Wait<WebDriver> wait){
        WebElement we1 = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(we1)).clear();
        we1.click();
        wait.until(ExpectedConditions.visibilityOf(we1)).sendKeys(value);
    }

    @After
    public void afterTest(){
        driver.quit();
    }
}
