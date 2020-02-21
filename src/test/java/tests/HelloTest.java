package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HelloTest extends BaseTest{


    @Test
    public void checkStyle() {
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        WebElement uaLan = driver.findElement(By.xpath("(//a[text() = 'UA'])[1]"));
        WebElement ruLan = driver.findElement(By.xpath("(//a[text() = 'RU'])[1]"));
        WebElement enLan = driver.findElement(By.xpath("(//a[text() = 'EN'])[1]"));
        /*waitForPresence.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(uaLan),
                ExpectedConditions.visibilityOf(ruLan),
                ExpectedConditions.visibilityOf(enLan)
        ));*/


        By callBack = By.className("callback-btn");
        WebElement callBackEl = driver.findElement(callBack);
        wait.until(ExpectedConditions.elementToBeClickable(callBack));



        callBackEl.click();

        By callBackMsg = By.xpath("//*[@class='b-header-contacte__detail' and contains(text(), 'manager')]");
        WebElement callBackMsgEl = driver.findElement(callBackMsg);
        //waitForPresence.until(ExpectedConditions.presenceOfElementLocated(callBackMsg));

        System.out.println(callBackMsgEl);
        ///waitForPresence.until(ExpectedConditions.visibilityOf(callBackMsgEl));
        String msg = callBackMsgEl.getText();
        System.out.println(msg);

        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-block']//input[@type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
        wait.until(ExpectedConditions.attributeContains(nameInput, "style", "border-color: red;"));
        String actualStyle = nameInput.getAttribute("style");

        String expectedValue = "border-color: red;";
        assertEquals(expectedValue, actualStyle);

    }
}
