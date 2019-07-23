import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


public class AboutMePage {


    private final By locatorPageReady                = By.cssSelector("form[action='/lk/biography/personal/']");
    private final By locatorFName                    = By.cssSelector("#id_fname");
    private final By locatorFNameLatin               = By.cssSelector("#id_fname_latin");
    private final By locatorLName                    = By.cssSelector("#id_lname");
    private final By locatorLNameLatin               = By.cssSelector("#id_lname_latin");
    private final By locatorBlogName                 = By.cssSelector("#id_blog_name");
    private final By locatorBDay                     = By.cssSelector("input[name='date_of_birth']");
    private final By locatorCountryDropdownHide      = By.cssSelector("div[data-ajax-slave='/lk/biography/cv/lookup/cities/by_country/'] div.hide");
    private final By locatorCountryDropdownVisible   = By.cssSelector("div[data-ajax-slave='/lk/biography/cv/lookup/cities/by_country/'] div[class='lk-cv-block__select-options js-custom-select-options-container']");
    private   String locatorCountry                  = "div.lk-cv-block__select-scroll_country button[title='%s']";
    private       By locatorCountryCheck             = By.cssSelector("div[data-ajax-slave='/lk/biography/cv/lookup/cities/by_country/'] button.lk-cv-block__select-option_selected");
    private final By locatorCityReady                = By.cssSelector("input[name='city']");
    private final By locatorCityDropdownHide         = By.cssSelector("div.js-lk-cv-dependent-slave-city div.hide");
    private final By locatorCityDropdownVisible      = By.cssSelector("div.js-lk-cv-dependent-slave-city div[class='lk-cv-block__select-options js-custom-select-options-container']");
    private   String locatorCity                     = "div.lk-cv-block__select-scroll_city button[title='%s']";
    private       By locatorCityCheck                = By.cssSelector("div.js-lk-cv-dependent-slave-city button.lk-cv-block__select-option_selected");
    private   String locatorWorkSchedule             = "input[name='work_schedule'][title='%s']";
    private final By locatorContact0DropdownHide     = By.cssSelector("div[data-num='0'] div.hide");
    private final By locatorContact0DropdownVisible  = By.cssSelector("div[data-num='0'] div[class='lk-cv-block__select-options lk-cv-block__select-options_left js-custom-select-options-container']");
    private final By locatorContact0Method           = By.cssSelector("div[data-num='0'] button[data-value='telegram']");
    private final By locatorContact0Value            = By.cssSelector("input[name='contact-0-value']");
    private final By locatorContactAdd               = By.cssSelector("div[data-prefix='contact'] button.js-formset-add");
    private final By locatorContact1DropdownHide     = By.cssSelector("div[data-num='1'] div.hide");
    private final By locatorContact1DropdownVisible  = By.cssSelector("div[data-num='1'] div[class='lk-cv-block__select-options lk-cv-block__select-options_left js-custom-select-options-container']");
    private final By locatorContact1Method           = By.cssSelector("div[data-num='1'] button[data-value='whatsapp']");
    private final By locatorContact1Value            = By.cssSelector("input[name='contact-1-value']");
    private final By locatorGender                   = By.cssSelector("#id_gender");
    private   String locatorGenderValue              = "//option[contains(text(), '%s')]";
    private final By locatorCompany                  = By.cssSelector("#id_company");
    private final By locatorWork                     = By.cssSelector("#id_work");
    private final By locatorSave                     = By.cssSelector("button[title='Сохранить']");
    private final By locatorSaveSuccess              = By.xpath("//div[contains(text(), '403')]");


    @Rule
    ErrorCollector collector = new ErrorCollector();

    private Logger logger = LogManager.getLogger(getClass().getSimpleName());
    private WebDriver driver;
    private WebDriverWait wait;

