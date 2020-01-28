import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.transform.stream.StreamResult;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test4 {
    @Test
    public void test4() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart");

        WebElement tovar = driver.findElement(By.cssSelector("#box-campaigns ul li.product.column.shadow.hover-light a.link"));
        String name = tovar.findElement(By.cssSelector("div.name")).getAttribute("textContent");

        String oldprice = tovar.findElement(By.cssSelector("s.regular-price")).getAttribute("textContent");
        String colorOld = tovar.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String fontOld = tovar.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line");
        String sizeOld = tovar.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size");

        String newprice = tovar.findElement(By.cssSelector("strong.campaign-price")).getAttribute("textContent");
        String colorNew = tovar.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String fontNew = tovar.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        String sizeNew = tovar.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");

        tovar.click();

        String name2 = driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");
        Assert.assertEquals(name, name2);
        String oldprice2 = driver.findElement(By.cssSelector("s.regular-price")).getAttribute("textContent");
        Assert.assertEquals(oldprice, oldprice2);
        String newprice2 = driver.findElement(By.cssSelector("strong.campaign-price")).getAttribute("textContent");
        Assert.assertEquals(newprice, newprice2);

        String colorOld2 = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-color");
        String fontOld2 = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line");
        String sizeOld2 = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size");
        String colorNew2 = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String fontNew2 = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        String sizeNew2 = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");

        System.out.println(name);
        System.out.println(name2);
        System.out.println(oldprice);
        System.out.println(oldprice2);
        System.out.println(newprice);
        System.out.println(newprice2);
        System.out.println();
        System.out.println(colorOld);
        System.out.println(fontOld);
        System.out.println(sizeOld);
        System.out.println(colorOld2);
        System.out.println(fontOld2);
        System.out.println(sizeOld2);
        System.out.println();
        System.out.println(colorNew);
        System.out.println(fontNew);
        System.out.println(sizeNew);
        System.out.println(colorNew2);
        System.out.println(fontNew2);
        System.out.println(sizeNew2);
      //  Assert.assertEquals(colorOld, colorOld2);



    }
}
