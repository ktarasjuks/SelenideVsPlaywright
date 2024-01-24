package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPageSelenium {

    private final WebDriver driver;

    public ProductPageSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(String productName) {
        if ("red t-shirt".equals(productName)) {
            driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        }
    }

    public void selectItemFromBurgerMenu(String item) {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        if ("all items".equals(item)) {
            driver.findElement(By.id("inventory_sidebar_link")).click();
        }
    }

    public void goToCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    public void validatePrice(String price) {
        WebElement priceElement = driver.findElement(By.className("inventory_item_price"));
        String actualPrice = priceElement.getText().trim();
        assertThat(actualPrice).isEqualTo(price);
    }
}
