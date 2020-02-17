import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test10 {
    @Test
    public void test10() {


//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("127.0.0.1:8888");
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("proxy", proxy);
//        WebDriver driver = new ChromeDriver(caps);



        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=submit]")).click();


    }
}
