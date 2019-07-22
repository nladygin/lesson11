import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class HelperJS {

    public static void click(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public static void setValue(WebDriver driver, By locator, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+value+"';", driver.findElement(locator));
    }
}
