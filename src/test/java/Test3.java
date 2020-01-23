import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Test3 {
    @Test
    public void test3() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=submit]")).click();

        List<WebElement> country = driver.findElements(By.cssSelector("tr.row a"));
        List<WebElement> country2 = new LinkedList<WebElement>(country);
        System.out.println(country2);

        int i;
        for (i = 0; i < country.size(); i++) {
          //  System.out.println(country.get(i).getText());

        }

    }
}
