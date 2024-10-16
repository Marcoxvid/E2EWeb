package pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnGuideMenu() {
        driver.findElement(Locators.MENU_GUIDE).click();
    }
}
