import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test6 {
    @Test
    public void test6() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.findElement(By.xpath("((//*[@id=\"app-\"]/a) [2])")).click();
        driver.findElement(By.linkText("Add New Product")).click();
        driver.findElements(By.name("status")).get(0).click();
        driver.findElement(By.name("name[en]")).sendKeys("Test");
        driver.findElement(By.name("save")).click();
    }
}
