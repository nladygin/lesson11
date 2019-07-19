import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestOtusLK {

    private final String fName = "Николай";
    private final String fNameLatin = "Nikolay";
    private final String lName = "Ладыгин";
    private final String lNameLatin = "Ladygin";
    private final String bDay = "19.12.1980";



    private static WebDriver driver;
    private Logger logger = LogManager.getLogger(this.getClass().getSimpleName());



    @Test
    public void go(){
        IndexPage indexPage = new IndexPage(driver);
        LogonPage logonPage = indexPage.gotoPrivateArea();
        AboutMePage aboutMePage = logonPage.logon("nladygin@hrsinternational.com", "passdjhl13");
        aboutMePage.putFName(fName);
        aboutMePage.putFNameLatin(fNameLatin);
        aboutMePage.putLName(lName);
        aboutMePage.putLNameLatin(lNameLatin);
        aboutMePage.putBDay(bDay);


    }












    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10L, TimeUnit.SECONDS);
    }


    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
