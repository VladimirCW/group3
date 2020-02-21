package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FromNatalya extends BaseTest {

    @Test
    public void checkCallback() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15000);
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/");
        driver.findElement(By.xpath("//a[@class = 'callback-btn']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id = 'b-contacte-phone-tel']")));
        driver.findElement(By.xpath("//*[@id = 'b-contacte__full-name']")).sendKeys("Test Natalia");
        driver.findElement(By.xpath("//*[@id = 'b-contacte-phone-tel']")).sendKeys("0973122382");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"callback-form\"]/input[4]")));
        driver.findElement(By.xpath("//*[@id=\"callback-form\"]/input[4]")).click();

        By callBackMsg = By.xpath("//*[@class = 'b-header-contacte-phone-thank']/p");
        Thread.sleep(2000);
        WebElement callBackMsgEl = driver.findElement(callBackMsg);
        String msg = callBackMsgEl.getText();
        System.out.println(msg);

        String expectedValue = "Спасибо!\nНаш менеджер свяжется с Вами.";
        assertEquals(expectedValue, msg);
    }
}
