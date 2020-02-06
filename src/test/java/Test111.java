import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test111 {
    @Test
    public void test111() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.get("http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product");
        driver.findElement(By.xpath("//*[normalize-space(text()) = 'Enabled']" ) ).click();

}
}
