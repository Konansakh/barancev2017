import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Test3 {
    @Test
    public void test3() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=submit]")).click();

        List<WebElement> count = driver.findElements(By.cssSelector("tr.row a"));


        ArrayList <String> country1 = new ArrayList<String>();
        for (int i = 0; i < count.size(); i++) {
            country1.add(count.get(i).getText());
        }

        ArrayList <String> country2 = country1;

        Collections.sort(country1);
        for(int i=0; i<country1.size(); i++) {
          //  System.out.println(country1.get(i));
        }

        int a = 0;
        for(String str: country1) { //сортированный список
            if (!str.equals(country2.get(a))) {
                System.out.println(String.format("fail %s %s", str, country2.get(a)));
                return;
            }
            a++;
        }

        System.out.println("ok");


    }

}
