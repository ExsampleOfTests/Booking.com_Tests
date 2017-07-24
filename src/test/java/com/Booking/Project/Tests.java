package com.Booking.Project;

import com.Booking.Project.pages.HomePage;
import com.Booking.Project.pages.SearchResultsPage;
import com.Booking.Project.pages.SignInForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.Booking.Project.WebDriver.BaseScript.getConfiguredDriver;


public class Tests {
    public WebDriver driver;
    public HomePage page;
    public SearchResultsPage searchPage;
    public SignInForm form;

    @BeforeMethod
    public void setup(){
        driver = getConfiguredDriver("chrome" );
        page = new HomePage (driver);
        searchPage = new SearchResultsPage(driver);
        form = new SignInForm(driver);
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }

    @DataProvider (name = "Cities")
    public Object[][] setCities() {
        return new Object[][] { { "New York" }, { "Kiev" }, { "Warsaw" }, };
    }

    @Test (dataProvider = "Cities", priority = 1)
    public void verifyOfSearchResult(String Destination)  {
        driver.get("https://www.booking.com");
        page.selectLanguage();
        page.cleanAndInputDestination(Destination);
        page.clickSelectNewYork();
        page.selectTheCheck_inAndCheck_outDate();
        page.clickLook_lookButton();
        searchPage.waitUntilTheElementsIsVisible();
        searchPage.checkTheCorrectHotel(Destination);
      }

    @Test(priority = 2)
    public void checkLogin ()  {
        driver.get("https://www.booking.com");
        page.selectLanguage();
        page.waitUntilTheSignInButtonClickable();
        page.clickSignInButton();
        form.waitUntilTheEMailAddressFieldClickable();
        form.cleanAndInputEMailAddressField("bookingtest9@gmail.com");
        form.waitUntilTheCreatePasswordFieldClickable();
        form.cleanAndInputCreatePasswordField("12345678");
        form.waitUntilTheSign_inButtonClickClickable();
        form.clickSign_inButtonClick();
        page.waitUntilTheYourAccountLinkClickable();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='header_name user_firstname']")).getText().contains("Your account")
                ,"Your Account link is not present on the page"  );

        //tests...
    }
}



