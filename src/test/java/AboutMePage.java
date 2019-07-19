import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutMePage {


    private final By locatorFName = By.cssSelector("#id_fname");
    private final By locatorFNameLatin = By.cssSelector("#id_fname_latin");
    private final By locatorLName = By.cssSelector("#id_lname");
    private final By locatorLNameLatin = By.cssSelector("#id_lname_latin");
    private final By locatorBlogName = By.cssSelector("#id_blog_name");
    private final By locatorBDay = By.cssSelector("input[name='date_of_birth']");



    private Logger logger = LogManager.getLogger(getClass().getSimpleName());
    private WebDriver driver;
    private WebDriverWait wait;

    public AboutMePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10L);
        wait.until(ExpectedConditions.titleIs("Личный кабинет | OTUS"));
        logger.info("loaded");
    }




    public void putFName(String fName) {
        driver.findElement(locatorFName).clear();
        driver.findElement(locatorFName).sendKeys(fName);
    }

    public void putFNameLatin(String fNameLatin) {
        driver.findElement(locatorFNameLatin).clear();
        driver.findElement(locatorFNameLatin).sendKeys(fNameLatin);
    }

    public void putLName(String lName) {
        driver.findElement(locatorLName).clear();
        driver.findElement(locatorLName).sendKeys(lName);
    }

    public void putLNameLatin(String lNameLatin) {
        driver.findElement(locatorLNameLatin).clear();
        driver.findElement(locatorLNameLatin).sendKeys(lNameLatin);
    }

    public void putBDay(String bDay) {
        driver.findElement(locatorBDay).clear();
        driver.findElement(locatorBDay).sendKeys(bDay);
    }


}
