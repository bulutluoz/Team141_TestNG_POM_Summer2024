package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_TestDatasiKullanimi {

    @Test (groups = {"smoke","E2E"})
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(3);

        // phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        ReusableMethods.bekle(3);
        Assert.assertTrue(  testotomasyonuPage.sonucElementleriList.size() > 0);

        // sayfayi kapatin
        Driver.quitDriver();


    }
}
