package tests;

import helpers.ElRinconDeSusiPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class ElRinconDeSusiTest extends BaseTest
{
    @Test
    public void positiveTest() throws InterruptedException {
        ElRinconDeSusiPage logInPage = new ElRinconDeSusiPage(driver);
        logInPage.logInForm("suzmar94", "Markovici.1");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-control")));
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("work-list")));

        WebElement input = driver.findElement(By.className("form-control"));
        WebElement list = driver.findElement(By.className("work-list"));
        List<WebElement> workList = list.findElements(By.className("work"));

        System.out.println("Number of articles in the list is:"+ workList.size());
        int numberOfArticles = workList.size();
        int five = 5;

        Assert.assertTrue(input.isDisplayed());
        Assert.assertEquals(five, numberOfArticles);


        //due to visual confirmation
        Thread.sleep(4000);
    }
    @Test
    public void negativeTest() throws InterruptedException {
        ElRinconDeSusiPage loginPage = new ElRinconDeSusiPage(driver);
        loginPage.logInForm("suzmar94", ".");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-control")));
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("work-list")));

        WebElement input = driver.findElement(By.className("form-control"));
        WebElement list = driver.findElement(By.className("work-list"));
        List<WebElement> workList = list.findElements(By.className("work"));

        System.out.println("Number of articles in the list is:"+ workList.size());
        int numberOfArticles = workList.size();
        int five = 5;

        Assert.assertTrue(input.isDisplayed());
        Assert.assertEquals(five, numberOfArticles);

        //due to visual confirmation
        Thread.sleep(4000);
    }

}
