import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public static String login;
    public static String password;


    @BeforeClass
    public static void beforeClass() {
        login = System.getProperty("login");
        password = System.getProperty("password");
    }


    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10L, TimeUnit.SECONDS);
    }


    @After
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
