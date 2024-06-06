package tests.day22_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C01_AramaTesti extends TestBaseCross {


    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // belirlenmis aranacak kelime icin arama yapin

        // POM'de locate'leri Page class'larindan aliriz
        // Ancak page class'larinda Driver Class'indaki getDriver() ile olusturulan WebDriver objesi tanimli
        // Eger cross browser calistiracagimiz class'lar fazla ise
        // driver'i tanimlayacagimiz yeni Page class'i olusturup, locate'leri oradan kullanabiliriz
        // bizim framework'umuzde CrossBrowser calisacak testler sinirli sayida oldugundan
        // yeni bir Page class'i olusturmak yerine
        // locate'leri eski usul ile @Test method'u icinde yapabiliriz

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = aramaSonucElementi.getText();

        Assert.assertNotEquals(actualSonuc,unExpectedSonuc);

    }
}
