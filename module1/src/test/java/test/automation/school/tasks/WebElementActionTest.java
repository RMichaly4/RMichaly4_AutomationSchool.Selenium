package test.automation.school.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.*;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class WebElementActionTest {

    private WebDriver driver;


    //TODO - tests should use new browser instance for each test method

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/

    @BeforeClass
    public void globalSetUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
    }


    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
    }

    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }


    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click())
    // and verify that user is navigated to other page

    @Test
    public void testSearchContactUs() {
        WebElement contactUsElement = driver.findElement(By.xpath("//*[@id='contact-link']"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        contactUsElement.click();
        assertEquals(driver.getTitle(), "Contact us - My Store");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //TODO 4 -Create TestNg Test method which inputs some value into search input field
    // and then clear the inputted text. Try do it in 2 possible ways.
        @Test
        public void testSearchClear() {
            WebElement searchInputElement = driver.findElement(By.name("search_query"));
            searchInputElement.sendKeys("dress" + Keys.ENTER);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            searchInputElement = driver.findElement(By.name("search_query"));
            searchInputElement.clear();
            searchInputElement.sendKeys("hat");


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result.
    // Verify that user is navigated to new page
    @Test
    public void testSearchSubmit() {
        WebElement searchInputElement = driver.findElement(By.id("search_query_top"));
        searchInputElement.sendKeys("shirt" + Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(driver.getTitle(), "Search - My Store");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    }





