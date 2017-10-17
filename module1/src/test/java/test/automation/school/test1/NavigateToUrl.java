package test.automation.school.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class NavigateToUrl {

    public static void main(String[] args) {
        System.setProperty ("webdriver.gecko.driver", "drivers/geckodriver-v0.19.0-win64/geckodriver.exe");
        //System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        new FirefoxDriver();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

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

        driver.quit();

    }

}
