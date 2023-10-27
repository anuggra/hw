package saucedemo.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class logins {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";
    @Given("Login_page_saucedemo")
    public void on_login_page() {
        driver = new FirefoxDriver();
        driver.manage().timeouts(). implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

        // Assertion: Memastikan judul halaman sesuai dengan yang diharapkan
        String expectedTitle = "Saucedemo: Cross Browser Testing, Selenium Testing, Mobile Testing, and Codeless Testing | Sauce Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        driver.quit();
    }

    @When("Input username")
    public void input_Username() {
        // Memasukkan username ke kolom input
        WebElement usernameField = driver.findElement(By.id("standard_user"));
        usernameField.sendKeys("exampleusername");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

    @And("Input password")
    public void input_Password() {
        // Memasukkan kata sandi ke kolom input
        WebElement passwordField = driver.findElement(By.id("secret_sauce"));
        passwordField.sendKeys("examplepassword");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @And("Click login button")
    public void click_Login_Button() {
        // Menemukan dan mengklik tombol login
        WebElement loginButton = driver.findElement(By.id("login_logo")); // Ganti "login-button" dengan id atau selector yang sesuai
        loginButton.click();


        try {
        Thread.sleep(2000);
        } catch (InterruptedException e){
        e.printStackTrace();
        }
    }

    @Then("User is on dashboard page")
    public void user_Is_On_Dashboard_Page() {
        // Verifikasi bahwa pengguna telah dialihkan ke halaman dashboard
        String expectedUrl = "https://www.saucedemo.com/dashboard"; // Ganti dengan URL halaman dashboard yang sesuai
        String actualUrl = driver.getCurrentUrl();

        // Assertion: Memastikan URL sesuai dengan yang diharapkan
        Assert.assertEquals(expectedUrl, actualUrl);

        // Verifikasi bahwa elemen-elemen halaman dashboard muncul (sesuaikan dengan elemen-elemen yang sesuai)
        boolean isDashboardHeaderVisible = driver.findElement(By.className("dashboard-header")).isDisplayed();
        Assert.assertTrue(isDashboardHeaderVisible);

        // driver.quit();
        }
}
