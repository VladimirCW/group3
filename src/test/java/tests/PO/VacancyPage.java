package test.java.tests.PO;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class VacancyPage extends BasePage{
    Logger logger = LogManager.getLogger(VacancyPage.class);


    public VacancyPage(WebDriver driver) {
        super(driver);
    }

    public VacancyPage open() {
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/corporate-education/");
        return this;
    }

    @Step("Select vacancy {vacancy}")
    public VacancyPage selectVacancy(String vacancy) {
        logger.trace("Select vacancy" + vacancy);
        logger.debug("Select vacancy" + vacancy);
        logger.info("Select vacancy" + vacancy);
        logger.error("Select vacancy" + vacancy);
        logger.warn("Select vacancy" + vacancy);
        WebElement uxVacancy = driver.findElement(By.xpath("//a//h2[text()='" + vacancy + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(uxVacancy));
        uxVacancy.click();
        return this;
    }

    @Step("Set name {name}")
    public VacancyPage setName(String name) {
        WebElement nameInput = driver.findElement(By.id("names"));
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Set email {email}")
    public VacancyPage setEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("email"));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Click submit")
    public VacancyPage submit() {
        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='submit-btn']/input[@name='ok']"));
        submitBtn.click();
        return this;
    }

    @Step("Get error message")
    public String getPhoneErrorMsg() {
        WebElement phoneMsg = driver.findElement(By.xpath("(//label[@for='telephone']/span)[2]"));
        wait.until(ExpectedConditions.visibilityOf(phoneMsg));
        return phoneMsg.getText();
    }
}
