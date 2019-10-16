import utility.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;



public class Nop_Com_Login_Page {

    private WebDriver driver;
    private Utility util;

    @Before
    public void setup()
    {
        String baseurl = "https://demo.nopcommerce.com";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        util = new Utility(driver);
    }

    @Test
    public void UserShouldNotLoginSuccessfully()
    {
        //util.ClickOnElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Log in")).click();
        util.SendTextToElement(By.id("Email"),"Lala234@gmail.com");
        util.SendTextToElement(By.id("Password"),"santa0987");
        util.ClickOnElement(By.xpath("//input[@class='button-1 login-button']"));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}