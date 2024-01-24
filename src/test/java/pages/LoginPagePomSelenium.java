package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePomSelenium {

    private final WebDriver driver;

    public LoginPagePomSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
