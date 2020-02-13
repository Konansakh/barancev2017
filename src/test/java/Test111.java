import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test111 extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println(by +  " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println(throwable);
        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screen = new File("screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tempFile, screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(screen);
    }


    @Test
    public void test111() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        EventFiringWebDriver driver = new EventFiringWebDriver (new ChromeDriver(options));
        driver.register(new Test111());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=submi]")).click();
        driver.get("http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product");
        driver.findElement(By.xpath("//*[normalize-space(text()) = 'Enabled']" ) ).click();

}
}