    public AboutMePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10L);
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorPageReady));
        logger.info("loaded");
    }




    public AboutMePage putFName(String fName) {
        driver.findElement(locatorFName).clear();
        driver.findElement(locatorFName).sendKeys(fName);
        return this;
    }

    public AboutMePage putFNameLatin(String fNameLatin) {
        driver.findElement(locatorFNameLatin).clear();
        driver.findElement(locatorFNameLatin).sendKeys(fNameLatin);
        return this;
    }

    public AboutMePage putLName(String lName) {
        driver.findElement(locatorLName).clear();
        driver.findElement(locatorLName).sendKeys(lName);
        return this;
    }

    public AboutMePage putLNameLatin(String lNameLatin) {
        driver.findElement(locatorLNameLatin).clear();
        driver.findElement(locatorLNameLatin).sendKeys(lNameLatin);
        return this;
    }

    public AboutMePage putBlogName(String blogName) {
        driver.findElement(locatorBlogName).clear();
        driver.findElement(locatorBlogName).sendKeys(blogName);
        return this;
    }

    public AboutMePage putBDay(String bDay) {
        driver.findElement(locatorBDay).clear();
        driver.findElement(locatorBDay).sendKeys(bDay);
        return this;
    }

    public AboutMePage selectCountry(String country) {
        HelperJS.click(driver, locatorCountryDropdownHide);
            wait.until(ExpectedConditions.presenceOfElementLocated(locatorCountryDropdownVisible));
        HelperJS.click(driver, By.cssSelector(String.format(locatorCountry,country)));
        return this;
    }

    public AboutMePage selectCity(String city) {
            wait.until(ExpectedConditions.attributeToBe(locatorCityReady, "disabled", ""));
        HelperJS.click(driver, locatorCityDropdownHide);
            wait.until(ExpectedConditions.presenceOfElementLocated(locatorCityDropdownVisible));
        HelperJS.click(driver, By.cssSelector(String.format(locatorCity, city)));
        return this;
    }

    public AboutMePage setSchedule(String schedule) {
        if (! driver.findElement(By.cssSelector(String.format(locatorWorkSchedule,schedule))).isSelected()) {
            HelperJS.click(driver, By.cssSelector(String.format(locatorWorkSchedule, schedule)));
        }
        return this;
    }

    public AboutMePage setContact0(String value) {
        HelperJS.click(driver, locatorContact0DropdownHide);
            wait.until(ExpectedConditions.presenceOfElementLocated(locatorContact0DropdownVisible));
        HelperJS.click(driver, locatorContact0Method);
        HelperJS.setValue(driver, locatorContact0Value, value);
        return this;
    }

    public AboutMePage setContact1(String value) {
        HelperJS.click(driver, locatorContactAdd);
        HelperJS.click(driver, locatorContact1DropdownHide);
            wait.until(ExpectedConditions.presenceOfElementLocated(locatorContact1DropdownVisible));
        HelperJS.click(driver, locatorContact1Method);
        HelperJS.setValue(driver, locatorContact1Value, value);
        return this;
    }

    public AboutMePage setGender(String gender) {
        Select dropdown = new Select(driver.findElement(locatorGender));
        dropdown.selectByVisibleText(gender);
        return this;
    }

    public AboutMePage setCompany(String value) {
        HelperJS.setValue(driver, locatorCompany, value);
        return this;
    }

    public AboutMePage setWork(String value) {
        HelperJS.setValue(driver, locatorWork, value);
        return this;
    }

    public void save() {
        HelperJS.click(driver, locatorSave);
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorSaveSuccess));
    }


    public AboutMePage checkFName(String fName) {
        assertThat(driver.findElement(locatorFName).getAttribute("value"), equalTo(fName));
        return this;
    }

    public AboutMePage checkFNameLatin(String fNameLatin) {
        assertThat(driver.findElement(locatorFNameLatin).getAttribute("value"), equalTo(fNameLatin));
        return this;
    }

    public AboutMePage checkLName(String lName) {
        assertThat(driver.findElement(locatorLName).getAttribute("value"), equalTo(lName));
        return this;
    }

    public AboutMePage checkLNameLatin(String lNameLatin) {
        assertThat(driver.findElement(locatorLNameLatin).getAttribute("value"), equalTo(lNameLatin));
        return this;
    }

    public AboutMePage checkBlogName(String blogName) {
        assertThat(driver.findElement(locatorBlogName).getAttribute("value"), equalTo(blogName));
        return this;
    }

    public AboutMePage checkBDay(String bDay) {
        assertThat(driver.findElement(locatorBDay).getAttribute("value"), equalTo(bDay));
        return this;
    }

    public AboutMePage checkCountry(String country) {
        assertThat(driver.findElement(locatorCountryCheck).getAttribute("title"), equalTo(country));
        return this;
    }

    public AboutMePage checkCity(String city) {
        assertThat(driver.findElement(locatorCityCheck).getAttribute("title"), equalTo(city));
        return this;
    }

    public AboutMePage checkSchedule(String schedule) {
        assertTrue(driver.findElement(By.cssSelector(String.format(locatorWorkSchedule,schedule))).isSelected());
        return this;
    }

    public AboutMePage checkContact0(String contact) {
        assertThat(driver.findElement(locatorContact0Value).getAttribute("value"), equalTo(contact));
        return this;
    }

    public AboutMePage checkContact1(String contact) {
        assertThat(driver.findElement(locatorContact1Value).getAttribute("value"), equalTo(contact));
        return this;
    }

    public AboutMePage checkGender(String gender) {
        assertTrue(driver.findElement(By.xpath(String.format(locatorGenderValue,gender))).isSelected());
        return this;
    }

    public AboutMePage checkCompany(String company) {
        assertThat(driver.findElement(locatorCompany).getAttribute("value"), equalTo(company));
        return this;
    }

    public AboutMePage checkWork(String work) {
        assertThat(driver.findElement(locatorWork).getAttribute("value"), equalTo(work));
        return this;
    }




}
