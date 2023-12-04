
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationAnywhere_RequestTest  {

    public static void main(String[] args) throws Exception {
        // Set the path to the ChromeDriver executable


        // Initialize ChromeDriver

        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.automationanywhere.com");

        try {
            // Locate the "Products" menu item using XPath
            WebElement requestDemo = driver.findElement(By.xpath("//*[text()='Request demo']"));
            requestDemo.click();


            // Wait for a moment to ensure the page navigation
            Thread.sleep(2000);

            // Verify that the current URL is the expected URL
            String expectedUrl = "https://www.automationanywhere.com/request-live-demo";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.equals(expectedUrl)) {
                System.out.println("Test Passed: Navigated to the correct URL.");
            } else {
                System.out.println("Test Failed: Expected URL: " + expectedUrl + ", Actual URL: " + actualUrl);
            }

                    // Locate the elements for first name and last name labels using their HTML structure or attributes
                    WebElement firstNameLabel = driver.findElement(By.xpath("//label[contains(text(), 'First Name')]"));
                    WebElement lastNameLabel = driver.findElement(By.xpath("//label[contains(text(), 'Last Name')]"));

                    // Get the text from the labels
                    String firstNameLabelText = firstNameLabel.getText();
                    String lastNameLabelText = lastNameLabel.getText();

                    // Print the label names
                    System.out.println("Label for First Name: " + firstNameLabelText);
                    System.out.println("Label for Last Name: " + lastNameLabelText);

                    // Close the WebDriver
        //            driver.quit();






        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


