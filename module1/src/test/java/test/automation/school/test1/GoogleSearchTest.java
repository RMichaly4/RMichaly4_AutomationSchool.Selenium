package test.automation.school.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {
    FirefoxDriver driver;



    @BeforeMethod ()
    public void setup () {
        System.setProperty ("webdriver.gecko.driver", "../drivers/geckodriver-v0.19.0-win64/geckodriver.exe");
        //System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }

    @Test
    public void testSearch () {
        WebElement element =  driver.findElement(By.name("q"));
        element.sendKeys("cheese" + Keys.ENTER);
        //element.submit();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //will find all elements with clas = 'g'
        List<WebElement> list = driver.findElements(By.cssSelector(".g"));
        System.out.println("List size:" + list.size());

        assertTrue (list.size()>0);

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
