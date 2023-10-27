package saucedemo.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sort {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/inventory.html";
    @Given("User is on the product listing page")
    public void userIsOnTheProductListingPage() {
        // Memastikan bahwa pengguna telah berada di halaman daftar produk
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();

        // Assertion: Memastikan judul halaman sesuai dengan yang diharapkan
        Assert.assertEquals(expectedTitle, actualTitle);

        // Memeriksa apakah elemen-elemen halaman daftar produk muncul (sesuaikan dengan elemen-elemen yang sesuai)
        boolean isProductListVisible = driver.findElement(By.id()("Swag Labs"))
        Assert.assertTrue(isProductListVisible);

        // Menutup browser setelah selesai (ini hanya contoh, sesuaikan dengan langkah-langkah selanjutnya dalam skenario Anda)
        // driver.quit();
    }
    }

    @When("User selects to sort products by {string}")
    public void userSelectsToSortProductsBy(String arg0) {
        // Temukan dan klik elemen yang memungkinkan pengguna memilih kriteria pengurutan
        String sortingOptionLocator = String.format("//option[contains(text(), '%s')]", sortingOption);
        driver.findElement(By.xpath(sortingOptionLocator)).click();

        // Tunggu beberapa detik (opsional, untuk memberi waktu halaman untuk merespons)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

    @Then("Products should be displayed in ascending order of price")
    public void productsShouldBeDisplayedInAscendingOrderOfPrice() {
        // Dapatkan daftar harga produk dari halaman (mungkin menggunakan elemen atau atribut tertentu)
        List<WebElement> priceElements = driver.findElements(By.cssSelector(".product-price")); // Ganti dengan selector yang sesuai

        // Dapatkan daftar harga dalam bentuk String
        List<String> prices = priceElements.stream().map(WebElement::getText).collect(Collectors.toList());

        // Konversi harga ke bentuk numerik (anda mungkin perlu menghilangkan simbol mata uang, koma, dll., tergantung pada struktur situs web Anda)
        List<Double> numericPrices = prices.stream().map(Double::parseDouble).collect(Collectors.toList());

        // Verifikasi apakah harga produk dalam urutan yang benar (dari yang terendah ke tertinggi)
        boolean isSorted = true;
        for (int i = 0; i < numericPrices.size() - 1; i++) {
        if (numericPrices.get(i) > numericPrices.get(i + 1)) {
        isSorted = false;
        break;
        }
        }

        // Assertion: Memastikan harga produk ditampilkan dalam urutan yang benar
        Assert.assertTrue("Products are not displayed in ascending order of price", isSorted);
        }
    }
}
