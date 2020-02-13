import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test8 {
    @Test
    public void test8() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.findElement(By.cssSelector("a.button")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindow = driver.getWindowHandles();
        List<WebElement> external = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
        for (int i = 0; i < external.size(); i++) {
            external = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
            external.get(i).click();
            WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
            String newWindow = wait.until(anyWindowOtherThan(oldWindow));
            driver.switchTo().window(newWindow);
            System.out.println(driver.getTitle());
            driver.close();
            driver.switchTo().window(mainWindow);
            System.out.println(driver.getTitle());
        }

    }

    public ExpectedCondition<String>anyWindowOtherThan(final Set<String>oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String>handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next():null;
            }
        };
    }
}
