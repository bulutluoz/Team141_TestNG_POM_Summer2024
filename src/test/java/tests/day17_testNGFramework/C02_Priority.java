package tests.day17_testNGFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {

    // 3 farkli test method'u olusturun
    // ve her bir method'da asagida verilen websayfalarindan birine gidip
    // o sayfaya gidildigini test edin
    // 1- testotomasyonu.com,
    // 2- wisequarter.com
    // 3- bestbuy.com

    WebDriver driver;

    @BeforeClass
    public void setup(){
        // WebDriverManager.chromedriver().setup();
        // sirket bize bir WebDriver verirse onu kullaniriz
        // yoksa Selenium'un kendi WebDriver'ini kullanabiliriz
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    /*
        JUnit'de test method'larinin hangi sira ile calisacagini ONGEREMEYIZ
        AMMA TestNG method'lari isim sirasina gore calistirir

        Eger method'lari istedigimiz sirada calistirmak istersek
        priority kullanabiliriz

        1- eger priority degeri atamazsak default degeri 0'dir
        2- priority kucukten buyuge dogru calisir
        3- priority degerleri her turlu tamsayi olabilir, belirli bir aralikla yazilma sarti yoktur
        4- eger bir method'da priority atamazsak default degeri olan 0'a gore siralanir
        5- eger birden fazla method'un priority degeri esitse
           esit olanlar kendi icinde harf sirasina gore calisir
           digerleri ile priority degerine gore siralanir
     */

    @Test (priority = -17)
    public void testOtomasyonuTesti(){

        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edelim

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test (priority = -17)
    public void wisequarterTesti(){

        driver.get("https://www.wisequarter.com");

        // url'in wisequarter icerdigini test edelim

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test (priority = 4)
    public void bestbuyTesti(){

        driver.get("https://www.bestbuy.com");

        // url'in bestbuy icerdigini test edelim

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

}
