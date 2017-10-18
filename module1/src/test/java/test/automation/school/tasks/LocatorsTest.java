package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.*;

import static org.testng.Assert.assertTrue;


public class LocatorsTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void locateElementByIdTest() throws Exception {
        //TODO 1 - locate search input field by ID and assign to a variable named elementById

        WebElement elementById = driver.findElement(By.id("search_query_top"));
        assertTrue (elementById.isDisplayed());
    }


    @Test
    public void locateElementByClassNameTest() throws Exception {
        //TODO 2 - locate all products by class name and put them into ArrayList Collection

        List<WebElement> ElementByClassNameTestList = driver.findElements(By.className("ajax_block_product"));
        //assertTrue (list.size()>0);
        assertTrue (ElementByClassNameTestList.get(0).isDisplayed());
    }


    @Test
    public void locateElementByTagNameTest() throws Exception {
        //TODO 3 - locate all images by tag name and put them into ArrayList Collection

        List<WebElement> ElementByTagNameTestList = driver.findElements(By.tagName("img"));
        assertTrue (ElementByTagNameTestList.get(0).isDisplayed());
    }


    @Test
    public void locateElementByNameTest() throws Exception {
        //TODO 4 - locate newsletter subscription input element by name

        WebElement elementByName = driver.findElement(By.name("email"));
        assertTrue (elementByName.isDisplayed());
    }


    @Test
    public void locateElementByLinkTextTest() throws Exception {
        //TODO 5 - locate "T-Shirts" element by link text
        // NOTE - linkText() is case sensitive

        WebElement elementByLinkText = driver.findElement(By.linkText("T-SHIRTS"));
        assertTrue (elementByLinkText.isDisplayed());
    }


    @Test
    public void locateElementByCssSelctorTest() throws Exception {
        //TODO 6 - locate all visible products element by CSS and put them into ArrayList Collection

        List<WebElement> ElementByCssSelctorTestList = driver.findElements(By.cssSelector(".active .ajax_block_product"));
        assertTrue (ElementByCssSelctorTestList.get(0).isDisplayed());

    }

    @Test
    public void locateElementByXpathTest() throws Exception {
        //TODO 7 - locate all visible products element by XPATH and put them into ArrayList Collection
        //NOTE - you have to indicate all class names that are specified on the current element
        // This is contrary to CSS Selector where you can specify just one of the class names

        List<WebElement> ElementByXPathTestList = driver.findElements(By.xpath("//*[contains(@class,'active')]/*[contains(@class,'ajax_block_product')]"));
        assertTrue (ElementByXPathTestList.get(0).isDisplayed());
        System.out.println("ElementByXPathTestList size: " + ElementByXPathTestList.size());
    }

}
