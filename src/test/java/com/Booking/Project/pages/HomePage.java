package com.Booking.Project.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

  public HomePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public WebDriver driver;


  @FindBy(id="ss")
  private WebElement DestinationField;

  @FindBy(xpath="//button[@class='sb-searchbox__button  ']")
  private WebElement look_lookButton;

  @FindBy(xpath="//div[@ class = 'sb-searchbox__row u-clearfix']/descendant::div[@ class ='sb-date-field__wrapper'][1]")
  private WebElement check_inField;

  @FindBy(xpath="//div[@ class = 'sb-searchbox__row u-clearfix']/descendant::div[@ class ='sb-date-field__wrapper'][2]")
  private WebElement check_outField;

  @FindBy(xpath="//div[@ class = 'leftwide rilt-left']/descendant::div [@class = 'c2-button c2-button-further']/span[@ class = 'c2-button-inner']")
  private WebElement check_inRightCalendarButton;

  @FindBy(xpath="//div [@class='sb-dates__grid u-clearfix']/" +
          "descendant::div[@ class = 'c2-wrapper c2-wrapper-s-position-undefined c2-wrapper-s-checkout c2-wrapper-s-has-arrow']/" +
          "descendant::div [@class = 'c2-button c2-button-further']/span")
  private WebElement check_outRightCalendarButton;

  @FindBy(xpath="//form[@ id = 'frm']/descendant::table[3][@class = 'c2-month-table'] /descendant::tbody/tr[4]/td[3]/span[text()='20']")
  private WebElement september20;

  @FindBy(xpath="//descendant::div[@class='sb-dates__col --checkout-field']/descendant::div[@ class = 'c2-calendar']/" +
          "descendant::table[3][@class = 'c2-month-table'] /descendant::tbody/tr[5]/td[1]/span[text()='25']")
  private WebElement september25;

  @FindBy(xpath="//li[@ class = 'c-autocomplete__item sb-autocomplete__item sb-autocomplete__item--city sb-autocomplete__item__item--elipsis ']")
  private WebElement selectNewYork;

  @FindBy(xpath="//a[@ class = 'popover_trigger']")
  private WebElement buttonOfChoiceLanguage;

  @FindBy(xpath="//div [@ id = 'bodyconstraint-inner']")
  private WebElement emptyPlaysOfHomePage;

  @FindBy(xpath="//ul[2]/descendant::li[@ class='lang_en-gb']/descendant::a [@ class='no_target_blank']")
  private WebElement linkOfChoiceEnglish_UK_Language;

  @FindBy(xpath="//div[@id = 'ajaxsrwrap']//div[@class = 'address']/a")
  private WebElement selectedHotels;

  @FindBy(xpath="//li[@data-priority='2' and @data-component='dropdown-onload-shower']/a/div[@class='sign_in_wrapper']")
  private WebElement signInButton;

  @FindBy(xpath="//span[@class='header_name user_firstname']")
  private WebElement yourAccountLink;



  public void clickLook_lookButton() { look_lookButton.click(); }

  public void clickCheck_outField() {
    check_outField.click();
  }

  public void clickSelectNewYork() {
    selectNewYork.click();
  }

  public void clickCheck_inRightCalendarButton() {
    check_inRightCalendarButton.click();
  }

  public void clickSeptember20() {
    september20.click();
  }

  public void clickSeptember25() {
    september25.click();
  }

  public void clickSignInButton() { signInButton.click(); }



  public void selectLanguage() {
    buttonOfChoiceLanguage.click();
    linkOfChoiceEnglish_UK_Language.click();
  }

  public void cleanAndInputDestination(String Destination) {
    DestinationField.clear();
    DestinationField.sendKeys(Destination);
  }

  public void selectTheCheck_inAndCheck_outDate()  {
    waitUntilTheCheck_inRightCalendarButtonIsVisible();
    clickCheck_inRightCalendarButton();
    waitUntilTheSeptember20IsVisible();
    clickSeptember20();
    clickCheck_outField();
    waitUntilTheSeptember25Clickable();
    clickSeptember25();
  }

  //waiting
  public void waitUntilTheCheck_inRightCalendarButtonIsVisible() {
    Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [@ class = 'sb-dates__col --checkin-field']/descendant::div[@ class = 'c2-calendar']/descendant::div [@class = 'c2-button c2-button-further']/span")));
  }

  public void waitUntilTheSeptember20IsVisible() {
    Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@ id = 'frm']/descendant::table[3][@class = 'c2-month-table'] /descendant::tbody/tr[4]/td[3]/span[text()='20']")));
  }

  public void waitUntilTheSeptember25Clickable() {
    Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//descendant::div[@class='sb-dates__col --checkout-field']/descendant::div[@ class = 'c2-calendar']/" +
            "descendant::table[3][@class = 'c2-month-table'] /descendant::tbody/tr[5]/td[1]/span[text()='25']")));
  }

  public void waitUntilTheSignInButtonClickable() {
    Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-priority='2' and @data-component='dropdown-onload-shower']/a/div[@class='sign_in_wrapper']")));
  }

  public void waitUntilTheYourAccountLinkClickable() {
    Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000).withMessage("Element was not found");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='header_name user_firstname']")));
  }
}


