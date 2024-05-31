package tests.day18_testNGFrameworkHazirlama;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C06_ListeLocateEtme {

    // tek test method'u olusturup, asagidaki gorevleri tamamlayin



    @Test
    public void aramaTesti(){

        // 1- testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        //    ve sayfaya gittiginizi test edin
        //    url'in testotomasyonu icerdigini test edelim

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // 2- phone icin arama yapin


        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramakutusu.sendKeys("phone" + Keys.ENTER);

        //    arama sonucunda urun bulunabildigini test edelim
        //    bulunan sonuclari bir liste olarak kaydedip, size'ini test edelim

        int bulunanSonucSayisi = testotomasyonuPage.sonucElementleriList.size();
        Assert.assertTrue(bulunanSonucSayisi > 0);

        Driver.quitDriver();

    }

}
