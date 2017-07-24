package com.Booking.Project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInForm {

    public SignInForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath="//div[@data-target='user_access_signup_menu']")
    private WebElement registerTab;

    @FindBy(xpath="//div[1]/descendant::form[1]/descendant::input[@name='username']")
    private WebElement eMailAddressField;

    @FindBy(xpath="//div[2]/descendant::form[1]/descendant::input[@name='password']")
    private WebElement createPasswordField;

    @FindBy(xpath="//input[@class='bootstrapped-input btn btn-primary  ']")
    private WebElement sign_inButtonClick;




    public void cleanAndInputEMailAddressField(String emailAddress) {
        eMailAddressField.clear();
        eMailAddressField.sendKeys(emailAddress);
    }

    public void cleanAndInputCreatePasswordField(String password) {
        createPasswordField.clear();
        createPasswordField.sendKeys(password);
    }
    public void clickSign_inButtonClick() {
        sign_inButtonClick.click();
    }


//waits
    public void waitUntilTheEMailAddressFieldClickable() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/descendant::form[1]/descendant::input[@name='username']")));
    }

    public void waitUntilTheCreatePasswordFieldClickable() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/descendant::form[1]/descendant::input[@name='password']")));
    }

    public void waitUntilTheSign_inButtonClickClickable() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='bootstrapped-input btn btn-primary  ']")));
    }
}
