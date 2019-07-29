package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {

    private final String root = "https://otus.ru/?next=/lk/biography/personal/";
    private final By locatorLogon = By.cssSelector("*[data-modal-id='new-log-reg'");

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LogManager.getLogger(getClass().getSimpleName());




    public IndexPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30L);
        driver.get(root);
        logger.info("loaded");
    }




    public LogonPage gotoPrivateArea() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locatorLogon))).click();
        return new LogonPage(driver);
    }
}
