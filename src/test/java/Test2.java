import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test2 {
    @Test
    public void test2() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/");

        boolean good = areElementsPresent(driver, (By.cssSelector("ul li.product.column.shadow.hover-light")));
        boolean sticker = areElementsPresent(driver, (By.cssSelector("ul li.product.column.shadow.hover-light .sticker")));

        if (good==sticker) {

            List<WebElement> tovar = driver.findElements(By.cssSelector("ul li.product.column.shadow.hover-light"));
            List<WebElement> lable = driver.findElements(By.cssSelector("ul li.product.column.shadow.hover-light .sticker"));

            if (tovar.size() == lable.size()) {
                System.out.println("ravny");
                int i;
                for (i = 0; i < tovar.size(); i++) {
                    System.out.println("tovar " + tovar.get(i).getText());
                    System.out.println("raven:" + lable.get(i).getText());
                }
            } else {
                System.out.println("ne ravny");
            }
        }
        else {
            Assert.assertEquals(good, sticker);
          //  System.out.println("razmer<0");
        }



      //  Assert.assertEquals(good.size(), sticker.size());
      //  System.out.println(Assert.assertEquals(good.size(), sticker.size()));
    }


    boolean areElementsPresent (ChromeDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

}

