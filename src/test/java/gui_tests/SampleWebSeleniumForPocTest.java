package gui_tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPagePomSelenium;
import pages.ProductPageSelenium;

import static org.junit.Assert.assertEquals;

public class SampleWebSeleniumForPocTest {

    private static ChromeDriver driver;
    private final LoginPagePomSelenium loginPagePom = new LoginPagePomSelenium(driver);
    private final ProductPageSelenium productPage = new ProductPageSelenium(driver);
    private static long startTime;

    @BeforeClass
    public static void setup() {
        startTime = System.currentTimeMillis();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ktara\\IdeaProjects\\SelenideVsPlaywright\\src\\test\\resource\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless");


        driver = new ChromeDriver(options);

    }

    @AfterClass
    public static void tearDown() {
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time of tests " + totalTime);
        driver.quit();
    }

    @Test
    public void addSomeRandomItemToCart() {
        driver.get("https://www.saucedemo.com/");
        loginPagePom.login();
        productPage.selectProduct("red t-shirt");
        productPage.selectItemFromBurgerMenu("All items");
        productPage.goToCart();
        productPage.validatePrice("$15.99");
    }
}
