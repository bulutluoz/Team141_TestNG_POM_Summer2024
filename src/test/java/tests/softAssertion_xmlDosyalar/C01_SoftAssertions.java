package tests.softAssertion_xmlDosyalar;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssertions {
    /*
        SoftAssertion'da 3 adim var
        1- softAssert objesi olustur
        2- istenen tum assertion'lari softAssert objesini kullanarak yap
        3- assertion'lar bittikten sonra, softAssert'un rapor vermesi icin
           assertAll() calistir.
     */

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // anasayfaya gittiginizi test edin

        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

            // 1.adim softAssert objesi olustur
        SoftAssert softAssert = new SoftAssert();
            // 2.adim olusturdugumuz obje ile istenen tum assertion'lari yapin
        softAssert.assertEquals(actualUrl,expectedUrl,"Url istenenden farkli, satir33");

        // belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage
                        .aramakutusu
                        .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        softAssert.assertTrue(testotomasyonuPage.sonucElementleriList.size()>0,"bulunan urun sayisi istenen kadar degil, satir 43");

        // ilk urunu tiklayin
        testotomasyonuPage
                .sonucElementleriList
                .get(0)
                .click();

        // acilan sayfadaki urun isminde case sensitive olmadan
        // aranacak kelime bulundugunu test edin

        String expectedIsimIcerigi = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage
                                        .ilkUrunSayfasindaUrunIsimElementi
                                        .getText()
                                        .toLowerCase(); // case sensitive olmamasi icin

        softAssert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi),"ilk urunun isminde aranacak kelime yok, satir 60");

        // 3.adim softAssert'un raporlamasi icin assertAll() calistir
        softAssert.assertAll();

        // sayfayi kapatin

        Driver.quitDriver();


    }
}
