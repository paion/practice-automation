package string;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Selenium {
    WebDriver driver = new ChromeDriver();
    void method(){

//        By by = By.xpath("//a/h3");
//        WebElement webElement = driver.findElement(by);
//        ExpectedCondition<WebElement> expectedCondition = ExpectedConditions.elementToBeClickable(webElement);
//        WebDriverWait firstResult =  new WebDriverWait(driver, 10L);
//        webElement = firstResult.until(expectedCondition);

        WebElement element = new WebDriverWait(driver, 10L)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

        ExpectedConditions.elementToBeClickable(By.xpath("//a/h3"));

        By by = By.xpath("//a/h3");

        WebElement webElement = driver.findElement(By.xpath("//a/h3"));


        WebElement foo = new WebDriverWait(driver, 3L)
                .until(driver -> webElement);

        //.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//==================================================================================

        WebElement webElement1 = driver.findElement(By.id("//a/h3"));

        WebElement webElement2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class).until(driver -> webElement1);

        //WebElement fool = wait.until(driver -> webElement1);
    }

}
