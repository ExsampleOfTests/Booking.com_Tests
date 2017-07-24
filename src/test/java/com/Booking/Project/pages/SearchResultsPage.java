package com.Booking.Project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;


public class SearchResultsPage {
    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    public void checkTheCorrectHotel(String Destination) {
        int urlsCount = driver.findElements(By.xpath("//div[@id = 'ajaxsrwrap']//div[@class = 'address']/a[@ href ]")).size();
        List<WebElement> urls = driver.findElements(By.xpath("//div[@id = 'ajaxsrwrap']//div[@class = 'address']/a[@ href ]"));
        for (int i = 0; i < urlsCount; i++) {
            Assert.assertTrue(urls.get(i).getText().contains(Destination), "The search result does not match the query");
        }
    }

    //waits
    public void waitUntilTheElementsIsVisible() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ class = 'rlt-right']")));
    }
}
