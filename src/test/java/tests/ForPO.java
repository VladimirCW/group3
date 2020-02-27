package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.tests.PO.BasePage;
import test.java.tests.PO.HomePage;
import test.java.tests.PO.VacancyPage;
import test.java.utils.RetryAnalizer;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForPO extends BaseTest {
    HomePage homePage;
    VacancyPage vacancyPage;
    BasePage basePage;

    @BeforeMethod
    public void PageLoad() {
        homePage = new HomePage(driver);
        vacancyPage = new VacancyPage(driver);
    }

    @Test
    public void anyTest() {
        homePage.open()
                .selectLanguage("uk")
                .openAbout()
                .openVacancies();
        vacancyPage
                .selectVacancy("Викладач UX")
                .setName("Vova")
                .setEmail("email@email.com")
                .submit();
        String actualMsg = vacancyPage.getPhoneErrorMsg();
        String expectedMsg = "Поле не має бути пустим";
        assertEquals(actualMsg, expectedMsg);
        assertTrue(false);
    }

    @Test()
    public void newAnyTest() {
        homePage.open()
                .selectLanguage("uk")
                .openAbout()
                .openVacancies();
        vacancyPage
                .selectVacancy("Викладач UX")
                .setName("Vova")
                .setEmail("email@email.com")
                .submit();
        String actualMsg = vacancyPage.getPhoneErrorMsg();
        String expectedMsg = "Поле не має бути пустим";
        ///assertTrue(false);
        assertEquals(actualMsg, expectedMsg);
    }

}
