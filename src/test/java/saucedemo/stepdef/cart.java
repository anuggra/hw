package saucedemo.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class cart {
           WebDriver driver;
        String baseurl = "https://www.saucedemo.com/inventory.html";
    @Given("User is on the product page")
    public void user_Is_On_The_Product_Page() {
        driver = new FirefoxDriver();
        driver.get(baseurl);

        String expectedTitle = "https://www.saucedemo.com/inventory.html";
        String actualTitle = driver.getTitle();

        // Assertion: Memastikan judul halaman sesuai dengan yang diharapkan
        Assert.assertEquals(expectedTitle, actualTitle);

        // Memeriksa apakah elemen-elemen halaman produk muncul (sesuaikan dengan elemen-elemen yang sesuai)
        boolean isProductTitleVisible = driver.findElement(By.id("product-title")).isDisplayed();
        Assert.assertTrue(isProductTitleVisible);

         driver.quit();
    }

    @When("User selects an item with name {string} and adds it to the cart")
    public void user_Selects_AnItem_With_Name_And_Adds_It_To_The_Cart(String arg0) {

        String productSelector = String.format("<div class=\"inventory_details_name large_size\">Sauce Labs Backpack</div>");
        driver.findElement(By.xpath(productSelector)).click();

                try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("The item {string} should appear in the cart")
    public void the_Item_Should_Appear_In_The_Cart(String arg0) {

        String cartItemSelector = String.format('<div class="inventory_item_name">Sauce Labs Bike Light</div>');
        boolean isItemDisplayedInCart = driver.findElement(By.xpath(cartItemSelector)).isDisplayed();

                Assert.assertTrue("Item should appear in the cart", isItemDisplayedInCart);
    }
    }
}
