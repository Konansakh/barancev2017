import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Test1 {


    @Test
    public void test1() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=submit]")).click();



        int i;
        int a;

        List<WebElement> menu1 = (List<WebElement>) ((JavascriptExecutor) driver).executeScript("return document.querySelectorAll('ul li#app-')");

        for (i=0; i<menu1.size(); i++) {
            List<WebElement> menu2 = (List<WebElement>) ((JavascriptExecutor) driver).executeScript("return document.querySelectorAll('ul li#app-')");
            menu2.get(i).click();
            Assert.assertTrue(isElementPresent(driver, driver.getTitle()));
            System.out.println("Glavnoe menu: " + driver.getTitle());
            List<WebElement> submenu1 = (List<WebElement>) ((JavascriptExecutor) driver).executeScript("return document.querySelectorAll('ul.docs li')");
            for (a = 0; a < submenu1.size(); a++) {
                List<WebElement> submenu2 = (List<WebElement>) ((JavascriptExecutor) driver).executeScript("return document.querySelectorAll('ul.docs li')");
                submenu2.get(a).click();
                Assert.assertTrue(isElementPresent(driver, driver.getTitle()));
                System.out.println("Podmenu: " + driver.getTitle());
            }
        }
    }

    private boolean isElementPresent(ChromeDriver driver, String locator) {
        try {
            driver.getTitle();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
