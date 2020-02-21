package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.tests.PO.HomePage;
import test.java.tests.PO.VacancyPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ForPO extends BaseTest {
    HomePage homePage;
    VacancyPage vacancyPage;

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
    }

    @Test
    public void checkLang() {
        //int arr[] = {2,4,6,8,1,1};
//        List<String> a = new ArrayList<String>();
//        List<Integer> a1 = new ArrayList<Integer>();
        String lang[] = {"UA", "EN", "RU"};

        homePage.open();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text() = 'UA'])[1]"))));

        List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='lang'])[1]//a"));
        System.out.println(list.get(0).getText());
        System.out.println(list.get(1).getText());
        System.out.println(list.get(2).getText());
        list.size();
        for(WebElement el: list) {
            System.out.println();
            System.out.println(el.getText());
        }

    }

}
