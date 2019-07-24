package page;

import helper.PageElementHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogonPage {

    private final By locatorPageReady = By.cssSelector("div[class='modal-container new-log-reg-container']");
    private final By locatorForm = By.cssSelector("form.new-log-reg__form.js-login");
    private By locatorEmail = By.cssSelector("form.new-log-reg__form.js-login input[name='email']"); //[class='new-input new-input_full js-placeholder']
    private By locatorPassword = By.cssSelector("input[name='password']");


    private Logger logger = LogManager.getLogger(getClass().getSimpleName());
    private WebDriver driver;
    private WebDriverWait wait;
    private PageElementHelper helper;




    public LogonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10L);
        this.helper = new PageElementHelper();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageReady));
        logger.info("loaded");
    }



    public AboutMePage logon(String login, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='password']")));

                helper
                        .setValue(driver, locatorEmail, login)
                        .setValue(driver, locatorPassword, password);

        driver.findElement(locatorForm).submit();

        return new AboutMePage(driver);
    }


}
