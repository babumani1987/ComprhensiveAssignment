


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationAnywhereTest {


    @Test
    public void verifyAutomationAnwhereTest(){
        // Set the path to the ChromeDriver executable


        // Initialize ChromeDriver

        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.automationanywhere.com");

        try {
            // Locate the "Products" menu item using XPath
            WebElement productsMenuItem = driver.findElement(By.xpath("//a[text()='Products']"));

            // Create an Actions object for performing mouse hover
            Actions actions = new Actions(driver);

            // Perform mouse hover on the "Products" menu item
            actions.moveToElement(productsMenuItem).build().perform();;

            // Locate the "Process Discovery" menu item and click on it using XPath
            WebElement processDiscoveryMenuItem = driver.findElement(By.xpath("//a[text()='Process Discovery']"));
            processDiscoveryMenuItem.click();

            // Wait for a moment to ensure the page navigation
            Thread.sleep(2000);

            // Verify that the current URL is the expected URL
            String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals(expectedUrl,actualUrl);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


