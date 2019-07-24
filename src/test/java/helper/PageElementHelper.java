package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class PageElementHelper {

    public PageElementHelper click(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(locator));
        return this;
    }


    public PageElementHelper setValue(WebDriver driver, By locator, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+value+"';", driver.findElement(locator));
        return this;
    }


    public String getValueByAttribute(WebDriver driver, By locator, String attribute){
        return driver.findElement(locator).getAttribute(attribute);
    }


    public String getValueByAttribute(WebDriver driver, By locator){
        return getValueByAttribute(driver, locator, "value");
    }


    public PageElementHelper setCheckboxState(WebDriver driver, By locator, String state){
        boolean checked = driver.findElement(locator).isSelected();
        if (state.equals("checked")) {
            if (! checked){
                click(driver, locator);
            }
        } else {
            if (checked){
                click(driver, locator);
            }
        }
        return this;
    }


    public String getCheckCheckboxState(WebDriver driver, By locator){
        boolean checked = driver.findElement(locator).isSelected();
        if (checked) {
            return "checked";
        } else {
            return "";
        }
    }



}
