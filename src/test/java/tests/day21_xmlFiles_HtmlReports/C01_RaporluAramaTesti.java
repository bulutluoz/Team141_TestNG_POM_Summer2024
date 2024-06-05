package tests.day21_xmlFiles_HtmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluAramaTesti extends TestBaseRapor {

    @Test
    public void aramaTesti(){

        extentTest = extentReports.createTest("arama testi","belirlenen kelimenin bulunabildigini test eder");

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");
        // belirlenen arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi icin arama yapar");
        // arama sonucunda urun bulunabildigini test edin

        Assert.assertTrue(testotomasyonuPage.sonucElementleriList.size()>80);
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");
    }
}
