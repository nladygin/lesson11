import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogonPage {

    private final By locatorReady = By.cssSelector("div[class='modal-container new-log-reg-container']");
    private final By locatorForm = By.cssSelector("form.new-log-reg__form.js-login");
    private String jsLocatorEmail = "$(\"[name='email']\")[2].value='%s';";
    private String jsLocatorPassword = "$(\"[name='password']\")[0].value='%s';";
//    private final String jsLocatorSubmit = "$(\"[type='submit']\").click();";

    private Logger logger = LogManager.getLogger(getClass().getSimpleName());
    private WebDriver driver;
    private WebDriverWait wait;




    public LogonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorReady));
        logger.info("loaded");
    }



    public AboutMePage logon(String login, String password) {

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='password']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript( String.format(jsLocatorEmail, login) );
                    js.executeScript( String.format(jsLocatorPassword, password) );

        driver.findElement(locatorForm).submit();

        return new AboutMePage(driver);
    }


}
