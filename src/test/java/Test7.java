import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Test7 {
    @Test
    public void test7() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://localhost/litecart");

        WebElement utka = driver.findElement(By.xpath( " //*[normalize-space(text()) = 'Red Duck']"));
        utka.click();
        driver.findElement(By.name("add_cart_product")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
        WebElement kolvo = wait.until(presenceOfElementLocated(By.cssSelector("span.quantity[style]")));
        String quantity = kolvo.getText();
        System.out.println(quantity);
        for (int i = 0; i < 2; i++) {

            driver.get("http://localhost/litecart");

            utka = driver.findElement(By.xpath( " //*[normalize-space(text()) = 'Red Duck']"));
            utka.click();
            driver.findElement(By.name("add_cart_product")).click();

            wait = new WebDriverWait(driver, 10/*seconds*/);
            kolvo = wait.until(presenceOfElementLocated(By.cssSelector("span.quantity[style]")));
            quantity = kolvo.getText();
            System.out.println(quantity);
        }
        driver.findElement(By.xpath("//*[normalize-space(text())='Checkout »']")).click();

        for (int i = 0; i < 3; i++) {
            WebElement summa = wait.until(presenceOfElementLocated(By.cssSelector("td.sum")));
            driver.findElement(By.name("quantity")).sendKeys(Keys.DOWN);
            driver.findElement(By.xpath("//*[normalize-space(text())='Update']")).click();
            wait.until(stalenessOf(summa));
        }


    }
}
