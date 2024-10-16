package pageobjects;

import org.openqa.selenium.By;

public class Locators {

    // Locators da página inicial
    public static final By MENU_GUIDE = By.linkText("Guide");

    // Locators da página Guide
    public static final By LINK_ALBUMS_PHOTOS = By.linkText("/albums/1/photos");

    // Locators da página Photos (ajuste conforme o HTML real)
    public static final By PHOTO_ITEMS = By.cssSelector(".photo");
}
