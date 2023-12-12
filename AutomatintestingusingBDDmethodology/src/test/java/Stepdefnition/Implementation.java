package Stepdefnition;//Script

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Implementation {
	static WebDriver driver;//Control will go to the next scenario while using static
	static Properties prop;

	@Given("Open the browser")

	public void open_the_browser() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Configuration\\Objectrepo.properties");
		prop = new Properties();
		prop.load(fis);
		ChromeOptions copt = new ChromeOptions();
		copt.addArguments("--start-maximized");
		driver = new ChromeDriver(copt);

	}


	@Given("launch the url below")
	public void launch_the_url_below(io.cucumber.datatable.DataTable data) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<List<String>> cells = data.cells();

		driver.get(cells.get(0).get(0));
	}


	@Then("verify the page title")
	public void verify_the_page_title() {
		// Write code here that turns the phrase above into concrete actions
		String title = driver.getTitle();
		Assert.assertEquals("The Internet", driver.getTitle());
		System.out.println("the title" + driver.getTitle() + "has been verified sucessfull");
	}


	@When("click on AB testing link")
	public void click_on_ab_testing_link() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("ABTesting"))).click();
		;

	}


	@Then("verify the below text on the page")
	public void verify_the_below_text_on_the_page(io.cucumber.datatable.DataTable data) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<List<String>> cells = data.cells();
		String expectedText = cells.get(0).get(0);
		String actualText = driver.findElement(By.xpath(prop.getProperty("ABTestVariation"))).getText();
		Assert.assertEquals(expectedText, actualText);

	}


	@When("navigate back to the home page")
	public void navigate_back_to_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().back();
		;
	}


	@When("click on the dropdown link")
	public void click_on_the_dropdown_link() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("dropdownLink"))).click();
		;

	}


	@When("select option1 value from the drop down")
	public void select_option1_value_from_the_drop_down() {
		// Write code here that turns the phrase above into concrete actionsS
		WebElement dropDown = driver.findElement(By.xpath(prop.getProperty("dropDownList")));
		Select s = new Select(dropDown);
		s.selectByVisibleText("Option 1");
	}


	@Then("verify option1 value is selected")
	public void verify_option1_value_is_selected() {
		// Write code here that turns the phrase above into concrete actions
		WebElement dropDown = driver.findElement(By.xpath(prop.getProperty("dropDownList")));
		Select s = new Select(dropDown);
		Assert.assertEquals(s.getFirstSelectedOption().getText(), "Option 1");

	}

	@When("click on frames")
	public void click_on_frames() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("frames"))).click();
	}


	@Then("verify the below hyperlinks are presented in the framespage")
	public void verify_the_below_hyperlinks_are_presented_in_the_framespage(io.cucumber.datatable.DataTable data) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<List<String>> cells = data.cells();
		String NestedFramesText = cells.get(0).get(0);
		String iFrameFramesText = cells.get(0).get(1);

		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + NestedFramesText + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + iFrameFramesText + "')]")).isDisplayed());
	}

}