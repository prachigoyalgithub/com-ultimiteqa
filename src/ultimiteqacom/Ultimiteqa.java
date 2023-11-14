package ultimiteqacom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ultimiteqa {
    static String browser = "Chrome";

    static String baseUrl = "https://courses.ultimateqa.com/login";
    static WebDriver driver;

    public static void main(String[] args) {



        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name ");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Open URL.
        driver.get("https://courses.ultimateqa.com/login");

        // 3. Print the title of the page.
        System.out.println("Page Title: " + driver.getTitle());

        // 4. Print the current URL.
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println("Page Source: " + driver.getPageSource());

        // 6.Click on 'Sign in ' link

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
        signInLink.click();

        // 7 Print the current URL.
        System.out.println("Current URL after login: " + driver.getCurrentUrl());

        // 8. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("your_email@example.com");

        // 9. Enter the password to the password field.
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("your_password");

        // 10. Click on Login Button.
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // 11. Navigate to baseUrl.
        driver.get(baseUrl);

        // 12. Navigate forward to Homepage.
        driver.navigate().forward();

        // 13. Navigate back to baseUrl.
        driver.navigate().back();

        // 14. Refresh the page.
        driver.navigate().refresh();

        // 15. Close the browser.
        driver.quit();
    }
}


