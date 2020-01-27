import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import javax.xml.transform.stream.StreamResult;
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

        List<WebElement> zonesold = driver.findElements(By.cssSelector("tr.row td:nth-child(6)"));
        for(int i=0; i<zonesold.size(); i++) {
            List<WebElement> zones = driver.findElements(By.cssSelector("tr.row td:nth-child(6)"));
            String zonatxt = zones.get(i).getText();
            int zona = Integer.parseInt(zonatxt);
            if (zona != 0) {
                System.out.println(zones.get(i).getText());
                driver.findElements(By.cssSelector("tr.row td:nth-child(5) a")).get(i).click();
                List<WebElement> subzones = driver.findElements(By.cssSelector("tbody tr td:nth-child(3)"));
                ArrayList <String> subzone1 = new ArrayList<String>();
                for (int b=0; b<subzones.size(); b++) {
                    subzone1.add(subzones.get(b).getText());
                }
                ArrayList <String> subzone2 = subzone1;
                Collections.sort(subzone1);
                int c = 0;
                    for(String str: subzone1) { //сортированный список
                    if (!str.equals(subzone2.get(c))) {
                        System.out.println(String.format("fail %s %s", str, subzone2.get(c)));
                        return;
                    }
                    c++;
                    }
                    System.out.println("ok");
                    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
           // System.out.println(zones.get(i).getText());
           // System.out.println(zones.get(i).getAttribute("innerText"));
        }

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> geosize = driver.findElements(By.cssSelector("tr.row td:nth-child(3) a"));
        for(int d=0; d<geosize.size(); d++) {
            List<WebElement> geo = driver.findElements(By.cssSelector("tr.row td:nth-child(3) a"));
            geo.get(d).click();
            List<WebElement> geoCountry = driver.findElements(By.cssSelector("select:not(.select2-hidden-accessible) option[selected=selected]"));
            ArrayList <String> geo1 = new ArrayList<String>();
            for (int e=0; e<geoCountry.size(); e++) {
                geo1.add(geoCountry.get(e).getText());
            }
            ArrayList <String> geo2 = geo1;
            Collections.sort(geo1);
            int f = 0;
            for(String str: geo1) { //сортированный список
                if (!str.equals(geo2.get(f))) {
                    System.out.println(String.format("fail %s %s", str, geo2.get(f)));
                    return;
                }
                f++;
            }
            System.out.println("ok");
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }

    }

}
