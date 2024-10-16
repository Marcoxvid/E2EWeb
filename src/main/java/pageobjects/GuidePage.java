package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GuidePage {

    WebDriver driver;
    WebDriverWait wait;

    public GuidePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnAlbumsLink() {
        WebElement albumsLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_ALBUMS_PHOTOS));
        albumsLink.click();
    }
}
