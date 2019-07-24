package page;

import data.User;
import helper.DataLoader;
import helper.PageElementHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




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
    private final By locatorCompany                  = By.cssSelector("#id_company");
    private final By locatorWork                     = By.cssSelector("#id_work");
    private final By locatorSave                     = By.cssSelector("button[title='Сохранить']");
    private final By locatorSaveSuccess              = By.xpath("//div[contains(text(), '403')]");


    @Rule
    ErrorCollector collector = new ErrorCollector();

    private Logger logger = LogManager.getLogger(getClass().getSimpleName());
    private WebDriver driver;
    private WebDriverWait wait;
    private PageElementHelper helper;

    public AboutMePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10L);
        this.helper = new PageElementHelper();
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorPageReady));
        logger.info("loaded");
    }



    public AboutMePage setUserData(User user){

            /* personal data */
            helper
                    .setValue(driver, locatorFName,      user.getfName())
                    .setValue(driver, locatorFNameLatin, user.getfNameLatin())
                    .setValue(driver, locatorLName,      user.getlName())
                    .setValue(driver, locatorLNameLatin, user.getlNameLatin())
                    .setValue(driver, locatorBlogName,   user.getBlogName())
                    .setValue(driver, locatorBDay,       user.getbDay());

            /* main information */
            /* country */
            helper.click(driver, locatorCountryDropdownHide);
                wait.until(ExpectedConditions.presenceOfElementLocated(locatorCountryDropdownVisible));
            helper.click(driver, By.cssSelector(String.format(locatorCountry, user.getCountry())));

            /* city */
                wait.until(ExpectedConditions.attributeToBe(locatorCityReady, "disabled", ""));
            helper.click(driver, locatorCityDropdownHide);
                wait.until(ExpectedConditions.presenceOfElementLocated(locatorCityDropdownVisible));
            helper.click(driver, By.cssSelector(String.format(locatorCity, user.getCity())));

            /* schedule */
            boolean checked = driver.findElement(By.cssSelector(String.format(locatorWorkSchedule, user.getSchedule()))).isSelected();
            if (! checked) {
                helper.click(driver, By.cssSelector(String.format(locatorWorkSchedule, user.getSchedule())));
            }

            /* contacts */
            /* contact 0 */
            helper.click(driver, locatorContact0DropdownHide);
                wait.until(ExpectedConditions.presenceOfElementLocated(locatorContact0DropdownVisible));
            helper
                .click(driver, locatorContact0Method)
                .setValue(driver, locatorContact0Value, user.getContactValue0());

            /* contact 1 */
            helper.click(driver, locatorContactAdd);
            helper.click(driver, locatorContact1DropdownHide);
                wait.until(ExpectedConditions.presenceOfElementLocated(locatorContact1DropdownVisible));
            helper
                    .click(driver, locatorContact1Method)
                    .setValue(driver, locatorContact1Value, user.getContactValue1());

            /* other */
            Select dropdown = new Select(driver.findElement(locatorGender));
            dropdown.selectByValue(user.getGender());

            helper.setValue(driver, locatorCompany, user.getCompanyName());
            helper.setValue(driver, locatorWork, user.getWork());

        return this;
    }


    public void save() {
        helper.click(driver, locatorSave);
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorSaveSuccess));
    }



    public User getUserData(){
        User user = new User();

            user
                    .setfName(
                            helper.getValueByAttribute
                                    (
                                            driver,
                                            locatorFName
                                    )
                    )
                    .setfNameLatin(
                            helper.getValueByAttribute
                                    (
                                            driver,
                                            locatorFNameLatin
                                    )
                    )
                    .setlName(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorLName
                            )
                    )
                    .setlNameLatin(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorLNameLatin
                            )
                    )
                    .setBlogName(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorBlogName
                            )
                    )
                    .setbDay(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorBDay
                            )
                    )
                    .setCountry(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorCountryCheck,
                                    "title"
                            )
                    )
                    .setCity(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorCityCheck,
                                    "title"
                            )
                    )
                    .setSchedule(getSchedule())
                    .setContactValue0(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorContact0Value
                            )
                    )
                    .setContactValue1(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorContact1Value
                            )
                    )
                    .setGender(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorGender
                            )
                    )
                    .setCompanyName(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorCompany
                            )
                    )
                    .setWork(
                            helper.getValueByAttribute(
                                    driver,
                                    locatorWork
                            )
                    );

        return user;
    }




    private String getSchedule(){
        String schedule = new DataLoader().load(User.class).getSchedule();
        boolean checked = driver.findElement(By.cssSelector(String.format(locatorWorkSchedule,schedule))).isSelected();
        if (checked) {
            return schedule;
        } else {
            return "";
        }
    }


}
