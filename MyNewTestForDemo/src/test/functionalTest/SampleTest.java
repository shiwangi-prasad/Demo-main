import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class SampleTest {
    WebDriver driver;

    @Before
    public void SetUp() throws IOException {
        driver = new FirefoxDriver();
        driver.get("https://www.google.co.in");
    }

    @Test
    public void OpenSearchEngine() throws InterruptedException, IOException{
        Assert.assertTrue("Landed on wrong page", driver.findElement(By.id("hplogo")).isDisplayed());
    }

    @Test
    public void SearchSelenium(){
        WebElement element = driver.findElement(By.name("q"));
        Assert.assertTrue("Search box is not present", element.isDisplayed());
        element.sendKeys("Selenium");
        Assert.assertTrue("Selenium text not present", driver.findElement(By.xpath("//a[@id='logo']")).isDisplayed());
    }

    @After
    public void TearDown(){driver.quit();}
}
